package ru.job4j.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class User {
    private String name;
    private int children;
    private Calendar birthday;


    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }


    public static void main(String... args) {
        HashMap<User, Object> map = new HashMap<>();
        User user1 = new User("Vasia", 10, new GregorianCalendar(1999, 1, 1, 1, 1, 1));
        User user2 = new User("Vasia", 10, new GregorianCalendar(1999, 1, 1, 1, 1, 1));

        System.out.println(user1.equals(user2));

        map.put(user1, new Object());
        map.put(user2, new Object());

        System.out.println(user1.hashCode() % 16);
        System.out.println(user2.hashCode() % 16);

        System.out.println(map);

    }
}
