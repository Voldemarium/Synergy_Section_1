package theme_2.lesson_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Lesson_12 {
    public static void main(String[] args) throws IOException {
//        Получение данных c ЦБ РФ, используя XML (динамики котировок доллара США:)
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter month: ");
        String month = scanner.next();
        System.out.println("Enter year: ");
        String year = scanner.next();

        for (int day = 1; day <= 31; day++) {
            String dayStr = day < 10 ? "0" + day : String.valueOf(day);
            String url = "https://www.cbr.ru/scripts/XML_dynamic.asp" +
                    "?date_req1=01/" + month + "/" + year +
                    "&date_req2=" + dayStr + "/" + month + "/" + year + "&VAL_NM_RQ=R01235";
            String pageXML1 = downloadWebPage(url);
            // Последняя котировка на странице;
            int startIndex1 = pageXML1.lastIndexOf("<Value>");
            if (startIndex1 != -1) {
                int endIndex1 = pageXML1.lastIndexOf("</Value>");
                String courseStr1 = pageXML1.substring(startIndex1 + 7, endIndex1);
                double course1 = Double.parseDouble(courseStr1.replace(',', '.'));
                System.out.println(dayStr + "/" + month + "/" + year + ": " + course1);
            }
        }

//  ---------------------------------------------
        for (int i = 0; i < 20; i++) {
            int countOfSpaces = 20 - i;
            for (int x = 0; x < countOfSpaces; x++) {
                System.out.print(" ");
            }
            int countOfDots = i;
            for (int y = 0; y < countOfDots; y++) {
                System.out.print(".");
            }
            System.out.print("    countOfSpaces = " + countOfSpaces);
            System.out.println(", countOfDots=" + countOfDots);
        }

        //  ------------------------------------------------------------------------------------
//    /  API NASA
        for (int day = 1; day <= 30; day++) {
            String dayStr = day < 10 ? "0" + day : String.valueOf(day);
            String page = downloadWebPage("https://api.nasa.gov/planetary/apod" +
                                               "?api_key=DEMO_KEY&date=2022-11-" + dayStr);
            int urlStart = page.lastIndexOf("url");
            int urlEnd = page.lastIndexOf("}");
            String url = page.substring(urlStart + 6, urlEnd - 1);
            System.out.println(url);
////  Скачаем картинку по ссылке:
            try (InputStream in = new URL(url).openStream()) {
                Path picturePath = Paths.get("./src/theme_2/lesson_3/files/picture" + day + ".jpg");
                if (Files.exists(picturePath)) {
                    Files.delete(picturePath);
                }
                Files.copy(in, picturePath);
                System.out.println("Picture saved of day " + day);
            }

        }
    }

    //Метод загрузки Web-страницы в String
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
