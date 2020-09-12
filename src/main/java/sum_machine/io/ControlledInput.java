package src.main.java.sum_machine.io;

import java.util.HashMap;
import java.util.regex.Pattern;

import src.main.java.sum_machine.utils.Observable;
import src.main.java.sum_machine.utils.Observer;
import src.main.java.sum_machine.utils.Pair;

public class ControlledInput implements Input, Observable<Pair<String, String>> {
    private HashMap<String, Input> inputs;
    private String method;
    private Observer observer;

    public ControlledInput(HashMap<String, Input> inputs, String defaultMethod, Observer observer) {
        this.inputs = inputs;
        this.method = defaultMethod;
        this.observer = observer;
    }
    
    @Override
    public String next() {
        return this.inputs.get(this.method).next();
    };

    @Override
    public Integer nextInt() {
        return this.inputs.get(this.method).nextInt();
    };

    @Override
    public String nextLine() {
        return this.inputs.get(this.method).nextLine();
    };

    @Override
    public boolean hasNext(Pattern pattern) {
        return this.inputs.get(this.method).hasNext(pattern);
    };

    @Override
    public void trigger(String event, Pair<String, String> data) {
        this.method = data.get0();
        this.inputs.get(this.method).useSettings(data.get1());
    }

    @Override
    public Input useSettings(Object settings) {
        return this;
    }

    public Input subscribe(String event) {
        this.observer.subscribe(event, this);
        return this;
    }
}
