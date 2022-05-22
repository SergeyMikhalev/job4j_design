package ru.job4j.serialization.json;

public class Weapon {
    private final int damage;

    public Weapon(int damage) {
        this.damage = damage;
    }

    @Override
    public String toString() {
        return "Weapon{"
                + "damage=" + damage
                + '}';
    }
}
