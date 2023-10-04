package menu;

import files.Constants;
import files.exceptions.FileProcessingException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.Scanner;

import static operations.DecryptionBruteForce.decryptBF;
import static operations.DecryptionKey.decrypt;
import static operations.Encryption.encrypt;

public class MainMenu {
    public void start() {
//        fileCreator(Constants.FILE_NAME);
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
                    encrypt();
                }
                case 2 -> {
                    System.out.println("Decrypting text using a key");
                    decrypt();
                }
                case 3 -> {
                    System.out.println("Decrypting text using brute force");
                    decryptBF();
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
    public static void fileCreator(String filename) {
        try {
            Path path = Path.of(filename);
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
        } catch (IOException | InvalidPathException e) {
            throw new FileProcessingException(e.getMessage(), e);
        }
    }




}
