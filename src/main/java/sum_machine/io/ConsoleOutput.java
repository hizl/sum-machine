package src.main.java.sum_machine.io;

public class ConsoleOutput implements Output {
    @Override
    public void output(String message) {
        System.out.println(message);
    };

    @Override
    public void outFormat(String pattern, Object... args) {
        System.out.printf(pattern, args);
    };
}
