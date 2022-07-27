package ru.job4j.solid.dip.error;

import java.util.ArrayList;

public class ArgumentExample {

    /*
    * Метод нарушает принцип инверсии зависимостей, следует указать тип параметра List без уточнения
    * реализации
    * */
    public void printListToConsole(ArrayList list) {
        list.forEach(System.out::println);
    }
}
