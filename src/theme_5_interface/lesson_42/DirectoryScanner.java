package theme_5_interface.lesson_42;

import java.io.File;

public interface DirectoryScanner {
    void printFilesOfDirectory(File[] files);

    default public File[] getFilesOfDirectory(String dirPath) {
        File directory = new File(dirPath);
        return directory.listFiles();
    }

    default void readAndPrint(String directoryPath) {
        File[] files = getFilesOfDirectory(directoryPath);
        printFilesOfDirectory(files);

    }
}
