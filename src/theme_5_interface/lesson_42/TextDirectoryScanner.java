package theme_5_interface.lesson_42;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TextDirectoryScanner implements DirectoryScanner{

    @Override
    public void printFilesOfDirectory(File[] files) {
        try {
            FileWriter fileWriter = new FileWriter("./src/theme_5_interface/lesson_42/dir.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < files.length; i++) {
                bufferedWriter.write(files[i].getName() + "\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
