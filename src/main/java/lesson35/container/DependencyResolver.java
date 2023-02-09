package lesson35.container;

import java.util.ArrayList;
import java.util.List;

public class DependencyResolver {

    List<Dependency> dependencies = new ArrayList<>();

    public void addDependency(String name, String[] parentTypes, String scope) {
        dependencies.add(new Dependency(name, parentTypes, scope));
    }

    public Dependency getDependency(String type) {
        for (Dependency d : dependencies) {
            if (d.getType() == type || d.getParentTypes().contains(type)) {
                return d;
            }
        }

        return null;
    }


    public class Dependency {
        private String type;
        private String[] parentTypes;
        private Scope scope;

        public Dependency(String type, String[] parentTypes, String scope) {
            this.type = type;
            this.parentTypes = parentTypes;
            this.scope = Scope.valueOf(scope.toUpperCase());
        }

        public String getType() {
            return type;
        }

        public List<String> getParentTypes() {
            return List.of(parentTypes);
        }

        public Scope getScope() {
            return scope;
        }
    }
}
