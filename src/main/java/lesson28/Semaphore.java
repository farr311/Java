package lesson28;

public class Semaphore {
    private final TestSubject t = new TestSubject();

    public TestSubject acquire() { return this.t; }

    public void release() {

    }
}

class TestSubject {
    private int count = 0;


    public void test() {
        System.out.println("Called " + ++count);
    }
}

class Runner {
    public static void main(String[] args) {
        Semaphore s = new Semaphore();

        for (int i = 0; i < 10; i++) {
            (new Thread(() -> {
                TestSubject t = s.acquire();
                for (int j = 0; j < 100; j++) {
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    t.test();
                }
                s.release();
            })).start();
        }
    }
}
