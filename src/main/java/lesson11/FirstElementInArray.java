package lesson11;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FirstElementInArray {


    // TODO: Найти первый элемент, встречающийся k раз в массиве
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 2, 4, 5, 6, 2, 2 };

        quadraticSearch(array, 2);
        mapSearch(array, 2);
    }

    public static void mapSearch(int[] arr, int count) {
        Map<Integer, Integer> map = new HashMap<>();

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.put(arr[i], map.getOrDefault(arr[i], 0) + 1) != null) {
                System.out.println("Element is " + arr[i]);
                return;
            };
        }
    }

    public static void quadraticSearch(int[] arr, int count) {
        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length; j++) {
                if (i != j && arr[i] == arr[j]) {
                    System.out.println("Element is " + arr[i]);
                    return;
                }
            }
        }
    }

}
