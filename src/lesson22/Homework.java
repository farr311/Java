package lesson22;

import java.util.Iterator;

public class Homework {

    public static void main(String[] args) {

        CustomStringBuilder sb = new CustomStringBuilder("Hello");
        sb = sb.append(" world").append("!");

        System.out.println(sb.toString());

        Iterator<Character> it = sb.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
