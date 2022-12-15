package lesson14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class Graph<T> {

    private final Map<T, Node> map;

    public Graph() {
        this.map = new HashMap<>();
    }

    public void add(T e, Node[] nodes) {
        Node node = new Node(e);

        if (nodes != null && nodes.length > 0) {
            for (Node n : nodes) {
                if (!map.containsKey(n.value)) {
                    throw new RuntimeException();
                }

                Edge edge = new Edge(node, n, 0);
                node.edges.add(edge);
                n.edges.add(edge);
            }
        }

        map.put(e, node);
    }

    public void add(T e, T[] linkedElements) {
        Node node = new Node(e);

        if (linkedElements != null && linkedElements.length > 0) {
            for (T element : linkedElements) {
                Node elementNode = map.get(element);

                if (elementNode == null) {
                    throw new RuntimeException();
                }

                Edge edge = new Edge(node, elementNode, 0);
                node.edges.add(edge);
                elementNode.edges.add(edge);
            }
        }

        map.put(e, node);
    }

    public Node getElement(T e) {
        return map.get(e);
    }

    public boolean containsElement(T e) {
        return map.containsKey(e);
    }

    public void deleteElement(T e) {
        Node node = map.get(e);

        if (node == null) {
            throw new RuntimeException();
        }

        map.remove(e);

        for (Edge edge : node.edges) {
            edge.node2.edges.remove(edge);
        }
    }

    public void deleteElement(Node n) {
        if (!map.containsKey(n.value)) {
            throw new RuntimeException();
        }

        map.remove(n.value);

        for (Edge edge : n.edges) {
            edge.node2.edges.remove(edge);
        }
    }

    private class Node {
        T value;
        final List<Edge> edges = new ArrayList<>();

        public Node(T t) {
            value = t;
        }
    }

    private class Edge {
        final Node node1;
        final Node node2;
        int weight;

        public Edge(Node node1, Node node2, int weight) {
            this.node1 = node1;
            this.node2 = node2;
            this.weight = weight;
        }
    }
}