package lesson26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MinMax {

    //(1, 2, 5, 10, 50, 100)
    public static void main(String[] args) throws InterruptedException {
        int[] arr = new int[100_000_000];
        Random r = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt();
        }

        int sleepTime = 1000;

       /* solve(1, arr);
        Thread.sleep(sleepTime);
        solve(2, arr);
        Thread.sleep(sleepTime);
        solve(5, arr);
        Thread.sleep(sleepTime);*/
        solve(10, arr);
        /*Thread.sleep(sleepTime);
        solve(50, arr);
        Thread.sleep(sleepTime);
        solve(100, arr);*/
    }

    public static void solve(int n, int[] arr) {
        List<Future<Integer>> futures = splitThreads(n, arr);

        while (!checkFutures(futures)) {
            System.out.println("Calculating...");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        int max = futures.stream()
                .mapToInt(f -> {
                    try {
                        return f.get();
                    } catch (InterruptedException | ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                })
                .max().getAsInt();

        System.out.println("Total Max: " + max);
    }

    public static boolean checkFutures(List<Future<Integer>> futures) {
        for (Future<Integer> f : futures) {
            if (!f.isDone()) {
                return false;
            }
        }

        return true;
    }

    public static List<Future<Integer>> splitThreads(int n, int[] arr) {
        List<Future<Integer>> futures = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(n);

        int subArraySize = arr.length / n;
        for (int i = 0; i < n; i++) {
            int finalI = i;
            futures.add(executor.submit(() -> {
                System.out.println(Thread.currentThread());

                int start = subArraySize * finalI;
                int max = Integer.MIN_VALUE;

                for (int j = start; j < start + subArraySize; j++) {
                    if (arr[j] > max) {
                        max = arr[j];
                    }
                }
                return max;
            }));
        }

        executor.shutdown();

        return futures;
    }
}
