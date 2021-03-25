package me.dev.killerjore.stats;

public class Stats {

    private int level;
    private int xp;
    private int xpToLevel;

    // Elaboration: integer value to be incremented to Xp to Level, after each level up
    private int incrementAmount;

    public Stats(int level, int xp, int xpToLevel, int levelXpIncrAmt) {
        this.level = level;
        this.xp = xp;
        this.xpToLevel = xpToLevel;
        this.incrementAmount = levelXpIncrAmt;
    }

    public int getXp() {
        return this.xp;
    }
    public void incrementXp(int xp) {
        this.xp += xp;
    }
    public int getLevel() {
        return level;
    }
    public void incrementLevel(int level) {
        this.level += level;
    }
    public void incrementLevel() {
        level ++;
        xpToLevel += incrementAmount;
    }
}
