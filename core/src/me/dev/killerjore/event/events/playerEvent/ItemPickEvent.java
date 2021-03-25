package me.dev.killerjore.event.events.playerEvent;

import me.dev.killerjore.entities.creature.attacker.movable.Player;
import me.dev.killerjore.entities.item.Item;

public class ItemPickEvent extends PlayerEvent{

    private Item item;

    public Item getItem() { return item; }
    public void setItem(Item item) { this.item = item; }

    public ItemPickEvent(Player player, Item item) {
        super(player);
        this.item = item;
    }
}
