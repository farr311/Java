package lesson34.annotationpractice;

import java.lang.reflect.Method;

public class HelloAnnotationProcessor {

    public void processForObject(Object o) {
        Class<?> clazz = o.getClass();

        Method[] methods = clazz.getDeclaredMethods();


        for (Method method : methods) {
            if (method.isAnnotationPresent(HelloAnnotation.class)) {
                greet(method);
            }
        }
    }

    private void greet(Method m) {
        HelloAnnotation a = m.getAnnotation(HelloAnnotation.class);
        String greetingString = a.greeting().toString().toLowerCase() + " from " + a.from() + " to " + a.to();

        System.out.println(greetingString);
    }
}
