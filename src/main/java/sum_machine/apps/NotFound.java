package src.main.java.sum_machine.apps;

import src.main.java.sum_machine.io.AllConsoleOutput;

public class NotFound implements Application {
    private AllConsoleOutput output;
    
    public NotFound(AllConsoleOutput output) {
        this.output = output;
    }
    
    @Override
    public boolean run() {
        this.output.output("Command not found!");
        return false;
    };
}
