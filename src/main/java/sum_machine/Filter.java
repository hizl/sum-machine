package src.main.java.sum_machine;

public abstract class Filter<T> {
    private T args;

    public final Filter<T> useArgs(String argsLine) {
        T args = this.parseArgs(argsLine);
        this.args = args;
        return this;
    }
    
    abstract protected T parseArgs(String argsLine);
    abstract public boolean isValid(int compared, T sourceArgs);
}

