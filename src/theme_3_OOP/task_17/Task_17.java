package theme_3_OOP.task_17;


import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Task_17 {
    public static void main(String[] args) throws IOException {
//  1. Создайте классы с полями для описания структуры университета. Комбинируйте! Пусть одни классы будут полями других
     //(см. директорию "university")
//  2. Создайте классы для описания операционных систем
        //(см. директорию "operatingSystem")
//  3. Создайте классы для описания языков программирования (типизации, версии,массив ключевых слов..)
     //(см. директорию "program_languages")
//  4. Сохраните информацию о всех файлах в заданной директории в массив FileInformation
        File dir = new File("./src/theme_3_OOP/task_17/text_files");
        File[] files = dir.listFiles();
        FileInformation[] fileInfos = new FileInformation[files.length];
        for (int i = 0; i < files.length; i++) {
            FileInformation info = new FileInformation();
            info.absolutePath = files[i].getAbsolutePath();
            info.fileName = files[i].getName();
            info.size = files[i].length();
            fileInfos[i] = info;
        }
        for (int i = 0; i < fileInfos.length; i++) {
            System.out.println("file " + (i + 1) + ": " +  fileInfos[i].fileName + ", absolutePath: "
                    + fileInfos[i].absolutePath + ", size: " + fileInfos[i].size);
        }
//   5. Сохраните снимок дня NASA в свой созданный класс
        String page = downloadWebPage("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY");
        int urlStart = page.indexOf("url\":\"");
        int urlEnd = page.indexOf("jpg");
        String url = page.substring(urlStart + 6, urlEnd + 3);
        System.out.println(url);
        //  Скачаем картинку по ссылке:
        File pictureOfDay = new File("./src/theme_3_OOP/task_17/picture_files/picture.jpg");
        try (InputStream in = new URL(url).openStream()) {
            Path picturePath = Paths.get(pictureOfDay.getPath());
            if (Files.exists(picturePath)) {
                Files.delete(picturePath);
            }
            Files.copy(in, picturePath);
        }
        //сохраняем файл с картинкой в объект класса NASA
        NASA nasa = new NASA();
        nasa.pictureOfDay = pictureOfDay;
        System.out.println("Picture saved!");
        System.out.println(nasa.pictureOfDay.getPath());
//  6. Сделайте класс для цитаты из breaking bad: цитата и автор. Сохраните в массив таких классов 10 цитат
        Quote[] quotes = new Quote[10];
        for (int i = 0; i < quotes.length; i++) {
            // Fav Quotes – это огромная коллекция цитат с бесплатным доступом
            String pageQuote = downloadWebPage("https://favqs.com/api/qotd");
            Quote currentQuote = new Quote();
            // Убрав лишнюю информацию, получим непосредственно цитату
            int quoteStart = pageQuote.indexOf("body\":");
            int quoteEnd = pageQuote.lastIndexOf("}");
            currentQuote.textQuote = pageQuote.substring(quoteStart + 7, quoteEnd - 2);
//        Добавим автора цитаты
            int authorStart = pageQuote.indexOf("author\":");
            int authorEnd = pageQuote.lastIndexOf("\"author_");
            currentQuote.author = pageQuote.substring(authorStart + 9, authorEnd - 2);
            quotes[i] = currentQuote;
        }
        for (int i = 0; i < quotes.length; i++) {
            System.out.println("quote " + i +  ": " + quotes[i].textQuote);
            System.out.println("author " + i +  ": " + quotes[i].author);
        }




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
