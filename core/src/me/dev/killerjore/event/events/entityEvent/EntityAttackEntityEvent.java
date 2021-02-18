package me.dev.killerjore.event.events.entityEvent;

import me.dev.killerjore.entities.Entity;

public class EntityAttackEntityEvent extends EntityEvent {

    private Entity victim;

    public Entity getVictim() {
        return victim;
    }

    public EntityAttackEntityEvent(Entity entity, Entity victim) {
        super(entity);
        this.victim = victim;
    }
}
