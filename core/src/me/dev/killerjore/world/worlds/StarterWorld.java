package me.dev.killerjore.world.worlds;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import me.dev.killerjore.entities.EntityManager;
import me.dev.killerjore.entities.statics.Teleporter;
import me.dev.killerjore.particles.ParticleManager;
import me.dev.killerjore.world.World;
import me.dev.killerjore.world.WorldType;

public class StarterWorld extends World {

    public StarterWorld() {
        super("maps/starterMap.tmx");
    }

    @Override
    public void dispose() {
        renderer.dispose();
        map.dispose();
        renderer.getBatch().dispose();
    }
    public void initializeComponents() {
        Teleporter teleporter = new Teleporter(22 * 32, 37 * 32, 10 * 32, 32 * 10, WorldType.STARTER_CAVE_WORLD);
        EntityManager.getInstance().getStarterWorldEntityList().add(teleporter);
    }
}
