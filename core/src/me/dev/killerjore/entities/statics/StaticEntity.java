package me.dev.killerjore.entities.statics;

import me.dev.killerjore.entities.Entity;

public abstract class StaticEntity extends Entity {
    public StaticEntity(float x, float y, int width, int height, int collisionWidth, int collisionHeight) {
        super(x, y, width, height, collisionWidth, collisionHeight);
    }
}
