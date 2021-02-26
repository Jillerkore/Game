package me.dev.killerjore.console;

import com.strongjoshua.console.CommandExecutor;
import com.strongjoshua.console.Console;
import me.dev.killerjore.entities.EntityManager;
import me.dev.killerjore.entities.creature.creatures.movable.Player;
import me.dev.killerjore.entities.creature.creatures.movable.Skeleton;

public class ConsoleCommandExecutor extends CommandExecutor {

    private Console console;

    public ConsoleCommandExecutor(Console console) {
        this.console = console;
    }

    public void setHealth(int health) {
        Player player = EntityManager.getInstance().getPlayer();
        if (health < 0) {
            console.log("Error: Player's health cannot be set to a value lesser than 0!");
            return;
        }
        console.log("Setting player's health to: " + health);
        player.setHealth(health);

    }
    public void setStamina(int stamina) {
        Player player = EntityManager.getInstance().getPlayer();
        if (stamina < 0) {
            console.log("Error: Player's stamina cannot be set to a value lesser than 0!");
            return;
        }
        console.log("Setting player's stamina to: " + stamina);
        player.setStamina(stamina);
    }
    public void summonEntity(String entityType, int x, int y) {
        console.log("Summoning entity: " + entityType);
        switch (entityType) {
            case "skeleton":
                Skeleton skeleton = new Skeleton(x * 32, y * 32, 64, 64, 25, 25,20, 20, 20, 20, 70);
                EntityManager.getInstance().activeEntityList().add(skeleton);
                break;
            default:
                console.log("Error: No such entity found");
        }
    }
    public void getLocation() {
        Player player = EntityManager.getInstance().getPlayer();

        console.log("Location: " + "(" + player.getX() / 32 + " ," + player.getY() / 32 + ")");
    }
    public void godMode(boolean godMode) {
        console.log("Setting player's godmode to: " + godMode);
        Player player = EntityManager.getInstance().getPlayer();
        player.godMode = godMode;
    }
}
