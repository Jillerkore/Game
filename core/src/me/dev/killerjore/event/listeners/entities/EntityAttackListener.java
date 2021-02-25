package me.dev.killerjore.event.listeners.entities;

import me.dev.killerjore.audio.AudioManager;
import me.dev.killerjore.entities.creature.Creature;
import me.dev.killerjore.entities.creature.creatures.movable.Player;
import me.dev.killerjore.event.annotations.EventHandler;
import me.dev.killerjore.event.events.entityEvent.EntityAttackEntityEvent;
import me.dev.killerjore.event.listeners.Listener;
import me.dev.killerjore.particles.particles.Blood;

public class EntityAttackListener implements Listener {

    @EventHandler
    public void onAttackEvent(EntityAttackEntityEvent event) {

        AudioManager.getInstance().attackSwing.play();

        if (event.getVictim() == null) {
            return;
        }
        if (event.getVictim() instanceof Creature) {
            Creature creature = (Creature) event.getVictim();
            if (event.getEntity() instanceof Player) {
                creature.setHealth(creature.getHealth() - 5);
            }else {
                creature.setHealth(creature.getHealth() - 1);
            }
        }
        //new Blood(event.getVictim().getOffsetX() - 32, event.getVictim().getOffsetY() - 40, 128, 128);
        new Blood(event.getVictim().getOffsetX() - 16, event.getVictim().getOffsetY() - 32, 64 + 32, 64 + 32);
    }

}
