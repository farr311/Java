package lesson19;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;

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
        //System.out.println(readMap());

        readStringMap();
    }

    static Map<?, ?> readMap() {
        Map returnMap = null;

        while (scanner.hasNext()) {
            Object key = readValue();
            Object value = readValue();

            if (key instanceof String && value instanceof String) {                         // str - str
                keyAndValueMatch(returnMap, k -> k instanceof String, v -> v instanceof String);
                returnMap = returnMap == null ? new HashMap<String, String>() : returnMap;
            } else if (key instanceof String && value instanceof Integer) {                 // str - int
                keyAndValueMatch(returnMap, k -> k instanceof String, v -> v instanceof Integer);
                returnMap = returnMap == null ? new HashMap<String, Integer>() : returnMap;
            } else if (key instanceof String && value instanceof Double) {                  //str - double
                keyAndValueMatch(returnMap, k -> k instanceof String, v -> v instanceof Double);
                returnMap = returnMap == null ? new HashMap<String, Double>() : returnMap;
            } else if (key instanceof Double && value instanceof Double) {                  // double - double
                keyAndValueMatch(returnMap, k -> k instanceof Double, v -> v instanceof Double);
                returnMap = returnMap == null ? new HashMap<Double, Double>() : returnMap;
            } else if (key instanceof Double && value instanceof String) {                  // double - str
                keyAndValueMatch(returnMap, k -> k instanceof Double, v -> v instanceof String);
                returnMap = returnMap == null ? new HashMap<Double, String>() : returnMap;
            } else if (key instanceof Double && value instanceof Integer) {                 // double - int
                keyAndValueMatch(returnMap, k -> k instanceof Double, v -> v instanceof Integer);
                returnMap = returnMap == null ? new HashMap<Double, Integer>() : returnMap;
            } else if (key instanceof Integer && value instanceof Integer) {                // int - int
                keyAndValueMatch(returnMap, k -> k instanceof Integer, v -> v instanceof Integer);
                returnMap = returnMap == null ? new HashMap<Integer, Integer>() : returnMap;
            } else if (key instanceof Integer && value instanceof Double) {                 // int - double
                keyAndValueMatch(returnMap, k -> k instanceof Integer, v -> v instanceof Double);
                returnMap = returnMap == null ? new HashMap<Integer, Double>() : returnMap;
            } else {                                                                        // int - str
                keyAndValueMatch(returnMap, k -> k instanceof Integer, v -> v instanceof String);
                returnMap = returnMap == null ? new HashMap<Integer, String>() : returnMap;
            }

            returnMap.put(key, value);
        }

        return returnMap;
    }

    static void keyAndValueMatch(Map map, Predicate keyCheck, Predicate valueCheck) {
        if (map != null && !(map.keySet().stream().limit(1).anyMatch(keyCheck)
                && map.values().stream().limit(1).anyMatch(valueCheck))) {
            throw new RuntimeException("TYPE MISMATCH");
        }
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

    static void readStringMap() {
        Map<String, Integer> map = new HashMap<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            int pos = line.indexOf("=");
            map.put(line.substring(0, pos).strip(), Integer.parseInt(line.substring(pos + 1).strip()));
        }

        System.out.println(map);
    }
}
