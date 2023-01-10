package lesson25.primes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Parallel {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        List<Future<Integer>> futures = new ArrayList<>();
        futures.add(executor.submit(() -> calculateInRange(2, 200_000)));
        futures.add(executor.submit(() -> calculateInRange(200_000, 400_000)));
        futures.add(executor.submit(() -> calculateInRange(400_000, 600_000)));
        futures.add(executor.submit(() -> calculateInRange(600_000, 800_000)));
        futures.add(executor.submit(() -> calculateInRange(800_000, 1_000_001)));

        while (!checkFutures(futures)) {
            Thread.sleep(300);
            System.out.println("Calculating...");
        }

        System.out.println(futures.stream()
                .mapToInt(f -> {
                    try {
                        return f.get();
                    } catch (InterruptedException | ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                })
                .max().orElseThrow(RuntimeException::new));
    }

    private static boolean checkFutures(List<Future<Integer>> futures) {
        for (Future<Integer> future : futures) {
            if (!future.isDone()) {
                return false;
            }
        }
        return true;
    }

    private static int calculateInRange(int rangeStart, int rangeEnd) {
        System.out.println("Started");
        long start = System.nanoTime();

        int count = 0;

        for (int i = rangeStart; i < rangeEnd; i++) {
            boolean isPrime = true;

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                count++;
            }
        }

        System.out.println("=".repeat(30));
        System.out.println("Total elapsed time: " + (double) (System.nanoTime() - start) / 1_000_000_000);
        return count;
    }
}
