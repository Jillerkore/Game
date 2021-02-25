package me.dev.killerjore.ai;

import com.badlogic.gdx.maps.tiled.TiledMap;
import me.dev.killerjore.entities.EntityManager;
import me.dev.killerjore.entities.creature.creatures.movable.MovableCreature;
import me.dev.killerjore.entities.creature.creatures.movable.Player;
import me.dev.killerjore.utils.Direction;

public class HostileCreatureAI {

    private int playerX, playerY, creatureX, creatureY;
    private int absValueX, absValueY;

    private Player player;

    public HostileCreatureAI() {

    }

    public void walkTowardsPlayer(MovableCreature creature, TiledMap tiledMap) {

        player = null;

        player = EntityManager.getInstance().getPlayer();

        playerX = Math.round(player.getX() / 32);
        playerY = Math.round(player.getY() / 32);
        creatureX = Math.round(creature.getX() / 32);
        creatureY = Math.round(creature.getY() / 32);

        if (playerY != creatureY) {
            if (playerY > creatureY) {
                creature.setDirection(Direction.NORTH);
            }else if (playerY < creatureY) {
                creature.setDirection(Direction.SOUTH);
            }
            creature.moveY(tiledMap);
        }else {
            if (playerX > creatureX) {
                creature.setDirection(Direction.EAST);
            }else if (playerX < creatureX) {
                creature.setDirection(Direction.WEST);
            }
            creature.moveX(tiledMap);
        }

        absValueX = Math.abs(creatureX - playerX);
        absValueY = Math.abs(creatureY - playerY);

        if (absValueX <= 1 && absValueY <= 1) {
            creature.setAttacking(true); creature.attack();
        }
    }
}
