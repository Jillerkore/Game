package me.dev.killerjore.event.events.projectileEvent;

import com.badlogic.gdx.maps.tiled.TiledMapTile;
import me.dev.killerjore.entities.projectile.Projectile;

public class ProjectileHitTileEvent extends ProjectileEvent {
    
    public ProjectileHitTileEvent(Projectile projectile) {
        super(projectile);
    }
}
