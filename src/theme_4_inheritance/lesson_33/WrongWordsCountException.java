package theme_4_inheritance.lesson_33;

public class WrongWordsCountException extends RuntimeException {
    int wordsCount;
    public WrongWordsCountException(int wordsCount) {
       this.wordsCount = wordsCount;
    }
}
