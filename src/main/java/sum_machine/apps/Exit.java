package src.main.java.sum_machine.apps;

public class Exit implements Application {
    @Override
    public void run() {};

    @Override
    public boolean killsFlow() {
        return true;
    }
}
