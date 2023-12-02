package theme_5_interface.task_41;

public class FileInformation {
    String fileName;
    String absolutePath;
    long size;

    public FileInformation(String fileName, String absolutePath, long size) {
        this.fileName = fileName;
        this.absolutePath = absolutePath;
        this.size = size;
    }

    public boolean isTextFile() {
        if (fileName.endsWith(".txt")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "fileName='" + fileName + '\'' +
                ", absolutePath='" + absolutePath + '\'' +
                ", size=" + size;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof FileInformation) {
            FileInformation info = (FileInformation) obj;
            return this.fileName.equals(info.fileName)
                    && this.absolutePath.equals(info.absolutePath)
                    && this.size == info.size;
        } else {
            return false;
        }
    }
}
