package src.main.java.sum_machine.apps;

import java.util.HashMap;

import src.main.java.sum_machine.io.ConsoleInput;
import src.main.java.sum_machine.io.FileInput;
import src.main.java.sum_machine.utils.Observer;
import src.main.java.sum_machine.io.AllConsoleOutput;
import src.main.java.sum_machine.io.ControlledOutput;

public class Index {
    private HashMap<String, Application> applications;
    
    private ConsoleInput consoleInput;
    private FileInput fileInput;

    private Observer observer;

    private AllConsoleOutput consoleOutput;
    private ControlledOutput controlledOutput;

    private boolean running = false;

    private Index setupInputs() {
        this.consoleInput = new ConsoleInput();
        this.fileInput = new FileInput();

        return this;
    }

    private Index setupObserver() {
        this.observer = new Observer();

        return this;
    }

    private Index setupOutputs() {
        this.consoleOutput = new AllConsoleOutput();
        this.controlledOutput = new ControlledOutput(this.observer);

        return this;
    }

    private Index setupApplications() {
        this.applications = new HashMap<String, Application>();

        this.applications.put(
            "calculate",
            new SumMachine(
                this.consoleInput, 
                this.controlledOutput,
                this.observer
            )
        );

        this.applications.put(
            "load_data",
            new LoadDataForSum(
                this.consoleInput,
                this.consoleOutput,
                this.observer,
                this.fileInput
            )
        );

        this.applications.put(
            "reset_data",
            new ResetDataForSum(
                this.observer,
                this.consoleInput,
                this.consoleOutput
            )
        );

        this.applications.put(
            "help",
            new Help(
                this.consoleOutput
            )
        );

        this.applications.put(
            "exit",
            new Exit()
        );

        this.applications.put(
            "404",
            new NotFound(consoleOutput)
        );
        
        return this;
    }

    private void setup() {
        this.setupInputs()
            .setupObserver()
            .setupOutputs()
            .setupApplications();
    }

    public Index() {
        this.setup();
    }

    public void run() {
        this.running = true;

        while (this.running) {
            this.consoleOutput.outFormat(">> ");
            String command = this.consoleInput.next();
            
            if (!this.applications.containsKey(command)) {
                this.applications.get("404").run();
            } else {
                this.running = !this.applications.get(command).run();
            }
        }
    }
}
