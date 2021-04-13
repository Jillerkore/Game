package me.dev.killerjore.event.listeners.player;

import me.dev.killerjore.audio.AudioManager;
import me.dev.killerjore.entities.EntityManager;
import me.dev.killerjore.entities.item.Item;
import me.dev.killerjore.entities.item.ItemId;
import me.dev.killerjore.entities.item.ItemState;
import me.dev.killerjore.event.annotations.EventHandler;
import me.dev.killerjore.event.events.playerEvent.ItemDropEvent;
import me.dev.killerjore.event.listeners.Listener;
import me.dev.killerjore.ui.uiModels.InventorySlot;

public class PlayerItemDropListener implements Listener {

    @EventHandler
    public void onItemDrop(ItemDropEvent event) {

        InventorySlot slot = event.getSlot();

        if (slot.getHoldingItem() == null)
            return;
        Item item = slot.getHoldingItem();
        item.setState(ItemState.IN_WORLD);
        item.setOffsetX(EntityManager.getInstance().getPlayer().getX());
        item.setOffsetY(EntityManager.getInstance().getPlayer().getY());
        EntityManager.getInstance().addEntity(item);
        slot.setHoldingItem(null);

        switch (event.getSlot().getHoldingItem().getId()) {
            case ItemId.BONE:
                AudioManager.getInstance().interface1.play();
                break;
            case ItemId.MEDAL:
                AudioManager.getInstance().coin.play();
                break;
            case ItemId.SPELL_BOOK:
                AudioManager.getInstance().interface3.play();
                break;
            case ItemId.WEAPON:
                AudioManager.getInstance().weapon.play();
                break;
        }
    }

}
