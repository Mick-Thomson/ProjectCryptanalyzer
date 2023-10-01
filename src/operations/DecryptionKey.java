package operations;

import files.Constants;
import files.FileOperations;

import java.util.Scanner;

public class DecryptionKey {

    protected static String decryptedText;
    private static void writeDecryptedTextInFile() {
        FileOperations write = new FileOperations();
        write.writeToFile(Constants.FILE_DECRYPTION_TEXT, decryptedText);
    }

    private static char[] decryptionKey(char[] str, int key) {
        char[] cipher = new char[str.length];
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < Constants.ENGLISH_ALPHABET.length; j++) {
                if (str[i] == Constants.ENGLISH_ALPHABET[j]) {             // Если ин.символ из теста равен ин.символу из алфавита
                    if (j < key) {                                        // И если индекс меньше ключа
                        j += Constants.ENGLISH_ALPHABET.length - key;      // То индекс = индекс плюс длина алфавита с вычтенным ключом
                        cipher[i] = Constants.ENGLISH_ALPHABET[j];
                        break;
                    }
                    cipher[i] = Constants.ENGLISH_ALPHABET[j - key];
                    break;
                }
            }
        }
        return cipher;
    }
    public static void decrypt() {
        System.out.println("Введите текст, который хотите расшифровать: ");
        Scanner scan = new Scanner(System.in);
        char[] decryptedTextSymbols = scan.nextLine().toCharArray();
        System.out.println("Введите ключ: ");
        int key = scan.nextInt();
        decryptedText = new String(decryptionKey(decryptedTextSymbols, key));
        writeDecryptedTextInFile();
        System.out.println("Текст расшифрован: ");
        System.out.println(decryptedText);
        scan.close();
    }
}
