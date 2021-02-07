package me.dev.killerjore.entities.creature;

/*
Class made to decouple the specific properties the creature class is going to have
just to neat up the code a tad bit more :)
 */
public class CreatureProperties {

    private int health;
    private int maxHealth;

    private int stamina;
    private int maxStamina;

    private float speed;

    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public int getMaxHealth() {
        return maxHealth;
    }
    public void setMaxHealth(int health) {
        this.health = health;
    }

    public int getStamina() {
        return this.stamina;
    }
    public void setStamina(int stamina) {
        this.stamina = stamina;
    }
    public int getMaxStamina() {
        return this.stamina;
    }
    public void setMaxStamina(int stamina) {
        this.stamina = stamina;
    }

    public float getSpeed() {
        return speed;
    }
    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
