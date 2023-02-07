package lesson34;

import lesson34.refl.Event;
import lesson34.refl.User;

import java.lang.reflect.*;
import java.time.LocalDateTime;
import java.util.*;

public class ReflectionPractice {

    private static final Map<Class<?>, Class<?>> wrapperMap = Map.of(
            long.class, Long.class,
            int.class, Integer.class
    );

    public static void main(String[] args) {
       /* User u = new User(1, "a", "b", LocalDateTime.of(1980, 10, 5, 0, 0));

        Class<? extends User> clazz = u.getClass();

        Method[] methods = clazz.getDeclaredMethods();
        Field[] fields = clazz.getDeclaredFields();

        Object o = new Event(1);

        System.out.println(o);*/

        Object o1 = createObjectFromClass(User.class);
        Object o2 = createObjectFromClass(Event.class);

        System.out.println(o1);
        System.out.println(o2);

        /*try {
            Field nameField = clazz.getDeclaredField("firstName");
            nameField.setAccessible(true);
            nameField.set(u, "John");

            System.out.println(nameField.get(u));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }*/

       /* for (Method method : methods) {
            Parameter[] params = method.getParameters();
            Class<?> returnType = method.getReturnType();

            if (params.length == 1 && params[0].getType().equals(String.class)) {
                System.out.println(method.getName());
            }

            if (returnType.equals(String.class)) {
                System.out.println(returnType.getName() + " " +method.getName());
            }
        }*/
    }

    public static Object createObjectFromClass(Class<?> clazz) {
        Constructor<?>[] constructors = clazz.getConstructors();

        Constructor<?> c = constructors[0];

        Parameter[] params = c.getParameters();
        List<Object> args = new ArrayList<>();

        for (Parameter p : params) {
            Class<?> paramClass = p.getType();
            Object arg = null;

            if (paramClass.isAssignableFrom(String.class)) {
                arg = "shhsf";
            } else if (paramClass.isPrimitive()) {
                Class<?> wrapperClass = wrapperMap.get(paramClass);

                if (wrapperClass.equals(Long.class)) {
                    arg = 11111;
                }
            } else if (paramClass.isAssignableFrom(LocalDateTime.class)) {
                arg = LocalDateTime.of(1980, 10, 5, 0, 0);
            }

            args.add(arg);
        }

        try {
            return c.newInstance(args.toArray());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
