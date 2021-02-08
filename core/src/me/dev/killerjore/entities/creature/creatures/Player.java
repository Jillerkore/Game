package me.dev.killerjore.entities.creature.creatures;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import me.dev.killerjore.animations.bigCreaturesAnimation.animations.PlayerAnimation;
import me.dev.killerjore.entities.EntityManager;
import me.dev.killerjore.entities.creature.Creature;
import me.dev.killerjore.entities.statics.Teleporter;
import me.dev.killerjore.textureRepository.PlayerTextureRepo;
import me.dev.killerjore.utils.Direction;
import me.dev.killerjore.world.WorldManager;

public class Player extends Creature {

    private EntityManager entityManager;

    private OrthographicCamera camera;

    public Player(float x, float y, int width, int height, int collisionWidth, int collisionHeight, int maxHealth, int health, int maxStamina, int stamina, OrthographicCamera camera) {

        super(x, y, width, height, collisionWidth, collisionHeight, health, maxHealth, stamina, maxStamina, 120f, 60);
        this.camera = camera;

        entityManager = EntityManager.getInstance();
        entityManager.setPlayer(this);

        setOffsetX(x + 16);
        setOffsetY(y);

        animation = new PlayerAnimation();
        animation.setCurrentFrame(PlayerTextureRepo.getInstance().getTextures()[1][1]);

        updatePos();
    }

    private void tick(TiledMap tiledMap) {
        /*
        Increments delta to a float variable "elapsedTime", gonna need that delta value to play
        animation due to the way the Animation class in libgdx works
         */

        updateElapsedTimes();

        if (isWalking()) {
            handleWalking(tiledMap);
        }

        handleWorldTeleporting();
        attack();
        handleAnimations();
    }

    @Override
    public void render(Batch batch, TiledMap tiledMap) {
        tick(tiledMap);
        batch.draw(animation.getCurrentFrame(), getOffsetX(), getOffsetY());
        updateCamera();
    }

    private void handleWalking(TiledMap tiledMap) {
        // Checks the direction and sets the position and animation's frame accordingly.
        if (getDirection() == Direction.EAST) {
            moveX(tiledMap);
            animation.setCurrentFrame(animation.getRightAnimation().getKeyFrame(elapsedTime, true));
        }else if (getDirection() == Direction.WEST) {
            moveX(tiledMap);
            animation.setCurrentFrame(animation.getLeftAnimation().getKeyFrame(elapsedTime, true));
        }
        else if (getDirection() == Direction.NORTH) {
            moveY(tiledMap);
            animation.setCurrentFrame(animation.getUpAnimation().getKeyFrame(elapsedTime, true));
        }
        else if (getDirection() == Direction.SOUTH) {
            moveY(tiledMap);
            animation.setCurrentFrame(animation.getDownAnimation().getKeyFrame(elapsedTime, true));
        }
        updatePos();
        updateCollisionBox();
    }

    private void updateCamera() {
        camera.position.set(getX(), getY(), 0);
        camera.update();
    }

    private void handleWorldTeleporting() {
        EntityManager.getInstance().activeEntityList().forEach(entity -> {
            /*
            Checks if the entity is an instance of the Teleporter class, if true, it'll handle
            the teleportation if the enttiy's collision box and the teleporter's collision boxes
            are colliding. As simple as that ^_^
            */
            if (entity instanceof Teleporter) {
                Teleporter teleporter = (Teleporter) entity;
                if (entity.getCollisionBox().intersects(getCollisionBox())) {
                    WorldManager.getInstance().setCurrentWorld(teleporter.getDestinationWorld());
                    EntityManager.getInstance().setActiveWorld(teleporter.getDestinationWorld());
                    setOffsetX(teleporter.getDestinationX() - 16);
                    setOffsetY(teleporter.getDestinationY());
                    updatePos();
                    updateCamera();
                    updateCollisionBox();
                }
            }
        });
    }

}
