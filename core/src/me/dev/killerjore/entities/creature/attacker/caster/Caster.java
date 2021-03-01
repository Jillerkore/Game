package me.dev.killerjore.entities.creature.attacker.caster;

import com.badlogic.gdx.Gdx;
import me.dev.killerjore.entities.EntityManager;
import me.dev.killerjore.entities.creature.Creature;
import me.dev.killerjore.entities.creature.attacker.Attacker;
import me.dev.killerjore.entities.projectile.projectiles.Fireball;
import me.dev.killerjore.event.EventManager;
import me.dev.killerjore.event.events.entityEvent.EntityAttackEntityEvent;
import me.dev.killerjore.event.events.entityEvent.EntityAttackEvent;
import me.dev.killerjore.utils.Direction;

import java.awt.*;

public abstract class Caster extends Attacker {

    private float castSpeed;
    private float castAnimationElapsedTime;
    private int castElapsedTime;
    private boolean playCastAnimation = false;
    private boolean isCasting = false;

    public boolean isCasting() { return isCasting; }
    public void setCasting(boolean casting) {this.isCasting = casting;}

    public float getCastSpeed() { return castSpeed; }
    public void setCastSpeed(float castSpeed) { this.castSpeed = castSpeed; }

    public Caster(float x, float y, int width, int height, int collisionWidth, int collisionHeight, int health, int maxHealth, int stamina, int maxStamina, float speed, float attackSpeedInFrames, float castSpeed) {
        super(x, y, width, height, collisionWidth, collisionHeight, health, maxHealth, stamina, maxStamina, speed, attackSpeedInFrames);
        setCastSpeed(castSpeed);
    }

    @Override
    public void handleAnimations() {
        super.handleAnimations();
        /*
        Cast animation
         */
        if (animation.getCurrentCastAnimation() != null) {
            if (animation.getCurrentCastAnimation().isAnimationFinished(castAnimationElapsedTime)) {
                playCastAnimation = false;
            }

            if (playCastAnimation) {
                animation.setCurrentFrame(animation.getCurrentCastAnimation().getKeyFrame(castAnimationElapsedTime, true));
            } else {
                castAnimationElapsedTime = 0;
                setCasting(false);
            }
        }
    }

    public void cast() {
        if (isCasting()) {
            if (castElapsedTime >= getCastSpeed()) {

                playCastAnimation = true;
                castElapsedTime = 0;

                Fireball fireball = null;
                switch (getDirection()) {
                    case EAST:
                        animation.setCurrentCastAnimation(animation.getRightCastAnimation());
                        fireball = new Fireball(getX() + 35, getY(), 32, 32, 32, 32, 100, getDirection());
                        break;
                    case WEST:
                        animation.setCurrentCastAnimation(animation.getLeftCastAnimation());
                        fireball = new Fireball(getX() - 35, getY(), 32, 32, 32, 32, 100, getDirection());
                        break;
                    case NORTH:
                        animation.setCurrentCastAnimation(animation.getUpCastAnimation());
                        fireball = new Fireball(getX(), getY() + 35, 32, 32, 32, 32, 100, getDirection());
                        break;
                    case SOUTH:
                        animation.setCurrentCastAnimation(animation.getDownCastAnimation());
                        fireball = new Fireball(getX(), getY() - 35, 32, 32, 32, 32, 100, getDirection());
                        break;
                }
                EntityManager.getInstance().addEntity(fireball);
            }

        }
    }


    @Override
    protected void updateElapsedTimes() {
        super.updateElapsedTimes();
        castElapsedTime++;
        castAnimationElapsedTime += Gdx.graphics.getDeltaTime();
    }
}
