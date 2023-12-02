package theme_5_interface.task_40;

import utils.DownloadPage;

import java.io.IOException;

public class WikiPage {
    String urlWiki = "https://ru.wikipedia.org/wiki/";

    String url;
    String wikiPage;

    public WikiPage(String request) {
        this.url = urlWiki + request;
        DownloadPage downloadPage = new DownloadPage();
        try {
            this.wikiPage = downloadPage.downloadWebPage(this.url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "WikiPage{" +
                "wikiPage='" + wikiPage + '\'' +
                '}';
    }
}
