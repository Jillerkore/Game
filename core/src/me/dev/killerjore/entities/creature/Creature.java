package me.dev.killerjore.entities.creature;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import me.dev.killerjore.animations.bigCreaturesAnimation.BigCreatureAnimation;
import me.dev.killerjore.entities.Entity;
import me.dev.killerjore.entities.EntityManager;
import me.dev.killerjore.entities.statics.Teleporter;
import me.dev.killerjore.utils.Direction;

import java.awt.*;

public abstract class Creature extends Entity {

    protected CreatureProperties properties;
    private boolean walking = false, attacking = false;

    protected float elapsedTime;
    protected BigCreatureAnimation animation;

    public CreatureProperties getProperties() {
        return properties;
    }

    public boolean isWalking() { return walking; }
    public void setWalking(boolean walking) { this.walking = walking; }
    public boolean isAttacking() { return attacking; }
    public void setAttacking(boolean attacking) { this.attacking = attacking; }


    public Creature(float x, float y, int width, int height, int collisionWidth, int collisionHeight, int health, int maxHealth, int stamina, int maxStamina, float speed) {

        super(x, y, width, height, collisionWidth, collisionHeight);
        properties = new CreatureProperties();
        properties.setHealth(health);
        properties.setMaxHealth(maxHealth);
        properties.setStamina(stamina);
        properties.setMaxStamina(maxStamina);
        properties.setSpeed(speed);
        setDirection(Direction.EAST);
    }

    protected void moveX(TiledMap tiledMap) {
        if (getDirection() == Direction.EAST) {
            float oldX = getOffsetX();
            setOffsetX(getOffsetX() + properties.getSpeed() * Gdx.graphics.getDeltaTime());
            updatePos();
            updateCollisionBox();
            // Checks collision for EAST
            if (isCollidingWithTile(tiledMap) || isCollidingWithEntity(getCollisionBox())) {
                setOffsetX(oldX);
            }
        }
        if (getDirection() == Direction.WEST) {
            float oldX = getOffsetX();
            setOffsetX(getOffsetX() - properties.getSpeed() * Gdx.graphics.getDeltaTime());
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
    public void moveY(TiledMap tiledMap) {
        if (getDirection() == Direction.NORTH) {
            float oldY = getOffsetY();
            setOffsetY(getOffsetY() + properties.getSpeed() * Gdx.graphics.getDeltaTime());
            updatePos();
            updateCollisionBox();
            if (isCollidingWithTile(tiledMap) || isCollidingWithEntity(getCollisionBox())) {
                setOffsetY(oldY);
            }
        }
        if (getDirection() == Direction.SOUTH) {
            float oldY = getOffsetY();
            setOffsetY(getOffsetY() - properties.getSpeed() * Gdx.graphics.getDeltaTime());
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

    public void attack() {
        if (isAttacking()) {
            Rectangle attackCollisionRect = new Rectangle(0, 0, 20, 20);

            if (getDirection() == Direction.EAST) {
                attackCollisionRect.setLocation((int)getX() + collisionWidth, (int)getY() + collisionHeight);
            }else if (getDirection() == Direction.WEST) {
                attackCollisionRect.setLocation((int)getX() - 20, (int)getY() + collisionHeight);
            }else if (getDirection() == Direction.NORTH) {
                attackCollisionRect.setLocation((int)getX() + 6, (int)getY() + collisionHeight + 20);
            }else if (getDirection() == Direction.SOUTH) {
                attackCollisionRect.setLocation((int)getX() + 6, (int)getY() - 20);
            }

            boolean isAttackingEntity = false;
            for (Entity entity : EntityManager.getInstance().activeEntityList()) {
                if (entity == this) continue;
                if (entity instanceof Teleporter) continue;
                if (entity.getCollisionBox().intersects(attackCollisionRect)) {
                }

            }
        }
    }

    public void updatePos() {
        setX(getOffsetX() + 16);
        setY(getOffsetY());
    }
}
