package lesson35;

import lesson35.container.DependencyResolver;
import lesson35.container.InjectionContainer;

public class Runner {

    public static void main(String[] args) {
        DependencyResolver resolver = new DependencyResolver();
        resolver.addDependency("lesson35.components.A", new String[0], "prototype");
        resolver.addDependency("lesson35.components.B", new String[0], "singleton");
        resolver.addDependency("lesson35.components.C", new String[0], "singleton");
        resolver.addDependency("lesson35.components.D", new String[] { "lesson35.components.E" }, "singleton");

        InjectionContainer container = new InjectionContainer(resolver);
        container.run("lesson35.components.A", "execute");
    }

   /* public static void main(String[] args) {
        Component c = new Component();
        c.execute();
    }*/
}

