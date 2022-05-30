package ru.job4j.serialization.json;

import java.util.Arrays;

public class Fighter {
    private final String name;
    private final boolean aggressive;
    private final Weapon weapon;
    private final String[] canUse;

    public Fighter(String name, boolean aggressive, Weapon weapon, String[] canUse) {
        this.name = name;
        this.aggressive = aggressive;
        this.weapon = weapon;
        this.canUse = canUse;
    }

    @Override
    public String toString() {
        return "Fighter{"
                + "name='" + name + '\''
                + ", aggressive=" + aggressive
                + ", weapon=" + weapon
                + ", canUse=" + Arrays.toString(canUse)
                + '}';
    }

    public String getName() {
        return name;
    }

    public boolean isAggressive() {
        return aggressive;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public String[] getCanUse() {
        return canUse;
    }
}
