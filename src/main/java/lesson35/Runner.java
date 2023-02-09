package lesson35;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Runner {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        InjectionContainer container = new InjectionContainer();
        container.run(Component.class, "execute");
    }

    public static void main(String[] args) {
        Component c = new Component();
        c.execute();
    }
}

class InjectionContainer {

    public void run(Class<?> clazz, String methodName) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Object o = instantiate(clazz);
        Class<?> c = o.getClass();

        try {
            Method m = c.getMethod(methodName);
            m.invoke(o);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private Object instantiate(Class<?> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        if (clazz.isAnnotationPresent(Injectable.class)) {
            Object instance = clazz.getConstructor().newInstance();
            Field[] fields = clazz.getDeclaredFields();

            for (Field f : fields) {
                if (f.isAnnotationPresent(Inject.class)) {
                    f.setAccessible(true);
                    f.set(instance, instantiate(f.getType()));
                }
            }
            return instance;
        } else {
            throw new RuntimeException();
        }
    }
}
