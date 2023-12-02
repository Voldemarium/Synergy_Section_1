package theme_5_interface.lesson_40;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NasaPictureDownloader {
    public void downloadAndOpen(NasaPictureInfo info) {
        System.out.println("Will download " + info + "...");
        System.out.println("Description: " + info.getPrettyExplanation());

        //  Скачаем картинку по ссылке:
        try (InputStream in = new URL(info.fileUrl).openStream()) {
            String[] arrUrl = info.fileUrl.split("\\.");
            String fileExtension = arrUrl[arrUrl.length - 1];
            String fileName = "./src/theme_5_interface/lesson_40/files/" + info.title + "." + fileExtension;
            Path picturePath = Paths.get(fileName);
            if (Files.exists(picturePath)) {
                Files.delete(picturePath);
            }
            Files.copy(in, picturePath);
            System.out.println("File saved!");

            // Откроем файл, используя класс java.awt.Desktop
            if (!Desktop.isDesktopSupported()) {
                System.out.println("Desktop not supported!");
            } else {
                Desktop desktop = Desktop.getDesktop();
                File file = new File(fileName);
                desktop.open(file);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
