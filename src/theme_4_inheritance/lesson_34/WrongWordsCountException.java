package theme_4_inheritance.lesson_34;

public class WrongWordsCountException extends RuntimeException {
    int wordsCount;
    public WrongWordsCountException(int wordsCount) {
       this.wordsCount = wordsCount;
    }
}
