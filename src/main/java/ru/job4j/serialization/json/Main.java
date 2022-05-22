package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        final Person person = new Person(false, 30, new Contact("11-111"),
                new String[]{"Worker", "Married"});

        final Fighter valeraFighter = new Fighter("Valera", true, new Weapon(10),
                new String[]{"Swords", "Daggers"});

        /* Преобразуем объект person в json-строку. */
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(person));

        System.out.println(gson.toJson(valeraFighter));

        /* Модифицируем json-строку */
        final String personJson =
                "{"
                        + "\"sex\":false,"
                        + "\"age\":35,"
                        + "\"contact\":"
                        + "{"
                        + "\"phone\":\"+7(924)111-111-11-11\""
                        + "},"
                        + "\"statuses\":"
                        + "[\"Student\",\"Free\"]"
                        + "}";

        final String fighterJson =
                "{"
                        + "\"name\":Valera,"
                        + "\"aggressive\":true,"
                        + "\"weapon\":"
                        + "{"
                        + "\"damage\":\"10\""
                        + "},"
                        + "\"canUse\":"
                        + "[\"Swords\",\"Daggers\"]"
                        + "}";


        final Person personMod = gson.fromJson(personJson, Person.class);
        System.out.println(personMod);

        final Fighter fighter = gson.fromJson(fighterJson, Fighter.class);
        System.out.println(fighter);
    }
}