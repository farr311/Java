package lesson12;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreePractice {

    public static void main(String[] args) {

        SortedMap<Integer, String> tree = new TreeMap<>();
        tree.put(100, "A");
        tree.put(200, "B");
        tree.put(500, "C");
        tree.put(400, "D");

        System.out.println(tree);

        /*System.out.println(tree.descendingMap());
        System.out.println(tree.tailMap(200));
        System.out.println(tree.tailMap(500));*/

        System.out.println(tree.subMap(200, 500));
        //System.out.println(tree.subMap(200, false, 500, true));
    }
}
