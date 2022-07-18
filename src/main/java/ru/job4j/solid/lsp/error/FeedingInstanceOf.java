package ru.job4j.solid.lsp.error;

public class FeedingInstanceOf {
    /*
    * Использование инстанс оф или гет класс в таком духе - плохая практика.
    * Правильнее использовать перегруженный метод класса.
    * */


    public void feed(Animal animal) {
        if (animal instanceof Cow) {
            System.out.println("Eating grass");
        }

        if (animal instanceof Wolf) {
            System.out.println("Eating grass");
        }
    }

}

class Animal {
}

class Cow extends Animal {
}

class Wolf extends Animal {
}
