package lesson29.homework;

public class PromiseRunner {

    public <T> Promise<T> run(Promisable<T> promisable) {
        Promise<T> promise = new Promise<>();

        (new Thread(() -> {
            promise.setValue(promisable.getPromise());
        })).start();

        return promise;
    }
}
