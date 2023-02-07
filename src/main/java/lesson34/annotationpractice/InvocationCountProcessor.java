package lesson34.annotationpractice;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvocationCountProcessor {

    public void processForObject(Object o) {
        Class<?> clazz = o.getClass();
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(InvocationCount.class)) {
                invoke(method, o);
            }
        }
    }

    private void invoke(Method m, Object o) {
        InvocationCount a = m.getAnnotation(InvocationCount.class);
        int count = a.value();

        for (int i = 0; i < count; i++) {
            try {
                m.invoke(o);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
