package lesson23.testing;

import java.time.LocalDate;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        createUserTest(
                "John Smith",
                LocalDate.of(1989, 12, 13),
                UserType.ADMIN,
                "@jsmith89");

        System.out.println("passed");
        createUserTest(
                "Tyler Black",
                LocalDate.of(1963, 9, 24),
                UserType.DEFAULT,
                "@tbl_22");
    }

    public static User createUser(String fullName, LocalDate birthDate, UserType userType, String login) {
        //TODO: Привести входные данные к тому формату, который ожидает конструктор класса User
        // Логин НЕ должен содержать символ @
        return new User(fullName.replaceAll("\\s+.*", ""),
                fullName.replaceAll(".*\s+", ""),
                LocalDate.now().compareTo(birthDate),
                true, //userType == UserType.ADMIN,
                login.replaceAll("@", ""));
    }

    public static boolean createUserTest(String fullName, LocalDate birthDate, UserType userType, String login) {
        //TODO: написать тест на метод createUser, если в полученном объекте есть какие-то неточности,
        // бросить RuntimeException
        User u = createUser(fullName, birthDate, userType, login);


        if (!(u.getName().equals(fullName.split(" ")[0])
                && u.getLastName().equals(fullName.split(" ")[1])
                && u.getAge() == LocalDate.now().compareTo(birthDate)
                && u.getLogin().equals(login.substring(1))
                && u.isAdmin() == (userType == UserType.ADMIN))) {
            throw new RuntimeException();
        }

        return true;
    }

    public static enum UserType {
        ADMIN, DEFAULT
    }
}
