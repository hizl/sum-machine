package sum_machine;

public interface Filter {
    public boolean isValid(int compared, int source);
}


public interface Input {
    public String next();

    public int nextInt();

}

public interface Output {
    public void output(String message);

    public void outFormat(String pattern, Object... args);
}