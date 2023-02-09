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

    public void run(String className, String methodName) {
        Object o = instantiate(className);
        Class<?> clazz = o.getClass();

        try {
            Method m = clazz.getMethod(methodName);
            m.invoke(o);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private Object instantiate(String className) {
        if (resolver.getDependency(className) != null) {
            DependencyResolver.Dependency d = resolver.getDependency(className);

            Object instance;

            Class<?> clazz;
            try {
                clazz = Class.forName(d.getType());
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            if (d.getScope() == Scope.SINGLETON) {
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
                        f.set(instance, instantiate(f.getType().getName()));
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
