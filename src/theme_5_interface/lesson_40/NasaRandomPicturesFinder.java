package theme_5_interface.lesson_40;

import utils.DownloadPage;
import utils.RandomDateGenerator;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class NasaRandomPicturesFinder {
    //Получение рандомных дат, вставка их в url, скачивание web-страниц, получение из них информации о снимке,
    // и сохранение этой информации в массив
    public NasaPictureInfo[] findRandomPictures(int count) {
        NasaPictureInfo[] arr = new NasaPictureInfo[count];

        for (int i = 0; i < count; i++) {
            String date = getRandomDateStr("yyyy-MM-dd");
            String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&date=" + date;
            DownloadPage downloadPage = new DownloadPage();
            String page = "";
            try {
                page = downloadPage.downloadWebPage(url);
            } catch (IOException e) {
                e.printStackTrace();
                throw new IllegalStateException("Can't call NASA API");
            }
            String explanation = getValue(page, "explanation");
            String urlPicture = getValue(page, "url");
            String mediaType = getValue(page, "media_type");
            String title = getValue(page, "title");
            NasaPictureInfo info = new NasaPictureInfo(title, date, explanation, urlPicture, mediaType);
            arr[i] = info;
        }
        return arr;
    }

    private String getValue(String page, String tagName) {
        int startIndex = page.indexOf('"' + tagName + '"') + tagName.length() + 4;
        int endIndex = page.indexOf('"', startIndex);
        return page.substring(startIndex, endIndex);
    }

    private String getRandomDateStr(String format) {
        RandomDateGenerator generator = new RandomDateGenerator();
        LocalDate randomDate = generator.getRandomDate(1996, 2022);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return randomDate.format(formatter);
    }
}
