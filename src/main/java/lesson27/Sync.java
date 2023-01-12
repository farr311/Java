package lesson27;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.IntFunction;

public class Sync {

    public static void main(String[] args) throws InterruptedException {
        Incrementer inc = new Incrementer();

        Object obj = new Object();

        for (int i = 0; i < 4; i++) {
            (new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    int x;
                    synchronized (obj) {
                        Modifier.setX(Producer.produce());
                        Modifier.setFunc(FunctionProducer.produce());
                        x = Modifier.Modify();
                    }

                    inc.increment(x);
                }
            })).start();
        }
        Thread.sleep(1000);
        System.out.println(inc.getCount());
    }
}

class Incrementer {
    private int count = 0;

    public synchronized void increment(int x) {
        count += x;
    }

    public int getCount() {
        return count;
    }
}

class Modifier {

    private static int x;
    private static IntFunction<Integer> func;
    public static int Modify() {
        return func.apply(x);
    }

    public static void setX(int a) {
        x = a;
    }

    public static void setFunc(IntFunction<Integer> func) {
        Modifier.func = func;
    }
}

class FunctionProducer {
    private static final List<IntFunction<Integer>> list = new ArrayList<>();

    static {
        list.add(x -> x * x);
        list.add(x -> x * 2);
        list.add(x -> -x);
    }
    private static final Random r = new Random();

    public static IntFunction<Integer> produce() {
        return list.get(r.nextInt(0, 3));
    }
}

class Producer {
    private static final Random r = new Random();

    public static int produce() {
        return r.nextInt(10);
    }
}
