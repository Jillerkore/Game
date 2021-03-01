package me.dev.killerjore.entities.projectile.projectiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import me.dev.killerjore.animations.spellAnimation.SpellAnimation;
import me.dev.killerjore.entities.projectile.Projectile;
import me.dev.killerjore.utils.Direction;

public class Fireball extends Projectile {

    public Fireball(float x, float y, int width, int height, int collisionWidth, int collisionHeight, float speed, Direction direction) {
        super(x, y, width, height, 32, 32, speed, direction);

        SpellAnimation animation = new SpellAnimation();

        switch (getDirection()) {
            case EAST:
                activeAnimation = animation.getRightAnimation();
                paddingCollisionX = 64 - collisionWidth;
                paddingCollisionY = 0;
                break;
            case WEST:
                activeAnimation = animation.getLeftAnimation();
                paddingCollisionX = 0;
                paddingCollisionY = 0;
                break;
            case NORTH:
                activeAnimation = animation.getUpAnimation();
                paddingCollisionX = 0;
                paddingCollisionY = 64 - collisionHeight;
                break;
            case SOUTH:
                activeAnimation = animation.getDownAnimation();
                paddingCollisionX = 0;
                paddingCollisionY = -collisionHeight;
                break;
        }

        updatePos();
    }

    @Override
    public void render(Batch batch, TiledMap tiledMap) {

        tick();

        moveX(tiledMap);
        moveY(tiledMap);

        updatePos();

        batch.draw(activeAnimation.getKeyFrame(elapsedTime, true), getOffsetX(), getOffsetY());
    }

    private void tick() {
        elapsedTime += Gdx.graphics.getDeltaTime();
    }
}
