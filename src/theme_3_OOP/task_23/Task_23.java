package theme_3_OOP.task_23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;

public class Task_23 {
    public static void main(String[] args) throws IOException, InterruptedException {
//  1. Реализуйте метод, который находит из трех чисел то, которое делится на 2 остальных; или возвращает -1,
        //   если такого нет
        int x = numberDividedByTwoOtherNumbers(2, 6, 3);
        System.out.println(x);

//  2. Реализуйте метод, который из двух массивов строк собирает третий, в котором чередуются элементы первых двух
        String[] str1 = new String[]{"one", "three", "five", "seven", "nine"};
        String[] str2 = new String[]{"two", "four", "six", "eight"};
        String[] newStr = interleave2Arrays(str1, str2);
        System.out.println(Arrays.toString(newStr));

//   3. Возьмите любую программу, которую вы писали до этого.. какая сердцу ближе. Отрефакторите ее
        //(улучшите читабельность кода) -путем разбиения крупных частей на методы поменьше. Стало лучше? (надеюсь, да)
        //  API NASA (Task_9 theme_1)
        String page = downloadWebPage("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY");
        String url = getUrlPicture(page);
        System.out.println(url);
        //  Скачаем картинку по ссылке:
        downloadPicture(url, "./src/theme_3_OOP/task_23/files/picture.jpg");
        //  Скачаем описание картинки
        String explanation = getExplanation(page);
        System.out.println(explanation);

//  4. Отрефакторите (улучшите читабельность) кода вашей реализации анализа курса валют.
        //  Выводим курс валют за 1 число каждого месяца в 2014 году
        getUSD_PerDayOfEveryMonth(1, 2014);

//  5. Реализуйте метод, который возвращает случайную цитату Уолтера Уайта.
        String quoteOfAuthor = getQuoteOfAuthor(100, "Walter White");
        System.out.println(quoteOfAuthor);
//  6. Реализуйте метод, который выводит explanation сегодняшнего снимка дня NASA
        String explanationPictureToday = getExplanationToday();
        System.out.println("explanation of today's photo: \n" + explanationPictureToday);

//  7. Реализуйте метод, который возвращает explanation снимка дня NASA, в качестве параметра принимайте LocalDate -
        // дату, на которую нужно брать снимок
        LocalDate date = LocalDate.of(2023, 10, 26);
        String explanationPictureLocalDate = getExplanationLocalDate(date);
        System.out.println("explanation of Local Date " + date + ": \n" + explanationPictureLocalDate);

//  8. Реализуйте метод, который принимает два LocalDate, и сохраняет все снимки дня NASA в указанный промежуток
        LocalDate startDate = LocalDate.of(2023, 10, 1);
        LocalDate endDate = LocalDate.of(2023, 10, 10);
        downloadPicturesOfDates(startDate, endDate);

    }

    private static String getQuoteOfAuthor(int limit, String author) throws InterruptedException {
        String quoteOfAuthor = null;

        for (int i = 0; i < limit; i++) {
            String pageQuotes = downloadWebPage("https://favqs.com/api/qotd");
            Thread.sleep(1000);
            int authorStart = pageQuotes.indexOf("author\":");
            int authorEnd = pageQuotes.lastIndexOf("\"author_");
            String currentAuthor = pageQuotes.substring(authorStart + 9, authorEnd - 2);
            System.out.println("currentAuthor = " + currentAuthor);
            //вывод цитат только Walter White
            if (currentAuthor.equals(author)) {
                int quoteStart = pageQuotes.indexOf("body\":");
                int quoteEnd = pageQuotes.lastIndexOf("}");
                quoteOfAuthor = pageQuotes.substring(quoteStart + 7, quoteEnd - 2);
                break;
            }
        }
        return quoteOfAuthor;
    }

    private static void getUSD_PerDayOfEveryMonth(int day, int year) {
        String dayStr = day < 10 ? "0" + day : String.valueOf(day);
        for (int month = 1; month <= 12; month++) {
            String monthStr = month < 10 ? "0" + month : String.valueOf(month);
            String url = "https://www.cbr.ru/scripts/XML_dynamic.asp" +
                    "?date_req1=" + dayStr + "/" + monthStr + "/" + year +
                    "&date_req2=" + dayStr + "/" + monthStr + "/" + year + "&VAL_NM_RQ=R01235";
            String page = downloadWebPage(url);
            double courseUSD = getCourseUSD(page);
            System.out.println("01/" + monthStr + "/2014: " + courseUSD);
        }
    }

    private static double getCourseUSD(String page) {
        int startIndex1 = page.lastIndexOf("<Value>");
        if (startIndex1 != -1) {
            int endIndex1 = page.lastIndexOf("</Value>");
            String courseStr1 = page.substring(startIndex1 + 7, endIndex1);
            return Double.parseDouble(courseStr1.replace(',', '.'));
        } else {
            return -1;
        }
    }

    private static String getExplanation(String page) {
        int expStart = page.indexOf("explanation");
        int expEnd = page.indexOf("hdurl");
        return page.substring(expStart + 14, expEnd - 3);
    }

    private static String getExplanationToday() {
        String page = downloadWebPage("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY");
        return getExplanation(page);
    }

    private static String getExplanationLocalDate(LocalDate date) {
        String page = downloadWebPage("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&date=" + date);
        return getExplanation(page);
    }

    private static void downloadPicturesOfDates(LocalDate startDate, LocalDate endDate) throws IOException {
        String page = downloadWebPage("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY" +
                "&start_date=" + startDate + "&end_date=" + endDate);
        int end = 0;
        do {
            int start = page.indexOf("date\":\"", end);
            end = page.indexOf("explanation", start);
            String datePicture = page.substring(start + 7, end - 3);
            System.out.println(datePicture);

            start = page.indexOf("\"url\":\"", end);
            end = page.indexOf("jpg", start);
            String urlPicture = page.substring(start + 7, end + 3);

            downloadPicture(urlPicture, "./src/theme_3_OOP/task_23/files/picture" + datePicture +".jpg");
        } while (end < page.length() - 10);


    }

    private static void downloadPicture(String url, String filePath) throws IOException {
        try (InputStream in = new URL(url).openStream()) {
            Path picturePath = Paths.get(filePath);
            if (Files.exists(picturePath)) {
                Files.delete(picturePath);
            }
            Files.copy(in, picturePath);
            System.out.println("Picture saved!");
        }
    }

    private static String getUrlPicture(String page) {
        int urlStart = page.indexOf("\"url\":\"");
        int urlEnd = page.indexOf("jpg", urlStart);
        return page.substring(urlStart + 7, urlEnd + 3);
    }


    static int numberDividedByTwoOtherNumbers(int x1, int x2, int x3) {
        if (x1 % x2 == 0 && x1 % x3 == 0) {
            return x1;
        } else if (x2 % x1 == 0 && x2 % x3 == 0) {
            return x2;
        } else if (x3 % x1 == 0 && x3 % x2 == 0) {
            return x3;
        } else {
            return -1;
        }
    }

    static String[] interleave2Arrays(String[] str1, String[] str2) {
        String[] newStr = new String[str1.length + str2.length];
        int j = 0;
        for (int i = 0; i < Math.max(str1.length, str2.length); i++) {
            if (i < str1.length) {
                newStr[j] = str1[i];
                j++;
            }
            if (i < str2.length) {
                newStr[j] = str2[i];
                j++;
            }
        }
        return newStr;
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
