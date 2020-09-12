package src.main.java.sum_machine.io;

import java.util.Scanner;
import java.io.File;
import java.util.regex.Pattern;

public class FileInput implements Input {
    private Scanner scanner = null;

    public void setFile(String pathname) throws Exception {
        this.scanner = new Scanner(new File(pathname));
    }
    
    @Override
    public String next() {
        if (this.scanner != null) {
            return this.scanner.next();
        }

        return null;
    };

    @Override
    public Integer nextInt() {
        if (this.scanner != null) {
            return this.scanner.nextInt();
        }

        return null;
    };

    @Override
    public String nextLine() {
        if (this.scanner != null) {
            return this.scanner.nextLine();
        }

        return null;
    };

    @Override
    public boolean hasNext(Pattern pattern) {
        if (this.scanner != null) {
            return this.scanner.hasNext(pattern);
        } else {
            return false;
        }
    };
}
