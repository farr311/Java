package lesson25.primes;

public class Sequential {
    public static void main(String[] args) {
        int count = 0;

        long start = System.nanoTime();

        for (int i = 2; i < 1_000_001; i++) {
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

        System.out.println("Total number of primes: " + count);
        System.out.println((System.nanoTime() - start) / 1_000_000);
    }
}
