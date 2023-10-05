package lesson_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Lesson_8 {
    public static void main(String[] args) {
//    Fav Quotes – это огромная коллекция цитат с бесплатным доступом
        String url ="https://favqs.com/api/qotd";
        String pageJSON = downloadWebPage(url);
        System.out.println(pageJSON);

        int quoteStart = pageJSON.indexOf("body\":");
        int quoteEnd = pageJSON.lastIndexOf("}");
        String quote = pageJSON.substring(quoteStart + 6, quoteEnd - 1);
//        if(quote.length() > 50) {
//            System.out.println(quote.substring(0, 50) + "...");
//        } else {
//            System.out.println(quote);
//        }
        String text_quote =  quote.length() > 50 ? quote.substring(0, 50) + "..." : quote;
        System.out.println(text_quote);

        int authorStart = pageJSON.indexOf("author\":");
        int authorEnd = pageJSON.lastIndexOf("\"author_");
        String author = pageJSON.substring(authorStart + 9, authorEnd - 2);
        System.out.println("(" + author + ")");

        System.out.println("----------------------");
        if(!author.equals("Coco Chanel")) {
            System.out.println("Restart and try again");
        } else {
            System.out.println(text_quote + "\n" + author);
        }

        String text_finish = !author.equals("Coco Chanel") ? "Restart and try again" : text_quote + "\n" + author;
        System.out.println(text_finish);


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
