package lesson20;

import java.util.*;

public class Main {

    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) {
        //TODO
        // Имея бесконечный набор случайных интов
        // Реализуйте метод put, чтобы он сохранял эти значения в некоторой структуре
        // И метод top, возвращающий 5 наибольших значений из тех, которые были получены к текущему моменту
        // Без повторений
        Random r = new Random();

        int[] indexes = getTopIndexes();
        int index = 0;

        for (int i = 0; i < 1_000_000; i++) {
            put(r.nextInt());

            if (i == indexes[index++]) {
                System.out.println(Arrays.toString(top()));
            }
        }
    }

    // Сохраняет переданное значение
    static void put(int a) {
        pq.add(a);

        if (pq.size() == 6) {
            pq.poll();
        }
    }

    // Выводит 5 наибольших значений
    static int[] top() {
        return pq.stream().toList().stream().mapToInt(e -> e).toArray();
    }

    static int[] getTopIndexes() {
        Random r = new Random();

        Set<Integer> indexSet = new HashSet<>();

        while (indexSet.size() < 100) {
            indexSet.add(r.nextInt(0, 1_000_000));
        }

        List<Integer> list = new ArrayList<>(indexSet.stream().toList());
        list.sort(Comparator.comparingInt(value -> value));

        return list.stream().mapToInt(e -> e).toArray();
    }
}
