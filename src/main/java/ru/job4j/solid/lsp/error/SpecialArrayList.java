package ru.job4j.solid.lsp.error;

import java.util.ArrayList;

public class SpecialArrayList<T> extends ArrayList {

    /* Пример с дополнительными ограничениями накладываемыми на входные параметры функции.
     * Таким образом, потомок ведет себя таким образом, что не выполняет контракт предка.
     * */
    @Override
    public boolean add(Object o) {
        if (this.size() >= 1000) {
            throw new IllegalArgumentException("Слишком большой массив!!");
        }

        return super.add(o);
    }
}
