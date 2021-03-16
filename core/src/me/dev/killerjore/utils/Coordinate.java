package me.dev.killerjore.utils;

public class Coordinate {

    private float x;
    private float y;

    public float getX() { return x; }
    public float getY() { return y; }
    public void setX(float x) { this.x = x; }
    public void setY(float y) { this.y = y; }

    public Coordinate(float x, float y) {
        setX(x);
        setY(y);
    }
}
