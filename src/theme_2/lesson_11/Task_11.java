package theme_2.lesson_11;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Task_11 {
    public static void main(String[] args) throws IOException {
// 1. Выведите числа от 0 до миллиона
        int i = 1;
        while (i <= 1_000_000) {
            System.out.println(i);
            i++;
        }
//  2. Выведите числа от 1.5 до 101.5: 1.5,2,2.5,3,3.5…101.5
        double j = 1.5;
        while (j <= 101.5) {
            System.out.println(j);
            j = j + 0.5;
        }
//  3. Выведите латинский алфавит от a до z
        char q = 'a';
        while (q <= 'z') {
            System.out.print(q + " ");
            q++;
        }
        System.out.println();
//  4. Выведите русский алфавит от а до я
        char w = 'а';
        while (w <= 'я') {
            System.out.print(w + " ");
            w++;
        }
//  5. Создайте 10 тысяч файлов
//        int x = 1;
//        while (x <= 10_0000) {
//            File file = new File("./src/theme_2/lesson_2/files/file_" + x + ".txt");
//            file.createNewFile();
//            x++;
//        }
//    6. В файле две строки: секретное слово и подсказка. Вывести подсказку. Считывать строку за строкой,
//            пока игрок не отгадает секретное слово(не введёт его)
//        String fileName = "./src/theme_2/lesson_2/files/mystery.txt";
//        InputStream stream = new FileInputStream(fileName);
//        Scanner scanFile = new Scanner(stream);
//        System.out.println();
//        System.out.println(scanFile.nextLine());  //выведем подсказку
//        String word = scanFile.next();
//
        Scanner scanner = new Scanner(System.in);
//        String str = "";
//        while (!str.equals(word)) {
//            System.out.println("Please, enter word: ");
//            str = scanner.next();
//        }
//        System.out.println("You guessed it!");
//      7. Предыдущее задание, но если пользователь ввел хотя бы часть слова верно,
//        то писать: горячо. (Проверять с помощью str.contains).
//        String str_2 = "";
//        while (!str_2.equals(word)) {
//            int r = 1;
//              boolean partOfGuessing = false;
//            while (r <= word.length() - 1) {
//                if (str_2.contains(word.substring(0, r))) {
//                   partOfGuessing = true;
//                }
//                r++;
//            }
//            if (partOfGuessing) {
//                System.out.println("Горячо!");
//            }
//            System.out.println("Please, enter word: ");
//            str_2 = scanner.next();
//            scanner.nextLine(); // очистка буфера ввода
//        }
//        System.out.println("You guessed it!");
//  8. Первый игрок сохраняет слово и подсказку в первый файл, второй игрок во второй.
      //  Игра начинается, выводятся подсказки, игроки по очереди пытаются отгадать слово противника.
        String file_1 = "./src/theme_2/lesson_2/files/1.txt";
        PrintWriter writer1 = new PrintWriter(file_1);
        System.out.println("Please enter word_1: ");
        String word_1 = scanner.nextLine();
        writer1.println(word_1);
        System.out.println("Please enter hint_1: ");
        String hint_1 = scanner.nextLine();
        writer1.println(hint_1);
        writer1.close();

        String file_2 = "./src/theme_2/lesson_2/files/2.txt";
        PrintWriter writer2 = new PrintWriter(file_2);
        System.out.println("Please enter word_2: ");
        String word_2 = scanner.nextLine();
        writer2.println(word_2);
        System.out.println("Please enter hint_2: ");
        String hint_2 = scanner.nextLine();
        writer2.println(hint_2);
        writer2.close();

        System.out.println("The game begins!");

        InputStream stream1 = new FileInputStream("./src/theme_2/lesson_2/files/1.txt");
        Scanner scanFile1 = new Scanner(stream1);
        String word1 = scanFile1.next();
        scanFile1.nextLine();
        System.out.println("hint 1: " + scanFile1.nextLine());  //выведем подсказку 1

        InputStream stream2 = new FileInputStream("./src/theme_2/lesson_2/files/2.txt");
        Scanner scanFile2 = new Scanner(stream2);
        String word2 = scanFile2.next();
        scanFile2.nextLine();
        System.out.println("hint 2: " + scanFile2.nextLine());  //выведем подсказку 2

        String str1 = "";
        String str2 = "";
        while (!str1.equals(word1) && !str2.equals(word2)) {
            System.out.println("Please, enter word1: ");
            str1 = scanner.next();
            if (str1.equals(word1)) {
                System.out.println("You guessed word1!");
                break;
            }
            int t = 1;
            boolean partOfGuessing1 = false;
            while (t <= word1.length() - 1) {
                if (str1.contains(word1.substring(0, t))) {
                    partOfGuessing1 = true;
                }
                t++;
            }
            if (partOfGuessing1) {
                System.out.println("Горячо!");
            }
            System.out.println("Please, enter word2: ");
            str2 = scanner.next();
            if (str2.equals(word2)) {
                System.out.println("You guessed word2!");
                break;
            }
            int u = 1;
            boolean partOfGuessing2 = false;
            while (u <= word2.length() - 1) {
                if (str2.contains(word2.substring(0, u))) {
                    partOfGuessing2 =true;
                }
                u++;
            }
            if (partOfGuessing2) {
                System.out.println("Горячо!");
            }
        }
//  9. Пока пользователь не введёт строку, содержащую пробел, считывайте
        //строки и выводите их первые буквы
        String str_1 = "";
        scanner.nextLine(); //очистка буфера ввода
        while (!str_1.contains(" ")) {
            if (!str_1.isEmpty()) {
                System.out.println(str_1.charAt(0));
            }
            System.out.println("Enter line: ");

            str_1 = scanner.nextLine();
        }
        System.out.println("The string has a space");
//  10. Пользователь вводит полный путь и название файла. Пока пользователь не ввел путь к существующему файлу,
        //  повторять ввод. Проверить, что файл существует, можно так: File f = new File(); boolean isExists = f.exists();
        boolean isExists = false;
        while (!isExists) {
            System.out.println("Enter file path: ");
            String filePath = scanner.nextLine();
            File f = new File(filePath);
            isExists = f.exists();
            if (!isExists) {
                System.out.println("File doesn't exist!");
            }
        }
//  11. Сохраните снимки NASA за январь 2022 года
        //  API NASA
        String page = downloadWebPage("https://api.nasa.gov/planetary/apod" +
                "?start_date=2022-01-01&end_date=2022-01-31&api_key=DEMO_KEY");
        System.out.println(page);
        int p = 0;
        int l = 1;
        while (p < page.length() - 10) {
            int urlStart = page.indexOf("\"url\":\"https://apod", p);
            int urlEnd = page.indexOf("jpg", urlStart);
            p = urlEnd;
            String url = page.substring(urlStart + 7, urlEnd + 3);
            System.out.println(url);

           // Скачаем картинку по ссылке:
            try (InputStream in = new URL(url).openStream()) {
                Path picturePath = Paths.get("./src/theme_2/lesson_2/files/picture" + l + ".jpg");
                if (Files.exists(picturePath)) {
                    Files.delete(picturePath);
                }
                Files.copy(in, picturePath);
            }
            System.out.println("Picture saved!");
            l++;
        }
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
