package lesson_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class Task_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//  Задание 1. Посмотрим и узнаем как можно написать программу проверки чисел гораздо меньше.
//       Пишем программу которая может найти максимум из двух чисел
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int max;
        if (x > y) {
            max = x;
        } else {
            max = y;
        }
        System.out.println("Max is " + max);
//      Теперь укоротим запись, используя тернарный оператор, сделаем абсолютно тоже самое, но в более коротком виде
        max = x > y ? x : y;
        System.out.println("Max is " + max);

//  Задание 2. Вернемся к первоначальному виду . И изменим его, сделаем так
        if (x > y) {
            System.out.println("x > y");
        } else {
            System.out.println("x <= y");
        }
        //  Напишите этот код короче, используя тернарный оператор
        String compare = x > y ? "икс > игрек" : "икс <= игрек";
        System.out.println(compare);
//  Задание 3. Сделаем поиск максимального числа из 3 введенных, используя тернарный оператор
        int z = scanner.nextInt();
        int max_3 = (x > y && x > z) ? x : (y > x && y > z) ? y : z;
        System.out.println(max_3);
//  Задание 4. Научимся получать случайную цитату из сериала в java.
        // Fav Quotes – это огромная коллекция цитат с бесплатным доступом
        String page = downloadWebPage("https://favqs.com/api/qotd");
        System.out.println(page);
        // Убрав лишнюю информацию, получим непосредственно цитату
        int quoteStart = page.indexOf("body\":");
        int quoteEnd = page.lastIndexOf("}");
        String quote = page.substring(quoteStart + 7, quoteEnd - 2);
        System.out.println(quote);
//  Задание 5. Возьмем код с 4 задания и добавим определение длины цитаты. Если цитата длинная мы ее обрежем
//        будем использовать конструкцию if else для выбора и переменную length для определения размера
        if (quote.length() > 50) {
            System.out.println(quote.substring(0, 50) + "...");
        } else {
            System.out.println(quote);
        }
//  Задание 6. переписать это же в виде тернарного оператора
        String text_quote =  quote.length() > 50 ? quote.substring(0, 50) + "..." : quote;
        System.out.println(text_quote);
//  Задание 7. Добавим вывод автора цитаты
        int authorStart = page.indexOf("author\":");
        int authorEnd = page.lastIndexOf("\"author_");
        String author = page.substring(authorStart + 9, authorEnd - 2);
        System.out.println("(" + author + ")");
// Задание 8. Самостоятельно добавьте вывод цитат только Walter White, используя тернарные операторы
        String text_finish = !author.equals("Walter White") ? "Restart and try again" : text_quote + "\n" + author;
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
