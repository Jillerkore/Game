package me.dev.killerjore.console;

import com.strongjoshua.console.CommandExecutor;
import com.strongjoshua.console.Console;
import me.dev.killerjore.entities.EntityManager;
import me.dev.killerjore.entities.creature.attacker.movable.Player;
import me.dev.killerjore.entities.creature.attacker.movable.Skeleton;
import me.dev.killerjore.entities.projectile.projectiles.Fireball;
import me.dev.killerjore.utils.Direction;

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
        try {
            console.log("Summoning entity: " + entityType);
            switch (entityType) {
                case "skeleton":
                    Skeleton skeleton = new Skeleton(x * 32, y * 32, 64, 64, 25, 25, 20, 20, 20, 20, 70);
                    EntityManager.getInstance().activeEntityList().add(skeleton);
                    break;
                case "fireball":
                    Fireball fireball = new Fireball(x * 32, y * 32, 64, 32, 32, 32, 10, Direction.WEST);
                    EntityManager.getInstance().activeEntityList().add(fireball);
                    break;
                default:
                    console.log("Error: No such entity found");
            }
        } catch (Exception e) {e.printStackTrace();}
    }
    public void summonEntity(String entityType, int x, int y, String direction) {

        Direction direction1 = Direction.NULL;
        direction = direction.toLowerCase();

        try {
            direction1 = Direction.valueOf(direction);
        }catch (IllegalArgumentException e) {
            console.log("Error: Invalid direction!");
        }

        console.log("Summoning entity: " + entityType);
        switch (entityType) {
            case "skeleton":
                Skeleton skeleton = new Skeleton(x * 32, y * 32, 64, 64, 25, 25,20, 20, 20, 20, 70);
                EntityManager.getInstance().activeEntityList().add(skeleton);
                break;
            case "fireball":
                Fireball fireball = new Fireball(x * 32, y * 32, 64, 32, 32, 32, 10, direction1);
                EntityManager.getInstance().activeEntityList().add(fireball);
                break;
            default:
                console.log("Error: No such entity found");
        }
    }

    public void summonEntity(String entityType, int x, int y, String direction, int speed) {

        Direction direction1 = Direction.NULL;
        direction = direction.toLowerCase();

        try {
            direction1 = Direction.valueOf(direction);
        }catch (IllegalArgumentException e) {
            console.log("Error: Invalid direction!");
        }

        console.log("Summoning entity: " + entityType);
        switch (entityType) {
            case "skeleton":
                Skeleton skeleton = new Skeleton(x * 32, y * 32, 64, 64, 25, 25,20, 20, 20, 20, speed);
                EntityManager.getInstance().activeEntityList().add(skeleton);
                break;
            case "fireball":
                Fireball fireball = new Fireball(x * 32, y * 32, 64, 32, 32, 32, speed, direction1);
                EntityManager.getInstance().activeEntityList().add(fireball);
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
        console.log("Toggling god mode to: " + godMode);
        Player player = EntityManager.getInstance().getPlayer();
        player.godMode = godMode;
    }
}
