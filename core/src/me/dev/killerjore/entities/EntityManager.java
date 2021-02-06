package me.dev.killerjore.entities;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import me.dev.killerjore.entities.creatures.Player;
import me.dev.killerjore.world.WorldType;

import java.util.ArrayList;

public class EntityManager {

    private ArrayList<Entity> entities;

    private ArrayList<Entity> starterWorldEntities, starterCaveEntities;

    private static EntityManager instance;
    private Player player;

    private boolean renderedPlayer = false;

    private WorldType activeWorld;

    public static EntityManager getInstance() {
        if (instance == null) instance = new EntityManager();
        return instance;
    }

    private EntityManager() {

        starterWorldEntities = new ArrayList<>();
        starterCaveEntities = new ArrayList<>();

        entities = starterWorldEntities;
    }

    public void setPlayer(Player player) { this.player = player; }
    public Player getPlayer() { return player;  }

    public void tick() {

        if (activeWorld == WorldType.STARTER_WORLD) {
            entities = starterWorldEntities;
        }else if (activeWorld == WorldType.STARTER_CAVE_WORLD) {
            entities = starterCaveEntities;
        }

        try {
            entities.removeIf(entity -> !entity.isActive());
        } catch(Exception ignored) {} // Ignore any concurrent exception cause we dont have to worry bout those
    }

    public void renderAllEntities(Batch batch, TiledMap tiledMap) {
        tick();
        ArrayList<Entity> postRenderList = new ArrayList<>();
        for (Entity entity : entities) {
            if (entity instanceof Player)
                continue;
            if (player.getOffsetY() + 3 < entity.getOffsetY() + entity.collisionHeight) {
                entity.render(batch, tiledMap);
            }else {
                postRenderList.add(entity);
            }
        }
        getPlayer().render(batch, tiledMap);
        for (Entity entity : postRenderList) {
            entity.render(batch, tiledMap);
        }
    }

    public ArrayList<Entity> activeEntityList() { return entities; }
    public ArrayList<Entity> getStarterWorldEntityList() { return starterWorldEntities; }
    public ArrayList<Entity> getStarterCaveEntityList() { return starterCaveEntities; }
    public void setActiveWorld(WorldType worldType) { this.activeWorld = worldType; tick(); }

}
