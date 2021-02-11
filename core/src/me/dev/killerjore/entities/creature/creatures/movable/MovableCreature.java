package me.dev.killerjore.entities.creature.creatures.movable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import me.dev.killerjore.entities.creature.Creature;
import me.dev.killerjore.utils.Direction;

public abstract class MovableCreature extends Creature {

    public void moveY(TiledMap tiledMap) {
        if (getDirection() == Direction.NORTH) {
            float oldY = getOffsetY();
            setOffsetY(getOffsetY() + getSpeed() * Gdx.graphics.getDeltaTime());
            updatePos();
            updateCollisionBox();
            if (isCollidingWithTile(tiledMap) || isCollidingWithEntity(getCollisionBox())) {
                setOffsetY(oldY);
            }
        }
        if (getDirection() == Direction.SOUTH) {
            float oldY = getOffsetY();
            setOffsetY(getOffsetY() - getSpeed() * Gdx.graphics.getDeltaTime());
            updatePos();
            updateCollisionBox();
            // Checks Collision for SOUTH
            if (isCollidingWithTile(tiledMap) || isCollidingWithEntity(getCollisionBox())) {
                setOffsetY(oldY);
            }
        }
        updatePos();
        updateCollisionBox();
    }

    protected void moveX(TiledMap tiledMap) {
        if (getDirection() == Direction.EAST) {
            float oldX = getOffsetX();
            setOffsetX(getOffsetX() + getSpeed() * Gdx.graphics.getDeltaTime());
            updatePos();
            updateCollisionBox();
            // Checks collision for EAST
            if (isCollidingWithTile(tiledMap) || isCollidingWithEntity(getCollisionBox())) {
                setOffsetX(oldX);
            }
        }
        if (getDirection() == Direction.WEST) {
            float oldX = getOffsetX();
            setOffsetX(getOffsetX() - getSpeed() * Gdx.graphics.getDeltaTime());
            updatePos();
            updateCollisionBox();
            // Checks collision for WEST
            if (isCollidingWithTile(tiledMap) || isCollidingWithEntity(getCollisionBox())) {
                setOffsetX(oldX);
            }
        }
        updatePos();
        updateCollisionBox();
    }

    public MovableCreature(float x, float y, int width, int height, int collisionWidth, int collisionHeight, int health, int maxHealth, int stamina, int maxStamina, float speed, float attackSpeedInFrames) {
        super(x, y, width, height, collisionWidth, collisionHeight, health, maxHealth, stamina, maxStamina, speed, attackSpeedInFrames);
    }
}
