
package src.main.java.sum_machine;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

import src.main.java.sum_machine.apps.SumMachine;
import src.main.java.sum_machine.io.Input;
import src.main.java.sum_machine.io.Output;

class Main {
    public static void main(String[] args) {
        Input input = new Input() {
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
        };


        Output output = new Output() {

            @Override
            public void output(String message) {
                System.out.print(message);
            }

            @Override
            public void outFormat(String pattern, Object... args) {
                System.out.printf(pattern, args);
            }
        };

        SumMachine application = new SumMachine(input, output);


        application.run();
    }
}



