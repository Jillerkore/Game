package me.dev.killerjore.event.model;

import me.dev.killerjore.event.events.Event;

import java.lang.invoke.MethodHandle;

public class MethodHandleModel {

    private final MethodHandle method;
    private final Class<? extends Event> eventClass;

    public MethodHandleModel(MethodHandle method, Class<? extends Event> eventClass) {
        this.method = method;
        this.eventClass = eventClass;
    }

    public MethodHandle getMethodHandle() { return method; }
    public Class<? extends Event> getEventClass() { return eventClass; }
}
