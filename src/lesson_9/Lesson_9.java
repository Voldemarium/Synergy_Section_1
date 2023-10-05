package lesson_9;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Lesson_9 {
    public static void main(String[] args) throws IOException {
//        InputStream x = System.in;
//        char c = (char) x.read();
//        Scanner scanner = new Scanner(System.in);

//        char x = (char) System.in.read();
//        char operator = (char) System.in.read();
//        char y = (char) System.in.read();

        int x = System.in.read() - 48;
        char operator = (char) System.in.read();
        int y = System.in.read() - 48;

        int z = 0;
        if (operator == '+') {
            z = x + y;
        }
        System.out.println("" + x + operator + y + "=" + z);

//        PrintStream console = System.out;
//        console.println("Hello, world!");

        PrintStream out = System.out;
        PrintStream err = System.err;
        out.println("Hello, world!");
        err.println("Hello, world!");

//   Scanner nextLine() and next()
        Scanner scan = new Scanner(System.in);
        System.in.read(); //считывем конец строки перед вызовом nextLine()
        String str1 = scan.nextLine();
        String str2 = scan.next();
        System.out.println("str1: " + str1);
        System.out.println("str2: " + str2);

//   Чтение из файла
        InputStream stream = new FileInputStream("./src/lesson_9/file.txt");
        Scanner scanFile = new Scanner(stream);
        StringBuilder text = new StringBuilder();
        while (scanFile.hasNextLine()) {
            text.append(scanFile.nextLine());
        }
        System.out.println(text);
//   Чтение из файла с подсчетом
        InputStream stream2 = new FileInputStream("./src/lesson_9/qwerty.txt");
        Scanner scanFile2 = new Scanner(stream2);
        int x1 = scanFile2.nextInt();
        char op = scanFile2.next().charAt(0);
        int y1 = scanFile2.nextInt();
        if (op == '*') {
            System.out.println(x1 * y1);
        }
//  Запись в файл
        PrintWriter writer = new PrintWriter("./src/lesson_9/out.txt");
        if (op == '*') {
            writer.println("result");
            writer.println("is ...");
            writer.println(x1 * y1);
        }
        writer.close();

//  API NASA
        String page = downloadWebPage("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY");
        int urlStart = page.indexOf("url\":\"");
        int urlEnd = page.indexOf("jpg");
        String url = page.substring(urlStart + 6, urlEnd + 3);
        System.out.println(url);
//  Скачаем картинку по ссылке:
        try (InputStream in = new URL(url).openStream()) {
            Path picturePath = Paths.get("./src/lesson_9/picture.jpg");
            if (Files.exists(picturePath)) {
                Files.delete(picturePath);
            }
            Files.copy(in, Paths.get("./src/lesson_9/picture.jpg"));
        }
        System.out.println("Picture saved!");

//  Скачаем описание картинки
        int expStart = page.indexOf("explanation");
        int expEnd = page.indexOf("hdurl");
        String explanation = page.substring(expStart + 14, expEnd - 3);
        System.out.println(explanation);

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
