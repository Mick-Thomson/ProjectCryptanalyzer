package operations;

import files.Constants;
import files.FileOperations;
import java.util.List;
import java.util.StringTokenizer;
import static files.FileOperations.getControlEnglishWords;
public class AnalyzeText {
    public static String analyzeText(List<String> list, String fileVerificationSource) {
        String result = "Не найдено совпадений!";
        int hitCounter = 0;
        int keyCounter = 0;
        StringTokenizer stringTokenizer;
        FileOperations readFile = new FileOperations();
        readFile.readFromFile(fileVerificationSource);  // Читаем из проверочного файла
        for (String line : list) {  // Проходимся по списку всех расшифровок построчно
            int countWords = separateWords(line);   // Возвращаем количество слов в каждой строке разделённое на 3
            stringTokenizer = new StringTokenizer(line, Constants.DELIMITER);
            while (stringTokenizer.hasMoreTokens()) {   // Пока есть следующее слово с этой строке
                String word = stringTokenizer.nextToken();
                for (String controlEnglishWord : getControlEnglishWords()) {    // Получаем поэлементно из проверочной библиотеки слов
                    if (word.equalsIgnoreCase(controlEnglishWord)) {    // Проверяем слово из расшифрованной строки на совпадение из проверочной библиотеки
                        hitCounter++;   // Если есть, то прибавляем счётчик совпадений
                        break;
                    }
                }
            }
//            System.out.println("hitCounter: " + hitCounter);
            if (hitCounter > countWords) {  // Если счётчик совпадений больше счётчика количества слов в строке делённых на 3
                result = line;  // Значит расшифрованная строка скорее всего найдена
                System.out.println("Возможный ключ: " + keyCounter);
//                System.out.println("result line: " + result + " hitCounter: " + hitCounter + " countWords: " + countWords);
            }
            hitCounter = 0;
            keyCounter++;
        }
        return result;
    }
    private static int separateWords(String line) {
        StringTokenizer st = new StringTokenizer(line, Constants.DELIMITER);
        int countWords = st.countTokens();
        return countWords / 3;
    }
}
