package theme_4_inheritance.task_33;

public class IncorrectInputException extends RuntimeException {
    public IncorrectInputException(String message) {
        super("Incorrect input!" + message);
    }
}
