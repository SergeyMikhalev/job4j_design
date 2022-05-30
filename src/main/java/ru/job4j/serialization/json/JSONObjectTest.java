package ru.job4j.serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JSONObjectTest {

    public static void main(String[] args) {
        personExample();
        fighterExample();

    }

    private static void personExample() {
        /* JSONObject из json-строки строки */
        JSONObject jsonContact = new JSONObject("{\"phone\":\"+7(924)111-111-11-11\"}");

        /* JSONArray из ArrayList */
        List<String> list = new ArrayList<>();
        list.add("Student");
        list.add("Free");
        JSONArray jsonStatuses = new JSONArray(list);

        /* JSONObject напрямую методом put */
        String[] statuses = {"Worker", "Married"};
        final Person person = new Person(false, 30, new Contact("11-111"), statuses);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sex", person.isSex());
        jsonObject.put("age", person.getAge());
        jsonObject.put("contact", jsonContact);
        jsonObject.put("statuses", jsonStatuses);

        /* Выведем результат в консоль */
        System.out.println(jsonObject);

        /* Преобразуем объект person в json-строку */
        System.out.println(new JSONObject(person));
    }

    private static void fighterExample() {
        /* JSONObject из json-строки строки */
        JSONObject jsonWeapon = new JSONObject("{\"damage\":\"20\"}");

        /* JSONArray из ArrayList */
        List<String> canUseList = new ArrayList<>();
        canUseList.add("Swords");
        canUseList.add("Daggers");
        JSONArray jsonCanUse = new JSONArray(canUseList);

        /* JSONObject напрямую методом put */
        String[] weapons = {"Swords", "Daggers"};
        final Fighter fighter = new Fighter("Vitek", true, new Weapon(10), weapons);

        JSONObject jsonFighter = new JSONObject();
        jsonFighter.put("name", fighter.getName());
        jsonFighter.put("aggressive", fighter.isAggressive());
        jsonFighter.put("weapon", jsonWeapon);
        jsonFighter.put("canUse", jsonCanUse);

        /* Выведем результат в консоль */
        System.out.println(jsonFighter);

        /* Преобразуем объект person в json-строку */
        System.out.println(new JSONObject(fighter));
    }

}
