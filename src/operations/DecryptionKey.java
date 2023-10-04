package operations;

import files.Constants;
import files.FileOperations;
import menu.AlphabetSelection;

import java.util.Scanner;

public class DecryptionKey {
    protected static String decryptedText;
    private static void writeDecryptedTextInFile() {
        FileOperations write = new FileOperations();
        write.writeToFile(Constants.FILE_DECRYPTION_TEXT, decryptedText);
    }

    private static char[] decryptionKey(char[] str, int key, char[] alphabet) {
        char[] cipher = new char[str.length];
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if (str[i] == alphabet[j]) {             // Если ин.символ из теста равен ин.символу из алфавита
                    if (j < key) {                                        // И если индекс меньше ключа
                        j += alphabet.length - key;      // То индекс = индекс плюс длина алфавита с вычтенным ключом
                        cipher[i] = alphabet[j];
                        break;
                    }
                    cipher[i] = alphabet[j - key];
                    break;
                }
            }
        }
        return cipher;
    }
    public static void decrypt() {
        char[] selectedAlphabet = AlphabetSelection.alphabetSelection();
        System.out.println("Введите текст, который хотите расшифровать: ");
        Scanner scan = new Scanner(System.in);
        char[] decryptedTextSymbols = scan.nextLine().toCharArray();
        System.out.println("Введите ключ: ");
        int key = scan.nextInt();
        decryptedText = new String(decryptionKey(decryptedTextSymbols, key, selectedAlphabet));
        writeDecryptedTextInFile();
        System.out.println("Текст расшифрован: ");
        System.out.println(decryptedText);
    }
}
