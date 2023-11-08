package theme_4_inheritance.task_31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.format.DateTimeFormatter;

public class CurrencyCourse {
    String[][] courses;
    DatePeriod datePeriod;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    Url url;

    public CurrencyCourse(DatePeriod datePeriod) {
        this.url = new Url(datePeriod.localDate1.format(formatter), datePeriod.localDate2.format(formatter));
        this.datePeriod = datePeriod;
        this.courses = setCurrencyCourse();
    }

    String[][] setCurrencyCourse() {
        String page = downloadWebPage(this.url.getUrl());
        // Перебираем котировки на странице;
        int lengthArray = getLengthArray(page);  //определяем необходимый размер массива
        this.courses = new String[lengthArray][2];

        int endIndex1 = 0;
        int endIndex2 = 0;
        for (int i = 0; i < courses.length; i++) {
            int startIndex1 = page.indexOf("<Record Date=", endIndex1);
            int startIndex2 = page.indexOf("<Value>", endIndex2);
            endIndex1 = page.indexOf("Id", startIndex1);
            endIndex2 = page.indexOf("</Value>", startIndex2);
            String dateStr = page.substring(startIndex1 + 14, endIndex1 - 2);
            String courseStr = page.substring(startIndex2 + 7, endIndex2);
            courses[i][0] = dateStr;
            courses[i][1] = courseStr;
        }
        return courses;
    }

    private int getLengthArray(String page) {
        int lengthArray = 0;
        int endIndex = 0;
        while (true) {
            int startIndex = page.indexOf("<Value>", endIndex);
            if (startIndex != -1) {
                endIndex = page.indexOf("</Value>", startIndex);
                lengthArray++;
            } else break;
        }
        return lengthArray;
    }

    private String downloadWebPage(String url) {
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
