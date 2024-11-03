package org.example;

import java.util.Scanner;

public class TemperatureCalculator {

    public float calculateAverageTemperature(Scanner scanner) {
        float totalTemperature = 0.0f;

        for (int day = 1; day <= 5; day++) {
            System.out.print("Enter the temperature for day " + day + ": ");
            float dailyTemperature = scanner.nextFloat();
            totalTemperature += dailyTemperature;
        }

        return totalTemperature / 5;
    }
}
