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

    CHEST_X = 369,
            CHEST_Y = 309,

    ACCONE_X = 372,
            ACCONE_Y = 182,

    ACCTWO_X = 536,
            ACCTWO_Y = 182,

    WEAPON_X = 370,
            WEAPON_Y = 246,

    ARTIFACT_X = START_X + 397,
            ARTIFACT_Y = START_Y + 29,

    PENDANT_X = 532,
            PENDANT_Y = START_Y + 246,

    SHIELD_X = 532,
            SHIELD_Y = 309;

    private final InventorySlot
            helm;

    public InventorySlot getHelm() {
        return helm;
    }

    public InventorySlot getChestplate() {
        return chestplate;
    }

    public InventorySlot getShield() {
        return shield;
    }

    public InventorySlot getPendant() {
        return pendant;
    }

    public InventorySlot getWeapon() {
        return weapon;
    }

    public InventorySlot getAccessoryOne() {
        return accessoryOne;
    }

    public InventorySlot getAccessoryTwo() {
        return accessoryTwo;
    }

    public InventorySlot getArtifact() {
        return artifact;
    }

    private final InventorySlot chestplate;
    private final InventorySlot shield;
    private final InventorySlot pendant;
    private final InventorySlot weapon;
    private final InventorySlot accessoryOne;
    private final InventorySlot accessoryTwo;
    private final InventorySlot artifact;


    public EquipmentSlot() {

        helm = new InventorySlot(HELM_X, HELM_Y, ITEM_WIDTH, ITEM_HEIGHT);
        chestplate = new InventorySlot(CHEST_X, CHEST_Y, ITEM_WIDTH, ITEM_HEIGHT);
        shield = new InventorySlot(SHIELD_X, SHIELD_Y, ITEM_WIDTH, ITEM_HEIGHT);
        pendant = new InventorySlot(PENDANT_X, PENDANT_Y, ITEM_WIDTH, ITEM_HEIGHT);
        accessoryOne = new InventorySlot(ACCONE_X, ACCONE_Y, ITEM_WIDTH, ITEM_HEIGHT);
        accessoryTwo = new InventorySlot(ACCTWO_X, ACCTWO_Y, ITEM_WIDTH, ITEM_HEIGHT);
        artifact = new InventorySlot(ARTIFACT_X, ARTIFACT_Y, ITEM_WIDTH, ITEM_HEIGHT);
        weapon = new InventorySlot(WEAPON_X, WEAPON_Y, ITEM_WIDTH, ITEM_HEIGHT);

        helm.setId(1);
        chestplate.setId(1);
        shield.setId(1);
        pendant.setId(1);
        accessoryOne.setId(1);
        accessoryTwo.setId(1);
        artifact.setId(1);
        weapon.setId(1);

    }

    public InventorySlot[] getSlots() {
        return new InventorySlot[] {helm, chestplate, shield, pendant, accessoryOne, accessoryTwo, artifact, weapon};
    }

}
