package lesson13;

import java.util.*;

public class Graph<T> {

    private List<Node> nodes;
    private Map<T, Node> map;

    public Graph() {
        this.nodes = new ArrayList<>();
        this.map = new HashMap<>();
    }

    public void add(T e, Node[] nodes) {
        Node node = new Node(e);

       /* if (nodes != null && ...) {
            // Если массив не пустой, каждую ноду из массива кладем в node.nodes
            // Для каждой ноды из массива добавляем текущую node в их .edges.node2
        }*/

        map.put(e, node);
    }

    /*public void add(T e, T[] linkedElements) {
        Node node = new Node(e);

        if (linkedElements != null && ...) {
            // Ищем ноды по элементам в HashMap
            // Если массив не пустой, каждую ноду из массива кладем в node.nodes
            // Для каждой ноды из массива добавляем текущую node в их .edges.node2
        }

        map.put(e, node);
    }*/

    private class Node {
        T value;
        List<Edge> edges = new ArrayList<>();

        public Node(T t) {
            value = t;
        }
    }

    private class Edge {
        Node node1;
        Node node2;
        int weight;

        public Edge(Node node1, Node node2, int weight) {
            this.node1 = node1;
            this.node2 = node2;
            this.weight = weight;
        }
    }
}
