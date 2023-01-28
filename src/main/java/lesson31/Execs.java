package lesson31;

import java.util.concurrent.*;

public class Execs {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService ex = Executors.newFixedThreadPool(12);
        for (int i = 0; i < 30; i++) {
            Future<?> f = ex.submit(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        Thread.sleep(100);
       /* long start = System.nanoTime();
        ex.shutdown();
        System.out.println((System.nanoTime() - start) / 1_000_000);*/

        ex.shutdown();
        try {
            if (!ex.awaitTermination(400, TimeUnit.MILLISECONDS)) {
                ex.shutdownNow();
            }
        } catch (InterruptedException e) {
            ex.shutdownNow();
        }

        /*while (!f.isDone()) {
            System.out.println("waiting");
            Thread.sleep(100);
        }
        System.out.println(f.get());*/

        //ex.shutdownNow();

        ScheduledExecutorService schex = Executors.newSingleThreadScheduledExecutor();
        schex.scheduleAtFixedRate(
                () -> System.out.println(System.nanoTime() / 1_000_000),
                500, 300, TimeUnit.MILLISECONDS);


        Thread.sleep(5000);
        schex.shutdown();
    }
}
