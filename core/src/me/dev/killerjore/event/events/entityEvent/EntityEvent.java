package me.dev.killerjore.event.events.entityEvent;

import me.dev.killerjore.entities.Entity;
import me.dev.killerjore.event.events.Event;

public class EntityEvent extends Event {

    private Entity entity;

    public Entity getEntity() { return entity; }

    public EntityEvent(Entity entity) {
        this.entity = entity;
    }
}
