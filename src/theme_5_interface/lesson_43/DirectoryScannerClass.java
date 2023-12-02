package theme_5_interface.lesson_43;

import java.io.File;

public abstract class DirectoryScannerClass {
    String directoryPath;
    boolean searchSubDirectories = false;

    public DirectoryScannerClass(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    abstract void printFilesOfDirectory(File[] files);

    File[] getFilesOfDirectory() {
        File directory = new File(this.directoryPath);
        return directory.listFiles();
    }

    void readAndPrint() {
        File[] files = getFilesOfDirectory();
        printFilesOfDirectory(files);

    }
}
