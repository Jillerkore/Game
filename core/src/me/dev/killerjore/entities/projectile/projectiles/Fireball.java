package me.dev.killerjore.entities.projectile.projectiles;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import me.dev.killerjore.entities.projectile.Projectile;
import me.dev.killerjore.textureRepository.projectileTextures.FireballSpellTextureRepo;
import me.dev.killerjore.utils.Direction;

public class Fireball extends Projectile {

    public Fireball(float x, float y, int width, int height, int collisionWidth, int collisionHeight, float speed, Direction direction) {
        super(x, y, width, height, collisionWidth, collisionHeight, speed, direction);
        updatePos();
    }

    @Override
    public void render(Batch batch, TiledMap tiledMap) {

//        System.out.println("Is rendering the fireball");
//        System.out.println((int)getOffsetX() / 32 + " is the x");
//        System.out.println((int)getOffsetY() / 32 + " is the y");
//        moveX(tiledMap);
//        moveY(tiledMap);
//
//        updatePos();
//
//        System.out.println("Drawing the fireball");
//        batch.draw(FireballSpellTextureRepo.getInstance().getTextures()[1][1], getOffsetX(), getOffsetY(), 32, 32 + 16);
//
    }
}
