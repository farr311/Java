package lesson11;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMapTest {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();


        map.put("Bob", 30);
        map.put("Alice", 27);

        System.out.println(map.get("Bob"));
        System.out.println(map.get("Alice"));
        System.out.println(map.get("Jane"));

        System.out.println("=".repeat(90));

        System.out.println(map.containsKey("Jane"));
        System.out.println(map.containsKey("Bob"));

        System.out.println("=".repeat(90));

        System.out.println(map.containsValue(30));
        System.out.println(map.containsValue(45));

        System.out.println("=".repeat(90));

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + " : " + e.getValue());
        }

        //TODO
        // Найти маршрут из заданного списка билетов
        // Учитывая список билетов, найти маршрут по порядку, используя данный список.
        // Вход:
        // «Berlin» -> «London»
        // «Tokyo» -> «Seoul»
        // «Mumbai» -> «Berlin»
        // «Seoul» -> «Mumbai»
        // Выход:
        // Tokyo->Seoul, Seoul->Mumbai, Mumbai->Berlin, Berlin->Lindon

        Scanner scanner = new Scanner(System.in);

        String start = scanner.next();

        Map<String, String> tickets = new HashMap<>();
        tickets.put("Berlin", "London");
        tickets.put("Tokyo", "Seoul");
        tickets.put("Mumbai", "Berlin");
        tickets.put("Seoul", "Mumbai");


    }
}
