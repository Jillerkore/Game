package me.dev.killerjore.entities;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import me.dev.killerjore.entities.statics.Teleporter;
import me.dev.killerjore.utils.Direction;

import java.awt.*;

public abstract class Entity extends EntityAbstract {

    public Entity(float x, float y, int width, int height, int collisionWidth, int collisionHeight) {

        setX(x + 16);
        setY(y);
        setOffsetX(x);
        setOffsetY(y);

        setWidth(width);
        setHeight(height);

        setDirection(Direction.EAST);
        setActive(true);

        this.collisionWidth = collisionWidth;
        this.collisionHeight = collisionHeight;

        collisionBound = new Rectangle((int) x, (int) y, collisionWidth, collisionHeight);
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
        boolean colliding = false;

        // All of the collidable tiles in the game are on Map Layer 2 (1 in terms of index value)
        // That's why I am setting layer to tiledMap.getLayers().get(1)
        TiledMapTileLayer layer = (TiledMapTileLayer) tiledMap.getLayers().get(1);
        TiledMapTileLayer.Cell leftCornor = null;
        TiledMapTileLayer.Cell rightCornor = null;

        /*
        Following Switch case checks if there's a cell at the position leftCornor and rightCornor
        depending on the direction the player is looking at.
         */

        switch (getDirection()) {
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
                colliding = true;
            }
        }
        if (rightCornor != null) {
            // Checks if the right cornor is colliding with a tile with the key "collidable"
            if (rightCornor.getTile().getProperties().containsKey("collidable")) {
                colliding = true;
            }
        }
        return colliding;
    }
    /*
    Updates the collision Box to match with the player's x and y
    The + collisionHeight makes sure the coordinates of the rectangle is on the Y-Up coordinate system
    I set libgdx to use Y-Down system however, the rectangle class in java awt uses Y-Down :/
    */
    public void updateCollisionBox() {
        this.collisionBound = new Rectangle((int) getX(), (int) getY() + collisionHeight, collisionWidth, collisionHeight);
    }

    public abstract void render(Batch batch, TiledMap tiledMap);
}