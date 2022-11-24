package lesson17.streampractice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClassWork {
    private static List<Product> productsEx1;
    private static List<Order> ordersEx2;
    private static List<Product> productsEx3;
    private static List<Product> productsEx4;

    public static void main(String[] args) {
        //ex1().forEach(System.out::println);
        //ex2().forEach(System.out::println);
        ex3().forEach(System.out::println);
    }

    //TODO: Obtain a list of products belongs to category “Books” with price > 100
    private static List<Product> ex1() {
        fillDataEx1();
        return productsEx1.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase("Books"))
                .filter(p -> p.getPrice() > 100)
                .collect(Collectors.toList());
    }

    //TODO: Obtain a list of orders with at least one product that belongs to category “Baby”
    private static List<Order> ex2() {
        fillDataEx2();
        return ordersEx2.stream()
                .filter(o -> o.getProducts().stream()
                        .anyMatch(p -> p.getCategory().equalsIgnoreCase("Baby")))
                .collect(Collectors.toList());
    }

    //TODO: Obtain a list of product with category = “Toys” and then apply 10% discount
    private static List<Product> ex3() {
        fillDataEx3();
        return productsEx3.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase("Toys"))
                .peek(p -> p.setPrice(p.getPrice() * 0.9))
                .collect(Collectors.toList());
    }

    //TODO: Obtain a list of products ordered by customer of tier 2 between 01-Feb-2021 and 01-Apr-2021
    private static List<Product> ex4() {
        fillDataEx4();
        return productsEx4.stream()
                .//...
    }

    private static void fillDataEx1() {
        productsEx1 = new ArrayList<>();

        productsEx1.add(new Product(0, "1", "bOOks", 200));
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

    private static void fillDataEx2() {
        List<Product> productsEx2 = new ArrayList<>();

        productsEx2.add(new Product(0, "1", "Baby", 200));
        productsEx2.add(new Product(0, "2", "Food", 30));
        productsEx2.add(new Product(0, "3", "Food", 200));
        productsEx2.add(new Product(0, "4", "Baby", 10));
        productsEx2.add(new Product(0, "5", "Baby", 200));
        productsEx2.add(new Product(0, "6", "Food", 250));
        productsEx2.add(new Product(0, "7", "Food", 200));
        productsEx2.add(new Product(0, "8", "Baby", 10));
        productsEx2.add(new Product(0, "9", "Baby", 200));
        productsEx2.add(new Product(0, "10", "Baby", 1200));
        productsEx2.add(new Product(0, "11", "Food", 11200));

        ordersEx2 = new ArrayList<>();

        Order o1 = new Order();
        Order o2 = new Order();
        Order o3 = new Order();
        Order o4 = new Order();

        o1.setProduct(productsEx2.get(1));
        o1.setProduct(productsEx2.get(2));
        o1.setProduct(productsEx2.get(3));
        o1.setProduct(productsEx2.get(4));

        o2.setProduct(productsEx2.get(1));
        o2.setProduct(productsEx2.get(9));
        o2.setProduct(productsEx2.get(4));
        o2.setProduct(productsEx2.get(7));

        o3.setProduct(productsEx2.get(0));
        o3.setProduct(productsEx2.get(5));
        o3.setProduct(productsEx2.get(3));
        o3.setProduct(productsEx2.get(2));

        o4.setProduct(productsEx2.get(2));
        o4.setProduct(productsEx2.get(5));
        o4.setProduct(productsEx2.get(6));
        o4.setProduct(productsEx2.get(10));

        ordersEx2.add(o1);
        ordersEx2.add(o2);
        ordersEx2.add(o3);
        ordersEx2.add(o4);
    }

    private static void fillDataEx3() {
        productsEx3 = new ArrayList<>();

        productsEx3.add(new Product(0, "1", "Toys", 200));
        productsEx3.add(new Product(0, "2", "Food", 30));
        productsEx3.add(new Product(0, "3", "Food", 200));
        productsEx3.add(new Product(0, "4", "Toys", 10));
        productsEx3.add(new Product(0, "5", "Toys", 200));
        productsEx3.add(new Product(0, "6", "Food", 250));
        productsEx3.add(new Product(0, "7", "Food", 200));
        productsEx3.add(new Product(0, "8", "Toys", 10));
        productsEx3.add(new Product(0, "9", "Toys", 200));
        productsEx3.add(new Product(0, "10", "Toys", 1200));
        productsEx3.add(new Product(0, "11", "Food", 11200));
    }


    private static void fillDataEx4() {
        List<Product> productsEx4 = new ArrayList<>();

        productsEx4.add(new Product(0, "0", "Baby", 200));
        productsEx4.add(new Product(0, "1", "Food", 30));
        productsEx4.add(new Product(0, "2", "Food", 200));
        productsEx4.add(new Product(0, "3", "Baby", 10));
        productsEx4.add(new Product(0, "4", "Baby", 200));
        productsEx4.add(new Product(0, "5", "Food", 250));
        productsEx4.add(new Product(0, "6", "Food", 200));
        productsEx4.add(new Product(0, "7", "Baby", 10));
        productsEx4.add(new Product(0, "8", "Baby", 200));
        productsEx4.add(new Product(0, "9", "Baby", 1200));
        productsEx4.add(new Product(0, "10", "Food", 11200));
        productsEx4.add(new Product(0, "11", "Food", 11200));
        productsEx4.add(new Product(0, "12", "Food", 11200));
        productsEx4.add(new Product(0, "13", "Food", 11200));
        productsEx4.add(new Product(0, "14", "Food", 11200));
        productsEx4.add(new Product(0, "15", "Food", 11200));

        ordersEx2 = new ArrayList<>();

        Customer c1 = new Customer(1, "Customer", 2);
        Customer c2 = new Customer(2, "Customer", 2);
        Customer c3 = new Customer(3, "Customer", 1);

        Order o1 = new Order(1, LocalDate.of(2021, 2, 10), null, "status", c1); //+
        Order o2 = new Order(2, LocalDate.of(2021, 3, 21), null, "status", c2); //+
        Order o3 = new Order(3, LocalDate.of(2020, 2, 10), null, "status", c3); //-
        Order o4 = new Order(4, LocalDate.of(2020, 12, 10), null, "status", c1); //-

        // 0, 1, 4, 8, 9, 10, 11 15
        productsEx4.get(0).setOrder(o1); //+
        productsEx4.get(1).setOrder(o1); //+
        productsEx4.get(2).setOrder(o3); //-
        productsEx4.get(3).setOrder(o3); //-
        productsEx4.get(4).setOrder(o2); //+
        productsEx4.get(5).setOrder(o4); //-
        productsEx4.get(6).setOrder(o3); //-
        productsEx4.get(7).setOrder(o4); //-
        productsEx4.get(8).setOrder(o2); //+
        productsEx4.get(9).setOrder(o2); //+
        productsEx4.get(10).setOrder(o1); //+
        productsEx4.get(11).setOrder(o1); //+
        productsEx4.get(12).setOrder(o4); //-
        productsEx4.get(13).setOrder(o4); //-
        productsEx4.get(14).setOrder(o3); //-
        productsEx4.get(15).setOrder(o2); //+

    }
}
