package src.main.java.sum_machine;

public interface Filter {
    public int[] parseArgs(String argsLine);
    public boolean isValid(int compared, int source);
}