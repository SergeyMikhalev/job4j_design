package ru.job4j.solid.ocp.error;

import java.util.ArrayList;
/*Данный код нарушает принцып открытости-закрытости, т.к. если нам понадобится распечатать другой список,
 одним из вариантов решения будет изменение сигнатуры метода, поэтому лучше сразу использовать интерфейс.*/
public class ListPrinterExample {
    public static void print(ArrayList<Object> objects) {
        objects.forEach(System.out::println);
    }

}
