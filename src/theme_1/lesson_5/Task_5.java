package theme_1.lesson_5;

import java.util.Scanner;

public class Task_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

// 1. Пользователь вводит два числа. Возвести второе в степень первого
        System.out.println("Input int x variable");
        int x = scanner.nextInt();
        System.out.println("Input int y variable");
        int y = scanner.nextInt();
        System.out.println(Math.pow(y, x));
//  2,3. Пользователь вводит три числа. Возвести 1 в степень 2, и результат в степень 3.
        System.out.println("Input int x1 variable");
        int x1 = scanner.nextInt();
        System.out.println("Input int x2 variable");
        int x2 = scanner.nextInt();
        System.out.println("Input int x3 variable");
        int x3 = scanner.nextInt();
        System.out.println(Math.pow(Math.pow(x1, x2), x3));
//  4. Пользователь вводит, две строки. Найти разницу в длине.
        System.out.println("Input String s1 cvariable");
        String s1 = scanner.next();
        System.out.println("Input String s2 cvariable");
        String s2 = scanner.next();
        System.out.println("difference length = " + Math.abs(s1.length() - s2.length()));
//  5,6. Пользователь вводит три строки. Найти разницу в длине самой короткой и самой длинной.
        System.out.println("Input String s_1 cvariable");
        String s_1 = scanner.next();
        System.out.println("Input String s_2 cvariable");
        String s_2 = scanner.next();
        System.out.println("Input String s_3 cvariable");
        String s_3 = scanner.next();
        int min = Math.min(s_3.length(), Math.min(s_1.length(), s_2.length()));
        int max = Math.max(s_3.length(), Math.max(s_1.length(), s_2.length()));
        System.out.println("difference length = " + (max - min));

//  7. Сделать калькулятор для трех чисел: пользователь вводит первое, потом оператор, второе, оператор, третье.
//  Посчитать первое на второе, потом результат с третьим. Пример: 11 + 4 * 20    Вывод: 300
        System.out.println("Input double x_1 variable");
        double x_1 = scanner.nextDouble();
        System.out.println("Input operator");
        char ch_1 = scanner.next().charAt(0);
        System.out.println("Input double x_2 variable");
        double x_2 = scanner.nextDouble();
        double res_1 = calculate_x_y(x_1, x_2, ch_1);
        System.out.println("Input operator");
        char ch_2 = scanner.next().charAt(0);
        System.out.println("Input double x_3 variable");
        double x_3 = scanner.nextDouble();
        double res_2 = calculate_x_y(res_1, x_3, ch_2);
        System.out.println("result: " + res_2);

//  8. Решить предыдущую задачу, но операции считать по приоритету (умножение и деление выше сложения вычитания).
        //  Предыдущий пример даст ответ 11 + 80 равно 91
        System.out.println("Input double y_1 variable");
        double y_1 = scanner.nextDouble();
        System.out.println("Input operator");
        char ch1 = scanner.next().charAt(0);
        System.out.println("Input double y_2 variable");
        double y_2 = scanner.nextDouble();
        System.out.println("Input operator");
        char ch2 = scanner.next().charAt(0);
        System.out.println("Input double y_3 variable");
        double y_3 = scanner.nextDouble();

        double res1;
        double res2;
        if ((ch1 == '+' || ch1 == '-') && (ch2 == '*' || ch2 == '/')) {
            res1 = calculate_x_y(y_2, y_3, ch2);
            res2 = calculate_x_y(y_1, res1, ch1);
        } else {
            res1 = calculate_x_y(y_1, y_2, ch1);
            res2 = calculate_x_y(res1, y_3, ch2);
        }
        System.out.println("result: " + res2);
//  9. Вывести английский алфавит
        int i = 65;
        while (i < 91) {
            char ch_i = (char) i;
            System.out.print(" " + ch_i);
            i++;
        }
        System.out.println();
//  10. Пользователь вводит N. Вывести букву английского алфавита по счету N.
        System.out.println("Input english alphabet number N:");
        int N = scanner.nextInt();
        System.out.println((char) (N + 64));
//  11. Вывести случайную букву английского алфавита.
        int random_letter = (int)(65 + Math.random() * 26);
        System.out.println((char) random_letter);
//  12. Вывести случайное число от 11 до 22
            int random_number11_22 = (int)(11 + Math.random() * 12);
            System.out.println(random_number11_22);

    }

    static public double calculate_x_y(double x, double y, char ch) {
        double res = 0;
        if (ch == '+') {
            res = x + y;
        }
        if (ch == '-') {
            res = x - y;
        }
        if (ch == '*') {
            res = x * y;
        }
        if (ch == '/') {
            res = x / y;
        }
        return res;
    }
}
