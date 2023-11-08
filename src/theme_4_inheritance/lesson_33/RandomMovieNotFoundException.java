package theme_4_inheritance.lesson_33;

public class RandomMovieNotFoundException extends RuntimeException {
    public RandomMovieNotFoundException() {
        super("Random movie not found. Something wrong with url?");
    }

    public RandomMovieNotFoundException(String message) {
        super(message);
    }
}
