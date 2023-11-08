package theme_4_inheritance.task_28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class CurrencyCourse {
    double course;
    String startDay;
    String startMonth;
    String startYear;
    String endDay;
    String endMonth;
    String endYear;
    Url url;

    public CurrencyCourse(int startDay, int startMonth, int startYear, int endDay, int endMonth, int endYear) {
        this.startDay = startDay < 10 ? "0" + startDay : String.valueOf(startDay);
        this.startMonth = startMonth < 10 ? "0" + startMonth : String.valueOf(startMonth);
        this.startYear = String.valueOf(startYear);
        this.endDay = endDay < 10 ? "0" + endDay : String.valueOf(endDay);
        this.endMonth = endMonth < 10 ? "0" + endMonth : String.valueOf(endMonth);
        this.endYear = String.valueOf(endYear);
        this.url = new Url(this.startDay + "/" + this.startMonth + "/" + this.startYear,
                this.endDay + "/" + this.endMonth + "/" + this.endYear);
        this.course = setCurrencyCourse();
    }

    double setCurrencyCourse() {
        String page = downloadWebPage(this.url.getUrl());
        // Последняя котировка на странице;
        int startIndex1 = page.lastIndexOf("<Value>");
        if (startIndex1 != -1) {
            int endIndex1 = page.lastIndexOf("</Value>");
            String courseStr1 = page.substring(startIndex1 + 7, endIndex1);
            course = Double.parseDouble(courseStr1.replace(',', '.'));
        }
     return course;
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
