package src.main.java.sum_machine.io;

public class ResultConsoleOutput implements Output {
    @Override
    public void output(String message) {
        if (!message.startsWith("@")) {
            System.out.println(message.substring(1));
        }
    };

    @Override
    public void outFormat(String pattern, Object... args) {
        if (!pattern.startsWith("@")) {
            System.out.printf(pattern.substring(1), args);
        }
    };
}
