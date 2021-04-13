package me.dev.killerjore.world.worlds;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import me.dev.killerjore.entities.EntityManager;
import me.dev.killerjore.entities.statics.Teleporter;
import me.dev.killerjore.particles.ParticleManager;
import me.dev.killerjore.world.World;
import me.dev.killerjore.world.WorldType;

public class StarterCaveWorld extends World {

    public StarterCaveWorld() {
        super("maps/starterCave.tmx");
    }

    @Override
    public void dispose() {
        renderer.dispose();
        map.dispose();
        renderer.getBatch().dispose();
    }

    @Override
    public void initializeComponents() {
        Teleporter teleporter = new Teleporter(10 * 32, 8 * 32, 22 * 32, 32 * 36, WorldType.STARTER_WORLD);
        EntityManager.getInstance().getStarterCaveEntityList().add(teleporter);
    }
}
