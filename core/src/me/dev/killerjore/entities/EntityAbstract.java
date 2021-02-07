package me.dev.killerjore.entities;

import me.dev.killerjore.utils.Direction;

import java.awt.*;


/*
Abstract class to decouple some properties from the Entity class to clean up the
Entity class a tad bit more. Similar to the CreatureProperties, but since you cannot
extend multiple classes on Java, I turned the creature properties into an object.
 */
public abstract class EntityAbstract {
    /*
     X and Y is the actual bottom left coordinate of the player while Offset X and Offset Y is
     the Bottom left cornor of the Player's texture. The dimension of x and y is 32x64 but the
     dimension of the offset X and offset Y is 64x64. Hope that makes sense haha
    */

    private float x;
    private float y;
    private float offsetX;
    private float offsetY;

    private int width;
    private int height;

    protected int collisionWidth;
    protected int collisionHeight;

    protected Rectangle collisionBound;

    /*
    If false, EntityManager will remove this entity from the entity list and the entity will stop
     getting rendered.
     */

    private boolean isActive;

    private Direction direction;

    /* Massive mess of getters and setters */
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public float getX() {
        return x;
    }
    public void setX(float x) {
        this.x = x;
    }
    public float getY() {
        return y;
    }
    public void setY(float y) {
        this.y = y;
    }
    public float getOffsetX() {
        return offsetX;
    }
    public void setOffsetX(float offsetX) {
        this.offsetX = offsetX;
    }
    public float getOffsetY() {
        return offsetY;
    }
    public void setOffsetY(float offsetY) {
        this.offsetY = offsetY;
    }
    public Rectangle getCollisionBox() {
        return collisionBound;
    }
    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean active) {
        this.isActive = active;
    }
    public Direction getDirection() {
        return direction;
    }
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

}