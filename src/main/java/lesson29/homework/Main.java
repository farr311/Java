package lesson29.homework;

//TODO: Реализовать класс Promise, который будет работать аналогично Future (в JS, например, такой функционал принадлежит
// именно что Promise).
// - Класс должен быть типизированным
// - Должны присутствовать методы hasValue(): boolean и getValue(): T
// - Реализовать функциональный интерфейс Promisable. Интерфейс должнен иметь метод  getPromise(): T
// - Реализовать класс PromiseRunner с методом run(Promisable): Promise, который возвращает пустой Promise и
//      выполняет код из Promisable в отдельном потоке, меняя значение в Promise на вычисленное

public class Main {

    public static void main(String[] args) {

        Promise<Integer> p = (new PromiseRunner()).run(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 10;
        });

        while(!p.hasValue()) {
            System.out.println("Waiting for the promise");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(p.getValue());
    }
}
