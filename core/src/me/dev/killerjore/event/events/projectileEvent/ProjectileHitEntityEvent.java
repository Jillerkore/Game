package me.dev.killerjore.event.events.projectileEvent;

import me.dev.killerjore.entities.Entity;
import me.dev.killerjore.entities.projectile.Projectile;

public class ProjectileHitEntityEvent extends ProjectileEvent{

    private Entity victim;

    public Entity getVictim() { return victim; }

    public ProjectileHitEntityEvent(Projectile projectile, Entity victim) {
        super(projectile);
        this.victim = victim;
    }
}
