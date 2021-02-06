package me.dev.killerjore.entities.statics;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import me.dev.killerjore.world.WorldType;

public class Teleporter extends StaticEntity {

    private WorldType destinationWorld;
    private float destinationX, destinationY;

    public float getDestinationX() { return destinationX; }
    public float getDestinationY() { return destinationY; }

    public WorldType getDestinationWorld() {return destinationWorld;}

    public Teleporter(float x, float y, float destinationX, float destinationY, WorldType destinationWorld) {
        super(x, y, 32, 32, 32, 32);
        setOffsetX(x);
        setOffsetY(y);

        this.destinationX = destinationX;
        this.destinationY = destinationY;

        updateCollisionBox();

        this.destinationWorld = destinationWorld;
    }

    @Override
    public void render(Batch batch, TiledMap tiledMap) {
    }
}
