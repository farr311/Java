package lesson21;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        //Pattern p = Pattern.compile(".+");  // 1 и более любых символов
        /*Pattern p = Pattern.compile(".*");  // 0 и более любых символов
        System.out.println(p.matcher("Hello world").matches());
        System.out.println(p.matcher("").matches());*/


        // \w
        // \d
        // ^
        // $
        // * - ? +
        // [] {} () x-x

        /*String s = "word word";

        Pattern p = Pattern.compile("\\s*\\w+\\s+\\w{5,6}\\s*");
        System.out.println(p.matcher("hello world").matches());
        System.out.println(p.matcher("goodbye world").matches());
        System.out.println(p.matcher("goodbye worldd").matches());
        System.out.println(p.matcher("goodbye     something").matches());
        System.out.println(p.matcher(" goodbye world").matches());
        System.out.println(p.matcher("goodbye world ").matches());
        System.out.println(p.matcher(" goodbye world  ").matches());

        System.out.println("=".repeat(100));
        System.out.println(p.matcher("helloworld").matches());
        System.out.println(p.matcher("helloworld ").matches());
        System.out.println(p.matcher(" helloworld").matches());
        System.out.println(p.matcher(" helloworld ").matches());*/

        /*String s = "www.telran.de";
        String s1 = "https://www.google.com";
        String s2 = "http://www.google.com";
        String s3 = "google.com";
        String s4 = "google.com.";
        String s5 = "domain1.domain2.domain3.com";

        Pattern p = Pattern.compile("(http(s)?://)?(www\\.)?(\\w+\\.)+\\w+");

        System.out.println(p.matcher(s).matches());         // true
        System.out.println(p.matcher(s1).matches());        // true
        System.out.println(p.matcher(s2).matches());        // true
        System.out.println(p.matcher(s3).matches());        // true
        System.out.println(p.matcher(s4).matches());        // false
        System.out.println(p.matcher(s5).matches());        // true*/

        String s1 = "telran.de";
        String s2 = "My telephone number is +10000000000";
        String s3 = "My Telephone number is +10000000000";
        String s4 = "TELEGRAM";

        writePositionsString(s1);
        writePositionsString(s2);
        writePositionsString(s3);
        writePositionsString(s4);




        /*
        1. TODO: Write a Java program to check whether a string contains only a certain set of characters
            (in this case a-z, A-Z and 0-9).

        3. TODO: Write a Java program that matches a string that has a 'p' followed by anything, ending in 'q'.
            aaaapgdgdsq -> true
            aaaapsfhsfh -> false

        4. TODO: Write a Java program to match a string that contains only upper and lowercase letters,
            numbers, and underscores.
            AgddHbnfFH_GDsgsg1dsgSdg3 -> true
            KGHSDG8jm3!!@# -> false

        5. TODO: Write a Java program that takes a number and set thousands separator in that number.
            2000 -> 2,000

        6. TODO: Write a Java program to validate a given phone number.
            Телефонные номера начинаются с + и имеют 1-3 символа кода страны, затем идет 3 символа кода оператора и
            7 символов самого номера

        7. TODO: Write a Java program to check if a given string is a Mathematical Expression or not.
            Строка может содержать в себе буквы и цифры, разделенные символами +, -, *, /

        8. TODO: Write a Java program to insert a dash (-) between an upper case letter and a lower case letter in a given string.
            AbCd -> A-bC-d
        */
    }

    static void writePositionsString(String s) {
        Pattern p = Pattern.compile("tel", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(s);

        while (m.find()) {
            System.out.println(
                    "For the string " + s + " pattern found at positions from " + m.start() + " to " + (m.end() - 1));
        }
    }
}
