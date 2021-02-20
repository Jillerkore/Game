package me.dev.killerjore.event.listeners;

import me.dev.killerjore.event.listeners.entities.EntityAttackListener;

import java.util.ArrayList;
import java.util.List;

public class ListenerList {

    public final List<Object> classes;

    public final List<Object> getListeners() { return classes; }

    public ListenerList() {
        this.classes = new ArrayList<>();
        classes.add(new EntityAttackListener());
    }
}
