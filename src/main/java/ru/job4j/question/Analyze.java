package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Analyze {

    public static Info diff(Set<User> previous, Set<User> current) {
        Map<Integer, String> processingMap = new HashMap<>();
        int changed = 0;
        int deleted = 0;

        for (User user : current
        ) {
            processingMap.put(user.getId(), user.getName());
        }

        for (User user : previous
        ) {
            String name = processingMap.get(user.getId());
            if (name == null) {
                deleted++;
            } else {
                if (!name.equals(user.getName())) {
                    changed++;
                }
            }
        }
        int added = current.size() - previous.size() + deleted;
        return new Info(added, changed, deleted);
    }

}
