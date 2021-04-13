package me.dev.killerjore.ui.inventory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import me.dev.killerjore.entities.EntityManager;
import me.dev.killerjore.entities.item.Item;
import me.dev.killerjore.entities.item.ItemState;
import me.dev.killerjore.event.EventManager;
import me.dev.killerjore.event.events.playerEvent.ItemDropEvent;
import me.dev.killerjore.save.Save;
import me.dev.killerjore.textureRepository.TextureManager;
import me.dev.killerjore.ui.uiModels.EquipmentSlot;
import me.dev.killerjore.ui.uiModels.InventorySlot;

import java.util.ArrayList;
import java.util.Arrays;

public class Inventory {

    private InventorySlot[] inventory;
    private InventorySlot[] hotbar;

    private Item selectedItem;
    private OrthographicCamera camera;

    private ItemDropEvent dropEvent;

    private Vector3 mousePos;

    private EquipmentSlot slots;

    public static final int

            STARTING_X = 60,
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

    public InventorySlot[] getInventorySlots() { return inventory; }
    public InventorySlot[] getHotbarSlots() { return hotbar; }

    public static Inventory getInstance() {
        if (instance == null) instance = new Inventory();
        return instance;
    }

    public void setCamera(OrthographicCamera camera) {
        this.camera = camera;
    }

    public boolean isInventoryActive = false;

    public void toggleInventory() {
        isInventoryActive = !isInventoryActive;
    }

    private Inventory() {

        slots = new EquipmentSlot();

        mousePos = new Vector3();

        hotbar = new InventorySlot[9];
        inventory = new InventorySlot[30];

        for (int i = 0; i < hotbar.length; i++) {
            hotbar[i] = new InventorySlot(HOTBAR_ITEM_START_RENDER_X + (HOTBAR_PADDING_BETWEEN_SLOTS * i), HOTBAR_ITEM_START_RENDER_Y, HOTBAR_ITEM_WIDTH, HOTBAR_ITEM_HEIGHT);
        }

        int index = 0;
        int index1 = 0;

        for (int i = 0; i < inventory.length; i++) {
            inventory[i] = new InventorySlot(ITEM_START_RENDER_X + (PADDING_BETWEEN_SLOTS * index), ITEM_START_RENDER_Y + (PADDING_BETWEEN_SLOTS * index1), ITEM_WIDTH, ITEM_HEIGHT);
            index++;
            if (lastColumnOfInventory.contains(index)) {
                index = 0;
                index1 ++;
            }
        }
        if (Save.getInstance().isInitialized()) {
            for (int i = 0; i < 30; i++) {
                inventory[i].setHoldingItem(
                        Item.getItemById(Save.getInstance().getData().getInventoryItems()[i].getId())
                );

                if (i < 9) {
                    hotbar[i].setHoldingItem(
                            Item.getItemById(Save.getInstance().getData().getHotbarItems()[i].getId())
                    );
                }
            }
        }

        inventoryTexture = TextureManager.getInstance().getAssetManager().get("sprites/ui/inventorySlots.png");
        hotbarTexture = TextureManager.getInstance().getAssetManager().get("sprites/ui/hotBar.png");
    }

    public void render(SpriteBatch batch) {

        mousePos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
        camera.unproject(mousePos);

        batch.draw(hotbarTexture, HOTBAR_START_X, HOTBAR_START_Y, 400, 42);
        for (InventorySlot slot : hotbar) {
            if (slot.getHoldingItem() != null)
                batch.draw(slot.getHoldingItem().getTexture(), slot.getX(), slot.getY(), slot.getWidth(), slot.getHeight());
        }

        if (isInventoryActive) {
            batch.draw(inventoryTexture, STARTING_X, STARTING_Y);
            for (InventorySlot slot : inventory) {
                if (slot.getHoldingItem() != null)
                    batch.draw(slot.getHoldingItem().getTexture(), slot.getX(), slot.getY(), slot.getWidth(), slot.getHeight());
            }
            for (InventorySlot slot : slots.getSlots()) {
                if (slot.getHoldingItem() != null) {
                    batch.draw(slot.getHoldingItem().getTexture(), slot.getX() + EquipmentSlot.ITEM_START_PADDING_X, slot.getY() + EquipmentSlot.ITEM_START_PADDING_Y, slot.getWidth(), slot.getHeight());
                }
            }
            if (selectedItem != null) {
                batch.draw(selectedItem.getTexture(), mousePos.x - 25, mousePos.y - 10, ITEM_WIDTH + 10, ITEM_HEIGHT + 10);
            }
        }

    }

    public void addItem(Item item, int slotType) {
        if (slotType == 1) {
            if (!isInventoryFull())
                for (InventorySlot slot : inventory) {
                    if (slot.getHoldingItem() == null) {
                        slot.setHoldingItem(item);
                        break;
                    }
                }
        }else {
            if (!isHotbarFull())
                for (InventorySlot slot : hotbar) {
                    if (slot.getHoldingItem() == null) {
                        slot.setHoldingItem(item);
                        break;
                    }
                }
        }
    }
    public void removeItem(InventorySlot slot) {
        slot.setHoldingItem(null);
    }

    public boolean isInventoryFull() {
        int index = 0;
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i].getHoldingItem() != null) index++;
        }
        return index >= 30;
    }
    public boolean isHotbarFull() {
        int index = 0;
        for (InventorySlot slot : hotbar) {
            if (slot.getHoldingItem() != null) index++;
        }
        return index >= 9;
    }

    public void handleMouseInput(int mouseX, int mouseY, int button) {
        for (InventorySlot slot : inventory) {
            mouseCallEvent(mouseX, mouseY, button, slot, 1);
        }
        if (isInventoryActive) {
            for (InventorySlot slot : hotbar) {
                mouseCallEvent(mouseX, mouseY, button, slot, 2);
            }
            for (InventorySlot slot : slots.getSlots()) {
                mouseCallEvent(mouseX, mouseY, button, slot, 3);
            }
        }
    }

    private void mouseCallEvent(int mouseX, int mouseY, int button, InventorySlot slot, int slotType) {
        System.out.println(mouseX);
        System.out.println(mouseY);
        if (slot.isHovering(mouseX, mouseY)) {
            if (button == Input.Buttons.LEFT) {
                if (selectedItem == null) {
                    if (slot.getHoldingItem() != null) {
                        selectedItem = slot.getHoldingItem();
                        slot.setHoldingItem(null);
                    }
                }
                else {
                    if (slot.getHoldingItem() != null) {
                        Item item = slot.getHoldingItem();
                        slot.setHoldingItem(selectedItem);
                        selectedItem = item;
                    }else {
                        slot.setHoldingItem(selectedItem);
                        selectedItem = null;
                    }
                }
            }else if (button == Input.Buttons.RIGHT) {

                dropEvent = new ItemDropEvent(EntityManager.getInstance().getPlayer(), slot);
                EventManager.getInstance().invokeEventMethods(dropEvent);
            }
        }
    }


    public void dispose() {
        inventoryTexture.dispose();
        hotbarTexture.dispose();
    }
}