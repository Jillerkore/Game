package me.dev.killerjore.inventory;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import me.dev.killerjore.entities.items.Item;

import java.util.ArrayList;

public class Inventory {

    private ArrayList<Item> hotBar;
    private ArrayList<Item> inventory;

    public boolean isInventoryActive = false;

    public ArrayList<Item> getHotBarItems() { return hotBar; }
    public ArrayList<Item> getInventoryItems() {return inventory;}

    public Inventory() {
        hotBar = new ArrayList<>();
        inventory = new ArrayList<>();
    }

    public void render(SpriteBatch batch) {


    }

    public void addItem(Item item, int slotType) {
        if (slotType == 1) {
            inventory.add(item);
        }else {
            hotBar.remove(hotBar);
        }
    }
    public void removeItem(Item item, int slotType) {
        if (slotType == 1) {
            inventory.remove(item);
        }
        else if (slotType == 2) {
            hotBar.remove(item);
        }
    }
}
