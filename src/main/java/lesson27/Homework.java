package lesson27;

public class Homework {
    /*TODO
        1. Создать 2 потока:
        1 Спит 10 секунд, обрабатывает InterruptedException следующим образом:
        Посчитать, сколько осталось до окончания сна через System.nanoTime()
        Написать в консоль, сколько еще осталось спать, продлолжить спать оставшееся время
        2 Каждые 10 мс проверяет, спит ли поток 1 через Thread.getState()
        Если поток спит, разбудить его
        Если поток закончил выполнение, сделать return

       TODO
        2. Модифицировать первую часть так, чтобы 2 поток интерраптил первый, даже если он активен
        Первый поток должен самостоятельно проверять свой флаг interrupted и выводить в консоль, что была попытка его разбудить, но он не спал
    */


    /*
    TODO
        Создать 5 потоков, которые будут спать по 10 секунд, причем если поток был разбужен, он должен уйти обратно в сон на оставшееся время
        Создать 6й демон-поток, который в бесконечном цикле будет проверять, спят ли основные потоки и менять значение в массиве по индексу на true,
        если они спят
        Поток main каждые 10мс проверяет состояние массива и будит все спящие потоки

    * */

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            long start = System.nanoTime();
            long end = start + 10_000 * 1_000_000L;
            long sleepTime = 10_000;

            while (System.nanoTime() < end) {
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    sleepTime = (end - System.nanoTime()) / 1_000_000;
                    System.out.println("Thread was awaken. Time remains: " + sleepTime);
                }
            }
            System.out.println("Thread execution finished");
        });

        Thread t2 = new Thread(() -> {
            while (t1.getState() != Thread.State.TERMINATED) {
                try {
                    Thread.sleep(10);
                    if (t1.getState() == Thread.State.TIMED_WAITING) {
                        System.out.println("Thread 1 is sleeping and must be interrupted");
                        t1.interrupt();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Thread 1 was terminated");
        });


        //t1.start();
        //t2.start();


        Thread t3 = new Thread(() -> {
            long start = System.nanoTime();
            long end = start + 10_000 * 1_000_000L;
            long sleepTime = 10_000;

            while (System.nanoTime() < end) {
                for (int i = 0; i < 1_000_000_000; i++) {
                    if (Thread.interrupted()) {
                        System.out.println("Thread was interrupted, but it was not asleep");
                    }
                }

                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    sleepTime = (end - System.nanoTime()) / 1_000_000;
                    //System.out.println("Thread was awaken. Time remains: " + sleepTime);
                }
            }
            System.out.println("Thread execution finished");
        });

        Thread t4 = new Thread(() -> {
            while (t3.getState() != Thread.State.TERMINATED) {
                try {
                    Thread.sleep(10);
                    //System.out.println("Thread 1 must be interrupted");
                    t3.interrupt();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
           System.out.println("Thread 1 was terminated");
        });


        t3.start();
        t4.start();
    }
}
