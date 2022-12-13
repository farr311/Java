package lesson22;

import java.util.ArrayList;
import java.util.List;

public class GenericsPractice {

    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("hello");
        list.add("1");

        /*String c = "gggg".concat(String.valueOf(12));

        String s = list.get(0) + " generics";
        System.out.println(s);*/

        for (String o : list) {
            System.out.println(o);
        }
    }
}

class GenericTest<T> {

}

class GenericTest2<T, A, B> {
    T t;
    A a;
    B b;

    public GenericTest2(T t, A a, B b) {
        this.t = t;
        this.a = a;
        this.b = b;
    }

    public static <X> X getValue(X x) {
        return x;
    }
}