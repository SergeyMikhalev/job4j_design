package ru.job4j.solid.lsp.foodstore;

import java.time.LocalDate;

public class Food {

    private String name;
    private LocalDate createDate;
    private LocalDate expiryDate;
    private double price;
    private double discount;

    public static Food getInstance(String name, LocalDate createDate, LocalDate expiryDate, double price, double discount) {
        checkDates(createDate, expiryDate);
        checkPrice(price);
        checkDiscount(discount);
        return new Food(name, createDate, expiryDate, price, discount);
    }

    private Food(String name, LocalDate createDate, LocalDate expiryDate, double price, double discount) {
        this.name = name;
        this.createDate = createDate;
        this.expiryDate = expiryDate;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        checkDates(createDate, this.expiryDate);
        this.createDate = createDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        checkDates(this.createDate, expiryDate);
        this.expiryDate = expiryDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        checkPrice(price);
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        checkDiscount(discount);
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Food{"
                + "name='" + name + '\''
                + ", createDate=" + createDate
                + ", expiryDate=" + expiryDate
                + ", price=" + price
                + ", discount=" + discount
                + '}';
    }

    private static void checkDiscount(double discount) {
        if (discount < 0.0 || discount > 100.0) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkDates(LocalDate createDate, LocalDate expiryDate) {
        if (expiryDate.isBefore(createDate)) {
            throw new IllegalArgumentException();
        }
    }


}
