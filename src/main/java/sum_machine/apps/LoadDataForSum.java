package src.main.java.sum_machine.apps;

import java.util.Scanner;

import src.main.java.sum_machine.utils.Observer;
import src.main.java.sum_machine.constants.Events;
import src.main.java.sum_machine.io.Input;
import src.main.java.sum_machine.io.FileInput;
import src.main.java.sum_machine.io.Output;

public class LoadDataForSum implements Application {
    private Observer observer;
    private Input input;
    private Output output;
    private FileInput fileInput;

    public LoadDataForSum(Input input, Output output, Observer observer, FileInput fileInput) {
        this.observer = observer;
        this.input = input;
        this.output = output;
        this.fileInput = fileInput;
    }

    /* Your code here */

    @Override
    public boolean run() {
        // Your code here
        return false;
    }
}
