package lesson15.classwork;

import java.util.Optional;
import java.util.function.Supplier;

public class Suppliers {


    //TODO
    // Используя примитивные интерфейсы Supplier, получить рандомные значения для примтивных типов int, double, long, boolean
    // И вывести их в консоль
    public static void main(String[] args) {
        String s = "test";
        Supplier<String> sup = () -> s.toUpperCase();

        System.out.println(sup.get());

        System.out.println(Optional.of(10.0).orElseGet(() -> Math.random()));
        System.out.println(Optional.empty().orElseGet(() -> Math.random()));
    }
}
