package theme_3_OOP.task_21;

public class FileInformation {
    String fileName;
    String absolutePath;
    long size;

    public boolean isTextFile() {
        if (fileName.endsWith(".txt")) {
            return true;
        } else {
            return false;
        }
    }
}
