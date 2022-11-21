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


        // Реализовать кастомный StringBuilder с методами append, reverse и toString.
        // Append должен добавлять значения во внутренний массив
        // toString должен возвращать строку, собранную из значений в порядке добавления
        // reverse должен возвращать строку, собранную из значений в обратном порядке
        // Для методов toSting и Reverse нужно использовать Function с методами compose и andThen
        MyStringBuilder sb = new MyStringBuilder();
        sb.append("H")
                .append("e")
                .append("l")
                .append("l")
                .append("o")
                .append(" ")
                .append("w")
                .append("o")
                .append("r")
                .append("l")
                .append("d");

        System.out.println(sb.toString());
        System.out.println(sb.reverse());
    }

    static void primitiveRandoms() {
        Random r = new Random();

        IntSupplier is = () -> r.nextInt();
        DoubleSupplier ds = () -> r.nextDouble();
        LongSupplier ls = () -> r.nextLong();
        BooleanSupplier bs = () -> r.nextBoolean();
    }
}

class MyStringBuilder {
    private static List<String> strings = new ArrayList<>();

    public String toString() {
        for (String s : strings) {

        }
        return "...";
    }

    public String reverse() {
        for (String s : strings) {

        }
        return "...";
    }

    public MyStringBuilder append(String s) {
        strings.add(s);
        return this;
    }
}
