package theme_5_interface.lesson_43;

public class Lesson_43 {
    public static void main(String[] args) {
        FileFinder fileFinder = new TextFileFinder();
        CsvDirectoryScannerClass directoryScannerClass =
                new CsvDirectoryScannerClass("./src/theme_5_interface");
        directoryScannerClass.searchSubDirectories = true;

    }
}
