package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("==================Task1==================");
        PriceCalculator calculator = new PriceCalculator();
        double priceIncludingVAT = calculator.calculatePriceIncludingVAT(scanner);
        System.out.printf("Price including VAT: %.2f%n", priceIncludingVAT);

        System.out.println();

        System.out.println("==================Task2==================");
        TemperatureCalculator temperatureCalculator = new TemperatureCalculator();
        float averageTemperature = temperatureCalculator.calculateAverageTemperature(scanner);
        System.out.printf("The average temperature over five days is: %.2f%n", averageTemperature);

        System.out.println();

        System.out.println("==================Task3==================");
        scanner.nextLine();
        VowelCounter vowelCounter = new VowelCounter();
        int vowelCount = vowelCounter.countVowels(scanner);
        System.out.printf("Total number of vowels found: %d%n", vowelCount);

        System.out.println();

        System.out.println("==================Task4==================");
        EvenOddChecker evenOddChecker = new EvenOddChecker();
        evenOddChecker.checkEvenOrOdd(scanner);

        System.out.println();

        System.out.println("==================Task5==================");
        GradeCalculator gradeCalculator = new GradeCalculator();
        gradeCalculator.calculateGrade(scanner);

        System.out.println();

        System.out.println("==================Task6==================");
        AgeCategoryClassifier ageClassifier = new AgeCategoryClassifier();
        ageClassifier.classifyAge(scanner);

        System.out.println();

        System.out.println("==================Task7==================");
        InterestCalculator interestCalculator = new InterestCalculator();
        interestCalculator.calculateInterest(scanner);

        System.out.println();

        System.out.println("==================Task8==================");
        RockPaperScissors rockPaperScissors = new RockPaperScissors();
        rockPaperScissors.playGame(scanner);

        System.out.println();

        System.out.println("==================Task9==================");
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        passwordGenerator.generatePassword(scanner);




        scanner.close();
    }
}
