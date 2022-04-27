package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Analyze {

    public static Info diff(Set<User> previous, Set<User> current) {
        Map testingMap = new HashMap();
        int added = 0;
        int changed = 0;
        int deleted = 0;

        for (User user : current
        ) {
            testingMap.put(user, user.getName());
        }

        for (User user : previous
        ) {
            if (!testingMap.containsKey(user)) {
                deleted++;
            }
        }

        return new Info(0,
                0,
                0
        );
    }

}
