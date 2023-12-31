package operations;

import files.Constants;
import files.FileOperations;

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
        System.out.println("Decrypting text using a key:");
        char[] selectedAlphabet = AlphabetSelection.alphabetSelection();
        InputSelection.selectingDataEntryMethodForDecryptionKey();
        decryptedText = new String(decryptionKey(InputSelection.encryptedTextSymbols, InputSelection.key, selectedAlphabet));
        writeDecryptedTextInFile();
        System.out.println("Текст расшифрован: ");
        System.out.println(decryptedText);
    }

}
