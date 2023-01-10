package lesson22.division;

public class First {
    public static void main(String[] args) {
        int number = 5;
        long count = 0;

        long start = System.nanoTime();

        for (int i = Integer.MIN_VALUE; i < 0; i++) {
            if (i % number == 0) {
                count++;
            }
        }

        System.out.println("Total divisible by " + number + ": " + count);
        System.out.println((System.nanoTime() - start) / 1_000_000);
    }
}
