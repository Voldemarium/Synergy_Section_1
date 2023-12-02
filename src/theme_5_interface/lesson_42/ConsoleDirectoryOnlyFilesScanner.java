package theme_5_interface.lesson_42;

import java.io.File;

public class ConsoleDirectoryOnlyFilesScanner implements DirectoryScanner{
    @Override
    public void printFilesOfDirectory(File[] files) {
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i].getName());
        }
    }

    @Override
    public File[] getFilesOfDirectory(String dirPath) {
        File directory = new File(dirPath);
        File[] filesAndDirs = directory.listFiles();
        int filesCount = 0;
        for (File file : filesAndDirs) {
            if (file.isFile()) {
                filesCount++;
            }
        }
        File[] filesOnly = new File[filesCount];
        int lastIndex = 0;
        for (File file : filesAndDirs) {
            if (file.isFile()) {
                filesOnly[lastIndex] = file;
                lastIndex++;
            }
        }
        return directory.listFiles();
    }
}
