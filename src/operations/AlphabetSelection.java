package operations;

import files.Constants;

import java.util.Scanner;

public class AlphabetSelection {
    public static char[] alphabetSelection() {
        System.out.println("Выберите какой алфавит использовать: ");
        System.out.println("1. Английский");
        System.out.println("2. Русский");
        InputValidator inputValidator = new InputValidator();
        Scanner inputScanner = new Scanner(System.in);
        int choice;
        while (true) {
            choice = inputValidator.validateChoiceAlphabet(inputScanner);
            switch (choice) {
                case 1 -> {
                    System.out.println("Выбран английский алфавит");
                    return Constants.ENGLISH_ALPHABET;
                }
                case 2 -> {
                    System.out.println("Выбран русский алфавит");
                    return Constants.RUSSIAN_ALPHABET;
                }
                default -> System.out.println("This is a not valid value");
            }
        }
    }
}
