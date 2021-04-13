package me.dev.killerjore.event.listeners;

import me.dev.killerjore.event.listeners.entities.EntityAttackListener;
import me.dev.killerjore.event.listeners.entities.EntityMagicCastListener;
import me.dev.killerjore.event.listeners.entities.EntityWeaponSwingListener;
import me.dev.killerjore.event.listeners.player.PlayerItemDropListener;
import me.dev.killerjore.event.listeners.player.PlayerItemPickupListener;
import me.dev.killerjore.event.listeners.player.PlayerMoveListener;
import me.dev.killerjore.event.listeners.projectiles.ProjectileCollideWithEntityListener;
import me.dev.killerjore.event.listeners.projectiles.ProjectileCollideWithTileListener;

import java.util.ArrayList;
import java.util.List;

public class ListenerList {

    public final List<Object> classes;

    public final List<Object> getListeners() { return classes; }

    public ListenerList() {
        this.classes = new ArrayList<>();

        // Entities
        classes.add(new EntityAttackListener());
        classes.add(new PlayerMoveListener());
        classes.add(new EntityWeaponSwingListener());
        classes.add(new EntityMagicCastListener());

        // Projectiles
        classes.add(new ProjectileCollideWithTileListener());
        classes.add(new ProjectileCollideWithEntityListener());

        //Inventory
        classes.add(new PlayerItemPickupListener());
        classes.add(new PlayerItemDropListener());
    }
}
