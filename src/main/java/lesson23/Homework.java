package lesson23;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Homework {

    public static void main(String[] args) {
        /*System.out.println(task1("ABCDEabcde1234"));
        System.out.println(task1("Java"));
        System.out.println(task1("telran.de"));
        System.out.println(task1("##&!(%&!#("));*/

        /*System.out.println(task2("aaaapgdgdsq"));
        System.out.println(task2("aaaapsfhsfh"));*/


        /*System.out.println(task3("AgddHbnfFH_GDsgsg1dsgSdg3"));
        System.out.println(task3("KGHSDG8jm3!!@#"));*/

        /*System.out.println(task4(1000));
        System.out.println(task4(1000000));
        System.out.println(task4(1000000000));*/

        /*System.out.println(task5("+7 535 311 11 22"));
        System.out.println(task5("+78 535 311 11 22"));
        System.out.println(task5("+378 535 311 11 22"));
        System.out.println(task5("+378 535 311 11 224"));
        System.out.println(task5("+38 535 hs311 11 22"));*/

        System.out.println(task6("100 + 200 - 300"));
        System.out.println(task6("10.5 + 200 - 300"));
        System.out.println(task6("a + 200 - 300"));
        System.out.println(task6("10.5 + a - 300"));
        System.out.println(task6("10.5 + a - 300 + 10"));
        System.out.println(task6("10?5 + a - 300 + b"));

       /* System.out.println(task7("AbCd"));
        System.out.println(task7("AbAAbbCd"));
        System.out.println(task7("AAAAAAAAAA"));
        System.out.println(task7("bbbbbbbbbbbb"));*/
    }

    // TODO: 1. Write a Java program to check whether a string contains only a certain set of characters
    //          (in this case a-z, A-Z and 0-9).
    public static boolean task1(String s) {
        return s.matches("^\\w+$");
    }


    // TODO: 2. Write a Java program that matches a string that has a 'p' followed by anything, ending in 'q'.
    //          aaaapgdgdsq -> true
    //          aaaapsfhsfh -> false
    public static boolean task2(String s) {
        return s.matches(".*p.*q$");
    }

    // TODO: 3. Write a Java program to match a string that contains only upper and lowercase letters,
    //          numbers, and underscores.
    //          AgddHbnfFH_GDsgsg1dsgSdg3 -> true
    //          KGHSDG8jm3!!@# -> false
    public static boolean task3(String s) {
        return s.matches("[A-Za-z0-9_]*");
    }

    // TODO: 4. Write a Java program that takes a number and set thousands separator in that number.
    //          2000 -> 2,000
    // 6,000,000 6,000,000,000
    public static String task4(int n) {
        String s = String.valueOf(n);
        Pattern p = Pattern.compile("\\d{3}");
        Matcher m = p.matcher(s);

        if (s.length() <= 3) {
            return s;
        }

        StringBuilder resultString = new StringBuilder();
        while (m.find()) {
            resultString.append(m.group()).append(",");
        }

        return resultString.toString().replaceAll(",$", "");
    }

    // TODO: 5. Write a Java program to validate a given phone number.
    //          Телефонные номера начинаются с + и имеют 1-3 символа кода страны, затем идет 3 символа кода оператора и
    //          7 символов самого номера

    public static boolean task5(String s) {
        return s.replaceAll("\\s+", "").matches("^\\+\\d{11,13}");
    }

    // TODO: 6. Write a Java program to check if a given string is a Mathematical Expression or not.
    //          Строка может содержать в себе буквы и цифры, разделенные символами +, -, *, /

    public static boolean task6(String s) {
        return s.matches("((\\d+\\.?\\d+)|[A-Za-z]+)\\s*[+\\-/*]\\s*((\\d+\\.?\\d+)|[A-Za-z]+)" +
                "(\\s*[+\\-/*]\\s*((\\d+\\.?\\d+)|[A-Za-z]+))*");
    }

    // TODO: 7. Write a Java program to insert a dash (-) between an upper case letter and a lower case letter in a given string.
    //          AbCd -> A-bC-d

    public static String task7(String s) {
        Matcher m = Pattern.compile("[A-Z][a-z]").matcher(s);

        while (m.find()) {
            String g = m.group();
            s = s.replaceAll(m.group(), g.charAt(0) + "-" + g.charAt(1));
        }

        return s;
    }
}
