package theme_3_OOP.lesson_19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class Lesson_19 {
    public static void main(String[] args) {
        int x= 15;
        helloWorld();
        System.out.println("done");

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
    static void helloWorld() {
        System.out.println("Hello, world");
        int z = 5;
        System.out.println("Hello world done");
        goDeeper();
    }

    static void goDeeper() {
        int a = 3;
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
        return itunesApi + termWithoutSpace + limitParam;
    }
    static void printResult(String page) {
        int start = page.indexOf("kind") + 7;
        int end = page.indexOf("\",", start);
        System.out.println(page.substring(start, end));
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
