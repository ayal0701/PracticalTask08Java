package org.example;

import java.util.Scanner;

public class AgeCategoryClassifier {

    public void classifyAge(Scanner scanner) {
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        if (age >= 0 && age <= 12) {
            System.out.println("You are a child.");
        } else if (age >= 13 && age <= 19) {
            System.out.println("You are a teenager.");
        } else if (age >= 20 && age <= 59) {
            System.out.println("You are an adult.");
        } else if (age >= 60) {
            System.out.println("You are a senior.");
        } else {
            System.out.println("Invalid age entered. Please enter a non-negative age.");
        }
    }
}
