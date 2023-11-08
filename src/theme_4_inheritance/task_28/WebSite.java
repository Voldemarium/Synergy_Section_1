package theme_4_inheritance.task_28;

public class WebSite {
    String name;
    String url;
    String technology;
    String type;

    WebSite() {
    }

    WebSite(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public WebSite(String name, String url, String technology, String type) {
        this.name = name;
        this.url = url;
        this.technology = technology;
        this.type = type;
    }
}
