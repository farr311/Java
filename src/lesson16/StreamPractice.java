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

        System.out.println(oddSum(list));
        System.out.println(oddSumStream(list));
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
                .filter(e -> ...)               // Проверка на нечетность
                .reduce((a1, a2) -> ...)        // Суммирование
                    orElse(0);
    }
}
