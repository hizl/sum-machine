package src.main.java.sum_machine.io;

public class AllConsoleOutput implements Output {
    @Override
    public void output(String message) {
        if (message.startsWith("@")) {
            System.out.println(message.substring(1));
        } else {
            System.out.println(message);
        }
    };

    @Override
    public void outFormat(String pattern, Object... args) {
        if (pattern.startsWith("@")) {
            System.out.printf(pattern.substring(1), args);
        } else {
            System.out.printf(pattern, args);
        }
    };

    @Override
    public Output useSettings(Object settings) {
        return this;
    }
}
