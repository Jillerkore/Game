package me.dev.killerjore.event.events.entityEvent;

import me.dev.killerjore.entities.Entity;

public class EntityMagicCastEvent extends EntityEvent {

    public static final int PRE = 1, POST = 2;

    public void setCastType(int castType) { this.castType = castType; }
    public int getCastType() { return this.castType; }

    private int castType;

    public EntityMagicCastEvent(Entity entity) {
        super(entity);
    }
}
