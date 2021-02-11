package me.dev.killerjore.entities.creature;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import me.dev.killerjore.animations.bigCreaturesAnimation.BigCreatureAnimation;
import me.dev.killerjore.entities.Entity;
import me.dev.killerjore.entities.EntityManager;
import me.dev.killerjore.utils.Direction;

import java.awt.*;

public abstract class Creature extends CreatureAbstract {

    protected BigCreatureAnimation animation;

    protected float elapsedTime;
    private float attackElapsedTime = 61;
    private float attackAnimationElapsedTime;

    private boolean playAttackAnimation = false;

    public Creature(float x, float y, int width, int height, int collisionWidth, int collisionHeight, int health, int maxHealth, int stamina, int maxStamina, float speed, float attackSpeedInFrames) {

        super(x, y, width, height, collisionWidth, collisionHeight);
        setHealth(health);
        setMaxHealth(maxHealth);
        setStamina(stamina);
        setMaxStamina(maxStamina);
        setSpeed(speed);
        setAttackSpeed(attackSpeedInFrames);
        setDirection(Direction.EAST);

    }

    public void attack() {

        if (isAttacking()) {

            if (attackElapsedTime >= getAttackSpeed()) {

                setStamina(getStamina() - 1);

                playAttackAnimation = true;
                attackElapsedTime = 0;

                Rectangle attackCollisionRect = new Rectangle(0, 0, 20, 20);

                if (getDirection() == Direction.EAST) {
                    animation.setCurrentAttackAnimation(animation.getRightAttackAnimation());
                    attackCollisionRect.setLocation((int) getX() + collisionWidth, (int) getY() + collisionHeight);
                } else if (getDirection() == Direction.WEST) {
                    animation.setCurrentAttackAnimation(animation.getLeftAttackAnimation());
                    attackCollisionRect.setLocation((int) getX() - 20, (int) getY() + collisionHeight);
                } else if (getDirection() == Direction.NORTH) {
                    animation.setCurrentAttackAnimation(animation.getUpAttackAnimation());
                    attackCollisionRect.setLocation((int) getX() + 6, (int) getY() + collisionHeight + 20);
                } else if (getDirection() == Direction.SOUTH) {
                    animation.setCurrentAttackAnimation(animation.getDownAttackAnimation());
                    attackCollisionRect.setLocation((int) getX() + 6, (int) getY());
                }

                EntityManager.getInstance().activeEntityList().forEach(entity -> {
                    if (entity == this) return;
                    if (!(entity instanceof Creature)) return;
                    if (entity.getCollisionBox().intersects(attackCollisionRect)) {
                        attackEvent(entity);
                    }
                });
            }

        }
    }
    public void updatePos() {
        setX(getOffsetX() + 16);
        setY(getOffsetY());
    }

    public void handleAnimations() {
        /*
        Attack animation
         */
        if (animation.getCurrentAttackAnimtion() == null) return;
        if (animation.getCurrentAttackAnimtion().isAnimationFinished(attackAnimationElapsedTime)) {
            playAttackAnimation = false;
        }

        if (playAttackAnimation) {
            animation.setCurrentFrame(animation.getCurrentAttackAnimtion().getKeyFrame(attackAnimationElapsedTime, true));
        } else {
            attackAnimationElapsedTime = 0;
            setAttacking(false);
        }
    }

    protected void updateElapsedTimes() {
        elapsedTime += Gdx.graphics.getDeltaTime();
        attackElapsedTime++;
        attackAnimationElapsedTime += Gdx.graphics.getDeltaTime();
    }

    public void attackEvent(Entity attackVictim) {
        ((Creature) attackVictim).setHealth(((Creature) attackVictim).getHealth() - 2);
    }
}
