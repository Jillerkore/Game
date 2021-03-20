package me.dev.killerjore.ui.inventory;

import me.dev.killerjore.entities.item.Item;

public class InventorySlot {

    private int x;
    private int y;
    private int width;
    private int height;

    private Item holdingItem;

    public Item getHoldingItem() { return holdingItem; }
    public void setHoldingItem(Item item) { this.holdingItem = item; }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }

    public InventorySlot(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean isHovering(int mouseX, int mouseY) {
        return mouseX > x && mouseX < x + width && mouseY > y && mouseY < y + height;
    }
}
