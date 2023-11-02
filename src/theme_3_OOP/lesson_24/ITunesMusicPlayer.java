package theme_3_OOP.lesson_24;

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ITunesMusicPlayer {
    void playSong(String searchRequest) throws IOException {
        playSongInternal(searchRequest, 1);
    }

    void playSong(String searchRequest, int limit) throws IOException {
         playSongInternal(searchRequest, limit);
    }

   private void playSongInternal(String searchRequest, int limit) throws IOException {
        String url = buildUrl(searchRequest, limit);
        String page = downloadWebPage(url);

        String artistName = getTag(page, "artistName");
        String trackName = getTag(page, "trackName");
        String previewUrl = getTag(page, "previewUrl");

        //  Скачаем аудиофайл по ссылке:
        try (InputStream in = new URL(previewUrl).openStream()) {
            Path audioPath = Paths.get("./src/theme_3_OOP/lesson_24/files/" + trackName +  ".mp4a");
            if (Files.exists(audioPath)) {
                Files.delete(audioPath);
            }
            Files.copy(in, audioPath);
        }
        System.out.println("Audio saved!");
        System.out.println(artistName + " - " + trackName);

        // Откроем файл, используя класс java.awt.Desktop
        if (!Desktop.isDesktopSupported()) {
            System.out.println("Desktop not supported!");
        } else {
            Desktop desktop = Desktop.getDesktop();
            File file = new File("./src/theme_3_OOP/lesson_24/files/" + trackName +  ".mp4a");
            desktop.open(file);
        }
    }


    private static String getTag(String page, String tagName) {
        int start = page.indexOf(tagName) + tagName.length() + 3;
        int end = page.indexOf("\"" , start);
        return page.substring(start, end);
    }

    private static String buildUrl(String searchRequest, int limit) {
        String term = searchRequest.replaceAll(" ", "+");
        String itunesApi = "https://itunes.apple.com/search?term=";
        String limitParam = "&limit=" + limit;
        String mediaParam = "&media=music";
        StringBuilder builder = new StringBuilder();
        builder.append(itunesApi);
        builder.append(term);
        builder.append(limitParam);
        builder.append(mediaParam);
        return builder.toString();
    }

    static public String downloadWebPage(String url) {
        StringBuilder result = new StringBuilder();
        try (InputStream inputStream = new URL(url).openConnection().getInputStream()) {
            String line;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while ((line = bufferedReader.readLine()) != null) {
                result.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result.toString();
    }
}
