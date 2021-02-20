package me.dev.killerjore.event;

import me.dev.killerjore.event.annotations.EventHandler;
import me.dev.killerjore.event.events.Event;
import me.dev.killerjore.event.listeners.ListenerList;
import me.dev.killerjore.event.model.MethodHandleModel;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.util.ArrayList;

/*
* Singleton class for managing the events and invoking methods
 */

public class EventManager {

    private static EventManager instance;

    private ArrayList<MethodHandleModel> eventMethodList;

    public static EventManager getInstance() {
        if (instance == null) instance = new EventManager();
        return instance;
    }

    private EventManager() {
        try {
            init();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void init() throws IllegalAccessException {

        eventMethodList = new ArrayList<>();

        ListenerList listenerList = new ListenerList();

        for (Object listenerObject : listenerList.getListeners()) {
            Class<?> cls = listenerObject.getClass();
            for (Method method : cls.getDeclaredMethods()) {
                if (!method.isAnnotationPresent(EventHandler.class)) continue;
                MethodHandle handle = MethodHandles.lookup().unreflect(method).bindTo(listenerObject);
                eventMethodList.add(new MethodHandleModel(handle, (Class<? extends Event>) method.getParameterTypes()[0]));
            }
        }
    }

    public void invokeEventMethods(Event event) {
        eventMethodList.forEach(methodHandleModel -> {
            if (event.getClass().isAssignableFrom(methodHandleModel.getEventClass())) {
                try {
                    methodHandleModel.getMethodHandle().invoke(event);
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
        });
    }

}
