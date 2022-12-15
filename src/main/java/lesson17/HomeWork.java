package lesson17;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class HomeWork {

    public static void main(String[] args) {
        // Реализовать кастомный StringBuilder с методами append, reverse и toString.
        // Append должен добавлять значения во внутренний массив
        // toString должен возвращать строку, собранную из значений в порядке добавления
        // reverse должен возвращать строку, собранную из значений в обратном порядке
        // Для методов toSting и Reverse нужно использовать Function с методами compose и andThen
        MyStringBuilder sb = new MyStringBuilder();
        System.out.println(sb.toString());

        sb.append("H")
                .append("e")
                .append("l")
                .append("l")
                .append("o")
                .append(" ")
                .append("w")
                .append("o")
                .append("r")
                .append("l")
                .append("d");

        System.out.println(sb.toString());
        System.out.println(sb.reverse());
    }


}

class MyStringBuilder {
    private static final List<String> strings = new ArrayList<>();

    public String toString() {
        if (strings.size() == 0) {
            return "";
        }

        Function<String, String> f = null;

        for (String s : strings) {
            Function<String, String> tf = str -> str + s;
            f = f == null ? tf : f.andThen(tf);
        }

        return f.apply("");
    }

    public String reverse() {
        if (strings.size() == 0) {
            return "";
        }

        Function<String, String> f = null;

        for (String s : strings) {
            Function<String, String> tf = str -> str + s;
            f = f == null ? tf : f.compose(tf);
        }

        return f.apply("");
    }

    public MyStringBuilder append(String s) {
        strings.add(s);
        return this;
    }
}