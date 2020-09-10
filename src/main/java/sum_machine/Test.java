package src.main.java.sum_machine;

import java.util.Scanner;

public class Test {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        double compared = scanner.nextDouble();
        if (compared < 2) {
            System.out.println("число до 2");
        }
        long upperBound = Math.round(Math.sqrt((double) compared));
        for (long i = 2; i <= upperBound; i++) {
            if (compared % i == 0) {
                System.out.println("Это Сложное число " + compared);
                break;
            } else {
                System.out.println("Это Простое число " + compared);
                break;
            }
        }
    }
}


