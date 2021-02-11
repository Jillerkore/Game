package me.dev.killerjore.entities.projectile;

import me.dev.killerjore.entities.Entity;

public abstract class ProjectileAbstract extends Entity {

    private float speed;

    public float getSpeed() {
        return speed;
    }
    public void setSpeed() {
        this.speed = speed;
    }

    public ProjectileAbstract(float x, float y, int width, int height, int collisionWidth, int collisionHeight, float speed) {
        super(x, y, width, height, collisionWidth, collisionHeight);
        this.speed = speed;
    }
}
