package lesson_9;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) throws IOException {
//   1. Пользователь вводит три слова, выведите в обратном порядке.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter 3 words: ");
        String word1 = scanner.next();
        String word2 = scanner.next();
        String word3 = scanner.next();
        System.out.println(word3 + "\n" +  word2 + "\n" +  word1);
//      Пользователь вводит три строки, выведите в обратном порядке.
        scanner.nextLine(); //Очистка буфера ввода
        System.out.println("Please, enter 3 lines: ");
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        String str3 = scanner.nextLine();
        System.out.println(str3 + "\n" +  str2 + "\n" +  str1);

//   2. Используя System.in (без сканера), считайте слово из 5 букв
        int i = 0;
        System.out.println("Please, enter word of five letters: ");
        while (i < 5) {
            char c = (char) System.in.read();
            System.out.print(c);
            i++;
        }
//   3. Используя System.in (без сканера),считайте слово до пробела. Макс размер слова 10 символов
        int j = 0;
        char c = 0;
        System.out.println();
        scanner.nextLine(); // очистка буфера ввода
        System.out.println("Please, enter line: ");
        while (j < 10 && c != ' ') {
            c = (char) System.in.read();
            System.out.print(c);
            j++;
        }
        System.out.println();
//   4. Используя Scanner на основе FileInputStream, прочесть из файла строку: название другого файла.
//   Из этого другого файла прочесть название третьего файла, и в третий файл записать букву,
//   которую пользователь введет через System.in (без сканера)
        String fileName = "./src/lesson_9/file1.txt";
        int w = 1;
        scanner.nextLine(); // очистка буфера ввода
        while (w < 3) {
            InputStream stream = new FileInputStream(fileName);
            Scanner scanFile = new Scanner(stream);
            fileName = scanFile.next();
            if (w == 2) {
                PrintWriter writer = new PrintWriter(fileName);
                System.out.println("Please enter letter: ");
                writer.println((char) System.in.read());
                writer.close();
            }
            w++;
        }
//   5. Пользователь вводит 7символов. Используя System.in (без сканнера),считайте целое число до первой нецифры.
//   (пример: «35 руб», ответ 35.) считаем, что первым пользователь всегда вводит цифру.
        int r = 0;
        scanner.nextLine(); // очистка буфера ввода
        System.out.println("Please enter numbers: ");
        while (r < 7) {
            int a = System.in.read();
            if(a >= 48 && a <= 57) {
                int ch = a - 48;
                System.out.print(ch);
            }
            r++;
        }
//  6. Аналогично предыдущей задаче, но пользователь всегда вводит дробное число (пример ввода: «3.5 кг»)
        int k = 0;
        scanner.nextLine(); // очистка буфера ввода

        System.out.println();
        System.out.println("Please enter double number: ");
        while (k < 7) {
            int a = System.in.read();
            if(a >= 48 && a <= 57) {
                int ch = a - 48;
                System.out.print(ch);
            } else if (a == 46 || a == 44) {
                System.out.print(".");
            } else {
                break;
            }
            k++;
        }
        System.out.println();
//  7. Пользователь вводит 10 строк. Те из них, в которых есть восклицательный знак, выведите в stderr.
       //  Попробуйте использовать цикл
       int a = 1;
        scanner.nextLine(); // очистка буфера ввода
        while (a <= 10) {
            System.out.println("Please enter string " + a);
            String str = scanner.nextLine();
            if (str.contains("!")) {
                System.err.println(str);
            } else {
                System.out.println(str);
            }
            a++;
        }
//  9. Пользователь вводит 10 строк, потом число max. Вывести в stdout те строки, длина которых меньше max,
//      а в stderr те, длина которых больше, обрезав по max.
        String fileNameStr = "./src/lesson_9/str.txt";
        PrintWriter writer = new PrintWriter(fileNameStr);
        int b = 1;
        while (b <= 10) {
            System.out.println("Please enter string: " + b);
            String str = scanner.nextLine();
            writer.println(str);
            b++;
        }
        writer.close();

        System.out.println("Please enter number max: ");
        int max = scanner.nextInt();

        InputStream stream = new FileInputStream(fileNameStr);
        Scanner scanFile = new Scanner(stream);
        while (scanFile.hasNextLine()) {
            String str =scanFile.nextLine();
            if (str.length() <= max) {
                System.out.println(str);
            } else {
                System.err.println(str.substring(0, max));
            }
        }

    }
}
