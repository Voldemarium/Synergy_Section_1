package theme_5_interface.lesson_42;

import java.io.File;

public class ConsoleDirectoryScanner implements DirectoryScanner{
    @Override
    public void printFilesOfDirectory(File[] files) {
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i].getName());
        }

    }
}
