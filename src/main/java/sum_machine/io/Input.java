package src.main.java.sum_machine.io;

import java.util.regex.Pattern;

public interface Input<S> {
    public String next();
    public Integer nextInt();
    public String nextLine();
    public boolean hasNext(Pattern pattern);

    public Input<S> useSettings(S settings);
}