package theme_4_inheritance.task_29;

public class Directory {
    String name;
    String url;

    public Directory(String name, String url) {
        this.name = name;
        this.url = url;
    }

    void printUrl() {
        System.out.println("url: " + this.url + "/" + this.name);
    }
}
