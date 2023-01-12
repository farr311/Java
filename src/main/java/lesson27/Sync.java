package lesson27;

public class Sync {

    public static void main(String[] args) throws InterruptedException {
        Incrementer inc = new Incrementer();

        for (int i = 0; i < 4; i++) {
            (new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    inc.increment();
                }
            })).start();
        }

        Thread.sleep(1000);
        System.out.println(inc.getCount());
    }
}

class Incrementer {
    private int count = 0;

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
