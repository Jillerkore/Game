package me.dev.killerjore.entities.creature.attacker.caster;

import com.badlogic.gdx.Gdx;
import me.dev.killerjore.audio.AudioManager;
import me.dev.killerjore.entities.EntityManager;
import me.dev.killerjore.entities.creature.attacker.Attacker;
import me.dev.killerjore.entities.projectile.projectiles.Fireball;
import me.dev.killerjore.event.EventManager;
import me.dev.killerjore.event.events.Event;
import me.dev.killerjore.event.events.entityEvent.EntityMagicCastEvent;

public abstract class Caster extends Attacker {

    private float castSpeed;
    private float castAnimationElapsedTime;
    private int castElapsedTime;
    private boolean playCastAnimation = false;
    private boolean isCasting = false;

    private EntityMagicCastEvent event;

    float tempX = 0;
    float tempY = 0;

    public boolean isCasting() { return isCasting; }
    public void setCasting(boolean casting) {this.isCasting = casting;}

    public float getCastSpeed() { return castSpeed; }
    public void setCastSpeed(float castSpeed) { this.castSpeed = castSpeed; }

    public Caster(float x, float y, int width, int height, int collisionWidth, int collisionHeight, int health, int maxHealth, int stamina, int maxStamina, float speed, float attackSpeedInFrames, float castSpeed) {
        super(x, y, width, height, collisionWidth, collisionHeight, health, maxHealth, stamina, maxStamina, speed, attackSpeedInFrames);
        setCastSpeed(castSpeed);
        event = new EntityMagicCastEvent(this);
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

                // Cast the fireball after animation is over
                event.setCastType(EntityMagicCastEvent.POST);
                Fireball fireball = new Fireball(tempX, tempY, 32, 32, 32, 32, 150, getDirection());
                EntityManager.getInstance().addEntity(fireball);
                tempX = 0;
                tempY = 0;
            }
        }
    }

    public void cast() {
        if (isCasting()) {
            if (castElapsedTime >= getCastSpeed()) {

                playCastAnimation = true;
                castElapsedTime = 0;

                switch (getDirection()) {

                    case EAST:
                        animation.setCurrentCastAnimation(animation.getRightCastAnimation());
                        tempX = getX();
                        tempY = getY();
                        break;
                    case WEST:
                        animation.setCurrentCastAnimation(animation.getLeftCastAnimation());
                        tempX = getX() - 32;
                        tempY = getY();
                        break;
                    case NORTH:
                        animation.setCurrentCastAnimation(animation.getUpCastAnimation());
                        tempX = getX();
                        tempY = getY() + 32;
                        break;
                    case SOUTH:
                        animation.setCurrentCastAnimation(animation.getDownCastAnimation());
                        tempX = getX();
                        tempY = getY() - 32;
                        break;
                }

                event.setCastType(EntityMagicCastEvent.PRE);
                EventManager.getInstance().invokeEventMethods(event);
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
