package lesson28;

public class SyncProblem {

    public static void main(String[] args) {
        Object o = new Object();
        MethodHolder mh = new MethodHolder(o);

        for (int i = 0; i < 10; i++) {
            (new Thread(() -> (new ObjectHandler(o)).handle())).start();
        }

        for (int i = 0; i < 10; i++) {
            (new Thread(() -> (new MethodInvoker(mh)).invoke())).start();
        }
    }
}

class MethodHolder {

    private final Object object;

    public MethodHolder(Object object) {
        this.object = object;
    }

    public synchronized void method() {
        System.out.println("Method invoked");
        synchronized (object) {
            System.out.println("Synchronized block reached");
        }
    }
}

class MethodInvoker {
    private final MethodHolder mh;

    public MethodInvoker(MethodHolder mh) {
        this.mh = mh;
    }

    public void invoke() {mh.method();
    }
}

class ObjectHandler {
    private final Object object;

    public ObjectHandler(Object object) {
        this.object = object;
    }

    public void handle() {
        synchronized (object) {
            System.out.println("Handling");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
