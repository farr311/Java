package lesson35;

import lesson35.components.A;
import lesson35.container.InjectionContainer;

public class Runner {

    //TODO:
    // Заменить логику обработки аннотаций на обработку данных, которые предоставляет класс DependencyResolver

    public static void main(String[] args) {
        //TODO:
        // 1. Создать объект DependencyResolver
        // 2. Для каждого класса, который являлся Injectable сделать добавление данных о нем в DependencyResolver
        // 3. Передать объект DependencyResolver в конструктор InjectionContainer
        // 3. Исправить код метода instantiate, чтобы все работало с DependencyResolver

        InjectionContainer container = new InjectionContainer(...);
        container.run(A.class, "execute");
    }

   /* public static void main(String[] args) {
        Component c = new Component();
        c.execute();
    }*/
}

