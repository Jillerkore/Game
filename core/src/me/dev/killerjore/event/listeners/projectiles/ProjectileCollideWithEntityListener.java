package me.dev.killerjore.event.listeners.projectiles;

import me.dev.killerjore.entities.creature.Creature;
import me.dev.killerjore.event.annotations.EventHandler;
import me.dev.killerjore.event.events.projectileEvent.ProjectileHitEntityEvent;
import me.dev.killerjore.event.listeners.Listener;

public class ProjectileCollideWithEntityListener implements Listener {

    @EventHandler
    public void onCollideWithEntity(ProjectileHitEntityEvent e) {
        e.getProjectile().setActive(false);
        if (e.getVictim() instanceof Creature) {
            System.out.println(e.getProjectile().getCollisionBox().intersects(e.getVictim().getCollisionBox()));
             ((Creature) e.getVictim()).setHealth(((Creature) e.getVictim()).getHealth() - 10);
         }
    }

}
