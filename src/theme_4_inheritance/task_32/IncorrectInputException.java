package theme_4_inheritance.task_32;

public class IncorrectInputException extends RuntimeException {
    public IncorrectInputException(String message) {
        super("Incorrect input!" + message);
    }
}
