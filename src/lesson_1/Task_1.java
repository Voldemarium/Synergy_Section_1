package lesson_1;

public class Task_1 {
    public static void main(String[] args) {
        // lesson_1.Task_1
//  1. Выведите ваше имя в консоль
        System.out.println("Vladimir");
//  2. Выведите любимое стихотворение в консоль
        System.out.println(
                "Я вас любил: любовь еще, быть может,\n" +
                        "В душе моей угасла не совсем,\n" +
                        "Но пусть она вас больше не тревожит,\n" +
                        "Я не хочу печалить вас ничем."
        );
//  3. Покажите в IDEA: Project explorer (область слева со списком файлов), область с кодом, номера строк кода.
//     Окошко, в котором выводится результат программы. Скройте и выведите обратно project explorer
//    (см файлы IDEA_1.png и IDEA_1.png)

//  4. Вывести значение 2 + 2 * 2
        System.out.println(2 + 2 * 2);
//  5. Вывести значение (2 + 2) * 2
        System.out.println((2 + 2) * 2);
//  6. Вывести значение деления 100 на пи
        System.out.println(100 / Math.PI);
//  7. Вывести значение 12345 в третьей степени
        System.out.println(Math.pow(12345, 3));
//  8. Вывести квадратный корень от двух в 10 степени
        System.out.println(Math.sqrt(Math.pow(2, 10)));
//  9. Вывести корень из двух, возведенный в 10 степень
        System.out.println(Math.pow(Math.sqrt(2), 10));
//  10. Что будет, если в джаве поделить на ноль? Проверить
//        System.out.println(2/0);    //ArithmeticException: / by zero
//  11. Попробуйте сложить две строки в Java. Выведите результат.
        System.out.println("I " + "do");
//  12. Попробуйте вычесть, разделить две строки.
//        System.out.println("I" - "asd"); //error:  bad operand types for binary operator '-'
//        System.out.println("I" / "asd"); //error:  bad operand types for binary operator '/'
//  13. Попробуйте сложить строку с числом пи. Что получилось?
        System.out.println("PI = " + Math.PI); // вывелась строка "PI = 3.141592653589793"
//  14. Напишите программу, которая считает корень линейного уравнения ax+b=0
        int a = 1;
        int b = 2;
        double x = (double) -b / a;
        System.out.println("x = " + x);
//  15. Напишите программу, которая считает корни уравнения (ax+b)*(cx+d)=0
//     т.е.  ax+b = 0 или cx+d = 0,
        int d = 3;
        double x1 = (double) -b / a;
        double x2 = -d / x;
        System.out.println("x1 = " + x1);
        System.out.println("x2 = " + x2);
//  16. Полезное упражнение: напишите программу, которая считает дискриминант квадратного уравнения
//        D = 2b - ac
        int c = 5;
        int D = 2 * b - a * c;
        System.out.println("D = " + D);
    }
}