package operations;

import files.Constants;
import menu.AlphabetSelection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DecryptionBruteForce {
    private static int key = 0;
    private static char[] selectedAlphabet;

    private static List<String> getAllTypesDecryptedTexts(char[] encryption) {  // Создание списка расшифрованного текста по всем возможным ключам

        List<String> list = new ArrayList<>();
        for (int i = 0; i < Constants.ENGLISH_ALPHABET.length; i++) {
            list.add(new String(DecryptionBruteForce.decryptionBruteForce(encryption, selectedAlphabet)));
        }
        return list;
    }
    private static char[] decryptionBruteForce(char[] str, char[] alphabet) {
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
        key++;
        return cipher;
    }
    public static void decryptBF() {
        System.out.println("Decrypting text using Brute Force:");
        selectedAlphabet = AlphabetSelection.alphabetSelection();
        System.out.println("Введите текст, который хотите расшифровать: ");
        Scanner scan = new Scanner(System.in);
        char[] encryptedText = scan.nextLine().toCharArray();
        List<String> listDecryptionTexts = getAllTypesDecryptedTexts(encryptedText);
        String decryptedText = AnalyzeText.analyzeText(listDecryptionTexts, Constants.FILE_CHECKLIST_OF_ENGLISH_WORDS);
        System.out.println("Возможный текст: \n" + decryptedText);
    }
}
