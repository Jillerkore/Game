package me.dev.killerjore.event.events.playerEvent;

import com.badlogic.gdx.maps.tiled.TiledMap;
import me.dev.killerjore.entities.creature.creatures.movable.Player;

public class PlayerMoveEvent extends PlayerEvent {

    private final TiledMap tiledMap;

    public TiledMap getMap() { return tiledMap; }

    public PlayerMoveEvent(Player player, TiledMap tiledMap) {
        super(player);
        this.tiledMap = tiledMap;
    }
}
