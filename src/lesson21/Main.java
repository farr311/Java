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

        writePositionsString(s1);
        writePositionsString(s2);
    }

    static void writePositionsString(String s) {
        Pattern p = Pattern.compile("tel");

        int start;
        int end;
        //Вычислить start и end для первой и второй строк
        System.out.println("For the string " + s + "pattern found at positions from " + start + " to " + end);
    }

}
