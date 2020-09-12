
package src.main.java.sum_machine;

import java.util.HashMap;

import src.main.java.sum_machine.utils.Observer;
import src.main.java.sum_machine.apps.Index;
import src.main.java.sum_machine.io.*;
import src.main.java.sum_machine.constants.*;

class Main {
    private static HashMap<String, Input> setupInputsForController() {
        HashMap<String, Input> inputs = new HashMap<String, Input>();

        inputs.put(
            InputMethods.CONSOLE,
            new DefaultConsoleInput()
        );

        inputs.put(
            InputMethods.FILE,
            new FileInput()
        );

        return inputs;
    }

    private static HashMap<String, Output> setupOutputsForController() {
        HashMap<String, Output> outputs = new HashMap<String, Output>();

        outputs.put(
            OutputMethods.ALL_TO_CONSOLE,
            new AllConsoleOutput()
        );

        outputs.put(
            OutputMethods.RESULT_TO_CONSOLE,
            new ResultConsoleOutput()
        );

        return outputs;
    }

    private static ControlledInput setupControlledInput(Observer observer) {
        ControlledInput controlledInput = new ControlledInput(
            setupInputsForController(),
            InputMethods.CONSOLE,
            observer
        );

        controlledInput.subscribe(Events.CHANGE_INPUT_METHOD);

        return controlledInput;
    }

    private static ControlledOutput setupControlledOutput(Observer observer) {
        ControlledOutput controlledOutput = new ControlledOutput(
            setupOutputsForController(),
            OutputMethods.ALL_TO_CONSOLE,
            observer
        );

        controlledOutput.subscribe(Events.CHANGE_OUTPUT_METHOD);

        return controlledOutput;
    }

    public static void main(String[] args) {
        Observer observer = new Observer();

        Index application = new Index(
            new ConsoleInput(),
            new ConsoleOutput(),
            setupControlledInput(observer),
            setupControlledOutput(observer),
            observer
        );

        application.run();
    }
}



