package src.main.java.sum_machine.io;

import java.util.HashMap;

import src.main.java.sum_machine.utils.Observable;
import src.main.java.sum_machine.utils.Observer;
import src.main.java.sum_machine.constants.Events;
import src.main.java.sum_machine.constants.OutputMethods;
import src.main.java.sum_machine.utils.Pair;

public class ControlledOutput implements Output, Observable {
    private HashMap<String, Output> outputs;
    private String method = OutputMethods.ALL_TO_CONSOLE;

    private void subscribeToInputChange(Observer observer) {
        observer.subscribe(
            Events.CHANGE_INPUT_METHOD,
            this
        );
    }

    public ControlledOutput(Observer observer) {
        this.outputs = new HashMap<String, Output>();

        this.outputs.put(
            OutputMethods.ALL_TO_CONSOLE,
            new AllConsoleOutput()
        );

        this.outputs.put(
            OutputMethods.RESULT_TO_CONSOLE,
            new ResultConsoleOutput()
        );

        this.subscribeToInputChange(observer);
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
    public void trigger(String event, Object data) {
        String parsedData = (String)data;
        this.method = parsedData;
    }
}
