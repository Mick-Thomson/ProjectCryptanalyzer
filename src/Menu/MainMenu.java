package Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        InputValidator inputValidator = new InputValidator();
        Scanner inputScanner = new Scanner(System.in);

        int choice;
        while (true) {
            System.out.println("\nCryptanalyzer Main Menu\n");
            System.out.print("1. Encryption. \n");
            System.out.print("2. Decryption (Key). \n");
            System.out.print("3. Decryption (Brute Force). \n");
            System.out.print("4. Decryption (Statistical Analysis). \n");
            System.out.print("0. Exit. \n");

            choice = inputValidator.validateChoice(inputScanner);


            switch (choice) {
                case 1 -> {
                    System.out.println("Encryption");
                }
                case 2 -> {
                    System.out.println("Decrypting text using a key");
                }
                case 3 -> {
                    System.out.println("Decrypting text using brute force");
                }
                case 4 -> {
                    System.out.println("Decrypting using statistical text analysis");
                }
                case 0 -> {
                    System.out.println("Exiting program!");
                    System.exit(0);
                }
                default -> {
                    System.out.println("This is a not valid value");
                }
            }
        }
    }




}
