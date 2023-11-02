package theme_3_OOP.lesson_22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class Lesson_22 {
    public static void main(String[] args) {
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
        String limitParam = "&limit=100";
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
        StringBuilder result = buildMovieInfo(page);
        System.out.println(result.toString());
    }

    static StringBuilder buildMovieInfo(String page) {
        StringBuilder builder = new StringBuilder();
        int start, end;

        int moviesCount = 0;
        int currentMovieIndex = 0;
        while (moviesCount < 5) {
            currentMovieIndex = page.indexOf("feature-movie", currentMovieIndex + 20);

            start = page.indexOf("trackName", currentMovieIndex) + "trackName".length() + 3;
            end = page.indexOf("\",", start);
            String movieName = page.substring(start, end);

            start = page.indexOf("longDescription", currentMovieIndex) + "longDescription".length() + 3;
            end = page.indexOf("\"", start);
            String movieDescription = page.substring(start, end).replaceAll("<br />", "\n");

            start = page.indexOf("primaryGenreName", currentMovieIndex) + "primaryGenreName".length() + 3;
            end = page.indexOf("\"", start);
            String movieGenreName = page.substring(start, end).replaceAll("<br />", "\n");

            if (movieGenreName.equals("Comedy")) {
                builder.append("This is a comedy.\n");
                builder.append(movieName);
                builder.append("\nDescription:\n");
                builder.append(movieDescription);
                break;
            } else {
                builder.append("This is a movie.\n");
                builder.append(movieName);
                builder.append("\nDescription:\n");
                builder.append(movieDescription + "\n");
                moviesCount++;
            }
        }
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
