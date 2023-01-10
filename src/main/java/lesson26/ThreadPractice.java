package lesson26;

public class ThreadPractice {

    private static boolean flag = false;


    public static void main(String[] args) {
        /*Thread t = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("running");
            }
        });*/

        //daemon thread


/*
        Thread t = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("running");
            }
        });

        t.setDaemon(true);

        t.start();
        System.out.println(t.isDaemon());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        Thread t = new Thread(() -> {
            while (!flag) {
                try {
                    Thread.sleep(10);
                    System.out.println("Thread had a good sleep");
                    //update all entities
                } catch (InterruptedException e) {
                    System.out.println("Sleep was interrupted");
                    //self-destruct
                    throw new RuntimeException(e);
                }
            }
        });
        t.start();

        try {
            Thread.sleep(5000);
            //t.interrupt();
            flag = true;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
