package me.dev.killerjore.event.listeners.player;

import com.badlogic.gdx.maps.tiled.TiledMap;
import me.dev.killerjore.entities.creature.attacker.movable.Player;
import me.dev.killerjore.event.annotations.EventHandler;
import me.dev.killerjore.event.events.playerEvent.PlayerMoveEvent;
import me.dev.killerjore.event.listeners.Listener;
import me.dev.killerjore.utils.Direction;

public class PlayerMoveListener implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        handleWalking(e);
    }

    private void handleWalking(PlayerMoveEvent e) {

        Player player = e.getPlayer();
        TiledMap tiledMap = e.getMap();

        if (!player.isAttacking())
            if (player.walkingUp) {
                player.setDirection(Direction.NORTH);
                player.moveY(tiledMap);
                player.getAnimation().setCurrentFrame(player.getAnimation().getUpAnimation().getKeyFrame(player.getElapsedTime(), true));
            }else if (player.walkingLeft) {
                player.setDirection(Direction.WEST);
                player.moveX(tiledMap);
                player.getAnimation().setCurrentFrame(player.getAnimation().getLeftAnimation().getKeyFrame(player.getElapsedTime(), true));
            }else if (player.walkingDown) {
                player.setDirection(Direction.SOUTH);
                player.moveY(tiledMap);
                player.getAnimation().setCurrentFrame(player.getAnimation().getDownAnimation().getKeyFrame(player.getElapsedTime(), true));
            }else if (player.walkingRight) {
                player.setDirection(Direction.EAST);
                player.moveX(tiledMap);
                player.getAnimation().setCurrentFrame(player.getAnimation().getRightAnimation().getKeyFrame(player.getElapsedTime(), true));
            }
    }

}
