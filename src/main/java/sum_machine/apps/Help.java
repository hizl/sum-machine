package src.main.java.sum_machine.apps;

import src.main.java.sum_machine.io.AllConsoleOutput;

public class Help implements Application {
    private AllConsoleOutput output;
    
    public Help() {
        this.output = new AllConsoleOutput();
    }

    @Override
    public boolean run() {
        // Your code here
        return false;
    };
}
