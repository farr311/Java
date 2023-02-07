package lesson34;

import lesson34.refl.Event;
import lesson34.refl.User;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.time.LocalDateTime;
import java.util.Arrays;

public class ReflectionPractice {

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
        Object o;

        /*
        * TODO:
        *   1. Получить список конструкторов класса
        *   2. Взять первые конструктор
        *   3. Узнать, какие аргументы он принимает
        *   4. В зависимости от типа передать любые аргументы этого типа
        * */

        /*Class<?> paramClass;
        Object arg;

        if (paramClass.isAssignableFrom(String.class)) {
            arg = "shhsf";
        } else if (paramClass.isAssignableFrom(Integer.class)) {
            arg = 11111;
        }*/

        return o;
    }
}
