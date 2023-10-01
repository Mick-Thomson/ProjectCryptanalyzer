package files.exceptions;

public class FileProcessingException extends RuntimeException {
    String reason;
    public FileProcessingException(String reason) {
        this.reason = reason;
    }
    public FileProcessingException(String reason, Throwable cause) {
        super(cause);
        this.reason = reason;
    }
    public String getReason() {
        return this.reason;
    }
}
