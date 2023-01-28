package lesson29;

import java.util.ArrayList;
import java.util.List;

public class TestDeadlock {
    public static void main(String[] args) {
        final String resource1 = "Dead";
        final String resource2 = "Lock";

        // t1 tries to lock resource1 then resource2
        List<Thread> threads = new ArrayList<>();

        Thread t1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 1: locked resource 1");

                try {
                    Thread.sleep(100);
                } catch (Exception ignored) {}

                Thread ft2 = threads.get(1);

                Thread.State state = ft2.getState();
                while (state != Thread.State.TERMINATED && state != Thread.State.NEW && state != Thread.State.TIMED_WAITING) {
                    System.out.println("Thread 1 is waiting for Thread 2");
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    state = ft2.getState();
                }

                synchronized (resource2) {
                    System.out.println("Thread 1: locked resource 2");
                }
            }
            System.out.println("Thread 1: all locks exited");
        });

        // t2 tries to lock resource2 then resource1
        Thread t2 = new Thread(() -> {
            Thread ft1 = threads.get(0);

            Thread.State state = ft1.getState();
            while (state != Thread.State.TERMINATED && state != Thread.State.NEW) {
                System.out.println("Thread 2 is waiting for Thread 1");
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                state = ft1.getState();
            }
            synchronized (resource2) {
                System.out.println("Thread 2: locked resource 2");

                try {
                    Thread.sleep(100);
                } catch (Exception ignored) {}

                synchronized (resource1) {
                    System.out.println("Thread 2: locked resource 1");
                }
            }
            System.out.println("Thread 2: all locks exited");
        });

        threads.add(t1);
        threads.add(t2);

        t1.start();
        t2.start();
    }
}
