package lesson35.container;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class InjectionContainer {

    DependencyResolver resolver;
    Map<Class<?>, Object> singletonMap = new HashMap<>();

    public InjectionContainer(DependencyResolver resolver) {
        this.resolver = resolver;
    }

    public void run(Class<?> clazz, String methodName) {
        Object o = instantiate(clazz);
        Class<?> c = o.getClass();

        try {
            Method m = c.getMethod(methodName);
            m.invoke(o);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private Object instantiate(Class<?> clazz) {
        if (clazz.isAnnotationPresent(Injectable.class)) {
            Injectable annotation = clazz.getAnnotation(Injectable.class);

            Object instance;

            if (annotation.scope() == Scope.SINGLETON) {
                instance = singletonMap.computeIfAbsent(clazz, k -> {
                    try {
                        return clazz.getConstructor().newInstance();
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                             NoSuchMethodException e) {
                        throw new RuntimeException(e);
                    }
                });
            } else {
                try {
                    instance = clazz.getConstructor().newInstance();
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                         NoSuchMethodException e) {
                    throw new RuntimeException(e);
                }
            }

            Field[] fields = clazz.getDeclaredFields();

            for (Field f : fields) {
                if (f.isAnnotationPresent(Inject.class)) {
                    f.setAccessible(true);
                    try {
                        f.set(instance, instantiate(f.getType()));
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            return instance;
        } else {
            throw new RuntimeException();
        }
    }
}
