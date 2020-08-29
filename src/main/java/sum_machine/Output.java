package src.main.java.sum_machine;

public interface Output {
    public void output(String message);

    public void outFormat(String pattern, Object... args);
}