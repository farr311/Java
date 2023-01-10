package lesson22.division;

public class Parallel {
    public static void main(String[] args) {
        int number = 5;

        //TODO:
        // В цикле разбить промежуток от Long.MIN_VALUE до Long.MAX_VALUE на 10 частей
        // Каждую часть выполнить в отдельном потоке

        for (int i = 0; i < 10; i++) {
            long start = i == 0 ? Long.MIN_VALUE : Long.MIN_VALUE + (Long.MAX_VALUE / 5) * (i + 2);
            long end = start + (Long.MAX_VALUE / 5) * (i + 1);
            (new Thread(() -> calculateInRange(start, end, number))).start();
        }

        /*(new Thread(() -> calculateInRange(Integer.MIN_VALUE, 0, number))).start();
        (new Thread(() -> calculateInRange(0, Integer.MAX_VALUE, number))).start();*/
    }

    private static void calculateInRange(long rangeStart, long rangeEnd, int divisor) {
        long start = System.nanoTime();

        long count = 0;

        for (long i = rangeStart; i < rangeEnd; i++) {
            if (i % divisor == 0) {
                count++;
            }
        }

        System.out.println("=".repeat(30));
        System.out.println("Total divisible by " + divisor + ": " + count);
        System.out.println("Total elapsed time: " + (double) (System.nanoTime() - start) / 1_000_000_000);
    }
}
