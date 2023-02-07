package lesson34.annotationpractice;

public class Runner {

    public static void main(String[] args) {
        Greeter g = new Greeter();

        HelloAnnotationProcessor p = new HelloAnnotationProcessor();
        p.processForObject(g);

        InvocationCountProcessor ip = new InvocationCountProcessor();
        ip.processForObject(g);
    }
}

class Greeter {
    private int count = 0;

    @HelloAnnotation(greeting = Greeting.HI, from = "Java", to = "Spring")
    void m1() {}

    @HelloAnnotation(greeting = Greeting.HELLO, from = "Java", to = "Spring")
    void m2() {}

    @HelloAnnotation(greeting = Greeting.GREETINGS, from = "Java", to = "Spring")
    void m3() {}

    @InvocationCount(5)
    void m4() {
        System.out.println(++count);
    }
}
