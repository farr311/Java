package lesson15.classwork;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
       /* Function<Double, Long> function = value -> {
            value *= value;
            return Math.round(value);
        };

        System.out.println(function.apply(5.78));
        System.out.println(function.apply(4.28));

        System.out.println("+".repeat(50));

        System.out.println(function(5.78));
        System.out.println(function(4.28));

        System.out.println("+".repeat(50));

        executeFunction(function, 5.78);
        executeFunction(function, 4.28);


        executeFunction(v -> {
            v *= v;
            return Math.round(v);
        }, 4.28);*/

        List<? extends Integer> list = new ArrayList<>();

        list.add(null);

        List<? extends A> list2 = new ArrayList<>();

        list2.add(null);
        //list2.add(new B());

        List<B> listB = new ArrayList<>();
        listB.add(new B());
        A b = listB.get(0);

        List<? extends A> listA = listB;
        A a = listA.get(0);

        List<? super Number> consumer = new ArrayList<>();
        consumer.add(1);
        consumer.add(2L);
        consumer.add(2.3f);
        consumer.add(10.1);

       // List<? extends Number> producer = consumer;

        List<Integer> c = new ArrayList<>(3);
        List<Integer> p = List.of(1, 2, 3);
        Collections.copy(p, c);

        System.out.println(p);

        /*System.out.println(consumer.get(0).getClass());
        System.out.println(consumer.get(1).getClass());
        System.out.println(consumer.get(2).getClass());
        System.out.println(consumer.get(3).getClass());*/



        /*for (int i = 0; i < consumer.size(); i++) {
            System.out.println(consumer.get(i));
            System.out.println((double) consumer.get(i));
            if (consumer.get(i) instanceof Integer) {
                System.out.println("INTEGER");
            }
        }*/



       /* Number s = consumer.get(0);

        for (Number n : consumer) {

        }*/
    }

    static long function(double d) {
        d *= d;
        return Math.round(d);
    }

    // PECS
    // Producer extends, Consumer super
    static void executeFunction(Function<Double, Long> function, double value) {
        System.out.println(function.apply(value));
    }
}

class A {

}

class B extends A {

}
