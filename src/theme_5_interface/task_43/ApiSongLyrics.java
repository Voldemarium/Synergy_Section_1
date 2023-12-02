package theme_5_interface.task_43;
import utils.DownloadPage;

import java.io.IOException;

public class ApiSongLyrics extends SongLyrics{
    DownloadPage downloadPage = new DownloadPage();
    int endIndex = 0;


    public ApiSongLyrics() {
    }

    public ApiSongLyrics(String artist, String song) {
        super(artist, song);
    }

//    public ApiSongLyrics(String artist, String songName) {
//        this.artist = artist;
//        this.textOfSong = findTextOfSong(songName);
//    }

    @Override
     String findTextOfSong(String songName) {
        StringBuilder textOfSong = new StringBuilder();
        String urlPage = buildUrl(this.artist, songName);
        String page;

        try {
            page = downloadPage.downloadWebPage(urlPage);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        textOfSong.append(songName.toUpperCase()).append("\n");

         int numberLine = 1;
         do {
             String line = getTagString(page, numberLine);
             numberLine++;
             //проверка на пробел
             String checkSpace1 = page.substring(endIndex + 55, endIndex + 57);
             String checkSpace2 = page.substring(endIndex + 55, endIndex + 56);
              if (checkSpace1.equals(String.valueOf(numberLine + 1)) ||
                      checkSpace2.equals(String.valueOf(numberLine + 1))) {
                  textOfSong.append("\n");
                  numberLine++;
              } else {
                  textOfSong.append(line).append("\n");
              }
         }
            while (!page.startsWith("</p>", endIndex + 12));
    return textOfSong.toString();
    }

    public String getTagString(String page, int numberLine) {
        String tagName ="<span class=\"highlightLine puzEng line" + numberLine + "\" line=\"" + numberLine  + "\">";
        int start = page.indexOf(tagName, endIndex) + tagName.length();
        this.endIndex = page.indexOf("</span>", start);
        return page.substring(start, endIndex);
    }

    public String buildUrl(String artist, String songName) {
        String api = "https://lyrsense.com";
        String author_url = "/" + artist.replaceAll(" ", "_");
        String songName_url = "/" + songName.replaceAll(" ", "_");
        return api + author_url + songName_url;
    }
}
