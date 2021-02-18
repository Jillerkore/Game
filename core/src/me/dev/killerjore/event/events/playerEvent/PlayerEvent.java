package me.dev.killerjore.event.events.playerEvent;

import me.dev.killerjore.entities.creature.creatures.movable.Player;
import me.dev.killerjore.event.events.Event;

public abstract class PlayerEvent extends Event {

    private Player player;

    public Player getPlayer() {
        return player;
    }

    public PlayerEvent(Player player) {
        this.player = player;
    }

}
