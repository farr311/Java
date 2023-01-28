package lesson31;

import java.util.concurrent.*;

public class ThreadSafeCollections {

    public static void main(String[] args) {
        ConcurrentHashMap<String, String> chm = new ConcurrentHashMap<>();
        ConcurrentHashMap<String, String> chm1 = new ConcurrentHashMap<>(16, .75f);
        ConcurrentHashMap<String, String> chm2 = new ConcurrentHashMap<>(16, .75f, 16);

        BlockingQueue<Integer> abq = new ArrayBlockingQueue<>(10, false);
        PriorityBlockingQueue<Integer> pbq = new PriorityBlockingQueue<>();

    }
}
