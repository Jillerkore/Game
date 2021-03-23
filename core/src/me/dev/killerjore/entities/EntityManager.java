package me.dev.killerjore.entities;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import me.dev.killerjore.entities.creature.attacker.movable.Player;
import me.dev.killerjore.entities.item.Item;
import me.dev.killerjore.world.WorldType;

import java.util.ArrayList;
import java.util.Comparator;

public class EntityManager {

    private ArrayList<Entity> entities;

    private ArrayList<Entity> starterWorldEntities, starterCaveEntities, pendingEntityList, pendingEntityRemoveList;

    private static EntityManager instance;
    private Player player;

    private WorldType activeWorld;

    private Comparator<Entity> entitySorter = (entityOne, entityTwo) -> {
        if(entityOne.getOffsetY() + entityOne.collisionHeight > entityTwo.getOffsetY() + entityTwo.collisionHeight + 3)
            return -1;
        return 1;
    };

    public static EntityManager getInstance() {
        if (instance == null) instance = new EntityManager();
        return instance;
    }

    private EntityManager() {

        starterWorldEntities = new ArrayList<>();
        starterCaveEntities = new ArrayList<>();

        pendingEntityList = new ArrayList<>();
        pendingEntityRemoveList = new ArrayList<>();

    }

    public void setPlayer(Player player) { this.player = player; }
    public Player getPlayer() { return player;  }

    public void tick() {
        if (activeWorld == WorldType.STARTER_WORLD) {
            entities = starterWorldEntities;
        }else if (activeWorld == WorldType.STARTER_CAVE_WORLD) {
            entities = starterCaveEntities;
        }

        if (!entities.contains(player)) {
            addEntity(player);
        }

        entities.sort(entitySorter);
        dispose();
    }

    public void renderAllEntities(Batch batch, TiledMap tiledMap) {
        tick();
        entities.forEach(e -> {
            if (e instanceof Item) {
                e.render(batch, tiledMap);
            }
        });
        entities.forEach((entity) -> {
            if (!(entity instanceof Item))
                entity.render(batch, tiledMap);
        });
        entities.addAll(pendingEntityList);
        entities.removeAll(pendingEntityRemoveList);
        pendingEntityList.clear();
        pendingEntityRemoveList.clear();
    }

    public void dispose() {
        entities.removeIf(entity -> !entity.isActive());
    }

    public ArrayList<Entity> activeEntityList() { return entities; }
    public ArrayList<Entity> getStarterWorldEntityList() { return starterWorldEntities; }
    public ArrayList<Entity> getStarterCaveEntityList() { return starterCaveEntities; }

    public void setActiveWorld(WorldType worldType) {
        this.activeWorld = worldType;

        switch (worldType) {
            case STARTER_WORLD:
                starterWorldEntities.add(player);
                break;
            case STARTER_CAVE_WORLD:
                starterCaveEntities.add(player);
                break;
        }

        removeEntity(player);
    }

    public void addEntity(Entity entity) { pendingEntityList.add(entity); }
    public void removeEntity(Entity entity) { pendingEntityRemoveList.add(entity); }
}
