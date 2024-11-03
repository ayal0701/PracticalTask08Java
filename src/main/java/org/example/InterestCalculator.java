package org.example;

import java.util.Scanner;

public class InterestCalculator {

    public void calculateInterest(Scanner scanner) {
        System.out.print("Enter the initial deposit amount (P): ");
        double principal = scanner.nextDouble();

        System.out.print("Enter the annual interest rate (in percentage): ");
        double annualInterestRate = scanner.nextDouble() / 100;

        System.out.print("Enter the number of years (t): ");
        int years = scanner.nextInt();

        double amount = principal;

        System.out.printf("%-10s %-10s%n", "Year", "Amount");
        System.out.println("======================");

        for (int year = 1; year <= years; year++) {
            amount *= (1 + annualInterestRate);
            System.out.printf("%-10d %-10.2f%n", year, amount);
        }
    }
}
