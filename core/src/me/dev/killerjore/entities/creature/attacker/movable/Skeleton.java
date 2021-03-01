package me.dev.killerjore.entities.creature.attacker.movable;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import me.dev.killerjore.ai.HostileCreatureAI;
import me.dev.killerjore.animations.bigCreaturesAnimation.animations.SkeletonAnimation;
import me.dev.killerjore.entities.creature.MovableCreature;
import me.dev.killerjore.entities.creature.attacker.Attacker;
import me.dev.killerjore.textureRepository.TextureManager;
import me.dev.killerjore.utils.Direction;

public class Skeleton extends Attacker {

    /* AI class object */
    private HostileCreatureAI ai;

    public Skeleton(float x, float y, int width, int height, int collisionWidth, int collisionHeight, int health, int maxHealth, int stamina, int maxStamina, float speed) {
        super(x, y, width, height, collisionWidth, collisionHeight, health, maxHealth, stamina, maxStamina, speed, 60);

        setOffsetX(x);
        setOffsetY(y);

        animation = new SkeletonAnimation();
        animation.setCurrentFrame(TextureManager.getInstance().skeletonTextureRepo.getTextures()[1][1]);

        ai = new HostileCreatureAI();

        updatePos();
        updateCollisionBox();
    }

    private void tick(TiledMap tiledMap) {
        updateElapsedTimes();

        handleMovement(tiledMap);
        attack();
        handleAnimations();
    }

    @Override
    public void render(Batch batch, TiledMap tiledMap) {
        if (getHealth() <= 0) {
            updateElapsedTimes();
            handleDeath();
        }else {
            tick(tiledMap);
        }
        batch.draw(animation.getCurrentFrame(), getOffsetX(), getOffsetY());
    }

    private void handleMovement(TiledMap tiledMap) {

        if (!isAttacking()) {
            ai.walkTowardsPlayer(this, tiledMap);

            if (getDirection() == Direction.NORTH) {
                animation.setCurrentFrame(animation.getUpAnimation().getKeyFrame(elapsedTime, true));
            } else if (getDirection() == Direction.SOUTH) {
                animation.setCurrentFrame(animation.getDownAnimation().getKeyFrame(elapsedTime, true));
            } else if (getDirection() == Direction.EAST) {
                animation.setCurrentFrame(animation.getRightAnimation().getKeyFrame(elapsedTime, true));
            } else if (getDirection() == Direction.WEST) {
                animation.setCurrentFrame(animation.getLeftAnimation().getKeyFrame(elapsedTime, true));
            }
        }
    }


}
