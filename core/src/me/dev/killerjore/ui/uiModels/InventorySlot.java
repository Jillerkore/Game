package me.dev.killerjore.ui.uiModels;

import me.dev.killerjore.entities.item.Item;

import java.io.Serializable;

public class InventorySlot implements Serializable {

    public static final int
        HELM_ID = 1,
        CHEST_ID = 2,
        ACCONE_ID = 3,
        ACCTWO_ID = 4,
        ARTIFACT_ID = 5,
        SHIELD_ID = 6,
        WEAPON_ID = 7,
        INVENTORY_ID = 0;

    private int x;
    private int y;
    private int width;
    private int height;

    private Item holdingItem;

    private int id;

    public Item getHoldingItem() { return holdingItem; }
    public void setHoldingItem(Item item) { this.holdingItem = item; }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public void setId(int id) { this.id = id; }
    public int getId() { return this.id; }

    public InventorySlot(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        id = 0;
    }

    public boolean isHovering(int mouseX, int mouseY) {
        return mouseX > x && mouseX < x + width && mouseY > y && mouseY < y + height;
    }
}
