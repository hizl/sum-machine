package src.main.java.sum_machine.utils;

public interface Observable {
    public void trigger(String event, Object data);
}
