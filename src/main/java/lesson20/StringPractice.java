package lesson20;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StringPractice {

    public static void main(String[] args) {
        /*String s = "Hello, world";

        s = s.toUpperCase();*/

        /*for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i));
        }*/

        /*System.out.println(Arrays.toString(s.split(", ")));
        s = s.substring(0, 5);
        System.out.println(s);
        System.out.println("=".repeat(50));
        s = s.concat(" WORLD");
        System.out.println(s.contains("H"));
        System.out.println(s.indexOf("L"));
        System.out.println(s.lastIndexOf("L"));
        System.out.println(s.endsWith("WORLD"));
        System.out.println(s.startsWith("HELLO"));*/

        /*Scanner scanner = new Scanner(System.in);
        System.out.println(countEachLetter(scanner.nextLine()));*/

        /*StringBuffer sBuff = new StringBuffer("Hello world");
        sBuff.insert(5, "Hello");
        sBuff.append(" World").append(" World");
        System.out.println(sBuff.reverse());*/

        StringBuilder sb = new StringBuilder("Hello world");
        sb.insert(5, "Hello");
        sb.append(" World").append(" World");
        System.out.println(sb.reverse());
    }

    //TODO
    // Написать метод, который возвращает мапу, которая содержит напротив каждрй буквы латинского алфавита
    // Количество повторение этой буквы в переданной стркое
    // Строку читать из консоли
    static Map<Character, Integer> countEachLetter(String s) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < alphabet.length(); i++) {
            map.put(alphabet.charAt(i), 0);
        }

        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            map.computeIfPresent(s.charAt(i), (k, v) -> ++v);
        }

        return map;
    }
}
