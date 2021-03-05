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

        playerX = Math.round(player.getX() / 32);
        playerY = Math.round(player.getY() / 32);
        creatureX = Math.round(creature.getX() / 32);
        creatureY = Math.round(creature.getY() / 32);


        absValueX = Math.abs(creatureX - playerX);
        absValueY = Math.abs(creatureY - playerY);

        float absValueXRaw = Math.abs(creature.getX() - player.getX());
        float absValueYRaw = Math.abs(creature.getY() - player.getY());

        if (absValueX > absValueY) {
            if (playerX > creatureX) {
                creature.setDirection(Direction.EAST);
                if (creature.isCollidingWithTile(tiledMap)) {
                    creature.setDirection(Direction.NORTH);
                    creature.moveY(tiledMap);
                    return;
                }
            } else if (playerX < creatureX) {
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

        if (absValueXRaw <= 30 && absValueYRaw <= 30) {
            if (player.isActive())
                creature.setAttacking(true);
            creature.attack();

        }
    }
}
