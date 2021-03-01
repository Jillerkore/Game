package me.dev.killerjore.entities.creature.attacker;

import com.badlogic.gdx.Gdx;
import me.dev.killerjore.entities.EntityManager;
import me.dev.killerjore.entities.creature.Creature;
import me.dev.killerjore.entities.creature.MovableCreature;
import me.dev.killerjore.event.EventManager;
import me.dev.killerjore.event.events.entityEvent.EntityAttackEntityEvent;
import me.dev.killerjore.event.events.entityEvent.EntityAttackEvent;
import me.dev.killerjore.utils.Direction;

import java.awt.*;

public abstract class Attacker extends MovableCreature {

    private EntityAttackEntityEvent attackEvent;
    private EntityAttackEvent weaponSwingEvent;

    private float attackElapsedTime;
    private float attackAnimationElapsedTime;
    private float attackSpeed;

    private boolean playAttackAnimation = false;

    private boolean attacking = false;

    public boolean isAttacking() { return attacking; }
    public void setAttacking(boolean attacking) { this.attacking = attacking; }


    public void setAttackSpeed(float attackSpeed) {
        this.attackSpeed = attackSpeed;
    }
    public float getAttackSpeed() {
        return this.attackSpeed;
    }

    public Attacker(float x, float y, int width, int height, int collisionWidth, int collisionHeight, int health, int maxHealth, int stamina, int maxStamina, float speed, float attackSpeedInFrames) {
        super(x, y, width, height, collisionWidth, collisionHeight, health, maxHealth, stamina, maxStamina, speed);
        setAttackSpeed(attackSpeedInFrames);
    }

    public void attack() {
        if (isAttacking()) {

            if (attackElapsedTime >= getAttackSpeed()) {

                attackEvent = null;
                weaponSwingEvent = null;

                weaponSwingEvent = new EntityAttackEvent(this);
                EventManager.getInstance().invokeEventMethods(weaponSwingEvent);

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
                        attackEvent = new EntityAttackEntityEvent(this, entity);
                        EventManager.getInstance().invokeEventMethods(attackEvent);
                    }
                });
            }

        }
    }

    @Override
    protected void updateElapsedTimes() {
        super.updateElapsedTimes();
        attackElapsedTime++;
        attackAnimationElapsedTime += Gdx.graphics.getDeltaTime();
    }

    @Override
    public void handleAnimations() {
        super.handleAnimations();
        /*
        Attack animation
         */
        if (animation.getCurrentAttackAnimation() != null) {
            if (animation.getCurrentAttackAnimation().isAnimationFinished(attackAnimationElapsedTime)) {
                playAttackAnimation = false;
            }

            if (playAttackAnimation) {
                animation.setCurrentFrame(animation.getCurrentAttackAnimation().getKeyFrame(attackAnimationElapsedTime, true));
            } else {
                attackAnimationElapsedTime = 0;
                setAttacking(false);
            }
        }
    }
}
