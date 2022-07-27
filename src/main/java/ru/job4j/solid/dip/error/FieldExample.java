package ru.job4j.solid.dip.error;

import java.util.ArrayList;

public class FieldExample {
}

interface SomeStorage {
    void store(Object obj);
}

class RAMStorage implements SomeStorage {
    /*
    * Не стоит использовать в качестве типа ссылки конкретный класс, правильнее применить интерфейс
    * List
    * */

    ArrayList list = new ArrayList(100);

    @Override
    public void store(Object obj) {
        list.add(obj);
    }
}