package me.dev.killerjore.world;

import me.dev.killerjore.world.worlds.StarterCaveWorld;
import me.dev.killerjore.world.worlds.StarterWorld;

public class WorldManager {

    private World starterWorld, starterCaveWorld;
    private static WorldManager instance;
    private World currentWorld;

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
            if (starterWorld == null) starterWorld = new StarterWorld();
            currentWorld = starterWorld;
        }if (worldType == WorldType.STARTER_CAVE_WORLD) {
            if (starterCaveWorld == null) starterCaveWorld = new StarterCaveWorld();
            currentWorld = starterCaveWorld;
        }
    }
}
