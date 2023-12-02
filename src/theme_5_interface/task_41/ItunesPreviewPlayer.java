package theme_5_interface.task_41;

import utils.DownloadPage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ItunesPreviewPlayer {
    DownloadPage downloadPage = new DownloadPage();
    ItunesProduct[] products;
    Scanner scanner = new Scanner(System.in);
    int endIndex = 0;

    void play() throws IOException {
        boolean existsNull = true;
        while (existsNull) {
            //Ввод запроса пользователем
            System.out.println("Enter search request: ");
            String searchRequest = scanner.nextLine();
            System.out.println("Enter media type: ");
            String mediaType = scanner.next();
            System.out.println("Enter limit: ");
            int limit;
            int limit_found = scanner.nextInt();
            if (products == null) {
                limit = limit_found;
                products = new ItunesProduct[limit];
            }
            scanner.nextLine();

            findItunesProducts(searchRequest, limit_found, mediaType);

            existsNull = false;
            for (ItunesProduct p : products) {
                if (p == null) {
                    existsNull = true;
                    break;
                }
            }

            for (int i = 0; i < products.length; i++) {
                System.out.println("product " + (i + 1) + ": " + products[i]);
            }
        }
            // Спрашиваем у пользователя, какой файл из массива найденных скачать
            System.out.println("Enter number of product: ");
            int number = scanner.nextInt() - 1;
            String name = products[number].trackName;
            String previewUrl = products[number].previewUrl;
            String fileExtension = previewUrl.substring(previewUrl.length() - 3);
            String filename = name + "." + fileExtension;
            System.out.println("Will download" + name);

            //  Скачаем файл по ссылке:
            try (InputStream in = new URL(previewUrl).openStream()) {
                Path filePath = Paths.get("./src/theme_5_interface/task_41/files/" + filename);
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
                    File file = new File("./src/theme_5_interface/task_41/files/" + filename);
                    desktop.open(file);
                }
            }
    }
        private void findItunesProducts (String searchRequest, int limit, String mediaName) throws IOException {
            String urlPage = buildUrl(searchRequest, limit, mediaName);
            String page = downloadPage.downloadWebPage(urlPage);

            for (int i = 0; i < products.length; i++) {
                String artistName = getTagString(page, "artistName");
                System.out.println("artistName: " + artistName);
                if(artistName == null) {
                    break;
                }
                String trackName = getTagString(page, "trackName");
                String previewUrl = getTagString(page, "previewUrl");
                String country = getTagString(page, "country");
                ItunesProduct product = new ItunesProduct(artistName, trackName, previewUrl, country);

                if(products[i] == null) {
                    boolean existsProduct = false;
                    for(ItunesProduct p : products) {
                        if (product.equals(p)) {
                            existsProduct = true;
                            break;
                        }
                    }
                    if(!existsProduct) {
                        products[i] = product;
                    }
                }
            }
        }

        public String getTagString(String page, String tagName) {
            int start = page.indexOf(tagName, endIndex) + tagName.length() + 3;
            if(start == -1) {
                return null;
            }
            this.endIndex = page.indexOf("\"", start);
            return page.substring(start, endIndex);
        }

        public String getTagNumbers(String page, String tagName) {
            int start = page.indexOf(tagName) + tagName.length() + 2;
            this.endIndex = page.indexOf(",", start);
            return page.substring(start, endIndex);
        }

        public String buildUrl(String searchRequest, int limit, String mediaName) {
            String term = searchRequest.replaceAll(" ", "+");
            String itunesApi = "https://itunes.apple.com/search?term=";
            String limitParam = "&limit=" + limit;
            String mediaParam = "&media=" + mediaName;
            StringBuilder builder = new StringBuilder();
            builder.append(itunesApi);
            builder.append(term);
            builder.append(limitParam);
            builder.append(mediaParam);
            return builder.toString();
        }
}
