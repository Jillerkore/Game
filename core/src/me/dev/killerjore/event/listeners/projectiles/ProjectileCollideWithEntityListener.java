package me.dev.killerjore.event.listeners.projectiles;

import me.dev.killerjore.event.annotations.EventHandler;
import me.dev.killerjore.event.events.projectileEvent.ProjectileHitEntityEvent;
import me.dev.killerjore.event.listeners.Listener;

public class ProjectileCollideWithEntityListener implements Listener {

    @EventHandler
    public void onCollideWithEntity(ProjectileHitEntityEvent e) {
        // e.getProjectile().setActive(false);
    }

}
