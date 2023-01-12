package lesson27;

public class DaemonThreadTask {

    /*
    TODO
        Создать 5 потоков, которые будут спать по 10 секунд, причем если поток был разбужен, он должен уйти обратно в сон на оставшееся время
        Создать 6й демон-поток, который в бесконечном цикле будет проверять, спят ли основные потоки и менять значение в массиве по индексу на true,
        если они спят
        Поток main каждые 10мс проверяет состояние массива и будит все спящие потоки

    * */

    public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        boolean[] threadStates = new boolean[] { false, false, false, false, false };

        for (int i = 0; i < threads.length; i++) {
            int finalI = i;
            threads[i] = new Thread(() -> {
                long start = System.nanoTime();
                long end = start + 10_000 * 1_000_000L;
                long sleepTime = 10_000;

                while (System.nanoTime() < end) {
                    try {
                        Thread.sleep(sleepTime);
                    } catch (InterruptedException e) {
                        sleepTime = (end - System.nanoTime()) / 1_000_000;
                        System.out.println("Thread " + finalI + " was awaken. Time remains: " + sleepTime);
                    }
                }
                System.out.println("Thread execution finished");
            });
        }

        Thread daemon = new Thread(() -> {
            while (true) {
                for (int i = 0; i < threads.length; i++) {
                    threadStates[i] = threads[i].getState() == Thread.State.TIMED_WAITING;
                }
            }
        });
        daemon.setDaemon(true);

        for (Thread thread : threads) {
            thread.start();
        }
        daemon.start();

        while (threadsAreNotTerminated(threads)) {
            try {
                Thread.sleep(10);

                for (int i = 0; i < threadStates.length; i++) {
                    if (threadStates[i]) {
                        threads[i].interrupt();
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static boolean threadsAreNotTerminated(Thread[] threads) {
        for (Thread thread : threads) {
            if (thread.getState() != Thread.State.TERMINATED) {
                return true;
            }
        }
        return false;
    }
}
