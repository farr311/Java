package lesson15.classwork;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.*;

public class Suppliers {


    //TODO
    // Используя примитивные интерфейсы Supplier, получить рандомные значения для примитивных типов int, double, long, boolean
    // И вывести их в консоль
    public static void main(String[] args) {
        String s = "test";
        Supplier<String> sup = () -> s.toUpperCase();
/*
        System.out.println(sup.get());

        System.out.println(Optional.of(10.0).orElseGet(() -> Math.random()));
        System.out.println(Optional.empty().orElseGet(() -> Math.random()));*/

        //TODO
        // Написать consumer, который получает на вход абстрактное число (Number)
        // При помощи instanceof выяснить, к какому типу относится это число
        // И в зависимости от типа внутри текущего консьюмера создать примтивный консьюмер под данный типа
        // И вывести значение в консоль с указанием типа

        //IntConsumer c = (e) -> System.out.println("INTEGER " + e);
        //if n instanceof Integer

        consumers();
    }


    static void consumers() {
        Consumer<Number> c = n -> {
            if (n instanceof Integer) {
                IntConsumer ic = e -> System.out.println("INTEGER " + e);
                ic.accept((int) n);
            } else if (n instanceof Double) {
                DoubleConsumer ic = e -> System.out.println("DOUBLE " + e);
                ic.accept((double) n);
            } else if (n instanceof Float) {
                DoubleConsumer ic = e -> System.out.println("FLOAT " + e);
                ic.accept((float) n);
            } else if (n instanceof Long) {
                LongConsumer ic = e -> System.out.println("LONG " + e);
                ic.accept((long) n);
            }
        };

        c.accept(1);
        c.accept(Long.MAX_VALUE / 2);
        c.accept(21.0);
        c.accept(31.0f);
    }

    static void primitiveRandoms() {
        Random r = new Random();

        IntSupplier is = () -> r.nextInt();
        DoubleSupplier ds = () -> r.nextDouble();
        LongSupplier ls = () -> r.nextLong();
        BooleanSupplier bs = () -> r.nextBoolean();
    }
}
