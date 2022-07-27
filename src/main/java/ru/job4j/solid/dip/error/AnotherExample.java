package ru.job4j.solid.dip.error;

public class AnotherExample {
    UserEntertainmentService service = new UserEntertainmentServiceImpl();

    /*
     * Этот пример нарушает принцип единственной ответственности и внедряет ненужную зависимость
     * от конкретной реализации. Правильнее было бы сделать так
     *
     *
     * public AnotherExample(UserEntertainmentService service) {
     *    this.service = service;
     * }
     * */

}

interface UserEntertainmentService {
    void showFunnyCatVideo();
}

class UserEntertainmentServiceImpl implements UserEntertainmentService {
    @Override
    public void showFunnyCatVideo() {
        System.out.println("Meow!");
    }
}

