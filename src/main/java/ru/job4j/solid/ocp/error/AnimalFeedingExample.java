package ru.job4j.solid.ocp.error;

import java.util.List;

/*В данном случае нарушается принцып открытости-закрытости, т.к. при добавлении новых типов животных придется
 * переписывать функцию комления */
public class AnimalFeedingExample {
    public static class Animal {
        String typeName;

        public static void feeding(List<Animal> animals) {
            for (Animal a : animals) {
                if ("Bear".equals(a.typeName)) {
                    System.out.println("Eating meat");
                }
                if ("Hamster".equals(a.typeName)) {
                    System.out.println("Eating bleeding flesh");
                }
            }
        }
    }

}
