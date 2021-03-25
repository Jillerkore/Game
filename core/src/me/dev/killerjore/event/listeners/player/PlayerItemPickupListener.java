package me.dev.killerjore.event.listeners.player;

import me.dev.killerjore.audio.AudioManager;
import me.dev.killerjore.entities.EntityManager;
import me.dev.killerjore.entities.item.ItemState;
import me.dev.killerjore.event.annotations.EventHandler;
import me.dev.killerjore.event.events.playerEvent.ItemPickEvent;
import me.dev.killerjore.event.listeners.Listener;
import me.dev.killerjore.ui.inventory.Inventory;

public class PlayerItemPickupListener implements Listener {

    @EventHandler
    public void onItemPickup(ItemPickEvent e) {

        // Handling the picking up portion
        if (!Inventory.getInstance().isHotbarFull()) {
            e.getItem().setState(ItemState.PICKED_UP);
            Inventory.getInstance().addItem(e.getItem(), 2);
            EntityManager.getInstance().removeEntity(e.getItem());
        }else if (!Inventory.getInstance().isInventoryFull()) {
            e.getItem().setState(ItemState.PICKED_UP);
            Inventory.getInstance().addItem(e.getItem(), 1);
            EntityManager.getInstance().removeEntity(e.getItem());
        }

        // Audio for pickup
        AudioManager.getInstance().interface2.play();
    }

}
