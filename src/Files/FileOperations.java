package Files;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileOperations {
    public List<String> readFile(String filename) {
        try {
            Path filePath = Path.of(filename);
            return Files.readAllLines(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void writeToFile(String filePathName, String content) {
        try (FileWriter writer = new FileWriter(filePathName)) {
            writer.write(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void appendToFile(String filePathName, String content) {
        try (FileWriter writer = new FileWriter(filePathName, true)) {
            writer.write(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
