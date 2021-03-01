package me.dev.killerjore.ai;

import com.badlogic.gdx.maps.tiled.TiledMap;
import me.dev.killerjore.entities.EntityManager;
import me.dev.killerjore.entities.creature.MovableCreature;
import me.dev.killerjore.entities.creature.attacker.Attacker;
import me.dev.killerjore.entities.creature.attacker.movable.Player;
import me.dev.killerjore.utils.Direction;

public class HostileCreatureAI {

    private int playerX, playerY, creatureX, creatureY;
    private int absValueX, absValueY;

    private Player player;

    public HostileCreatureAI() {

    }

    public void walkTowardsPlayer(Attacker creature, TiledMap tiledMap) {

        player = null;

        player = EntityManager.getInstance().getPlayer();

        playerX = Math.round(player.getX());
        playerY = Math.round(player.getY());
        creatureX = Math.round(creature.getX());
        creatureY = Math.round(creature.getY());

        if (playerX != creatureX) {
            if (playerX > creatureX) {
                creature.setDirection(Direction.EAST);
                if (creature.isCollidingWithTile(tiledMap)) {
                    creature.setDirection(Direction.NORTH);
                    creature.moveY(tiledMap);
                    return;
                }
            }else if (playerX < creatureX) {
                creature.setDirection(Direction.WEST);
                if (creature.isCollidingWithTile(tiledMap)) {
                    creature.setDirection(Direction.SOUTH);
                    creature.moveY(tiledMap);
                    return;
                }
            }
            creature.moveX(tiledMap);

        }else {
            if (playerY > creatureY) {
                creature.setDirection(Direction.NORTH);
                if (creature.isCollidingWithTile(tiledMap)) {
                    creature.setDirection(Direction.EAST);
                    creature.moveX(tiledMap);
                    return;
                }
            }else if (playerY < creatureY) {
                creature.setDirection(Direction.SOUTH);
                if (creature.isCollidingWithTile(tiledMap)) {
                    creature.setDirection(Direction.EAST);
                    creature.moveX(tiledMap);
                    return;
                }
            }
            creature.moveY(tiledMap);
        }

        absValueX = Math.abs(creatureX - playerX);
        absValueY = Math.abs(creatureY - playerY);


        if (absValueX <= 30 && absValueY <= 30) {
            if (player.isActive())
                creature.setAttacking(true); creature.attack();
        }
    }
}
