package lesson25;

public class Classwork {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            (new Thread(() -> System.out.println(finalI))).start();
        }
    }
}
