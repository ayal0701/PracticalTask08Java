package org.example;

import java.util.Scanner;

public class EvenOddChecker {

    public void checkEvenOrOdd(Scanner scanner) {
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        if (number % 2 == 0) {
            System.out.println(number + " is an even number.");
        } else {
            System.out.println(number + " is an odd number.");
        }
    }
}
