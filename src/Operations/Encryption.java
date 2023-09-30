package Operations;

import Files.Constants;
import Files.FileOperations;
import java.util.Scanner;

public class Encryption {
    private static String defaultText;
    private static int key;
    protected static String encryptedText;
    private static void writeOriginalTextInFile() {
        Scanner scanText = new Scanner(System.in);
        defaultText = scanText.nextLine();
        FileOperations write = new FileOperations();
        write.writeToFile(Constants.FILE_ORIGINAL_TEXT, defaultText);
    }
    private static void writeEncryptedTextInFile() {
        FileOperations write = new FileOperations();
        write.writeToFile(Constants.FILE_ENCRYPTION_TEXT, encryptedText);
    }
    private static void writeKeyInFile() {
        FileOperations write = new FileOperations();
        write.writeToFile(Constants.FILE_CURRENT_KEY, key + "");
    }
    private static char[] encryption(char[] str, int key) {
        char[] cipher = new char[str.length];
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < Constants.ENGLISH_ALPHABET.length; j++) {
                if (str[i] == Constants.ENGLISH_ALPHABET[j]) {              // Если ин.символ из текста равен ин.символу из алфавита
                    if (j + key > Constants.ENGLISH_ALPHABET.length - 1) {  // И если индекс с ключом больше длины алфавита
                        j -= Constants.ENGLISH_ALPHABET.length - key;       // То индекс = индекс минус длина алфавита с вычтенным ключом
                        cipher[i] = Constants.ENGLISH_ALPHABET[j];
                        break;
                    }
                    cipher[i] = Constants.ENGLISH_ALPHABET[j + key];
                    break;
                }
            }
        }
        return cipher;
    }
    private static void generateKey() {
        Scanner scanKey = new Scanner(System.in);
        key = 0;
        while (key < 1 || key > 36) {
            int tmp = scanKey.nextInt();
            if (tmp > 0 && tmp < 37) {
                key = tmp;
            } else {
                System.out.println("Введено некорректное число, попробуйте ещё раз!");
            }
        }
    }
    public static void encrypt() {
        System.out.println("Введите текст, который хотите зашифровать: ");
        writeOriginalTextInFile();
        System.out.println("Введите ключ от 1 до 36: ");
        generateKey();
        char[] defaultTextSymbols = defaultText.toLowerCase().toCharArray();
        encryptedText = new String(encryption(defaultTextSymbols, key));   // Зашифровывание
        writeEncryptedTextInFile();
        writeKeyInFile();
        System.out.println("Текст зашифрован: ");
        System.out.println(encryptedText);
    }
}
