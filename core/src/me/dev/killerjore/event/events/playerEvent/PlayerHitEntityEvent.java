package me.dev.killerjore.event.events.playerEvent;

import me.dev.killerjore.entities.Entity;
import me.dev.killerjore.entities.creature.creatures.movable.Player;

public class PlayerHitEntityEvent extends PlayerEvent {

    private final Entity victim;

    public Entity getVictim() { return victim; }

    public PlayerHitEntityEvent(Entity victim, Player player) {
        super(player);
        this.victim = victim;
    }
}
