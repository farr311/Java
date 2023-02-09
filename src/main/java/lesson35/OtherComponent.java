package lesson35;
@Injectable(scope = Scope.SINGLETON)
public class OtherComponent {
    public void doSomething() {
        System.out.println("IT'S ALIVE");
    }
}

enum Scope {
    SINGLETON, PROTOTYPE
}

