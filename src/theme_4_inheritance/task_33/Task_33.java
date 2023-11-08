package theme_4_inheritance.task_33;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Task_33 {
    public static void main(String[] args) {
//  1. В чем разница между throw и throws в Java?
        // throw - команда для выбрасывания исключения в данном месте программы,
        // throws - команда пробрасывания исключения из текущего метода на уровень выше

//  2. Пользователь вводит число. Если произошла ошибка ввода, выведите пользователю сообщение о том,
        //  что ввод некорректный
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Input number: ");
            int number = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("input is incorrect!!!");
        }

//  3. Пользователь вводит число. Если произошла ошибка ввода, дайте пользователю ввести еще раз: так пока он не введёт
        // нормально (подсказка: while)
        boolean inputInt = false;
        while (!inputInt) {
            try {
                scanner.nextLine();
                System.out.println("Input number: ");
                int number = scanner.nextInt();
                inputInt = true;
            } catch (InputMismatchException e) {
                System.out.println("input is incorrect!!!");
            }
        }

//  4. Доработайте калькулятор. Если пользователь ввел неверное значение, просто дайте ему ввести еще раз. (Пока он не
    //  введёт корректно)
        Calculator calculator = new Calculator();
        System.out.println(calculator.x + " " + calculator.operator  + " " + calculator.y +
                " = " + calculator.getResult());

//  5. Пользователь вводит адрес ссылки. Если удаётся скачать страничку по адресу, сохранить ее в html файл;
    //  иначе вывести, что страница не найдена.
        System.out.println("Input url: ");
        String url = scanner.next();
        //  Скачаем файл по ссылке:
        try (InputStream in = new URL(url).openStream()) {
            Path path = Paths.get("./src/theme_4_inheritance/task_33/files/file.html");
            if (Files.exists(path)) {
                Files.delete(path);
            }
            Files.copy(in, path);
            System.out.println("File saved!");
        } catch (IOException e) {
            System.out.println("The page not found!");
        }

//  6. Пользователь вводит имя файла. Выведите содержимое этого файла, если не получилось - выведите сообщение,
   // что файл не найден
        System.out.println("Input file name: ");
        String fileName = scanner.next();
        try {
            InputStream stream = new FileInputStream(fileName);
            Scanner scanFile = new Scanner(stream);
            StringBuilder text = new StringBuilder();
            while (scanFile.hasNextLine()) {
                text.append(scanFile.nextLine());
            }
            System.out.println(text);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

//  7. Доработайте скачивальщик снимков NASA, чтобы в нем не было ни одного throws (пройдитесь прям поиском по файлу).
     //  Throws придётся заменить на try catch
        NASA nasa = new NASA("./src/theme_4_inheritance/task_33/files/picture.jpg");
        nasa.downloadPictureNASA();
    }
}
