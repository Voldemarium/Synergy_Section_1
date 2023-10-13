package theme_2.lesson_14;

import java.io.*;
import java.net.URL;

public class Lesson_14 {
    public static void main(String[] args) throws InterruptedException, IOException {
//    Получение данных c ЦБ РФ, используя XML (динамики котировок доллара США:)
//        Получение данных c ЦБ РФ, используя XML (динамики котировок доллара США:)
//        double[] courses = new double[10];
//        for (int day = 1; day <= 10; day++) {
//            String dayStr = day < 10 ? "0" + day : String.valueOf(day);
//            Thread.sleep(1000);
//            String url = "https://www.cbr.ru/scripts/XML_dynamic.asp" +
//                    "?date_req1=01/11/2020&date_req2=" + dayStr + "/11/2020&VAL_NM_RQ=R01235";
//            String pageXML = downloadWebPage(url);
//            // Последняя котировка на странице 1;
//            int startIndex = pageXML.lastIndexOf("<Value>");
//            if (startIndex != -1) {
//                int endIndex = pageXML.lastIndexOf("</Value>");
//                String courseStr = pageXML.substring(startIndex + 7, endIndex);
//                double course = Double.parseDouble(courseStr.replace(',', '.'));
//                System.out.println("For day " + day + " course is " + course);
//                courses[day - 1] = course;
//            }
//        }
//        System.out.println(Arrays.toString(courses));
//        System.out.println("For 7 november course is " + courses[6]);

//  --------------------------------------------------------------------------------------
        // Считывание строк из файла.
//        FileReader fileReader = new FileReader("./src/theme_2/lesson_5/files/book.txt");
//        BufferedReader reader = new BufferedReader(fileReader);
//        String[] part = new String[50];
//        for (int i = 0; i < 50; i++) {
//            part[i] = reader.readLine();
//        }
//        for (int i = 0; i < 50; i++) {
//            System.out.println(part[i]);
//        }
//  --------------------------------------------------------------------------------------
        // Несколько цитат из сайта
        //    Fav Quotes – это огромная коллекция цитат с бесплатным доступом
        String[] quotes = new String[30];
        String url ="https://favqs.com/api/qotd";
        for (int i = 0; i < quotes.length; i++) {
            String pageJSON = downloadWebPage(url);
            int quoteStart = pageJSON.indexOf("body\":");
            int quoteEnd = pageJSON.lastIndexOf("}");
            String quote = pageJSON.substring(quoteStart + 6, quoteEnd - 1);

            int authorStart = pageJSON.indexOf("author\":");
            int authorEnd = pageJSON.lastIndexOf("\"author_");
            String author = pageJSON.substring(authorStart + 9, authorEnd - 2);

            String newQuoteWithAuthor = author + ": " + quote;

            // Проверим, есть ли уже в массиве данная фраза
            boolean quoteInArray = false;
            for (int j = 0; j < i; j++) {
                if (newQuoteWithAuthor.equals(quotes[j])) {
                    quoteInArray = true;
                }
            }
            if (quoteInArray) {
                System.out.println("quote already in array");
            } else {
                quotes[i] = newQuoteWithAuthor;
            }

        }
        for (int i = 0; i < 30; i++) {
            System.out.println(quotes[i]);
        }





    }
    //Метод загрузки Web-страницы в String
    static public String downloadWebPage (String url){
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
