package files.exceptions;

import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.List;

public class FilenameValidator {
    private static final List<String> FORBIDDEN_DIRS_FILES = List.of("", "", "");
    private static final String SYSTEM_SEPARATOR = System.getProperty("file.separator");

    public void validateForWriting(String filename) {
        Path path = validatePath(filename);

        if (Files.exists(path)) {
            if (Files.isDirectory(path)) {
                throw new FileProcessingException("File" + path + "is directory");
            }
            if (!Files.isWritable(path)) {
                throw new FileProcessingException("File" + path + "is not accessible for writing");
            }
        }
    }
    public void validateForReading(String filename) {
        Path path = validatePath(filename);

        if (Files.notExists(path)) {
            throw new FileProcessingException("File" + path + "doesn't exist");
        }
        if (Files.isDirectory(path)) {
            throw new FileProcessingException("File" + path + "is directory");
        }
        if (!Files.isReadable(path)) {
            throw new FileProcessingException("You don't have right to read from the file: " + path);
        }
    }
    private Path validatePath(String filename) {
        for (String pathPart : filename.split(SYSTEM_SEPARATOR)) {
            if (FORBIDDEN_DIRS_FILES.contains(pathPart)) {
                throw new FileProcessingException("Path contains forbidden part: " + pathPart);
            }
        }
        try {
            Path path = Path.of(filename);
            return path;
        } catch (InvalidPathException e) {
            throw new FileProcessingException("Invalid path.Reason: " + e.getMessage(), e);
        }
    }
}
