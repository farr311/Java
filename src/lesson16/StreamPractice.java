package lesson16;

import java.util.*;
import java.util.stream.Collectors;

public class StreamPractice {

    public static void main(String[] args) {
        var a = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).stream()
                .skip(10)
                .findFirst().orElse(42);

        System.out.println(a);

        /*String s = null;

        String str;

        if (s != null) {
            str = s;
        } else {
            str = "NULL";
        }

        str = Optional.ofNullable(s).orElse("NULL");

        System.out.println(str);

        Optional<Integer> o = Optional.of(10);
        Optional<Integer> o1 = Optional.ofNullable(null);
        Optional<Integer> o2 = Optional.empty();*/


        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        /*System.out.println(oddSum(list));
        System.out.println(oddSumStream(list));*/


        /*System.out.println(countOccurrences(List.of("a", "b", "a", "c", "a", "d", "s", "x", "a"), "a"));

        System.out.println(findMin(list));
        System.out.println(findMax(list));*/

        //System.out.println(sortReverseUnique(List.of("a1", "b5", "c1", "a2", "b4", "c1", "a1")));

       /* List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);
        List<Integer> list3 = Arrays.asList(7, 8, 9);

        List<List<Integer>> listOfLists = Arrays.asList(list1, list2, list3);

        List<Integer> result = listOfLists.stream()
                .flatMap(o -> o.stream())
                .toList();

        System.out.println(result);*/

        List<String> strings = List.of("10", "20", "1", "10", "15", "50", "25");

        System.out.println(strings.stream()
                .map(Integer::valueOf)
                .reduce((c, b) -> c * b).get());

        System.out.println(strings.stream().collect(Collectors.joining()));
        System.out.println(strings.stream().collect(Collectors.toSet()));

        System.out.println(strings.stream().map(Integer::valueOf).collect(Collectors.summingInt()));
        System.out.println(strings.stream().map(Integer::valueOf).collect(Collectors.averagingInt()));
        System.out.println(strings.stream().map(Integer::valueOf).collect(Collectors.groupingBy()));
    }

    public static int oddSum(List<Integer> list) {
        int sum = 0;
        for (Integer i : list) {
            if (i % 2 == 1) {
                sum += i;
            }
        }
        return sum;
    }


    //TODO
    // Доработать код
    // *Использовать method reference вместо одной из лямбд
    public static int oddSumStream(List<Integer> list) {
        return list.stream()
                .filter(e -> e % 2 == 1)               // Проверка на нечетность
                .reduce(Integer::sum)           // Суммирование
                .orElse(0);
    }

    //TODO: написать код через стрим, который будет проверять сколько раз word встречается в list
    public static int countOccurrences(List<String> list, String word) {
        return (int) list.stream().filter(word::equals).count();
    }

    //TODO: написать код, который с помощью стримов будет искать наименьший элемент
    public static int findMin(List<Integer> list) {
        return list.stream().min(Integer::compareTo).orElse(-1);
    }

    //TODO: написать код, который с помощью стримов будет искать наибольший элемент
    public static int findMax(List<Integer> list) {
        return list.stream().max(Integer::compareTo).orElse(-1);
    }

    //TODO: написать стрим, который отсортирует коллекцию в обратном порядке и удалит дубликаты
    public static List<String> sortReverseUnique(List<String> list) {
        return list.stream()
                .sorted(Comparator.reverseOrder())
                .distinct()
                .toList();
    }
}
