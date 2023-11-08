package theme_4_inheritance.task_33;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NASA {
    File pictureOfDay;
    String outputFileName;
    DownloadPage downloadPage = new DownloadPage();

    public NASA(String outputFileName) {
        this.outputFileName = outputFileName;
        this.pictureOfDay = downloadPictureNASA();
    }

    public File downloadPictureNASA() {
        //качаем страницу
        System.out.println("Download page...");
        String page;
        try {
            page = downloadPage.downloadWebPage("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //вычленяем url картинки
        int urlStart = page.indexOf("url\":\"");
        int urlEnd = page.indexOf("jpg");
        String url = page.substring(urlStart + 6, urlEnd + 3);
        //сохраняем файл с картинкой в файл
        return downloadPicture(url);
    }

    private File downloadPicture(String url) {
        File pictureOfDay = new File(this.outputFileName);
        try (InputStream in = new URL(url).openStream()) {
            Path picturePath = Paths.get(pictureOfDay.getPath());
            if (Files.exists(picturePath)) {
                Files.delete(picturePath);
            }
            Files.copy(in, picturePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("File saved!");
        return pictureOfDay;
    }
}
