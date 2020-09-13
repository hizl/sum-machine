package src.main.java.sum_machine.apps;

import src.main.java.sum_machine.io.Output;

public class NotFound implements Application {
    private Output output;
    
    public NotFound(Output output) {
        this.output = output;
    }
    
    @Override
    public void run() {
        this.output.output("Command not found!");
    };

    @Override
    public boolean killsFlow() {
        return false;
    }
}
