package theme_4_inheritance.lesson_38;

import java.io.File;
import java.util.Scanner;

public class MediaFileOpener extends FileOpener{
    public MediaFileOpener(File file) {
        super(file);
    }

    @Override
    public void openFile() {
        System.out.println("This is media file. It can play sound, be careful. Do you want to open it? (y/n)");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();
        if (answer.equals("y")) {
            super.openFile();
        }
    }
}
