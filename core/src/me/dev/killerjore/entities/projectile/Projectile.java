package me.dev.killerjore.entities.projectile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import me.dev.killerjore.utils.Direction;

public abstract class Projectile extends ProjectileAbstract {

    public Projectile(float x, float y, int width, int height, int collisionWidth, int collisionHeight, float speed) {
        super(x, y, width, height, collisionWidth, collisionHeight, speed);
        setSpeed();
    }

    public void moveX(TiledMap tiledMap) {
        if (getDirection() == Direction.EAST) {
            setOffsetX(getOffsetX()+ getSpeed() * Gdx.graphics.getDeltaTime());
            updatePos();
        }
        if (getDirection() == Direction.WEST) {
            setOffsetX(getOffsetX()- getSpeed() * Gdx.graphics.getDeltaTime());
            updatePos();
        }

        if (isCollidingWithTile(tiledMap)) {
            tileCollisionImpact();
        }
        if (isCollidingWithEntity(getCollisionBox())) {
            entityCollisionImpact();
        }
    }
    public void moveY(TiledMap tiledMap) {
        if (getDirection() == Direction.NORTH) {
            setOffsetY(getOffsetY() + getSpeed() * Gdx.graphics.getDeltaTime());
            updatePos();

        }
        if (getDirection() == Direction.SOUTH) {
            setOffsetY(getOffsetY() - getSpeed() * Gdx.graphics.getDeltaTime());
            updatePos();
        }
        if (isCollidingWithTile(tiledMap)) {
            tileCollisionImpact();
        }
        if (isCollidingWithEntity(getCollisionBox())) {
            entityCollisionImpact();
        }
    }

    private void updatePos() {
        setX(getOffsetX());
        setY(getOffsetY());
        updateCollisionBox();
    }

    public abstract void entityCollisionImpact();

    public void tileCollisionImpact() {
        setActive(false);
    }
}
