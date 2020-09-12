package src.main.java.sum_machine.io;

import java.util.HashMap;

import src.main.java.sum_machine.utils.Observable;
import src.main.java.sum_machine.utils.Observer;

public class ControlledOutput implements Output, Observable<String> {
    private HashMap<String, Output> outputs;
    private String method;
    private Observer observer;

    public ControlledOutput(HashMap<String, Output> outputs, String defaultMethod, Observer observer) {
        this.outputs = outputs;
        this.method = defaultMethod;
        this.observer = observer;
    }
    
    @Override
    public void output(String message) {
        this.outputs.get(this.method).output(message);
    };

    @Override
    public void outFormat(String pattern, Object... args) {
        this.outputs.get(this.method).outFormat(pattern, args);
    };

    @Override
    public void trigger(String event, String data) {
        this.method = data;
    }

    @Override
    public Output useSettings(Object settings) {
        return this;
    }

    public Output subscribe(String event) {
        this.observer.subscribe(event, this);
        return this;
    }
}
