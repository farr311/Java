package lesson35.components;

import lesson35.container.Inject;

/*@Injectable(scope = Scope.PROTOTYPE)*/
public class A {
    @Inject private B b;
    @Inject private C c;
    @Inject private E e;

    public void execute() {
        b.doSomething();
        c.printHi();
        e.printHello();
    }
}
