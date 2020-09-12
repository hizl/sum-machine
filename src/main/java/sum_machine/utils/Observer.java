package src.main.java.sum_machine.utils;

import java.util.HashMap;
import java.util.HashSet;

public final class Observer {
    private HashMap<String, HashSet<Observable>> events;
    
    public Observer() {
        this.events = new HashMap<
            String,
            HashSet<Observable> 
        >();
    }

    public Observer subscribe(String event, Observable observable) {
        if (!this.events.containsKey(event)) {
            this.events.put(event, new HashSet<Observable>());
        }

        this.events.get(event).add(observable);

        return this;
    }

    public Observer unsubscribe(String event, Observable observable) {
        if (!this.events.containsKey(event)) {
            return null;
        }

        this.events.get(event).remove(observable);

        return this;
    }

    public Observer dispatch(String event, Object data) {
        if (!this.events.containsKey(event)) {
            return null;
        }

        HashSet<Observable> observables = this.events.get(event);

        for (Observable observable : observables) {
            observable.trigger(event, data);
        }

        return this;
    }
}
