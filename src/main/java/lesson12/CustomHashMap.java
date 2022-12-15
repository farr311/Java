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

    private Node<K, V>[] elements;

    private int size = 16;
    private final int START_SIZE = 16;
    private final double threshold = .75;

    private int elementCount = 0;

    public CustomHashMap() {
        this.elements = new Node[START_SIZE];
    }

    public void put(K key, V value) {
        if (elementCount >= elements.length * threshold) {
            enlarge();
        }
        
        elements[getPos(key)] = new Node<>(key, value);
        elementCount++;
    }
    
    private void enlarge() {
        size *= 2;
        Node<K, V>[] elementsCopy = new Node[size];

        rehash(elementsCopy);
        elements = elementsCopy;
    }
    
    private int getPos(K key) {
        return key.hashCode() % size;
    }

    private void rehash(Object[] elementsCopy) {
        for (Node<K, V> element : elements) {
            if (element != null) {
                elementsCopy[getPos(element.getKey())] = element;
            }
        }
    }

    public V get(K key) {
        Node<K, V> node = (Node<K, V>) elements[getPos(key)];

        if (node != null) {
            return node.getValue();
        }

        return null;
    }

    private static class Node<K, V> {
        private final K key;
        private final V value;

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
