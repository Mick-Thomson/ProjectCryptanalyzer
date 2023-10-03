import files.Constants;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Test {
    public static final String FILE_NAME = "file.txt";
    public static void main(String[] args) throws IOException {
        Path path = Path.of(FILE_NAME);
//        System.out.println(Path.of(Constants.FILE_ORIGINAL_TEXT).toAbsolutePath());
        System.out.println(Files.exists(path));
        Path pathFile = Files.createFile(path);
    }
}
