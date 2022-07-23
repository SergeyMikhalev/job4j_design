package ru.job4j.solid.isp.error;

/* Для огнестрельного оружия всё ок, но что делать если мы
 * захотим сделать например меч, какой у него боеприпас?
 * необходимо два интерфейса
 * что-то вроде
 * interface Damager
 * interface AmmoConsumer
 */

public interface Weapon {
    double getDamage();

    AmmoType getAmmoType();
}

interface AmmoType {
}
