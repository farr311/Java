package lesson14.classwork;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);


       /* for (int i : list) {
            System.out.println(i);
        }*/

        Consumer<Integer> c = new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println(o);
            }
        };

       /* Consumer c2 = (Consumer) o -> System.out.println(o);
        Consumer c3 = (Consumer) System.out::println;

        list.forEach(c);
        System.out.println("*".repeat(50));
        list.forEach(c2);
        System.out.println("*".repeat(50));
        list.forEach(c3);
        System.out.println("*".repeat(50));
        list.forEach(e -> System.out.println(e));
        System.out.println("*".repeat(50));
        list.forEach(System.out::println);*/

        /*list.forEach(System.out::println);
        list.forEach(e -> {
            System.out.println(e);
            System.out.println(e);
        });*/


        Checker checker1 = new Checker(5, 2);
        Checker checker2 = new Checker(6, 2);

        checker1.printIfChecked((a, b) -> a % b == 0 && b > 2);
        checker2.printIfChecked((a, b) -> a % b == 0);
    }


}
