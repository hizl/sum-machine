package src.main.java.sum_machine.io;

import java.util.HashMap;
import java.util.regex.Pattern;

import src.main.java.sum_machine.utils.Observable;
import src.main.java.sum_machine.utils.Observer;
import src.main.java.sum_machine.constants.Events;
import src.main.java.sum_machine.constants.InputMethods;
import src.main.java.sum_machine.utils.Pair;

public class ControlledInput implements Input, Observable {
    private HashMap<String, Input> inputs;
    private String method = InputMethods.CONSOLE;

    private void subscribeToInputChange(Observer observer) {
        observer.subscribe(
            Events.CHANGE_INPUT_METHOD,
            this
        );
    }

    public ControlledInput(Observer observer) {
        this.inputs = new HashMap<String, Input>();

        this.inputs.put(
            InputMethods.CONSOLE,
            new DefaultConsoleInput()
        );

        this.inputs.put(
            InputMethods.FILE,
            new FileInput()
        );

        this.subscribeToInputChange(observer);
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
    public void trigger(String event, Object data) {
        String parsedData = (String)data;
        this.method = parsedData;
    }
}
