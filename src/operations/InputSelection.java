package operations;

import files.Constants;
import files.FileOperations;

import java.util.Scanner;

public class InputSelection {
    protected static char[] encryptedTextSymbols;
    protected static int key;
    protected static void selectingDataEntryMethodForDecryptionKey() {
        System.out.println("Выберите способа ввода данных: ");
        System.out.println("1. С клавиатуры");
        System.out.println("2. Из файла");
        InputValidator inputValidator = new InputValidator();
        Scanner inputScanner = new Scanner(System.in);
        int choice;
        while (true) {
            choice = inputValidator.validateChoiceAlphabet(inputScanner);
            switch (choice) {
                case 1 -> {
                    System.out.println("Выбран ввод с клавиатуры");
                    System.out.println("Введите текст, который хотите расшифровать: ");
                    Scanner scan = new Scanner(System.in);
                    // Вводим текст
                    encryptedTextSymbols = scan.nextLine().toCharArray();
                    System.out.println("Введите ключ: ");
                    // Вводим ключ
                    key = scan.nextInt();
                    return;
                }
                case 2 -> {
                    System.out.println("Выбрано чтение из файла");
                    // Вводим текст
                    FileOperations readEncryptionFile = new FileOperations();
                    encryptedTextSymbols = readEncryptionFile.readFile(Constants.FILE_ENCRYPTION_TEXT).toCharArray();
                    System.out.println("Зашифрованный текст: " + new String(encryptedTextSymbols));
                    // Вводим ключ
                    FileOperations readCurrentKeyFile = new FileOperations();
                    key = Integer.parseInt(readCurrentKeyFile.readFile(Constants.FILE_CURRENT_KEY));
                    System.out.println("Ключ: " + key);
                    return;
                }
                default -> System.out.println("This is a not valid value");
            }
        }
    }
    protected static void selectingDataEntryMethodForDecryptionBruteForce() {
        System.out.println("Выберите способа ввода данных: ");
        System.out.println("1. С клавиатуры");
        System.out.println("2. Из файла");
        InputValidator inputValidator = new InputValidator();
        Scanner inputScanner = new Scanner(System.in);
        int choice;
        while (true) {
            choice = inputValidator.validateChoiceAlphabet(inputScanner);
            switch (choice) {
                case 1 -> {
                    System.out.println("Выбран ввод с клавиатуры");
                    System.out.println("Введите текст, который хотите расшифровать: ");
                    Scanner scan = new Scanner(System.in);
                    // Вводим текст
                    encryptedTextSymbols = scan.nextLine().toCharArray();
                    return;
                }
                case 2 -> {
                    System.out.println("Выбрано чтение из файла");
                    // Вводим текст
                    FileOperations readEncryptionFile = new FileOperations();
                    encryptedTextSymbols = readEncryptionFile.readFile(Constants.FILE_ENCRYPTION_TEXT).toCharArray();
                    System.out.println("Зашифрованный текст: " + new String(encryptedTextSymbols));
                    return;
                }
                default -> System.out.println("This is a not valid value");
            }
        }
    }
}
