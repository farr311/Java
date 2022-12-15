import lesson23.testing.Main;
import lesson23.testing.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import static lesson23.testing.Main.createUser;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("User related rests")
public class UserTest {
    User u;
    static List<User> list = new ArrayList<>();
    static Iterator<User> it;
    static User expected;

    static {
        list.add(new User("John", "Smith", 33, true, "jsmith89"));
        list.add(new User("Tyler", "Black", 59, false, "tbl_22"));
        it = list.iterator();
    }

    @BeforeEach
    void createUserData() {
        expected = it.next();
        u = createUser(
                expected.getName() + " " + expected.getLastName(),
                LocalDate.of(LocalDate.now().getYear() - expected.getAge(), 1, 1),
                expected.isAdmin() ? Main.UserType.ADMIN : Main.UserType.DEFAULT,
                expected.getLogin());
    }

    //@Test
    @DisplayName("Test user creation with correct output")
    @RepeatedTest(2)
    void testUserCorrectData() {
        assertAll(
                () -> assertEquals(u.getName(), expected.getName()),
                () -> assertEquals(u.getAge(), expected.getAge()),
                () -> assertEquals(u.getLastName(), expected.getLastName()),
                () -> assertEquals(u.isAdmin(), expected.isAdmin()),
                () -> assertEquals(u.getLogin(), expected.getLogin())
        );
    }
}
