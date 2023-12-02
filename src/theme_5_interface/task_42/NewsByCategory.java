package theme_5_interface.task_42;

import java.io.IOException;

public interface NewsByCategory {
    default String getNewsByCategory(String category) {
        String url = "https://inshortsapi.vercel.app/news?category=" + category;
        DownloadPage downloadPage = new DownloadPage();
        String page = "";
        try {
            page = downloadPage.downloadWebPage(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return page;
    }
}