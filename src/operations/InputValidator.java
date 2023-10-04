package operations;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputValidator {
    public static final int DEFAULT_CHOICE = -1;
    public static final String BAD_VALUE = "Please enter number from 0 to 4. Your value is: ";
    public static final String BAD_VALUE_ALPHABET = "Please enter number from 1 or 2. Your value is: ";

    public int validateChoice(Scanner inputScanner) {
        try {
            return inputScanner.nextInt();
        } catch (InputMismatchException e) {
            System.err.println(BAD_VALUE + inputScanner.nextLine());
            return DEFAULT_CHOICE;
        }
    }
    public int validateChoiceAlphabet(Scanner inputScanner) {
        try {
            return inputScanner.nextInt();
        } catch (InputMismatchException e) {
            System.err.println(BAD_VALUE_ALPHABET + inputScanner.nextLine());
            return DEFAULT_CHOICE;
        }
    }
}
