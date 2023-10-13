package theme_1.lesson_6;

import java.util.Scanner;

public class Task_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//     1. Пользователь вводит дробное число. Если оно больше пи, вывести “pimore”
        System.out.println("Please input double number: ");
        double x = scanner.nextDouble();
        if (x > Math.PI) {
            System.out.println("pimore");
        }
        scanner.nextLine();
//     2. Пользователь вводит строку. Используя метод .contains(‘ ‘) пробел, определите, ввел пользователь одно слово,
//        или больше
        System.out.println("Please input string: ");
        String str = scanner.nextLine();
        if (str.contains(" ")) {
            System.out.println("You entered multiple words");
        } else {
            System.out.println("You entered one word");
        }
//     3. Пользователь вводит четыре числа. Найти наибольшее из них.
        System.out.println("Please input int x1: ");
        int x1 = scanner.nextInt();
        System.out.println("Please input int x2: ");
        int x2 = scanner.nextInt();
        System.out.println("Please input int x3: ");
        int x3 = scanner.nextInt();
        System.out.println("Please input int x4: ");
        int x4 = scanner.nextInt();
        int biggest_X = 0;
        if(x1 > x2) {
            if(x1 > x3) {
                if(x1 > x4) {
                    biggest_X = x1;
                }
            } else if(x3 > x4) {
                biggest_X = x3;
            } else {
                biggest_X = x4;
            }
        } else {
            if(x2 > x3) {
               if (x2 > x4) {
                   biggest_X = x2;
               } else {
                   biggest_X = x4;
               }
            } else if (x3 > x4) {
                biggest_X = x3;
            } else {
                biggest_X = x4;
            }
        }
        System.out.println("biggest number: " + biggest_X);
    }
}
