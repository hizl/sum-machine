package src.main.java.sum_machine.io;

import java.util.regex.Pattern;

public interface Input {
    public String next();

    public int nextInt();

    public String nextLine();

    public boolean hasNext(Pattern pattern);
}