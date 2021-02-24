package me.dev.killerjore.event.listeners;

import me.dev.killerjore.event.listeners.entities.EntityAttackListener;
import me.dev.killerjore.event.listeners.entities.EntityWeaponSwingListener;
import me.dev.killerjore.event.listeners.player.PlayerMoveListener;

import java.util.ArrayList;
import java.util.List;

public class ListenerList {

    public final List<Object> classes;

    public final List<Object> getListeners() { return classes; }

    public ListenerList() {
        this.classes = new ArrayList<>();
        classes.add(new EntityAttackListener());
        classes.add(new PlayerMoveListener());
        classes.add(new EntityWeaponSwingListener());
    }
}
