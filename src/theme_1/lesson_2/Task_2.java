package theme_1.lesson_2;

import java.io.*;
import java.net.URL;

public class Task_2 {
    public static void main(String[] args) {
//  1. Если 5 в 15 степени больше миллиарда, вывести - «Степень это мощь. Power is a power.»
        if (Math.pow(5, 15) > 1_000_000_000) {
            System.out.println("Степень это мощь. Power is a power");
        }
//  2. Задайте переменную. Если она больше 0, вывести «позитив», если меньше 0,вывести «отрицательно»
        int x = -7;
        if (x > 0) {
            System.out.println("positive");
        } else if (x < 0) {
            System.out.println("negative");
        }
//  3. Если квадратный корень из 15 миллионов меньше 5 тысяч, вывести - «два измерения лучше, чем одно»
        if (Math.sqrt(5_000_000) < 5_000) {
            System.out.println("два измерения лучше, чем одно");
        }
//  4. Если 2 в 10 степени меньше 512 вывести - «Pentium 2», иначе вывести -«ARM»
        if (Math.pow(2, 10) < 512) {
            System.out.println("Pentium 2");
        } else {
            System.out.println("ARM");
        }
//  5. Задать две дробных переменных. Вывести наибольшую из них.
        double a = 1.5;
        double b = 2.5;
        if (a > b) {
            System.out.println("biggest: " + a);
        } else if (b > a) {
            System.out.println("biggest: "+ b);
        } else {
            System.out.println("equals");
        }
//  6. Задать две переменных - first и second. Вывести first в степени second, second в степени first.
        int first = 2;
        int second = 3;
        System.out.println(Math.pow(first, second));
        System.out.println(Math.pow(second, first));
//  7. Задать две переменных - икс и игрек. Вывести, что больше - икс в степени игрек, или наоборот.
        int x1 = 2;
        int y1 = 3;
        if (Math.pow(x1, y1) > Math.pow(y1, x1)) {
            System.out.println("biggest: " + Math.pow(x1, y1));
        } else if (Math.pow(x1, y1) < Math.pow(y1, x1)) {
            System.out.println("biggest: " + Math.pow(y1, x1));
        }
//  8. Вывести числа от 1 до 100
        for (int i = 1; i <= 100; i++) {
            System.out.print(i + " ");
        }
        System.out.println("");
//  9. Вывести числа от 50 до 100
        for (int i = 50; i <= 100; i++) {
            System.out.print(i + " ");
        }
        System.out.println("");
//  10. Вывести числа от 100 до 1
        for (int i = 100; i > 0; i--) {
            System.out.print(i + " ");
        }
        System.out.println("");
//  11. Вывести числа от 0 до -100
        for (int i = 0; i >= -100; i--) {
            System.out.print(i + " ");
        }
        System.out.println("");
//  12. Задать строковую переменную. Заменить в ней все буквы о на «обро»
        String s = "короб";
        s = s.replace("о", "обро");
        System.out.println(s);
//  13. адать строковую переменную. Вывести ее в верхнем регистре.
        String s1 = "fang";
        s1 = s1.toUpperCase();
        System.out.println(s1);
//  14. Задать строковую переменную. Заменить в ней буквы а на @, а буквы о на 0.
        String s2 = "Ворота";
        s2 = s2.replace("а", "@").replace("о", "О");
        System.out.println(s2);
//  15. Задать две строковых переменных. Найти, какая из них длиннее.(Используйте .length() )
        String s3 = "Breakfast";
        String s4 = "Launch";
        if (s3.length() > s4.length()) {
            System.out.println(s3 + " longer than " + s4);
        } else if (s3.length() < s4.length()) {
            System.out.println(s4 + "longer than " + s3);
        } else {
            System.out.println("equals");
        }

//  16. Задать три переменных, найти наибольшую из них
        int y_1 = 4;
        int y_2 = 3;
        int y_3 = 5;
        if (y_1 > y_2 && y_1 > y_3) {
            System.out.println("biggest variable: " + y_1);
        } else if (y_2 > y_1 && y_2 > y_3) {
            System.out.println("biggest variable: " + y_2);
        } else if (y_3 > y_1 && y_3 > y_2) {
            System.out.println("biggest variable: " + y_3);
        }
//  17. Напишите программу, сохраняющую в файл статью из википедии«Проблема 2000 года».
        String url = "https://ru.wikipedia.org/wiki/" +
                "%D0%9F%D1%80%D0%BE%D0%B1%D0%BB%D0%B5%D0%BC%D0%B0_2000_%D0%B3%D0%BE%D0%B4%D0%B0";
        String result = downloadWebPage(url);
        writeToFile(result, "./src/theme_1.txt.lesson_2/files/file.html");

//  18. Напишите программу, сохраняющую в файл статью из википедии «ДональдКнут».
//      Перед сохранением в файл замените все слова Кнут на Пряник
        String url2 = "https://ru.wikipedia.org/wiki/%D0%9A%D0%BD%D1%83%D1%82," +
                "_%D0%94%D0%BE%D0%BD%D0%B0%D0%BB%D1%8C%D0%B4_%D0%AD%D1%80%D0%B2%D0%B8%D0%BD";
        String result2 = downloadWebPage(url2);
        result2 = result2.replace("Кнут", "Пряник");
        writeToFile(result2, "./src/theme_1.txt.lesson_2/files/file2.html");


//  19. Напишите программу, которая сохраняет в файл случайную статью изВикипедии
        String url3 = "https://ru.wikipedia.org/wiki/%D0%A1%D0%BB%D1%83%D0%B6%D0%B5%D0%B1%D0%BD%D0%B0%D1%8F:" +
                "%D0%A1%D0%BB%D1%83%D1%87%D0%B0%D0%B9%D0%BD%D0%B0%D1%8F" +
                "_%D1%81%D1%82%D1%80%D0%B0%D0%BD%D0%B8%D1%86%D0%B0";
        String result3 = downloadWebPage(url3);
        writeToFile(result3, "./src/theme_1.txt.lesson_2/files/file3.html");

//  20. Напишите программу, которая сохраняет в разные файлы 50 случайных статей из Википедии
        String url_random = "https://ru.wikipedia.org/wiki/%D0%A1%D0%BB%D1%83%D0%B6%D0%B5%D0%B1%D0%BD%D0%B0%D1%8F:" +
                "%D0%A1%D0%BB%D1%83%D1%87%D0%B0%D0%B9%D0%BD%D0%B0%D1%8F" +
                "_%D1%81%D1%82%D1%80%D0%B0%D0%BD%D0%B8%D1%86%D0%B0";
        for (int i = 1; i <= 5; i++) {
            String result_random = downloadWebPage(url_random);
            writeToFile(result_random, "./src/theme_1.txt.lesson_2/files/file_" + i + ".html");
        }
    }

    //Метод загрузки Web-страницы в String
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

    //Метод записи в файл
    static public void writeToFile(String result, String pathToFile) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(pathToFile));
            writer.write(result);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
