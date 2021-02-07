package me.dev.killerjore.entities.creature.creatures;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import me.dev.killerjore.animations.bigCreaturesAnimation.animations.SkeletonAnimation;
import me.dev.killerjore.entities.creature.Creature;
import me.dev.killerjore.textureRepository.SkeletonTextureRepo;

public class Skeleton extends Creature {

    public Skeleton(float x, float y, int width, int height, int collisionWidth, int collisionHeight, int health, int maxHealth, int stamina, int maxStamina, float speed) {
        super(x, y, width, height, collisionWidth, collisionHeight, health, maxHealth, stamina, maxStamina, speed);

        setOffsetX(x);
        setOffsetY(y);

        animation = new SkeletonAnimation();
        animation.setCurrentFrame(SkeletonTextureRepo.getInstance().getTextures()[1][1]);

        updatePos();
        updateCollisionBox();

    }

    @Override
    public void render(Batch batch, TiledMap tiledMap) {

        elapsedTime += Gdx.graphics.getDeltaTime();

        if (properties.getHealth() <= 0) {
            handleDeath();
        }

        handleMovement(tiledMap);
        batch.draw(animation.getCurrentFrame(), getOffsetX(), getOffsetY());
    }

    private void handleMovement(TiledMap tiledMap) {
    }

    private void handleDeath() {
        if (animation.getDeathAnimation().isAnimationFinished(elapsedTime))
            setActive(false);
        animation.setCurrentFrame(animation.getDeathAnimation().getKeyFrame(elapsedTime, true));
    }
}
