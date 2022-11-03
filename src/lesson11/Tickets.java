package lesson11;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Tickets {

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

    public static void main(String[] args) {
        Map<String, String> tickets = new HashMap<>();
        tickets.put("Berlin", "London");
        tickets.put("Tokyo", "Seoul");
        tickets.put("Mumbai", "Berlin");
        tickets.put("Seoul", "Mumbai");

        Scanner scanner = new Scanner(System.in);


        System.out.println(findRoute(tickets, "Tokyo3"));
        System.out.println(findRoute(tickets, "Tokyo"));
        System.out.println(findRoute(tickets, scanner.next()));
    }

    public static String findRoute(Map<String, String> tickets, String start) {
        if (!tickets.containsKey(start)) {
            return "No flights";
        }

        StringBuilder sb = new StringBuilder();

        while (tickets.containsKey(start)) {
            if (!sb.isEmpty()) {
                sb.append(", ");
            }

            String value = tickets.get(start);
            sb.append(start).append("->").append(value);
            start = value;
        }

        return sb.toString();
    }
}
