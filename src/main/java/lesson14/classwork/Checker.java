package lesson14.classwork;

public class Checker {

    private final int b;
    private final int a;

    public Checker(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void printIfChecked(Check c) {
        if (c.check(this.a, this.b)) {
            System.out.println("CHECKED");
        } else {
            System.out.println("UNCHECKED");
        }
    }
}
