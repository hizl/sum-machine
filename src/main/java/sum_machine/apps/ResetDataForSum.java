package src.main.java.sum_machine.apps;

import src.main.java.sum_machine.utils.Observer;
import src.main.java.sum_machine.constants.Events;
import src.main.java.sum_machine.io.ConsoleInput;
import src.main.java.sum_machine.io.Output;

public class ResetDataForSum implements Application {
    private Observer observer;
    private ConsoleInput consoleInput;
    private Output output;

    public ResetDataForSum(Observer observer, ConsoleInput consoleInput, Output output) {
        this.observer = observer;
        this.consoleInput = consoleInput;
        this.output = output;
    }

    /* Your code here */
    
    @Override
    public boolean run() {
        // Your code here
        return false;
    }
}
