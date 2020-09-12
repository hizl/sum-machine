package src.main.java.sum_machine.io;

public interface Output {
    public void output(String message);

    public void outFormat(String pattern, Object... args);
}