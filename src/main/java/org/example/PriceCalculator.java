package org.example;

import java.util.Scanner;

public class PriceCalculator {

    public double calculatePriceIncludingVAT(Scanner scanner) {
        System.out.print("Enter the price of the product excluding VAT: ");
        double priceExcludingVAT = scanner.nextDouble();

        double vat = priceExcludingVAT * 0.20;
        return priceExcludingVAT + vat;
    }
}
