package theme_4_inheritance.lesson_33;

public class CbrNotAvailableException extends RuntimeException {
    CbrNotAvailableException(Exception cause) {
        super("cbr api is not working now", cause);
    }
}
