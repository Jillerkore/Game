package me.dev.killerjore.entities.projectile.projectiles;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import me.dev.killerjore.entities.projectile.Projectile;
import me.dev.killerjore.textureRepository.projectileTextures.FireballSpellTextureRepo;
import me.dev.killerjore.utils.Direction;

public class Fireball extends Projectile {

    public Fireball(float x, float y, int width, int height, int collisionWidth, int collisionHeight, float speed, Direction direction) {
        super(x, y, width, height, collisionWidth, collisionHeight, speed, direction);
    }

    @Override
    public void render(Batch batch, TiledMap tiledMap) {

        moveX(tiledMap);
        moveY(tiledMap);

        batch.draw(FireballSpellTextureRepo.getInstance().getTextures()[5][1], getOffsetX(), getOffsetY());
    }
}
