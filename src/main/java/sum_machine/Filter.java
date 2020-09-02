package src.main.java.sum_machine;

public interface Filter<T> {
    public T parseArgs(String argsLine);
    public boolean isValid(int compared, T sourceArgs);
}

