package me.dev.killerjore.event.listeners;

import me.dev.killerjore.entities.creature.Creature;
import me.dev.killerjore.event.annotations.EventHandler;
import me.dev.killerjore.event.events.entityEvent.EntityAttackEntityEvent;

public class EntityAttackListener implements Listener {

    @EventHandler
    public void onAttackEvent(EntityAttackEntityEvent event) {
        if (event.getVictim() == null) {
            return;
        }
        if (event.getVictim() instanceof Creature) {
            Creature creature = (Creature) event.getVictim();
            creature.setHealth(creature.getHealth() - 1);
        }
    }

}
