package lesson17.streampractice;

import java.util.ArrayList;
import java.util.List;

public class ClassWork {
    private static List<Product> productsEx1;

    public static void main(String[] args) {
        fillDataEx1();
    }

    //TODO: Obtain a list of products belongs to category “Books” with price > 100
    private List<Product> ex1() {
        return productsEx1.stream(). //...
    }

    private static void fillDataEx1() {
        productsEx1 = new ArrayList<>();

        productsEx1.add(new Product(0, "1", "Books", 200));
        productsEx1.add(new Product(0, "2", "Food", 30));
        productsEx1.add(new Product(0, "3", "Food", 200));
        productsEx1.add(new Product(0, "4", "Books", 10));
        productsEx1.add(new Product(0, "5", "Books", 200));
        productsEx1.add(new Product(0, "6", "Food", 250));
        productsEx1.add(new Product(0, "7", "Food", 200));
        productsEx1.add(new Product(0, "8", "Books", 10));
        productsEx1.add(new Product(0, "9", "Books", 200));
        productsEx1.add(new Product(0, "10", "Books", 1200));
        productsEx1.add(new Product(0, "11", "Food", 11200));
    }
}
