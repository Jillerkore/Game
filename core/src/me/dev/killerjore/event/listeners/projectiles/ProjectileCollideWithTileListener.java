package me.dev.killerjore.event.listeners.projectiles;

import me.dev.killerjore.event.annotations.EventHandler;
import me.dev.killerjore.event.events.projectileEvent.ProjectileHitTileEvent;
import me.dev.killerjore.event.listeners.Listener;

public class ProjectileCollideWithTileListener implements Listener {

    @EventHandler
    public void onCollideWithTile(ProjectileHitTileEvent e) {
        e.getProjectile().setActive(false);
    }

}
