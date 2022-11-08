package lesson12;

// 2. Напишите простую реализацию HashMap на основе динамического массива.
// Для этого вам потребуется реализовать класс Node<K, V>,
// где будет храниться ключ и значений и метод,
// который будет искать нужный индекс массива через hashcode ключа и размер массива.
// Стоить учесть, что при увеличении размера массива нужно провесить рехэшинг
// (перезаписать все существующие элементы массива на новые позиции, так как изменился размер).
// Если этого не сделать, поиск по индексам будет работать некорректно.
// В рамках данного задания вам не нужно волноваться о потенциальных коллизиях
public class CustomHashMap<K, V> {

    private Object[] elements;

    private int size = 16;
    private final int startSize = 16;

    private int elementCount = 0;

    public CustomHashMap() {
        this.elements = new Object[startSize];
    }

    public void put(K key, V value) {
        if (elementCount == elements.length) {
            size *= 2;
            Object[] elementsCopy = new Object[size];
            System.arraycopy(elements, 0, elementsCopy, 0, elements.length);

            rehash(elementsCopy);
            elements = elementsCopy;
        }

        int hash = key.hashCode();
        int pos = hash % size;

        elements[pos] = new Node<>(key, value);

        elementCount++;
    }

    private void rehash(Object[] elementsCopy) {
        for (int i = 0; i < elements.length; i++) {
            Node<K, V> node = (Node<K, V>) elements[i];

            if (node != null) {
                int hash = node.getKey().hashCode();
                int pos = hash % elementsCopy.length;

                elementsCopy[pos] = node;
            }
        }
    }

    public V get(K key) {
        int hash = key.hashCode();
        int pos = hash % size;

        Node<K, V> node = (Node<K, V>) elements[pos];

        if (node != null) {
            return node.getValue();
        }

        return null;
    }

    private static class Node<K, V> {
        private K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
