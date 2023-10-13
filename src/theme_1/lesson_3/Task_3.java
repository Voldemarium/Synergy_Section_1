package theme_1.lesson_3;

import java.util.Scanner;

public class Task_3 {
    public static void main(String[] args) {
//  1. Где хранятся переменные? Сколько переменных можно задать в программе? Чем ограничен размер?
   // Ответ: Переменные хранятся в оперативной памяти ПК. Количество и размер максимального количества переменных
   // зависит от объема выделенной под работу программы оперативной памяти и размера самих переменны
         Scanner scanner = new Scanner(System.in);
//  2.  Пользователь вводит строку, выведите ее длину
        System.out.println("Please enter string: ");
        String s = scanner.nextLine();
        System.out.println("length = " + s.length());
//  3. Пользователь вводит две строки, выведите сумму их длин
        System.out.println("Please enter string 1: ");
        String s1 = scanner.nextLine();
        System.out.println("Please enter string 2: ");
        String s2 = scanner.nextLine();
        System.out.println("sum lengths = " + (s1.length() + s2.length()));
//  4. Пользователь вводит три строки. Найти, какая из них короче всех.
        System.out.println("Please enter string 3: ");
        String s3 = scanner.nextLine();
        String s_shortest = shortestStringFrom3(s1, s2, s3);
        System.out.println("shortest string = " + s_shortest);

//  5. Пользователь вводит три дробных числа. Вывести те из них, квадратный корень которых меньше 2.
        System.out.println("Please enter double x1 (example 1,5): ");
        double x1 = scanner.nextDouble();
        System.out.println("Please enter double y1: ");
        double y1 = scanner.nextDouble();
        System.out.println("Please enter double z1: ");
        double z1 = scanner.nextDouble();

        if (Math.sqrt(x1) < 2) {
            System.out.println("square root from " + x1 + " less 2");
        }
        if (Math.sqrt(y1) < 2) {
            System.out.println("square root from " + y1 + " less 2");
        }
        if (Math.sqrt(z1) < 2) {
            System.out.println("square root from " + z1 + " less 2");
        }
//  6. Пройдите в дебаге программу: Сколько раз выводится икс?
        int x2 = 1;
        while (x2 >= -3) {
            System.out.print(" " + x2); // x выводится 5 раз
            x2= x2 - 1;
        }
        System.out.println();
//  7. Пройдите в дебаге программу: Сколько раз вызывается метод str.length() ?
        String str = "Hell";
        while (str.length() < 10) { // вызывается 7 раз
            str = str + "o";
        }
//  8. Пользователь вводит два числа. Разделить меньшее на большее и вывести результат.
        System.out.println("Please enter double x3 (example 1,5): ");
        double x3 = scanner.nextDouble();
        System.out.println("Please enter double y3: ");
        double y3 = scanner.nextDouble();
        if (x3 < y3) {
            System.out.println(x3 / y3);
        } else {
            System.out.println(y3 / x3);
        }
//  9. Пользователь вводит строку. Используя substring, вывести первые 5 символов.
        System.out.println("Please enter string with length >= 5 : ");
        String s4 = scanner.nextLine();
        System.out.println(s4.substring(0, 5));
//  10. Считайте boolean-переменную. Если пользователь ввел true вывести “истина”, иначе ничего не стоит выводить.
        System.out.println("Please enter boolean: ");
        boolean b = scanner.nextBoolean();
        if (b) {
            System.out.println("истина");
        }
//  11. Пользователь вводит 3 числа. Сделайте три boolean переменных: есть ли среди введённых четное,
//  есть ли среди введённых отрицательное, есть ли число больше тысячи
        System.out.println("Please enter int x4: ");
        int x4 = scanner.nextInt();
        System.out.println("Please enter int y4: ");
        int y4 = scanner.nextInt();
        System.out.println("Please enter int z4: ");
        int z4 = scanner.nextInt();
        boolean evenNumber = false;
        boolean negativeNumber = false;
        boolean numberOver1000 = false;
        if (x4 % 2 == 0 || y4 % 2 == 0 || z4 % 2 == 0) {
            evenNumber = true;
        }
        if (x4 < 0 || y4 < 0 || z4 < 0) {
            negativeNumber = true;
        }
        if (x4 > 1000 || y4 > 1000 || z4 > 1000) {
            numberOver1000 = true;
        }
        System.out.println("evenNumber - " + evenNumber +
                ", negativeNumber - " + negativeNumber +
                ",  numberOver1000 - " + numberOver1000);
//  12. Пользователь вводит три строки, используя .substring(0, x)
//выведите эти строки, обрезав те, что длиннее самой короткой. Пример ввода:
//«повар», «поделка», «лампочка». Вывод: «повар», «подел», «лампо»
        System.out.println("Please enter string s_1: ");
        String s_1 = scanner.next();
        System.out.println("Please enter string s_2: ");
        String s_2 = scanner.next();
        System.out.println("Please enter string s_3: ");
        String s_3 = scanner.next();
        String shortest = shortestStringFrom3(s_1, s_2, s_3);
        System.out.println("shortest: " + shortest);
        String s_1_1;
        String s_2_1;
        String s_3_1;
        if(s_1.length() > shortest.length()) {
            s_1_1 = s_1.substring(0, shortest.length());
        } else {
            s_1_1 = s_1;
        }
        if(s_2.length() > shortest.length()) {
            s_2_1 = s_2.substring(0, shortest.length());
        } else {
            s_2_1 = s_2;
        }
        if(s_3.length() > shortest.length()) {
            s_3_1 = s_3.substring(0, shortest.length());
        } else {
            s_3_1 = s_3;
        }
        System.out.println(s_1_1 + ", " + s_2_1 + ", " + s_3_1);

//  13. Мини-игра в слова
        System.out.println("Please enter string 1: ");
        String str1 = scanner.nextLine();

        System.out.println("Please enter 2 number int (begin_2 and end_2 : ");
        int begin_2 = scanner.nextInt();
        int end_2 = scanner.nextInt();
        String str_2_2 = str1.substring(begin_2, end_2);
        System.out.println(str_2_2);

        System.out.println("Please enter 2 number int (begin_1 and end_1 : ");
        int begin_1 = scanner.nextInt();
        int end_1 = scanner.nextInt();
        String str_1_2 = str1.substring(begin_1, end_1);
        System.out.println(str_1_2);

        if (str_1_2.length() > str_2_2.length()) {
            System.out.println("Победил игрок 1");
        } else if (str_1_2.length() < str_2_2.length()) {
            System.out.println("Победил игрок 2");
        } else {
            System.out.println("Ничья!");
        }
   }

    static String shortestStringFrom3(String s1, String s2, String s3) {
        String s_shortest;
        if (s1.length() <= s2.length()) {
            if (s1.length() <= s3.length()) {
                s_shortest = s1;
            } else {
                s_shortest = s3;
            }
        } else {
            if (s2.length() <= s3.length()) {
                s_shortest = s2;
            } else {
                s_shortest = s3;
            }
        }
        return s_shortest;
    }

}
