package theme_2.lesson_11;

import java.io.File;
import java.io.IOException;

public class Lesson_11 {
    public static void main(String[] args) throws IOException {
        int x = 1;
        while (x < 6) {
            File file = new File("./src/theme_2/lesson_2/files/" + x + ".txt");
            file.createNewFile();
            x++;
        }
    }
}
