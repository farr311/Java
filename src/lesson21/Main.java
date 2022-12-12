package lesson21;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        //Pattern p = Pattern.compile(".+");  // 1 и более любых символов
        /*Pattern p = Pattern.compile(".*");  // 0 и более любых символов
        System.out.println(p.matcher("Hello world").matches());
        System.out.println(p.matcher("").matches());*/

        String s = "word word";

        Pattern p = Pattern.compile("");
        System.out.println(p.matcher("hello world").matches());
        System.out.println(p.matcher("goodbye world").matches());
        System.out.println(p.matcher("helloworld").matches());
        System.out.println(p.matcher("helloworld ").matches());
        System.out.println(p.matcher(" helloworld").matches());
        System.out.println(p.matcher(" helloworld ").matches());
    }
}
