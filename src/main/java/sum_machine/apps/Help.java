package src.main.java.sum_machine.apps;

import src.main.java.sum_machine.io.Output;

public class Help implements Application {
    private Output output;
    
    public Help(Output output) {
        this.output = output;
    }

    @Override
    public boolean run() {
        // Your code here
        return false;
    };
}
