package me.dev.killerjore.save;

import java.io.Serializable;

public class ItemData implements Serializable {

    int id = -1;
    int count = 1;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getCount() { return count; }
    public void setCount(int count) { this.count = count; }

    public boolean hasItem() { return id == -1 || count == 0; }
}
