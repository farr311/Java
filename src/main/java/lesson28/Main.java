package lesson28;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static volatile AtomicInteger a = new AtomicInteger(0);
    private static volatile AtomicInteger b = new AtomicInteger(0);

    public static void main(String[] args) {
        (new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                try {
                    Thread.sleep(10);
                    b.incrementAndGet(); // while
                    a.incrementAndGet(); // while
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        })).start();

        (new Thread(() -> {
            int count = 0;

            for (int i = 0; i < 1000; i++) {
                try {
                    Thread.sleep(10);
                    int a1 = a.get(); 
                    int b1 = b.get(); 

                    if (a1 != b1) {
                        System.out.println(a1 + " != " + b1);
                        count++;
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            System.out.println(count);
        })).start();
    }
}
