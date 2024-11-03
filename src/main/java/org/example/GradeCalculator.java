package org.example;

import java.util.Scanner;

public class GradeCalculator {

    public void calculateGrade(Scanner scanner) {
        System.out.print("Enter the numerical score (0-100): ");
        int score = scanner.nextInt();

        char grade;

        if (score >= 90 && score <= 100) {
            grade = 'A';
        } else if (score >= 80) {
            grade = 'B';
        } else if (score >= 70) {
            grade = 'C';
        } else if (score >= 60) {
            grade = 'D';
        } else if (score >= 0) {
            grade = 'F';
        } else {
            System.out.println("Invalid score. Please enter a score between 0 and 100.");
            return;
        }

        System.out.printf("The letter grade for a score of %d is: %c%n", score, grade);
    }
}
