package src.main.java.sum_machine.apps;

import src.main.java.sum_machine.utils.Observer;
import src.main.java.sum_machine.constants.Events;
import src.main.java.sum_machine.io.ConsoleInput;
import src.main.java.sum_machine.io.Output;
import src.main.java.sum_machine.constants.Events;
import src.main.java.sum_machine.constants.InputMethods;
import src.main.java.sum_machine.constants.OutputMethods;

public class ResetDataForSum implements Application {
    private Observer observer;
    private Output output;

    public ResetDataForSum(Observer observer, Output output) {
        this.observer = observer;
        this.output = output;
    }

    /* Your code here */
    
    @Override
    public void run() {
        // Your code here
    }

    @Override
    public boolean killsFlow() {
        return false;
    }
}
