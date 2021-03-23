package me.dev.killerjore.world;

import me.dev.killerjore.world.worlds.StarterCaveWorld;
import me.dev.killerjore.world.worlds.StarterWorld;

public class WorldManager {

    private final World starterWorld;
    private final World starterCaveWorld;
    private static WorldManager instance;
    private World currentWorld;
    private WorldType currentWorldType;

    public WorldType getCurrentWorldType() { return currentWorldType; }

    public static WorldManager getInstance() { if (instance == null) instance = new WorldManager(); return instance; }

    private WorldManager() {
        starterWorld = new StarterWorld();
        starterCaveWorld = new StarterCaveWorld();
    }

    public World getCurrentWorld() {
        if (currentWorld == null) currentWorld = starterWorld;
        return currentWorld;
    }
    public void setCurrentWorld(WorldType worldType) {
        if (worldType == WorldType.STARTER_WORLD) {
            currentWorld = starterWorld;
        }if (worldType == WorldType.STARTER_CAVE_WORLD) {
            currentWorld = starterCaveWorld;
        }
        currentWorldType = worldType;
    }
}
