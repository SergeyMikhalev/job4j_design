package ru.job4j.solid.lsp.error;

public class Rectangle {

    private int height;
    private int weight;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getArea() {
        return height * weight;
    }
}


class Square extends Rectangle {
    /* Каноничный пример с квадратом и прямоугольником.
    * Несмотря на то, что квадрат является частным случаем прямоугольника,
    * применить наследование в явном\чистом виде нельзя, т.к. у квадрата
    * стороны должны быть равны. Как реализовывать изменение размера стороны
    * неясно. Толи при присвоении длинны или ширины изменять и вторую сторону,
    * то ли вводить другой метод.
     */
}