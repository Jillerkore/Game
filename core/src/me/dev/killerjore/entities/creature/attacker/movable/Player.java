package me.dev.killerjore.entities.creature.attacker.movable;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import me.dev.killerjore.animations.bigCreaturesAnimation.animations.PlayerAnimation;
import me.dev.killerjore.entities.EntityManager;
import me.dev.killerjore.entities.creature.attacker.caster.Caster;
import me.dev.killerjore.entities.statics.Teleporter;
import me.dev.killerjore.event.EventManager;
import me.dev.killerjore.event.events.playerEvent.PlayerMoveEvent;
import me.dev.killerjore.textureRepository.TextureManager;
import me.dev.killerjore.ui.inventory.Inventory;
import me.dev.killerjore.world.WorldManager;

public class Player extends Caster {

    private EntityManager entityManager;
    private OrthographicCamera camera;

    private boolean updateCamEachFrame = false;
    public boolean walkingUp, walkingDown, walkingLeft, walkingRight;
    public boolean picking = false;

    private PlayerMoveEvent moveEvent;

    public boolean godMode = false;

    public void toggleCameraUpdate() {
        if (updateCamEachFrame) {
            updateCamEachFrame = false;
        }else {
            updateCamEachFrame = true;
        }
        updateCamera();
    }

    public Player(float x, float y, int width, int height, int collisionWidth, int collisionHeight, int maxHealth, int health, int maxStamina, int stamina, OrthographicCamera camera) {

        super(x, y, width, height, collisionWidth, collisionHeight, health, maxHealth, stamina, maxStamina, 120f, 60, 60);
        this.camera = camera;

        entityManager = EntityManager.getInstance();
        entityManager.setPlayer(this);

        setOffsetX(x + 16);
        setOffsetY(y);

        animation = new PlayerAnimation();
        animation.setCurrentFrame(TextureManager.getInstance().playerTextureRepo.getTextures()[1][1]);

        updatePos();
        camera.position.set(getX(), getY(), 0);

        walkingUp = false;
        walkingDown = false;
        walkingLeft = false;
        walkingRight = false;
    }

    private void tick(TiledMap tiledMap) {
        /*
        Increments delta to a float variable "elapsedTime", gonna need that delta value to play
        animation due to the way the Animation class in libgdx works
         */
        updateElapsedTimes();

        if (walkingUp || walkingDown || walkingLeft || walkingRight) {
            if (!isCasting()) {
                moveEvent = null;
                moveEvent = new PlayerMoveEvent(this, tiledMap);
                EventManager.getInstance().invokeEventMethods(moveEvent);
            }
        }

        handleWorldTeleporting();
        if (!isCasting())
            attack();
        cast();
        handleAnimations();

        if (getHealth() <= 0) {
            setActive(false);
        }
    }

    @Override
    public void render(Batch batch, TiledMap tiledMap) {
        if (!(getHealth() <= 0)) {
            tick(tiledMap);
        }else {
            updateElapsedTimes();
            handleDeath();
        }
        batch.draw(animation.getCurrentFrame(), getOffsetX(), getOffsetY());
        updateCamera();
    }



    private void updateCamera() {
        if (updateCamEachFrame) {
            camera.position.set(getOffsetX(), getOffsetY(), 0);
        }
        camera.update();
    }

    public void forceUpdateCamera() {
        camera.position.set(getOffsetX(), getOffsetY(), 0);
        camera.update();
    }

    private void handleWorldTeleporting() {
        EntityManager.getInstance().activeEntityList().forEach(entity -> {
            /*
            Checks if the entity is an instance of the Teleporter class, if true, it'll handle
            the teleportation if the entity's collision box and the teleporter's collision boxes
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

    public boolean isPicking() {
        return picking;
    }

    public void togglePicking() {
        picking = !picking;
    }
}