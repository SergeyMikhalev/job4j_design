package ru.job4j.question;

import java.util.Objects;

public class Info {

    private int added;
    private int changed;
    private int deleted;

    public Info(int added, int changed, int deleted) {
        this.added = added;
        this.changed = changed;
        this.deleted = deleted;
    }

    public int getAdded() {
        return added;
    }

    public void setAdded(int added) {
        this.added = added;
    }

    public int getChanged() {
        return changed;
    }

    public void setChanged(int changed) {
        this.changed = changed;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }
}
