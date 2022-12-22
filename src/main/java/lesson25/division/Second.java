package lesson25.division;

public class Second {
    public static void main(String[] args) {
        int number = 5;
        long count = 0;

        long start = System.nanoTime();

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if (i % number == 0) {
                count++;
            }
        }

        System.out.println("Total divisible by " + number + ": " + count);
        System.out.println((System.nanoTime() - start) / 1_000_000);
    }
}
