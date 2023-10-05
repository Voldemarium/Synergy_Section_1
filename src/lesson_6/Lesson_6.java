package lesson_6;

import java.io.*;
import java.net.URL;

public class Lesson_6 {
    public static void main(String[] args) {
//        Получение данных c ЦБ РФ, используя XML (динамики котировок доллара США:)
        String url1 ="https://www.cbr.ru/scripts/XML_dynamic.asp" +
                    "?date_req1=28/09/2023&date_req2=29/09/2023&VAL_NM_RQ=R01235";
        String pageXML1 = downloadWebPage(url1);
        // Последняя котировка на странице 1;
        int startIndex1 = pageXML1.lastIndexOf("<Value>") + 7;
        int endIndex1 = pageXML1.lastIndexOf("</Value>");
        String courseStr1 = pageXML1.substring(startIndex1, endIndex1);
        double course1 = Double.parseDouble(courseStr1.replace(',', '.'));


        String url2 ="https://www.cbr.ru/scripts/XML_dynamic.asp" +
                "?date_req1=28/09/2022&date_req2=29/09/2022&VAL_NM_RQ=R01235";
        String pageXML2 = downloadWebPage(url2);
        // Последняя котировка на странице 2;
        int startIndex2 = pageXML2.lastIndexOf("<Value>") + 7;
        int endIndex2 = pageXML2.lastIndexOf("</Value>");
        String courseStr2 = pageXML2.substring(startIndex2, endIndex2);
        double course2 = Double.parseDouble(courseStr2.replace(',', '.'));

        System.out.println("course1 = " + course1);
        System.out.println("course2 = " + course2);

        if (course1 > course2) {
            System.out.println("За год курс доллара вырос на " + (course1 - course2));

        } else {
            System.out.println("За год курс доллара снизился на" + (course2 - course1));
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

    //Метод записи в файл
    static public void writeToFile(String result, String pathToFile) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(pathToFile));
            writer.write(result);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
