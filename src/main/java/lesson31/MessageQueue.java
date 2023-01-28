package lesson31;

/*
* Задание: Написать класс MessageQueue, который будет представлять из себя простейшую очередь сообщений из 1 элемента.
* Потокобезопасность является основным условием успешной реализации для подобных утилит.
*
* Несколько важных деталей:
*   - Поле String message используется для хранения сообщения
*   - Метод send(String message) принимает сообщение записывает его в поле message, либо ждет,
*       пока предыдущее сообщение не будет прочитано
*   - Метод receive() возвращает сообщение, если оно есть, либо бросает IllegalStateException, если поле message пустое
*   - Только 1 поток может прочитать конкретное сообщение. Другой поток должен будет прочитать уже следующее сообщение.
*
* Доп. задание: Модифицировать MessageQueue таким образом, чтобы очередь могла хранить в себе n сообщений
* (число передается в конструктор)
*
* Доп. задание 2: Каждое сообщение может быть считано m раз
* */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static java.lang.Thread.sleep;

public class MessageQueue {

    private final int size;
    private final int readLimit;
    private int readCount = 0;
    private final List<Thread> threads = new ArrayList<>();

    private final Deque<String> queue;
    public MessageQueue(int size, int readLimit) {
        this.size = size;
        this.readLimit = readLimit;
        this.queue = new ArrayDeque<>();
    }

    public synchronized void send(String message) {
        threads.add(Thread.currentThread());
        while (queue.size() == size) {
            try {
                wait();
            } catch (InterruptedException e) {
                return;
            }
        }
        queue.push(message);
        notifyAll();
    }

    public synchronized String receive() {
        while (queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        String msg;
        if (++readCount == readLimit) {
            msg = queue.pop();
            readCount = 0;
        } else {
            msg = queue.peek();
        }
        notifyAll();
        return msg;
    }

    public void shutdown() {
        threads.forEach(t -> t.interrupt());
    }

}

class Runner {

    public static void main(String[] args) throws InterruptedException {
        MessageQueue mq = new MessageQueue(5, 2);

        for (int i = 0; i < 20; i++) {
            int finalI = i;
            (new Thread(() -> {
                mq.send("Message " + finalI);
            })).start();
        }

        for (int i = 0; i < 20; i++) {
            (new Thread(() -> {
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(mq.receive());
            })).start();
        }

        sleep(2000);
        mq.shutdown();
    }
}
