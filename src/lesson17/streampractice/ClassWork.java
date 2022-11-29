package lesson17.streampractice;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class ClassWork {
    private static List<Product> productsEx1;
    private static List<Order> ordersEx2;
    private static List<Product> productsEx3;
    private static List<Product> productsEx4;
    private static List<Product> productsEx5;
    private static List<Order> ordersEx6;
    private static List<Order> ordersEx7;

    public static void main(String[] args) {
        //ex1().forEach(System.out::println);
        //ex2().forEach(System.out::println);
        //ex3().forEach(System.out::println);
        //ex4().forEach(System.out::println);
        //System.out.println(ex5());
        //ex6().forEach(System.out::println);

        fillDataEx7();
        ordersEx7.forEach(System.out::println);

        //ex7().forEach(System.out::println);
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
                .filter(p -> Optional.of(p.getOrders()).orElse(new HashSet<>()).stream()
                        .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 2, 1)) >= 0)
                        .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 4, 1)) <= 0)
                        .anyMatch(o -> o.getCustomer().getTier() == 2))
                .collect(Collectors.toList());
    }

    // TODO: Get the cheapest product of “Books” category
    private static Product ex5() {
        fillDataEx5();
        return productsEx5.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase("book"))
                .min(Comparator.comparing(Product::getPrice)).orElseThrow(RuntimeException::new);
    }

    // TODO: Get the 3 most recent placed orders
    private static List<Order> ex6() {
        fillDataEx6();
        return ordersEx6.stream()
                .sorted(Comparator.comparing(Order::getOrderDate)
                        .reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    // TODO: Get a list of orders which were ordered on 15-Mar-2021,
    //  log the order records to the console and then return its product list

    /*private static List<Product> ex7() {
        fillDataEx7();
        return ordersEx7.stream()
                . //...
    }*/

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
        productsEx4 = new ArrayList<>();

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

    private static void fillDataEx5() {
        productsEx5 = new ArrayList<>();

        productsEx5.add(new Product(0, "0", "Book", 200));
        productsEx5.add(new Product(0, "1", "Food", 30));
        productsEx5.add(new Product(0, "2", "Food", 200));
        productsEx5.add(new Product(0, "3", "Book", 10));
        productsEx5.add(new Product(0, "4", "Book", 200));
        productsEx5.add(new Product(0, "5", "Food", 250));
        productsEx5.add(new Product(0, "6", "Food", 200));
        productsEx5.add(new Product(0, "7", "Book", 10));
        productsEx5.add(new Product(0, "8", "Book", 200));
        productsEx5.add(new Product(0, "9", "Book", 1200));
        productsEx5.add(new Product(0, "10", "Food", 11200));
        productsEx5.add(new Product(0, "11", "Food", 11200));
        productsEx5.add(new Product(0, "12", "Food", 11200));
        productsEx5.add(new Product(0, "13", "Food", 11200));
        productsEx5.add(new Product(0, "14", "Food", 11200));
        productsEx5.add(new Product(0, "15", "Food", 11200));
    }

    private static void fillDataEx6() {
        ordersEx6 = new ArrayList<>();

        // 28 (10), 27 (5), 27 (2)

        ordersEx6.add(new Order(1, LocalDate.of(2022, 2, 1), null, "", null));
        ordersEx6.add(new Order(2, LocalDate.of(2022, 2, 27), null, "", null));
        ordersEx6.add(new Order(3, LocalDate.of(2022, 2, 25), null, "", null));
        ordersEx6.add(new Order(4, LocalDate.of(2022, 2, 13), null, "", null));
        ordersEx6.add(new Order(5, LocalDate.of(2022, 2, 27), null, "", null));
        ordersEx6.add(new Order(6, LocalDate.of(2022, 2, 7), null, "", null));
        ordersEx6.add(new Order(7, LocalDate.of(2022, 2, 3), null, "", null));
        ordersEx6.add(new Order(8, LocalDate.of(2022, 2, 9), null, "", null));
        ordersEx6.add(new Order(9, LocalDate.of(2022, 2, 1), null, "", null));
        ordersEx6.add(new Order(10, LocalDate.of(2022, 2, 28), null, "", null));
    }

    private static void fillDataEx7() {
        ordersEx7 = new ArrayList<>();

        ordersEx7.add(new Order(1, LocalDate.of(2021, 3, 1), null, "", null));
        ordersEx7.add(new Order(2, LocalDate.of(2021, 3, 15), null, "", null));
        ordersEx7.add(new Order(3, LocalDate.of(2021, 3, 1), null, "", null));
        ordersEx7.add(new Order(4, LocalDate.of(2021, 3, 15), null, "", null));
        ordersEx7.add(new Order(5, LocalDate.of(2021, 3, 15), null, "", null));
        ordersEx7.add(new Order(6, LocalDate.of(2021, 3, 1), null, "", null));
        ordersEx7.add(new Order(7, LocalDate.of(2021, 3, 1), null, "", null));
        ordersEx7.add(new Order(8, LocalDate.of(2021, 3, 1), null, "", null));
        ordersEx7.add(new Order(9, LocalDate.of(2021, 3, 15), null, "", null));
        ordersEx7.add(new Order(10, LocalDate.of(2021, 3, 1), null, "", null));

        for (Order o : ordersEx7) {
            for (int i = 0; i < (new Random()).nextInt(10); i++) {
                o.setProduct(new Product(
                        i + 1, "Order-" + o.getId() + "-Product-" + (i + 1), "Book",
                        (new Random()).nextDouble(2000)));
            }
        }
    }
}
