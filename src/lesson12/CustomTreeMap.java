package lesson12;

import java.util.ArrayDeque;

public class CustomTreeMap<K, V> {


    //TODO
    // Реализовать простое бинарное дерево на основе кода из гита.
    // Данное дерево должно поддерживать методы для добавления и получения элементов,
    // а так же итератор, который будет позволять обходить его.
    // Дерево должно быть построено по образу TreeMap и содержать пары ключ-значение для каждого узла
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


        }

        public Node(K key, V value, Node<K, V> parent, Node<K, V> left, Node<K, V> right) {
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

        private Node<K, V> node;

        private ArrayDeque<Node<K, V>> stack = new ArrayDeque<>();


        public Node<K, V> next() {
            Node<K, V> nextNode = nextElement();

            //
        }

        public boolean hasNext() {
            return false;
        }

        private Node<K, V> nextElement() {
            if (node.left != null) {
                return node.left;
            }

            if (node.right != null) {
                return node.right;
            }

            return node.parent;
        }
    }
}
