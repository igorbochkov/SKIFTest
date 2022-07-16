package util;

import model.User;

import java.util.Arrays;
import java.util.List;

public class UserData {

    private UserData() {
    }

    public static final User USER_1 = new User("Ivanov", "Ivan", "ivanov@mail.ru", "12345");
    public static final User USER_2 = new User("Petrov", "Petr", "petrov@mail.ru", "petrov");
    public static final User USER_3 = new User("Sidorov", "Sidor", "sidorov@mail.ru", "sidorov");
    public static final User USER_4 = new User("Sveticova", "Svetlana", "sveticova@mail.ru", "sveticova");
    public static final User USER_5 = new User("Dmitriev", "Dmitriy", "dmitriev@mail.ru", "dmitriev");

    public final static List<User> users = Arrays.asList(USER_1, USER_2, USER_3, USER_4, USER_5);

    public static List<User> getUsers() {
        return users;
    }

}
