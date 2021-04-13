package me.dev.killerjore.event.events.playerEvent;

import me.dev.killerjore.entities.creature.attacker.movable.Player;
import me.dev.killerjore.entities.item.Item;
import me.dev.killerjore.ui.uiModels.InventorySlot;

public class ItemDropEvent extends PlayerEvent {

    private InventorySlot slot;

    public InventorySlot getSlot() { return slot; }

    public ItemDropEvent(Player player, InventorySlot slot) {
        super(player);
        this.slot = slot;
    }
}
