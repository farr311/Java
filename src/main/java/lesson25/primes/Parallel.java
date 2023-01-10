package lesson25.primes;

public class Parallel {
    public static void main(String[] args) {
        (new Thread(() -> calculateInRange(2, 200_000))).start();
        (new Thread(() -> calculateInRange(200_000, 400_000))).start();
        (new Thread(() -> calculateInRange(400_000, 600_000))).start();
        (new Thread(() -> calculateInRange(600_000, 800_000))).start();
        (new Thread(() -> calculateInRange(800_000, 1_000_001))).start();
    }

    private static void calculateInRange(int rangeStart, int rangeEnd) {
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
        System.out.println("Total number of primes: " + count);
        System.out.println("Total elapsed time: " + (double) (System.nanoTime() - start) / 1_000_000_000);
    }
}
