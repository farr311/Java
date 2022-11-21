package lesson15.homework;

import java.util.List;

public class Main {
    /*TODO
       Написать интерфейс Класс Button с методом void click(ButtonAction action)
       Написать функциональный интерфейс ButtonAction с методом performAction
       Создать Button и вызвать у него метод click 2 раза -- с лямбдой и с method
       reference (для этого нужно будет создать реализацию интерфейса ButtonAction)
     */

    public static void main(String[] args) {
        //List.of(1, 2, 3).forEach(System.out::println);
        List.of(1, 2, 3).stream()
                .map((t) -> {
                        int a = t * t;
                        int b = t - a;
                        return (double) a % b;
                    })
                .forEach(System.out::println);

        System.out.println("+".repeat(50));

        List.of(1, 2, 3).stream()
                .map(Double::valueOf)
                .forEach(System.out::println);

        System.out.println("+".repeat(50));

        List.of(1, 2, 3).stream()
                .map(e -> Double.valueOf(e))
                .forEach(System.out::println);
    }

    private void testButtons() {
        Button b = new Button();
        b.click(() -> System.out.println("Action"));

        ButtonAction ba = new ButtonAction() {
            @Override
            public void performAction() {
                System.out.println("Action 4");
            }
        };

        b.click(ba::performAction);

        /*() -> System.out.println("g");                         // Нет аргументов, нет возвращаемого значения
        () -> 5;                                                // Нет аргументов, значение 5 будет возвращено
        t -> System.out.println(t);                             // 1 аргумент, нет возвращаемого значения
        (t) -> System.out.println(t);                           // 1 аргумент, нет возвращаемого значения
        t -> Integer.valueOf(t);                                // 1 аргумент, значение Integer.valueOf(t) будет возвращено
        (t) -> Integer.valueOf(t);                              // 1 аргумент, значение Integer.valueOf(t) будет возвращено
        (a, b, c) -> System.out.println(a + b + c);             // 3 аргумента, нет возвращаемого значения
        (a, b) -> Integer.valueOf(a) + Integer.valueOf(b);      // 2 аргумента, значение суммы будет возвращено

        () -> {                                                 // Если 1 операция, блок не обязателен, если 2+, то он обязателен
            System.out.println("g");
            System.out.println("gg");

            for (int i = 0; i < 10; i++) {
                return 5;
            }
        }*/


    }
}
