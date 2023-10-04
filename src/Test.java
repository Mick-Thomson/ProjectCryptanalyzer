import files.Constants;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Test {
    public static final String FILE_NAME = "file.txt";
    public static void main(String[] args) throws IOException {
        Path path = Path.of(FILE_NAME);
        if (!Files.exists(path)) {
            Files.createFile(path);
            System.out.println("Создан файл: file.txt");
        } else {
            System.out.println("Файл не создан, так как был уже создан до этого");
        }
        Path path1 = Path.of(Constants.FILE_CHECKLIST_OF_ENGLISH_WORDS);
        System.out.println(Files.readString(path1));
    }
}
