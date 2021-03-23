package me.dev.killerjore.save;

import me.dev.killerjore.world.WorldType;

import java.io.Serializable;

public class GameData implements Serializable {

    private int health;
    private int maxHealth;
    private int stamina;
    private int maxStamina;
    private int playerX;
    private int playerY;

    private ItemData[] items;
    private ItemData[] hotbar;

    private WorldType worldType;

    public void init() {
        health = 20;
        maxHealth = 20;
        stamina = 20;
        maxStamina = 20;
        playerX = 23 * 32;
        playerY = 22 * 32;
        worldType = WorldType.STARTER_WORLD;
        items = new ItemData[30];
        hotbar = new ItemData[9];

        for (int i = 0; i < 30; i++) {
            items[i] = new ItemData();
            if (i < hotbar.length) {
                hotbar[i] = new ItemData();
            }
        }
    }


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getMaxStamina() {
        return maxStamina;
    }

    public void setMaxStamina(int maxStamina) {
        this.maxStamina = maxStamina;
    }

    public int getPlayerX() {
        return playerX;
    }

    public int getPlayerY() {
        return playerY;
    }

    public void setPlayerX(int x) {
        this.playerX = x;
    }
    public void setPlayerY(int y) {
        this.playerY = y;
    }

    public void setWorldType(WorldType worldType) { this.worldType = worldType; }
    public WorldType getWorldType() { return worldType; }

    public ItemData[] getInventoryItems() { return items; }
    public ItemData[] getHotbarItems() { return hotbar; }

}
