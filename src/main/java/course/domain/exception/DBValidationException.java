package course.domain.exception;

public class DBValidationException extends RuntimeException {
    public DBValidationException(String message) {
        super(message);
    }
}
