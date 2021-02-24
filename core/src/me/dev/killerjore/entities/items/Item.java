package me.dev.killerjore.entities.items;

import me.dev.killerjore.entities.Entity;

public abstract class Item extends Entity {

    private int count;

    public int getCount() { return count; }
    public void setCount(int count) { this.count = count; }

    public Item(float x, float y, int width, int height, int collisionWidth, int collisionHeight) {
        super(x, y, width, height, collisionWidth, collisionHeight);
    }


}
