package me.dev.killerjore.entities.projectile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import me.dev.killerjore.entities.Entity;
import me.dev.killerjore.entities.EntityManager;
import me.dev.killerjore.event.EventManager;
import me.dev.killerjore.event.events.projectileEvent.ProjectileHitEntityEvent;
import me.dev.killerjore.event.events.projectileEvent.ProjectileHitTileEvent;
import me.dev.killerjore.utils.Direction;

public abstract class Projectile extends ProjectileAbstract {

    public Projectile(float x, float y, int width, int height, int collisionWidth, int collisionHeight, float speed, Direction direction) {
        super(x, y, width, height, collisionWidth, collisionHeight, speed);
        setSpeed(speed);
        setDirection(direction);
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
        for (Entity entity : EntityManager.getInstance().activeEntityList()) {
            if (entity.getCollisionBox().intersects(getCollisionBox())) {
                entityCollisionImpact(entity);
                break;
            }
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
        for (Entity entity : EntityManager.getInstance().activeEntityList()) {
            if (entity.getCollisionBox().intersects(getCollisionBox())) {
                entityCollisionImpact(entity);
                break;
            }
        }
    }

    private void updatePos() {
        setX(getOffsetX());
        setY(getOffsetY());
        updateCollisionBox();
    }

    public void tileCollisionImpact() {
        ProjectileHitTileEvent e = new ProjectileHitTileEvent(this);
        EventManager.getInstance().invokeEventMethods(e);
    }

    public void entityCollisionImpact(Entity victim) {
//        ProjectileHitEntityEvent e = new ProjectileHitEntityEvent(this, victim);
//        EventManager.getInstance().invokeEventMethods(e);
    }
}
