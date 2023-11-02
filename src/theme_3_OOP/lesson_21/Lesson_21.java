package theme_3_OOP.lesson_21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class Lesson_21 {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
//  Добавление в конец строки
        builder.append("I will be");
        builder.append(" a programmer.");
//  Добавление в начало/середину строки
        builder.insert(0, "I am study ");
        builder.insert(10, ".");
//  Удаление части строки
        builder.delete(31, 39);
//  Удаление символа по его индексу
        builder.deleteCharAt(30);

        String str = builder.toString();
        System.out.println(str);
        builder.delete(0, builder.length());
// ------------строка зАбОрЧиКоМ------------------------------------------
        String input = "I am working";
        StringBuilder builder1 = new StringBuilder(input);
        for (int i = 0; i < builder1.length(); i++) {
            char ch = builder1.charAt(i);
            builder1.deleteCharAt(i);
            if (i % 2 == 0) {
                builder1.insert(i, Character.toUpperCase(ch));
            } else {
                builder1.insert(i, Character.toLowerCase(ch));
            }
        }
        System.out.println(builder1.toString());
//  ------------слова задом наперед------------------------------------------
        String s1 = "Cat1";
        String s2 = "Cat2";
        String s3 = "Cat3";
        String s4 = "Cat4";
        String s5 = "Cat5";
        StringBuilder builder2 = new StringBuilder();
        builder2.insert(0, s1);
        builder2.insert(0, s2 + " ");
        builder2.insert(0, s3 + " ");
        builder2.insert(0, s4 + " ");
        builder2.insert(0, s5 + " ");
        System.out.println(builder2.toString());
//  ----------------------------------------
        //  API Itunes
        //   String url1 = "https://itunes.apple.com/search?term=chris+rea+road+to+hell&limit=1";
        //   String url2 = "https://itunes.apple.com/search?term=war+of+worlds&limit=1";

        //1. user input
        String term = getUserInput();
        //2. build url
        String url = buildUrl(term);
        //3. download page
        String page = downloadWebPage(url);
        //4. parseResult
        printResult(page);
    }

    static String getUserInput() {
        System.out.println("What you looking for itunes?");
        Scanner scanner = new Scanner(System.in);
        String term = scanner.nextLine();
        return term;
    }

    static String buildUrl(String partOfRequest) {
        String termWithoutSpace = partOfRequest.replaceAll(" ", "+");
        String itunesApi = "https://itunes.apple.com/search?term=";
        String limitParam = "&limit=1";
        StringBuilder url = new StringBuilder();
        url.append(itunesApi);
        url.append(termWithoutSpace);
        url.append(limitParam);
        return url.toString();
    }

    // 1. wrapperType ->
    //  - track -
    //      kind:
    //        - song
    //          - artistName, trackName
    //        - feature-movie
    //        - trackName, longDescription
    //  - audiobook -
    //        - authorName, collectionName, descriotion
    static void printResult(String page) {
        int start = page.indexOf("wrapperType");
        int end = page.indexOf("\",", start);
        StringBuilder result = new StringBuilder();
        if (start != -1) {
            String wrapperType = page.substring(start + 14, end);
            if (wrapperType.equals("audiobook")) {
                result = buildBookResult(page);
            } else if (wrapperType.equals("track")) {
                String kind = getKind(page);
                if (kind.equals("song")) {
                    result = buildSongInfo(page);
                } else if (kind.equals("feature-movie")) {
                    result = buildMovieInfo(page);
                }
            }
            if (result.length() == 0) {
                result.append("Unknown result: ");
                result.append(page);
            }
            System.out.println(result.toString());
        }

    }

    private static String getKind(String page) {
        int start;
        int end;
        start = page.indexOf("kind") + "kind".length() + 3;
        end = page.indexOf("\",", start);
        String kind = page.substring(start, end);
        return kind;
    }

    private static StringBuilder buildBookResult(String page) {
        StringBuilder builder = new StringBuilder();
        int start;
        int end;
        start = page.indexOf("artistName") + 13;
        end = page.indexOf("\",", start);
        String author = page.substring(start, end);

        start = page.indexOf("collectionName") + "collectionName".length() + 3;
        end = page.indexOf("\",", start);
        String bookName = page.substring(start, end);

        start = page.indexOf("description") + "description".length() + 3;
        end = page.indexOf("\"", start);
        String bookDescription = page.substring(start, end);
        builder.append("This is book. Author is ");
        builder.append(author);
        builder.append(". \nThe name is:\n ");
        builder.append(bookName);
        builder.append("\nDescription:\n");
        builder.append(bookDescription);
        return builder;
    }

    static StringBuilder buildSongInfo(String page) {
        StringBuilder builder = new StringBuilder();
        int start, end;
        start = page.indexOf("artistName") + "artistName".length() + 3;
        end = page.indexOf("\",", start);
        String artistName = page.substring(start, end);

        start = page.indexOf("trackName") + "trackName".length() + 3;
        end = page.indexOf("\",", start);
        String trackName = page.substring(start, end);

        builder.append("This is a song.\n");
        builder.append(artistName);
        builder.append("-");
        builder.append(trackName);
        return builder;
    }

    static StringBuilder buildMovieInfo(String page) {
        StringBuilder builder = new StringBuilder();
        int start, end;
        start = page.indexOf("trackName") + "trackName".length() + 3;
        end = page.indexOf("\",", start);
        String movieName = page.substring(start, end);

        start = page.indexOf("longDescription") + "longDescription".length() + 3;
        end = page.indexOf("\"", start);
        String movieDescription = page.substring(start, end).replaceAll("<br />", "\n");

        builder.append("This is a movie.\n");
        builder.append(movieName);
        builder.append("\nDescription:\n");
        builder.append(movieDescription);
        return builder;
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
