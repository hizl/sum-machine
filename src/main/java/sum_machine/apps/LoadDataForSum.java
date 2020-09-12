package src.main.java.sum_machine.apps;

import java.util.Scanner;

import src.main.java.sum_machine.utils.Observer;
import src.main.java.sum_machine.constants.Events;
import src.main.java.sum_machine.constants.InputMethods;
import src.main.java.sum_machine.constants.OutputMethods;
import src.main.java.sum_machine.io.Input;
import src.main.java.sum_machine.io.Output;

public class LoadDataForSum implements Application {
    private Input input;
    private Output output;
    private Observer observer;

    public LoadDataForSum(Input input, Output output, Observer observer) {
        this.observer = observer;
        this.input = input;
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
