package me.dev.killerjore.world;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import me.dev.killerjore.entities.EntityManager;
import me.dev.killerjore.particles.ParticleManager;

public abstract class World {

    protected TiledMap map;
    protected OrthogonalTiledMapRenderer renderer;
    protected MapLayers layers;

    public World(String mapPath) {
        map = new TmxMapLoader().load(mapPath);
        renderer = new OrthogonalTiledMapRenderer(map);
        layers = map.getLayers();

        fixTextureBleed(layers);
        initializeComponents();
    }

    public void render(float deltaTime, OrthographicCamera camera) {
        renderer.setView(camera);

        renderer.getBatch().begin();
        renderer.renderTileLayer((TiledMapTileLayer) layers.get(0));
        renderer.renderTileLayer((TiledMapTileLayer) layers.get(1));
        if (layers.get(3) != null) renderer.renderTileLayer((TiledMapTileLayer) layers.get(3));
        EntityManager.getInstance().renderAllEntities(renderer.getBatch(), map);
        ParticleManager.getInstance().render(renderer.getBatch());
        renderer.renderTileLayer((TiledMapTileLayer) layers.get(2));
        renderer.getBatch().end();
    }
    public abstract void dispose();
    public abstract void initializeComponents();

    public void fixTextureBleed(MapLayers mapLayer) {
        TiledMapTileLayer[] layers = new TiledMapTileLayer[3];

        for (int i = 0; i < layers.length; i++) {
            layers[i] = (TiledMapTileLayer)mapLayer.get(i);
            for(int x = 0; x < layers[i].getWidth(); x++) {
                for(int y = 0; y < layers[i].getHeight(); y++) {
                    TiledMapTileLayer.Cell cell = layers[i].getCell(x, y);
                    if (cell != null) {
                        fixBleeding(cell.getTile().getTextureRegion());
                    }
                }
            }
        }
    }

    private void fixBleeding(TextureRegion region) {
        region.setRegion((region.getRegionX() + 0.01f) / region.getTexture().getWidth(),
                (region.getRegionY() + 0.01f) / region.getTexture().getHeight(),
                (region.getRegionX() + region.getRegionWidth() - 0.01f) /
                        region.getTexture().getWidth(), (region.getRegionY() + region.
                        getRegionHeight() - 0.01f) / region.getTexture().getHeight());
    }

}
