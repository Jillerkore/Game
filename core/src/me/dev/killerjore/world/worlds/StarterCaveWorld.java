package me.dev.killerjore.world.worlds;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import me.dev.killerjore.entities.EntityManager;
import me.dev.killerjore.entities.statics.Teleporter;
import me.dev.killerjore.world.World;
import me.dev.killerjore.world.WorldType;

public class StarterCaveWorld extends World {

    private Teleporter teleporter;

    public StarterCaveWorld() {
        super("maps/starterCave.tmx");
    }

    @Override
    public void render(float deltaTime, OrthographicCamera camera) {
        renderer.setView(camera);

        renderer.getBatch().begin();
        renderer.renderTileLayer((TiledMapTileLayer) layers.get(0));
        renderer.renderTileLayer((TiledMapTileLayer) layers.get(1));
        renderer.renderTileLayer((TiledMapTileLayer) layers.get(3));
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

    @Override
    public void initializeComponents() {
        teleporter = new Teleporter(22 * 32, 8 * 32, 22 * 32, 32 * 36, WorldType.STARTER_WORLD);
        EntityManager.getInstance().getStarterCaveEntityList().add(teleporter);
    }
}
