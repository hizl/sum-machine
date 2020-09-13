package src.main.java.sum_machine.io;

import java.util.Scanner;
import java.util.regex.Pattern;

public class DefaultConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String nextLine() {
        String line = this.scanner.nextLine();
        return line;
    }

    @Override
    public String next() {
        String token = this.scanner.next();

        return token;
    }

    @Override
    public Integer nextInt() {
        int number = this.scanner.nextInt();
        return number;
    }

    @Override
    public boolean hasNext(Pattern pattern) {
        return this.scanner.hasNext(pattern);
    }

    @Override
    public Input useSettings(Object settings) {
        return this;
    }
}
