package me.dev.killerjore.event.listeners.entities;

import me.dev.killerjore.audio.AudioManager;
import me.dev.killerjore.entities.creature.Creature;
import me.dev.killerjore.event.annotations.EventHandler;
import me.dev.killerjore.event.events.entityEvent.EntityAttackEvent;
import me.dev.killerjore.event.listeners.Listener;

public class EntityWeaponSwingListener implements Listener {

    @EventHandler
    public void onEntityWeaponSwing(EntityAttackEvent e) {
        AudioManager.getInstance().attackSwing.play();
        if (e.getEntity() instanceof Creature) {
            ((Creature) e.getEntity()).setStamina(((Creature) e.getEntity()).getStamina() - 1);
        }
    }

}
