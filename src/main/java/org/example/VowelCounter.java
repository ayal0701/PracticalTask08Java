package org.example;

import java.util.Scanner;

public class VowelCounter {

    public int countVowels(Scanner scanner) {
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();

        int count = 0;
        str = str.toLowerCase();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }

        return count;
    }
}
