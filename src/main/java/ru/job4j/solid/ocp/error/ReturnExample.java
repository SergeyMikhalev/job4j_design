package ru.job4j.solid.ocp.error;

public class ReturnExample {

    /* Возвращаемый результат ввиде класса, не наследующего интерфейса так же приводит к большей связности и
    *  высокой вероятности внесения изменений в класс вдальнейшем.*/
    public Apple getFruit() {
        return new Apple();
    }
}

class Apple {
}