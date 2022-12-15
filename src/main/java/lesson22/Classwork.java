package lesson22;

import java.util.List;

public class Classwork {

    public static void main(String[] args) {
        //TODO:
        // 1. Написать метод, который получает на вход список
        // 2. Для каждого вызова первого метода, полученную коллекцию нужно разбить по элементам и каждый элемент
        // передать во второй метод, который так же будет типизирован типом коллекции
        // Второй метод должен проверять, является ли число простым, а первый метод должен возвращать количество
        // простых чисел в коллекции

        System.out.println(countPrimes(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19)));
    }

    public static <T extends Number> int countPrimes(List<T> list) {
        int count = 0;

        for (T e : list) {
            if (isPrime(e)) {
                count++;
            }
        }

        return count;
    }

    public static <T extends Number> boolean isPrime(T n) {
        long num = (long) n.doubleValue();

        if (num != n.doubleValue()) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return num != 1;
    }
}
