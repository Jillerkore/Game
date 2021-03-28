package me.dev.killerjore.ui.uiModels;

import me.dev.killerjore.ui.inventory.Inventory;

public class EquipmentSlot {

    public static final int
            ITEM_WIDTH = Inventory.ITEM_WIDTH,
            ITEM_HEIGHT = Inventory.ITEM_HEIGHT,
            START_X = Inventory.STARTING_Y,
            START_Y = Inventory.STARTING_Y,
            ITEM_START_PADDING_X = 0,
            ITEM_START_PADDING_Y = 10;

    private final int
            HELM_X = START_X + 397,
            HELM_Y = START_Y + 270,

    CHEST_X = START_X + 317,
            CHEST_Y = START_Y + 211,

    ACCONE_X = 372,
            ACCONE_Y = 182,

    ACCTWO_X = 536,
            ACCTWO_Y = 182,

    WEAPON_X = START_X + 317,
            WEAPON_Y = START_Y + 150,

    ARTIFACT_X = START_X + 397,
            ARTIFACT_Y = START_Y + 29,

    PENDANT_X = START_X + 480,
            PENDANT_Y = START_Y + 150,

    SHIELD_X = START_X + 480,
            SHIELD_Y = START_Y + 211;

    private final InventorySlot
            helm, chestplate, shield, pendant, weapon, accessoryOne, accessoryTwo, artifact;


    public EquipmentSlot() {

        helm = new InventorySlot(HELM_X, HELM_Y, ITEM_WIDTH, ITEM_HEIGHT);
        chestplate = new InventorySlot(CHEST_X, CHEST_Y, ITEM_WIDTH, ITEM_HEIGHT);
        shield = new InventorySlot(SHIELD_X, SHIELD_Y, ITEM_WIDTH, ITEM_HEIGHT);
        pendant = new InventorySlot(PENDANT_X, PENDANT_Y, ITEM_WIDTH, ITEM_HEIGHT);
        accessoryOne = new InventorySlot(ACCONE_X, ACCONE_Y, ITEM_WIDTH, ITEM_HEIGHT);
        accessoryTwo = new InventorySlot(ACCTWO_X, ACCTWO_Y, ITEM_WIDTH, ITEM_HEIGHT);
        artifact = new InventorySlot(ARTIFACT_X, ARTIFACT_Y, ITEM_WIDTH, ITEM_HEIGHT);
        weapon = new InventorySlot(WEAPON_X, WEAPON_Y, ITEM_WIDTH, ITEM_HEIGHT);

    }

    public InventorySlot[] getSlots() {
        return new InventorySlot[] {helm, chestplate, shield, pendant, accessoryOne, accessoryTwo, artifact, weapon};
    }

}
