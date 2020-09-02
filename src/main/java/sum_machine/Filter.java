package src.main.java.sum_machine;

public abstract class Filter<T> {
    private T data;

    public final Filter<T> useArgs(String argsLine) {
        T args = this.parseArgs(argsLine);
        this.data = args;
        return this;
    }
    
    abstract protected T parseArgs(String argsLine);
    abstract public boolean isValid(int compared);
}

