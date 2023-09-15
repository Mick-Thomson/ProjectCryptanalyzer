package Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputValidator {
    public static final int DEFAULT_CHOICE = -1;
    public static final String BAD_VALUE = "Please enter number from 0 to 4. Your value is: ";

    public int validateChoice(Scanner inputScanner) {
        try {
            return inputScanner.nextInt();
        } catch (InputMismatchException e) {
            System.err.println(BAD_VALUE + inputScanner.nextLine());
            return DEFAULT_CHOICE;
        }
    }
}
