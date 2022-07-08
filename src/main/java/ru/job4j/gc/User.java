package ru.job4j.gc;

public class User {

    private int id;


    public User(int id) {
        this.id = id;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Removed user with id = %d %n", id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

