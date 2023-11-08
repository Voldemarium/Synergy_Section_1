package theme_4_inheritance.task_29;

public class File extends Directory {
    String fileExtension;

    public File(String name, String url, String fileExtension) {
        super(name, url);
        this.fileExtension = fileExtension;
    }

}
