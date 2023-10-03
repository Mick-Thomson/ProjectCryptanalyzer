package files;

import files.exceptions.FileProcessingException;
import operations.AnalyzeText;
import operations.DecryptionBruteForce;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileOperations {
    private static final List<String> controlEnglishWords = new ArrayList<>();
    private static final StandardOpenOption[] FILE_WRITE_OPTIONS =
            {StandardOpenOption.CREATE, StandardOpenOption.APPEND};
    public List<String> readFile(String filename) {
        try {
            Path filePath = Path.of(filename);
            return Files.readAllLines(filePath);
        } catch (IOException | InvalidPathException e) {
            throw new FileProcessingException(e.getMessage(), e);
        }
    }
    public void readFromFile(String fileNAme) {
        try (FileReader fileReader = new FileReader(fileNAme);
             BufferedReader bufferedWriter = new BufferedReader(fileReader)) {
            while (bufferedWriter.ready()) {
                controlEnglishWords.add(bufferedWriter.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("File not found!");
        }
    }
    public void writeToFile(String filePathName, String content) {
        try (FileWriter writer = new FileWriter(filePathName)) {
            writer.write(content);
        } catch (IOException e) {
            throw new FileProcessingException(e.getMessage(), e);
        }
    }
    public void appendToFile(String fileName, String content) {
        try {
            Path filePath = Path.of(fileName);
            Files.writeString(filePath, content, FILE_WRITE_OPTIONS);
        } catch (IOException | InvalidPathException e) {
            throw new FileProcessingException(e.getMessage(), e);
        }
/*        try (Path filePath = Path.of(fileName);
             FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
    }
    public static List<String> getControlEnglishWords() {
        return controlEnglishWords;
    }
}
