package me.dev.killerjore.event.events.projectileEvent;

import me.dev.killerjore.entities.projectile.Projectile;
import me.dev.killerjore.event.events.Event;

public abstract class ProjectileEvent extends Event {

    private Projectile projectile;

    public Projectile getProjectile() {
        return projectile;
    }

    public ProjectileEvent(Projectile projectile) {
        this.projectile = projectile;
    }
}
