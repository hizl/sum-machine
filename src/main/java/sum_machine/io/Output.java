package src.main.java.sum_machine.io;

public interface Output<S> {
    public void output(String message);
    public void outFormat(String pattern, Object... args);
    public Output<S> useSettings(S settings);
}