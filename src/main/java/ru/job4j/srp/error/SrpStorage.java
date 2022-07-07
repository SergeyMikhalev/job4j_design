package ru.job4j.srp.error;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SrpStorage {
    private List<String> data = new ArrayList<>(100);

    public void load() {
    }

    /*  Нарушение принципа SRP  выражается в том, что условия поиска представлены в самом классе,
     *  несколькими методами. Должен быть один метод с передаваемым туда предикатом. Функционал фильтрации
     * данных должен быть делегирован в предикат поиска. */

    public List<String> findStartsWithA() {
        return data.stream().filter(s -> s.startsWith("A")).collect(Collectors.toList());
    }

    public List<String> findEndsWith1() {
        return data.stream().filter(s -> s.endsWith("1")).collect(Collectors.toList());
    }

}
