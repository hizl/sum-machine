package src.main.java.sum_machine.apps;

import java.util.HashMap;

import src.main.java.sum_machine.utils.Observer;
import src.main.java.sum_machine.io.ControlledInput;
import src.main.java.sum_machine.io.ControlledOutput;
import src.main.java.sum_machine.io.Input;
import src.main.java.sum_machine.io.Output;

public class Index {
    private HashMap<String, Application> applications;
    private Input input;
    private Output output;
    private ControlledInput controlledInput;
    private ControlledOutput controlledOutput;
    private Observer observer;

    private boolean running = false;

    private void setup() {
        this.setupApplications();
    }

    private Index setupApplications() {
        this.applications = new HashMap<String, Application>();

        this.applications.put(
            "summator",
            new SumMachine(
                this.controlledInput,
                this.controlledOutput
            )
        );

        this.applications.put(
            "load_to_summator",
            new LoadDataForSum(
                this.input,
                this.output,
                this.observer
            )
        );

        this.applications.put(
            "reset_summator",
            new ResetDataForSum(
                this.observer,
                this.output
            )
        );

        this.applications.put(
            "help",
            new Help(this.output)
        );

        this.applications.put(
            "exit",
            new Exit()
        );

        this.applications.put(
            "404",
            new NotFound(this.output)
        );

        return this;
    }

    public Index(
        Input input, 
        Output output,
        ControlledInput controlledInput, 
        ControlledOutput controlledOutput, 
        Observer observer
    ) {
        this.input = input;
        this.output = output;
        this.controlledInput = controlledInput;
        this.controlledOutput = controlledOutput;
        this.observer = observer;
        this.setup();
    }

    public void run() {
        this.running = true;

        while (this.running) {
            this.output.outFormat(">> ");

            String command = this.input.nextLine();

            if (!this.applications.containsKey(command)) {
                this.applications.get("404").run();
            } else {
                Application app = this.applications.get(command);
                app.run();
                this.running = !app.killsFlow();
            }
        }
    }
}
