package lesson28;

public class Semaphore {
    private final TestSubject t = new TestSubject();

    public synchronized TestSubject acquire() {
        return null;
    }

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

    }
}
