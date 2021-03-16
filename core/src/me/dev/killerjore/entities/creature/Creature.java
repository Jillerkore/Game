package me.dev.killerjore.entities.creature;

import com.badlogic.gdx.Gdx;
import me.dev.killerjore.animations.bigCreaturesAnimation.BigCreatureAnimation;
import me.dev.killerjore.utils.Direction;

public abstract class Creature extends CreatureAbstract {

    protected BigCreatureAnimation animation;
    protected float elapsedTime;
    boolean initializedDeath = false;

    public BigCreatureAnimation getAnimation() { return animation; }
    public float getElapsedTime() { return elapsedTime; }

    public Creature(float x, float y, int width, int height, int collisionWidth, int collisionHeight, int health, int maxHealth, int stamina, int maxStamina, float speed) {

        super(x, y, width, height, collisionWidth, collisionHeight);
        setHealth(health);
        setMaxHealth(maxHealth);
        setStamina(stamina);
        setMaxStamina(maxStamina);
        setSpeed(speed);
        setDirection(Direction.EAST);
    }



    public void handleAnimations() {
    }

    protected void updateElapsedTimes() {
        elapsedTime += Gdx.graphics.getDeltaTime();

    }

    protected void handleDeath() {

        if (!initializedDeath) {
            elapsedTime = 0;
            initializedDeath = true;
        }
        if (animation.getDeathAnimation().isAnimationFinished(elapsedTime)) {
            setActive(false);
            dropItem();
        }
        animation.setCurrentFrame(animation.getDeathAnimation().getKeyFrame(elapsedTime, true));
    }

}
