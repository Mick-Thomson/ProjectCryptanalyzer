package operations;

import files.Constants;
import files.FileOperations;
import menu.AlphabetSelection;
import menu.InputValidator;

import java.io.File;
import java.nio.file.Path;
import java.util.Scanner;

import static operations.DecryptionKey.decrypt;

public class Encryption {
    private static String defaultText;
    private static int key;
    protected static String encryptedText;
    private static void writeOriginalTextInFile() {
        Scanner scanText = new Scanner(System.in);
        defaultText = scanText.nextLine();
        FileOperations originalText = new FileOperations();

//        FileOperations.fileCreator(Constants.FILE_NAME);
//        write.appendToFile(FileOperations.fileCreator(Constants.FILE_NAME), defaultText);

//        originalText.writeToFile(Constants.FILE_ORIGINAL_TEXT, defaultText);

        originalText.writeToFile(originalText.fileCreator(Constants.FILE_ORIGINAL_TEXT), defaultText);
//        write.writeToFile(Constants.FILE_NAME, defaultText);
    }
    private static void writeEncryptedTextInFile() {
        FileOperations write = new FileOperations();
        write.writeToFile(Constants.FILE_ENCRYPTION_TEXT, encryptedText);
    }
    private static void writeKeyInFile() {
        FileOperations write = new FileOperations();
        write.writeToFile(Constants.FILE_CURRENT_KEY, key + "");
    }
    private static char[] encryption(char[] str, int key, char[] alphabet) {
        char[] cipher = new char[str.length];
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if (str[i] == alphabet[j]) {              // Если ин.символ из текста равен ин.символу из алфавита
                    if (j + key > alphabet.length - 1) {  // И если индекс с ключом больше длины алфавита
                        j -= alphabet.length - key;       // То индекс = индекс минус длина алфавита с вычтенным ключом
                        cipher[i] = alphabet[j];
                        break;
                    }
                    cipher[i] = alphabet[j + key];
                    break;
                }
            }
        }
        return cipher;
    }
    private static void generateKey(char[] alphabet) {
        Scanner scanKey = new Scanner(System.in);
        key = 0;
        int limit = alphabet.length;
        while (key < 1 || key > limit) {
            int tmp = scanKey.nextInt();
            if (tmp > 0 && tmp < limit) {
                key = tmp;
            } else {
                System.out.println("Введено некорректное число, попробуйте ещё раз!");
            }
        }
    }
    public static void encrypt() {
        System.out.println("Encryption:");
        char[] selectedAlphabet = AlphabetSelection.alphabetSelection();
        System.out.println("Введите текст, который хотите зашифровать: ");
        writeOriginalTextInFile();
        System.out.printf("Введите ключ от 1 до %d: \n", selectedAlphabet.length - 1);
        generateKey(selectedAlphabet);
        char[] defaultTextSymbols = defaultText.toLowerCase().toCharArray();
        encryptedText = new String(encryption(defaultTextSymbols, key, selectedAlphabet));   // Зашифровывание
        writeEncryptedTextInFile();
        writeKeyInFile();
        System.out.println("Текст зашифрован: ");
        System.out.println(encryptedText);
    }
}
