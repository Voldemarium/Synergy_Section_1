package theme_3_OOP.task_21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class Task_21 {
    public static void main(String[] args) {
//   1. Пользователь вводит стихотворение из четырёх строк. Соберите их в одну переменную, между каждой строкой вставьте
        // символ переноса строки: «\n»
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter four-line poem");
        StringBuilder builderPoem = new StringBuilder();
        for (int i = 1; i <= 4; i++) {
            System.out.println("Enter line " + i + ": ");
            builderPoem.append(scanner.nextLine()).append("\n");
        }
        System.out.println(builderPoem.toString());

//  2. Пользователь вводит три слова, соберите из них строку, где слова будут в обратном порядке
        System.out.println("Enter three words: ");
        StringBuilder builderReversLine = new StringBuilder();
        for (int i = 1; i <= 3; i++) {
            System.out.println("Enter word " + i  + ": ");
            builderReversLine.insert(0, (scanner.nextLine()) + " ");
        }
        System.out.println(builderReversLine);
//  3. Пользователь вводит слово. Добавьте к нему в начало «вы говорите:» слово пользователя. И в конец: «.. и что?»
        System.out.println("Enter word: ");
        StringBuilder builder3 = new StringBuilder();
        builder3.append(scanner.next());
        builder3.insert(0, "вы говорите: ");
        builder3.append(".. и что?");
        System.out.println(builder3);
//  4. Пользователь вводит пять слов, соберите из них целую строку, между каждым словом вставьте «, и»
        System.out.println("Enter five words");
        StringBuilder builder4 = new StringBuilder();
        for (int i = 1; i <= 5; i++) {
            System.out.println("Enter word " + i + ": ");
            if (i == 5) {
                builder4.append(scanner.next());
            } else {
                builder4.append(scanner.next()).append(", и ");
            }
        }
        System.out.println(builder4);
//  5. Пользователь вводит предложение из двух слов (считайте в одну переменную String phrase). Вставьте между этими
        //словами «так сказать» используя StringBuilder.insert. Было: «Учу Java». Станет: «Учу, так сказать, Java»
        System.out.println("Enter two-word sentence: ");
        scanner.nextLine();
        String phrase = scanner.nextLine();
        StringBuilder builder5 = new StringBuilder();
        builder5.append(phrase);
        builder5.insert(phrase.indexOf(" "), ", так сказать,");
        System.out.println(builder5);
//  6. Пользователь вводит число, любое. 237, например. Выведите: 237 программистов, окончание должно зависеть от числа.
        //1 программист, 2 программиста, и так далее
        System.out.println("Enter number: ");
        String number = scanner.next();
        if (number.endsWith("1")) {
            System.out.println(number + " программист");
        } else if (number.endsWith("2") || number.endsWith("3") || number.endsWith("4")) {
            System.out.println(number + " программиста");
        } else  {
            System.out.println(number + " программистов");
        }
//  7. Пользователь вводит предложение, удалите все пробелы из него
        System.out.println("Enter sentence: ");
        scanner.nextLine();
        String sentence = scanner.nextLine();
        String sentenceWithoutSpace = sentence.replaceAll(" ", "");
        System.out.println(sentenceWithoutSpace);
//  8. Вернитесь к программе, которая запрашивает курс валют. Напишите генератор даты для запроса к апи, на основе даты,
        // введенной пользователем. Используйте StringBuilder.
        System.out.println("Enter date: ");
        String date = scanner.next();
        String dateRight = date.replace(".", "/");
        StringBuilder builder6 = new StringBuilder();
        builder6.append("https://www.cbr.ru/scripts/XML_dynamic.asp?date_req1=");
        builder6.append(dateRight);
        builder6.append("&date_req2=");
        builder6.append(dateRight);
        builder6.append("&VAL_NM_RQ=R01235");
        String page = downloadWebPage(builder6.toString());
        // Последняя котировка на странице;
        int startIndex = page.lastIndexOf("<Value>");
        if (startIndex != -1) {
            int endIndex = page.lastIndexOf("</Value>");
            String courseStr1 = page.substring(startIndex + 7, endIndex);
            double course = Double.parseDouble(courseStr1.replace(',', '.'));
            System.out.println("course on date " + date + ": " + course);
        } else {
            System.out.println("No quotations on this day");
        }
//  9. Скачайте цитату из breaking bad (Fav Quotes) и замените все плохие слова звёздочками
        //    Fav Quotes – это огромная коллекция цитат с бесплатным доступом
        String pageQuote = downloadWebPage("https://favqs.com/api/qotd");
        int quoteStart = pageQuote.indexOf("body\":");
        int quoteEnd = pageQuote.lastIndexOf("}");
        String quote = pageQuote.substring(quoteStart + 7, quoteEnd - 2);
        System.out.println("Quote: " + quote);
        String[] badWords = new String[]{"shit", "crap", "fuck "};
        StringBuilder builder9 = new StringBuilder(quote);

        for (String badWord : badWords) {
            int wordStart, wordEnd = 0;
            do {
                wordStart = builder9.indexOf(badWord, wordEnd);
                wordEnd = wordStart + badWord.length();
                if (wordStart != -1) {
                    char charBeforeWord = builder9.charAt(wordStart - 1);
                    char charAfterWord = builder9.charAt(wordEnd);
                    if ((charBeforeWord == ' ' || wordStart == 0) &&
                            (charAfterWord == ' ' || charAfterWord == ',' || charAfterWord == '.')) {
                        builder9.replace(wordStart, wordEnd, "*");
                        System.out.println(builder9);
                    }
                }

            } while (wordEnd < builder9.length() && wordStart != -1);
        }
        System.out.println("Quote without bad words: " + builder9);
//  10. Напишите крестики-нолики, используя StringBuilder
//        см. класс TicTacToe
//  11. Пусть пользователь вводит поля класса FileInformation, но в одну строку; формат придумайте сами. Считайте ввод
//пользователя и из него создайте экземпляр класса.
        System.out.println("Enter fields of class FileInformation separated by a comma and spase (, ): ");
        scanner.nextLine(); //очистка буфера ввода
        String fields = scanner.nextLine();
//        String fields2 = "file1.txt, .src/theme_3_OOP/task_21/file1.txt, 450000";
        FileInformation fileInformation = new FileInformation();
        StringBuilder builder = new StringBuilder(fields);

        int startInd = 0;
        for (int i = 1; i <= 3; i++) {
            int endInd = builder.indexOf(",", startInd);
            if(i == 1) {
                fileInformation.fileName = builder.substring(startInd, endInd);
            } else if (i == 2) {
                fileInformation.absolutePath = builder.substring(startInd, endInd);
            } else {
                endInd =  builder.length();
                fileInformation.size = Long.parseLong(builder.substring(startInd, endInd));
            }
            startInd = endInd + 2;
        }
        System.out.println(fileInformation.fileName);
        System.out.println(fileInformation.absolutePath);
        System.out.println(fileInformation.size);
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
