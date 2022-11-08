package lesson12;

public class CustomTreeMap<K, V> {

    private int size = 0;
    private Node<K, V> root = null;

    public void put(K key, V value) {
        if (root == null) {
            root = new Node<>(key, value);;
            return;
        }

        // TODO: вычислить, в какую сторону должен добавляться элемент (лево или право)
        // TODO: получить доступ к последнему элементу, который будет родительским по отношению к данному

        Node<K, V> parent = root; // Исправить

        if (...) {
            parent.left = new Node<>(key, value, parent);
        } else {
            parent.right = new Node<>(key, value, parent);
        }
    }

    public V get(K key) {
        return null;
    }

    public int size() {
        return this.size;
    }

    public Iterator<K, V> iterator() {
        return new Iterator<>();
    }

    private static class Node<K, V> {
        private final K key;
        private final V value;

        Node<K, V> parent;
        Node<K, V> left;
        Node<K, V> right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Node(K key, V value, Node<K, V> parent) {
            this(key, value);
            this.parent = parent;


        }public Node(K key, V value, Node<K, V> parent, Node<K, V> left, Node<K, V> right) {
            this(key, value, parent);
            this.left = left;
            this.right = right;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public static class Iterator<K, V> {

        public Node<K, V> next() {
            return null;
        }

        public boolean hasNext() {
            return false;
        }
    }
}
