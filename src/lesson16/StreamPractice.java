package lesson16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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


        System.out.println(countOccurrences(List.of("a", "b", "a", "c", "a", "d", "s", "x", "a"), "a"));

        System.out.println(findMin(list));
        System.out.println(findMax(list));
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

    }

    //TODO: написать код, который с помощью стримов будет искать наименьший элемент
    public static int findMin(List<Integer> list) {

    }

    //TODO: написать код, который с помощью стримов будет искать наибольший элемент
    public static int findMax(List<Integer> list) {

    }
}
