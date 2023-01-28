package lesson29;

import java.util.Scanner;

import static java.lang.Thread.sleep;

public class JoinWaitNotify {

    public static void main(String[] args) {

        Object o = new Object();
        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            threads[i] = new Thread(() -> {
                synchronized (o) {
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    try {
                        sleep(300);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Thread " + finalI + " was awaken");
                   //o.notify();
                }
            });
        }

        Thread t2 = new Thread(() -> {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            synchronized (o) {
                o.notifyAll();
            }
        });

        for (Thread thread : threads) {
            thread.start();
        }

        t2.start();
    }
}

class Person {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        System.out.println(a);


    }

    static synchronized void m1() {
        Person.class.notify();
    }

    synchronized void m2() throws InterruptedException {
        this.wait();
    }
}
