package src.main.java.sum_machine.apps;

import src.main.java.sum_machine.utils.Observer;
import src.main.java.sum_machine.constants.Events;

public class ResetDataForSum implements Application {
    private Observer observer;

    public ResetDataForSum(Observer observer) {
        this.observer = observer;
    }

    /* Your code here */
    
    @Override
    public boolean run() {
        // Your code here
        return false;
    }
}
