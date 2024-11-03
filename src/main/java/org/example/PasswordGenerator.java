package org.example;

import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {

    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:,.<>?";

    public void generatePassword(Scanner scanner) {
        System.out.print("Enter the desired password length (minimum 8): ");
        int length = Integer.parseInt(scanner.nextLine());

        while (length < 8) {
            System.out.print("Password length must be at least 8. Please enter again: ");
            length = Integer.parseInt(scanner.nextLine());
        }

        boolean includeLowercase = true;
        boolean includeUppercase = true;
        boolean includeDigits = true;
        boolean includeSpecialCharacters = true;

        System.out.print("Include lowercase letters? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("no")) {
            includeLowercase = false;
        }

        System.out.print("Include uppercase letters? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("no")) {
            includeUppercase = false;
        }

        System.out.print("Include digits? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("no")) {
            includeDigits = false;
        }

        System.out.print("Include special characters? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("no")) {
            includeSpecialCharacters = false;
        }

        StringBuilder characterPool = new StringBuilder();
        if (includeLowercase) characterPool.append(LOWERCASE);
        if (includeUppercase) characterPool.append(UPPERCASE);
        if (includeDigits) characterPool.append(DIGITS);
        if (includeSpecialCharacters) characterPool.append(SPECIAL_CHARACTERS);

        if (characterPool.length() == 0) {
            System.out.println("No character types selected. Password cannot be generated.");
            return;
        }

        StringBuilder password = new StringBuilder(length);
        Random random = new Random();

        if (includeLowercase) password.append(LOWERCASE.charAt(random.nextInt(LOWERCASE.length())));
        if (includeUppercase) password.append(UPPERCASE.charAt(random.nextInt(UPPERCASE.length())));
        if (includeDigits) password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        if (includeSpecialCharacters) password.append(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));

        while (password.length() < length) {
            password.append(characterPool.charAt(random.nextInt(characterPool.length())));
        }

        String generatedPassword = shuffleString(password.toString());

        System.out.println(password);
        System.out.println("Generated Password: " + generatedPassword);
    }

    private String shuffleString(String input) {
        char[] characters = input.toCharArray();
        Random random = new Random();
        for (int i = characters.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            char temp = characters[i];
            characters[i] = characters[j];
            characters[j] = temp;
        }
        return new String(characters);
    }
}
