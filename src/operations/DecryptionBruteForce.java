package operations;

import files.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DecryptionBruteForce {
    private static int key = 0;

    private static List<String> getAllTypesDecryptedTexts(char[] encryption) {  // Создание списка расшифрованного текста по всем возможным ключам
        List<String> list = new ArrayList<>();
        for (int i = 0; i < Constants.ENGLISH_ALPHABET.length; i++) {
            list.add(new String(DecryptionBruteForce.decryptionBruteForce(encryption)));
        }
        return list;
    }
    private static char[] decryptionBruteForce(char[] str) {
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
        key++;
        return cipher;
    }
    public static void decryptBF() {
        System.out.println("Введите текст, который хотите расшифровать: ");
        Scanner scan = new Scanner(System.in);
//        String encryptionText = scan.nextLine();
        char[] encryptedText = scan.nextLine().toCharArray();
        List<String> listDecryptionTexts = getAllTypesDecryptedTexts(encryptedText);
        String decryptedText = AnalyzeText.analyzeText(listDecryptionTexts, Constants.FILE_LIST_ENGLISH_WORDS);
        System.out.println("Возможный текст: \n" + decryptedText);
    }
}
