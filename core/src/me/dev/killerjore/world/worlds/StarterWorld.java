package me.dev.killerjore.world.worlds;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import me.dev.killerjore.entities.EntityManager;
import me.dev.killerjore.entities.statics.Teleporter;
import me.dev.killerjore.world.World;
import me.dev.killerjore.world.WorldType;

public class StarterWorld extends World {

    private Teleporter teleporter;

    public StarterWorld() {
        super("maps/starterMap.tmx");
    }

    @Override
    public void render(float deltaTime, OrthographicCamera camera) {
        renderer.setView(camera);

        renderer.getBatch().begin();
        renderer.renderTileLayer((TiledMapTileLayer) layers.get(0));
        renderer.renderTileLayer((TiledMapTileLayer) layers.get(1));
        EntityManager.getInstance().renderAllEntities(renderer.getBatch(), map);
        renderer.renderTileLayer((TiledMapTileLayer) layers.get(2));
        renderer.getBatch().end();
    }
    @Override
    public void dispose() {
        renderer.dispose();
        map.dispose();
        renderer.getBatch().dispose();
    }
    public void initializeComponents() {
        teleporter = new Teleporter(22 * 32, 37 * 32, 22 * 32, 32 * 10, WorldType.STARTER_CAVE_WORLD);
        EntityManager.getInstance().getStarterWorldEntityList().add(teleporter);
    }
}
