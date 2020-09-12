package src.main.java.sum_machine.utils;

public interface Observable<T> {
    public void trigger(String event, T data);
}
