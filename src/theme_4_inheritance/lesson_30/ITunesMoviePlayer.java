package theme_4_inheritance.lesson_30;

import utils.DownloadPage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ITunesMoviePlayer {
    DownloadPage downloadPage = new DownloadPage();

//    ITunesMovie getMovie(String searchRequest) {
//        String url = buildUrl(searchRequest);
//        String page = downloadPage.downloadWebPage(url);
//        String movieName = getTag(page, "trackName");
//        String previewUrl = getTag(page, "previewUrl");
//        ITunesMovie movie = new ITunesMovie();
//        movie.trackName = movieName;
//
//    }


    void playMovie(String searchRequest) throws IOException {
        String url = buildUrl(searchRequest);

        String page = downloadPage.downloadWebPage(url);

        String movieName = getTag(page, "trackName");
        String previewUrl = getTag(page, "previewUrl");
        String fileExtension = previewUrl.substring(previewUrl.length() - 3);

        //  Скачаем файл по ссылке:
        try (InputStream in = new URL(previewUrl).openStream()) {
            Path audioPath = Paths.get("./src/theme_4_inheritance/lesson_28/files/" + movieName + fileExtension);
            if (Files.exists(audioPath)) {
                Files.delete(audioPath);
            }
            Files.copy(in, audioPath);
        }
        System.out.println("Movie saved!");
        System.out.println(movieName);

        // Откроем файл, используя класс java.awt.Desktop
        if (!Desktop.isDesktopSupported()) {
            System.out.println("Desktop not supported!");
        } else {
            Desktop desktop = Desktop.getDesktop();
            File file = new File("./src/theme_4_inheritance/lesson_28/files/" + movieName + fileExtension);
            desktop.open(file);
        }
    }


    private static String getTag(String page, String tagName) {
        int start = page.indexOf(tagName) + tagName.length() + 3;
        int end = page.indexOf("\"", start);
        return page.substring(start, end);
    }

    private static String buildUrl(String searchRequest) {
        int limit = 50;
        String term = searchRequest.replaceAll(" ", "+");
        String itunesApi = "https://itunes.apple.com/search?term=";
        String limitParam = "&limit=" + limit;
        String mediaParam = "&media=movie";
        StringBuilder builder = new StringBuilder();
        builder.append(itunesApi);
        builder.append(term);
        builder.append(limitParam);
        builder.append(mediaParam);
        return builder.toString();
    }


}
