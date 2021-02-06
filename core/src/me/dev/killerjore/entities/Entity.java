package me.dev.killerjore.entities;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import me.dev.killerjore.entities.statics.Teleporter;
import me.dev.killerjore.utils.Direction;

import java.awt.*;

public abstract class Entity {

    // X and Y is the actual bottom left coordinate of the player while Offset X and Offset Y is
    // the Bottom left cornor of the Player's texture. The dimension of x and y is 32x64 but the
    // dimension of the offset X and offset Y is 64x64. Hope that makes sense haha
    private float x, y, offsetX, offsetY;
    private int width, height;

    protected final int collisionWidth, collisionHeight;

    private Rectangle collisionBound;

    // If false, EntityManager will remove this entity from the entity list and the entity will stop
    // getting rendered.
    private boolean isActive;

    private Direction direction;

    // Massive mess of getters and setters
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

    public Entity(float x, float y, int width, int height, int collisionWidth, int collisionHeight) {

        this.offsetX = x;
        this.offsetY = y;
        this.width = width;
        this.height = height;

        this.x = offsetX + 16;
        this.y = offsetY;

        this.collisionWidth = collisionWidth;
        this.collisionHeight = collisionHeight;

        collisionBound = new Rectangle((int) x, (int) y, collisionWidth, collisionHeight);

        isActive = true;
    }
    public boolean isCollidingWithEntity(Rectangle collisionRectangle) {
        boolean colliding = false;
        // Iterates through every entity in the active entity list
        for (Entity entity : EntityManager.getInstance().activeEntityList()) {
            if (!(entity instanceof Teleporter)) { // The entity mustn't be a teleporter, a separate code in the player class handles teleporter collision
                if (entity == this) continue; // The entity cannot be this or it'll be stuck on a single tile as the game will think the entity is colliding (with itself)
                if (collisionRectangle.intersects(entity.getCollisionBox())) {
                    colliding = true;
                    break;
                }
            }
        }
        return colliding;
    }

    public boolean isCollidingWithTile(TiledMap tiledMap) {
        boolean bolin = false;

        // All of the collidable tiles in the game are on Map Layer 2 (1 in terms of index value)
        // That's why I am setting layer to tiledMap.getLayers().get(1)
        TiledMapTileLayer layer = (TiledMapTileLayer) tiledMap.getLayers().get(1);
        TiledMapTileLayer.Cell leftCornor = null;
        TiledMapTileLayer.Cell rightCornor = null;

        /*
        Following Switch case checks if there's a cell at the position leftCornor and rightCornor
        depending on the direction the player is looking at.
         */

        switch (direction) {
            case EAST:
                leftCornor = layer.getCell((int) (getX() + 20) / 32, (int) (getY()) / 32);
                rightCornor = layer.getCell((int) (getX() + 20) / 32, (int) (getY() + 14) / 32);
                break;
            case WEST:
                leftCornor = layer.getCell((int) (getX()) / 32, (int) (getY()) / 32);
                rightCornor = layer.getCell((int) (getX()) / 32, (int) (getY() + 14) / 32);
                break;
            case NORTH:
                leftCornor = layer.getCell((int) (getX()) / 32, (int) (getY() + 14) / 32);
                rightCornor = layer.getCell((int) (getX() + 20) / 32, (int) (getY() + 14) / 32);
                break;
            case SOUTH:
                leftCornor = layer.getCell((int) (getX()) / 32, (int) (getY()) / 32);
                rightCornor = layer.getCell((int) (getX() + 20) / 32, (int) (getY()) / 32);
                break;
        }

        if (leftCornor != null) {
            // Checks if the left cornor is colliding with a tile with the key "Collidable"
            if (leftCornor.getTile().getProperties().containsKey("collidable")) {
                bolin = true;
            }
        }
        if (rightCornor != null) {
            // Checks if the right cornor is colliding with a tile with the key "collidable"
            if (rightCornor.getTile().getProperties().containsKey("collidable")) {
                bolin = true;
            }
        }
        return bolin;
    }

    // Updates the collision Box to match with the player's x and y
    // The + collisionHeight makes sure the coordinates of the rectangle is on the Y-Up coordinate system
    // I set libgdx to use Y-Down system however, the rectangle class in java awt uses Y-Down :/
    public void updateCollisionBox() {
        this.collisionBound = new Rectangle((int) getX(), (int) getY() + collisionHeight, collisionWidth, collisionHeight);
    }

    public abstract void render(Batch batch, TiledMap tiledMap);
}