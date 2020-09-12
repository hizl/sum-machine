package src.main.java.sum_machine.io;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);
    
    @Override
    public String next() {
        return this.scanner.next();
    };

    @Override
    public Integer nextInt() {
        return this.scanner.nextInt();
    };

    @Override
    public String nextLine() {
        return this.scanner.nextLine();
    };

    @Override
    public boolean hasNext(Pattern pattern) {
        return this.scanner.hasNext(pattern);
    };

    @Override
    public Input useSettings(Object settings) {
        return this;
    }
}
