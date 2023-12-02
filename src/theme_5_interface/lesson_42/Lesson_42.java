package theme_5_interface.lesson_42;

import java.io.File;

public class Lesson_42 {
    public static void main(String[] args) {
        DirectoryScanner consoleDirectoryScanner = new ConsoleDirectoryScanner();
        File[] files_1 = consoleDirectoryScanner.getFilesOfDirectory("./src/theme_5_interface");
        consoleDirectoryScanner.printFilesOfDirectory(files_1);
        DirectoryScanner textDirectoryScanner = new TextDirectoryScanner();
//        textDirectoryScanner.getFilesOfDirectory("./src/theme_5_interface/lesson_42");
        textDirectoryScanner.printFilesOfDirectory(files_1);
        DirectoryScanner csvDirectoryScanner = new CsvDirectoryScanner();
        csvDirectoryScanner.printFilesOfDirectory(files_1);
        DirectoryScanner consoleDirectoryOnlyFilesScanner = new ConsoleDirectoryOnlyFilesScanner();
//        File[] filesOnly = consoleDirectoryOnlyFilesScanner.getFilesOfDirectory(".");
//        consoleDirectoryOnlyFilesScanner.printFilesOfDirectory(filesOnly);
        consoleDirectoryOnlyFilesScanner.readAndPrint(".");
    }
}
