package theme_5_interface.task_40;

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

    @Override
    public String toString() {
        return  "fileName='" + fileName + '\'' +
                ", absolutePath='" + absolutePath + '\'' +
                ", size=" + size;
    }
}
