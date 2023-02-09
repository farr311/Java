package lesson35;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Injectable()
public class Component {
    @Inject private OtherComponent c;

    public void execute() {
        c.doSomething();
    }
}

@Retention(RetentionPolicy.RUNTIME)
@interface Injectable {
    Scope scope();
}

@Retention(RetentionPolicy.RUNTIME)
@interface Inject {

}
