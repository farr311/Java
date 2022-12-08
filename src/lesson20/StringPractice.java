package lesson20;

import java.util.Arrays;
import java.util.Map;

public class StringPractice {

    public static void main(String[] args) {
        String s = "Hello, world";

        s = s.toUpperCase();

        /*for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i));
        }*/

        System.out.println(Arrays.toString(s.split(", ")));
        s = s.substring(0, 5);
        System.out.println(s);
        System.out.println("=".repeat(50));
        s = s.concat(" WORLD");
        System.out.println(s.contains("H"));
        System.out.println(s.indexOf("L"));
        System.out.println(s.lastIndexOf("L"));
        System.out.println(s.endsWith("WORLD"));
        System.out.println(s.startsWith("HELLO"));
    }

    //TODO
    // Написать метод, который возвращает мапу, которая содержит напротив каждрй буквы латинского алфавита
    // Количество повторение этой буквы в переданной стркое
    // Строку читать из консоли
    static Map<Character, Integer> countEachLetter(String s) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        // Заполнить мапу
        // Читать строку посимвольно и увеличивать нужную запись в мапе
    }
}
