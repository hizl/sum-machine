package src.main.java.sum_machine.apps;

import src.main.java.sum_machine.io.Output;

public class Help implements Application {
    private Output output;

    public Help(Output output) {
        this.output = output;
    }

    @Override
    public void run() {
        this.output.output(
                "summator - calculate sum of integer numbers by filter;\n" +
                "load_to_summator - load data for \"summator\" from file;\n" +
                "reset_summator - reset data for \"summator\" (it asks for user input again);\n" +
                "help - output help about options;\n" +
                "exit - terminate the program."
        ) ;
    };

    @Override
    public boolean killsFlow() {
        return false;
    }
}
