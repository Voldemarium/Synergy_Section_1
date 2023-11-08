package theme_4_inheritance.lesson_30;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ItunesPreviewPlayer {
    void play(ITunesProduct product) throws IOException {
        String name = product.collectionName;
        String extension = product.previewUrl.substring(product.previewUrl.length() - 3);
        String filename = name + "." + extension;
        System.out.println("Will download" + name);
        //  Скачаем файл по ссылке:
        try (InputStream in = new URL(product.previewUrl).openStream()) {
            Path filePath = Paths.get("./src/theme_4_inheritance/lesson_30/files/" + filename);
            if (Files.exists(filePath)) {
                Files.delete(filePath);
            }
            Files.copy(in, filePath);

            System.out.println("File saved!");
            System.out.println(filename);

            // Откроем файл, используя класс java.awt.Desktop
            if (!Desktop.isDesktopSupported()) {
                System.out.println("Desktop not supported!");
            } else {
                Desktop desktop = Desktop.getDesktop();
                File file = new File("./src/theme_4_inheritance/lesson_30/files/" + filename);
                desktop.open(file);
            }
        }
    }
}
