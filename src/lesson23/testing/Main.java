package lesson23.testing;

import java.time.LocalDate;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        User u = createUser(
                "John Smith",
                LocalDate.of(1989, 12, 13),
                UserType.ADMIN,
                "@jsmith89"
        );
    }

    static User createUser(String fullName, LocalDate birthDate, UserType userType, String login) {
        //TODO: Привести входные данные к тому формату, который ожидает конструктор класса User
        // Логин НЕ должен содержать символ @
    }

    private static enum UserType {
        ADMIN, DEFAULT
    }
}

class User {
    private String name;
    private String lastName;
    private int age;
    private boolean isAdmin;
    private String login;

    public User(String name, String lastName, int age, boolean isAdmin, String login) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.isAdmin = isAdmin;
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
