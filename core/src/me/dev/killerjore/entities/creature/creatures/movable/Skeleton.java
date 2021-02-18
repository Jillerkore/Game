package me.dev.killerjore.entities.creature.creatures.movable;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import me.dev.killerjore.animations.bigCreaturesAnimation.animations.SkeletonAnimation;
import me.dev.killerjore.textureRepository.entityTextures.SkeletonTextureRepo;
import me.dev.killerjore.utils.Direction;

import java.util.Random;

public class Skeleton extends MovableCreature {

    /*
     * Temp code for a simple AI that randomly decides which direction to walk based on randomly generated
     * integers (1: east, 2: west, 3: north, 4: south) and also how many times to walk.
     */

    /* Random class variable to generate random number */
    private Random randomNum;

    /* Self explanatory variables */
    private int timesToWalk = 0;
    private int directionToWalk = 0;

    public Skeleton(float x, float y, int width, int height, int collisionWidth, int collisionHeight, int health, int maxHealth, int stamina, int maxStamina, float speed) {
        super(x, y, width, height, collisionWidth, collisionHeight, health, maxHealth, stamina, maxStamina, speed, 60);

        setOffsetX(x);
        setOffsetY(y);

        animation = new SkeletonAnimation();
        animation.setCurrentFrame(SkeletonTextureRepo.getInstance().getTextures()[1][1]);

        updatePos();
        updateCollisionBox();

        randomNum = new Random();
    }

    private void tick(TiledMap tiledMap) {
        updateElapsedTimes();

        handleMovement(tiledMap);
        attack();
        handleAnimations();
    }

    @Override
    public void render(Batch batch, TiledMap tiledMap) {

        tick(tiledMap);

        if (getHealth() <= 0) {
            handleDeath();
            return;
        }
        batch.draw(animation.getCurrentFrame(), getOffsetX(), getOffsetY());
    }

    private void handleMovement(TiledMap tiledMap) {

        if (!isAttacking()) {
            if (timesToWalk <= 0) {
                timesToWalk = randomNum.nextInt(40); // Picks from 1 to 20 times to walk
                directionToWalk = randomNum.nextInt(8); // 50% chance to walk and 50% not to. If it's 1-4 then 4 directions, ez
            }

            timesToWalk--;

            if (directionToWalk == 1) {
                setDirection(Direction.EAST);
                animation.setCurrentFrame(animation.getRightAnimation().getKeyFrame(elapsedTime, true));
            } else if (directionToWalk == 2) {
                setDirection(Direction.WEST);
                animation.setCurrentFrame(animation.getLeftAnimation().getKeyFrame(elapsedTime, true));
            } else if (directionToWalk == 3) {
                setDirection(Direction.NORTH);
                animation.setCurrentFrame(animation.getUpAnimation().getKeyFrame(elapsedTime, true));
            } else if (directionToWalk == 4) {
                setDirection(Direction.SOUTH);
                animation.setCurrentFrame(animation.getDownAnimation().getKeyFrame(elapsedTime, true));
            } else {
                setAttacking(true);
                return;
            }
            if (timesToWalk >= 0) {
                moveX(tiledMap);
                moveY(tiledMap);
            }

        }
    }

    private void handleDeath() {
        animation.setCurrentFrame(animation.getDeathAnimation().getKeyFrame(elapsedTime, true));
        if (animation.getDeathAnimation().isAnimationFinished(elapsedTime)) {
            setActive(false);
        }
    }
}
