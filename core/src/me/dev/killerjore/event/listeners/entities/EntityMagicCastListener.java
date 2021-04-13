package me.dev.killerjore.event.listeners.entities;

import me.dev.killerjore.audio.AudioManager;
import me.dev.killerjore.event.annotations.EventHandler;
import me.dev.killerjore.event.events.entityEvent.EntityMagicCastEvent;
import me.dev.killerjore.event.listeners.Listener;

public class EntityMagicCastListener implements Listener {

    @EventHandler
    public void onEntityMagicCast(EntityMagicCastEvent e) {
        AudioManager.getInstance().magicCast.play();
    }

}
