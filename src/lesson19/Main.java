package lesson19;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Main {

    final static Scanner scanner = new Scanner(System.in);

    //TODO
    // Написать программу, которая, используя сканнер, считытвает из консоли пары значений.
    // На основе этих значений создается HashMap, типизированный типами этих значений, затем туда добавляются элементы.
    // Любые значения в парах могут принимать типы Integer, String и Double
    // (Возможны вфриации String, String или Integer, Integer)
    // * Отдельно написать модификацию программы, которая будет читать значения в формате строки (nextLine)
    // в формате "key = value" без кавычек. Ключи могут быть только строками, а значения только integer

    public static void main(String[] args) {
        System.out.println(readMap());
    }

    static Map<?, ?> readMap() {
        Map returnMap = null;

        while (scanner.hasNext()) {
            Object key = readValue();
            Object value = readValue();


            System.out.println("SCANNING KEY");
            System.out.println(key instanceof String);
            System.out.println(key instanceof Integer);
            System.out.println(key instanceof Double);

            System.out.println("SCANNING VALUE");
            System.out.println(value instanceof String);
            System.out.println(value instanceof Integer);
            System.out.println(value instanceof Double);

            if (key instanceof String && value instanceof String) {                         // str - str
                Map<String, String> map = new HashMap<>();
                map.put();
                returnMap = map;
            } else if (key instanceof String && value instanceof Integer) {                 // str - int
                Map<String, Integer> map = new HashMap<>();
                map.put();
                returnMap = map;
            } else if (key instanceof String && value instanceof Double) {                  //str - double
                Map<String, Double> map = new HashMap<>();
                map.put();
                returnMap = map;
            } else if (key instanceof Double && value instanceof Double) {                  // double - double
                Map<Double, Double> map = new HashMap<>();
                map.put();
                returnMap = map;
            } else if (key instanceof Double && value instanceof String) {                  // double - str
                Map<Double, String> map = new HashMap<>();
                map.put();
                returnMap = map;
            } else if (key instanceof Double && value instanceof Integer) {                 // double - int
                Map<Double, Integer> map = new HashMap<>();
                map.put();
                returnMap = map;
            } else if (key instanceof Integer && value instanceof Integer) {                // int - int
                Map<Integer, Integer> map = new HashMap<>();
                map.put();
                returnMap = map;
            } else if (key instanceof Integer && value instanceof Double) {                 // int - double
                Map<Integer, Double> map = new HashMap<>();
                map.put();
                returnMap = map;
            } else {                                                                        // int - str
                Map<Integer, String> map = new HashMap<>();
                map.put();
                returnMap = map;
            }
        }

        return returnMap;
    }

    static Object readValue() {
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else if (scanner.hasNextDouble()) {
            return scanner.nextDouble();
        } else {
            return scanner.next();
        }
    }

}
