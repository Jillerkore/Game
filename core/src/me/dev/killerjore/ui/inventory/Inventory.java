package me.dev.killerjore.ui.inventory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import me.dev.killerjore.entities.item.Item;
import me.dev.killerjore.textureRepository.TextureManager;

import java.util.ArrayList;
import java.util.Arrays;

public class Inventory {

    private ArrayList<Item> hotBar;
    private ArrayList<Item> inventory;

    public static final int

            STARTING_X = 165,
            STARTING_Y = 100,
            ITEM_START_RENDER_X = STARTING_X + 5,
            ITEM_START_RENDER_Y = STARTING_Y + 10,
            ITEM_WIDTH = 50,
            ITEM_HEIGHT = 50,
            PADDING_BETWEEN_SLOTS = 60,
            HOTBAR_START_X = 110,
            HOTBAR_START_Y = 15,
            HOTBAR_ITEM_START_RENDER_X = HOTBAR_START_X + 15,
            HOTBAR_ITEM_START_RENDER_Y = HOTBAR_START_Y + 10,
            HOTBAR_ITEM_WIDTH = 32,
            HOTBAR_ITEM_HEIGHT = 32,
            HOTBAR_PADDING_BETWEEN_SLOTS = 42;



    private final ArrayList<Integer> lastColumnOfInventory = new ArrayList<>(Arrays.asList(5, 10, 15, 20, 25, 30));
    private final Texture inventoryTexture, hotbarTexture;
    private static Inventory instance;

    public boolean isLeftClicking = false;

    public static Inventory getInstance() {
        if (instance == null) instance = new Inventory();
        return instance;
    }

    public boolean isInventoryActive = false;

    public ArrayList<Item> getHotBarItems() { return hotBar; }
    public ArrayList<Item> getInventoryItems() {return inventory;}

    public void toggleInventory() {
        if (isInventoryActive)
            isInventoryActive = false;
        else
            isInventoryActive = true;
    }

    private Inventory() {
        hotBar = new ArrayList<>();
        inventory = new ArrayList<>();

        inventoryTexture = TextureManager.getInstance().getAssetManager().get("sprites/ui/inventorySlots.png");
        hotbarTexture = TextureManager.getInstance().getAssetManager().get("sprites/ui/hotBar.png");
    }

    public void render(SpriteBatch batch) {

        int index = 0;
        int index1 = 0;

        batch.draw(hotbarTexture, HOTBAR_START_X, HOTBAR_START_Y, 400, 42);
        for (Item item : hotBar) {
            batch.draw(item.getTexture(), HOTBAR_ITEM_START_RENDER_X + (index * HOTBAR_PADDING_BETWEEN_SLOTS), HOTBAR_ITEM_START_RENDER_Y, HOTBAR_ITEM_WIDTH, HOTBAR_ITEM_HEIGHT);
            index ++;
        }

        index = 0;

        if (isInventoryActive) {
            batch.draw(inventoryTexture, STARTING_X, STARTING_Y);
            for (Item item : inventory) {
                batch.draw(item.getTexture(), ITEM_START_RENDER_X + (PADDING_BETWEEN_SLOTS * index), ITEM_START_RENDER_Y + (PADDING_BETWEEN_SLOTS * index1), ITEM_WIDTH, ITEM_HEIGHT);
                index++;
                if (lastColumnOfInventory.contains(index)) {
                    index = 0;
                    index1++;
                }
            }
        }

    }

    public void addItem(Item item, int slotType) {
        if (slotType == 1) {
            if (!isInventoryFull())
                inventory.add(item);
        }else {
            if (!isHotbarFull())
                hotBar.add(item);
        }
    }
    public void removeItem(Item item, int slotType) {
        if (slotType == 1) {
            if (!isInventoryFull())
                inventory.remove(item);
        }
        else {
            if (!isHotbarFull())
                hotBar.remove(item);
        }
    }

    public boolean isInventoryFull() {
        return inventory.size() >= 30;
    }
    public boolean isHotbarFull() {
        return hotBar.size() >= 9;
    }

    public void handleMouseInput(int mouseX, int mouseY) {

    }

    public void dispose() {
        inventoryTexture.dispose();
        hotbarTexture.dispose();
    }
}
