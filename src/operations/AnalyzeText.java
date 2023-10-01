package operations;

import files.Constants;
import files.FileOperations;

import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import static files.FileOperations.getControlEnglishWords;


public class AnalyzeText {

    public static String analyzeText(List<String> list, String fileVerificationSource) {
        String result = "Не найдено совпадений!";
        int hitCounter = 0;
        StringTokenizer stringTokenizer;
        FileOperations readFile = new FileOperations();
        readFile.readFromFile(fileVerificationSource);
        for (String line : list) {
            int countWords = separateWords(line);
            stringTokenizer = new StringTokenizer(line, Constants.DELIMITER);
            while (stringTokenizer.hasMoreTokens()) {
                String word = stringTokenizer.nextToken();
                for (String controlEnglishWord : getControlEnglishWords()) {
                    if (word.equalsIgnoreCase(controlEnglishWord)) {
                        hitCounter++;
                        break;
                    }
                }
            }
            if (hitCounter > countWords) {
                result = line;
                System.out.println(result + " " + countWords);
            }
            hitCounter = 0;
        }
        return result;
    }

    private static int separateWords(String line) {
        StringTokenizer stringTokenizer = new StringTokenizer(line, Constants.DELIMITER);
        int countWords = stringTokenizer.countTokens();
//        System.out.println(countWords / 2);
        return countWords / 2;
    }
}
