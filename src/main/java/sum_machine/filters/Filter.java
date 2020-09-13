package src.main.java.sum_machine.filters;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public abstract class Filter<T> {
    protected T args;

    public  Filter<T> useArgs(String argsLine) {
        T args = this.parseArgs(argsLine);

        this.args = args;


                return this;

    }
    abstract protected T parseArgs(String argsLine);
    abstract public boolean isValid(int compared);
}

