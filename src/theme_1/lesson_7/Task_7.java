package theme_1.lesson_7;

import java.util.Scanner;

public class Task_7 {
    public static void main(String[] args) {
//  Задание 1. Написать простой булев калькулятор.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter boolean expression: ");
        String expr = scanner.nextLine();
        char x = expr.charAt(0);
        char op = expr.charAt(1);
        char y = expr.charAt(2);

        boolean xValue = false;
        if (x == '1') {
            xValue = true;
        } else {
            xValue = false;
        }
        boolean yValue = false;
        if (y == '1') {
            yValue = true;
        } else {
            yValue = false;
        }

        if (op == '&') {
            System.out.println(xValue && yValue);
        } else if (op == '|') {
            System.out.println(xValue || yValue);
        } else {
            System.out.println("Unknown operator");
        }
//      Задача 2.
//        Решите логическую загадку.
//        Альберт и Бернард только что познакомились с Шерил. Они хотят знать, когда у неё день рождения.
//        Шерил предложила им десять возможных дат:
//                    15 мая,     16 мая,                           19 мая,
//                                           17 июня,    18 июня,
//        14 июля,                16 июля,
//        14 августа, 15 августа             17 августа.
//        Затем Шерил сказала Альберту месяц своего рождения, а Бернарду - день. После этого состоялся диалог:
//        Альберт - знает МЕСЯЦ
//        Бернард - знает ДЕНЬ

//        1)Альберт(знает МЕСЯЦ): Я не знаю, когда у Шерил день рождения, но я знаю, что Бернард тоже не
//        знает.
//        - он говорит о том, потому что этот МЕСЯЦ - точно НЕ МАЙ и НЕ ИЮНЬ, потому что только в случае,
//        если  бы это был май или июнь, существовала вероятность, что тот (Бернард), кто знает день,
//        сразу узнает и месяц из предложенных дат (если бы это были 18июня или 19мая).
//        2) Бернард(знает ДЕНЬ): Поначалу я не знал, когда у Шерил день рождения, но знаю теперь.
//        - это означает, ДР - точно не 14 число (т.е. это либо 16 июля, либо 15 августа, либо 17 августа),
//        т.к., если бы это было 14 число, то он не смог бы так утверждать, поскольку есть 14 июля и 14 августа
//        3) Альберт(знает МЕСЯЦ): Теперь я тоже знаю, когда у Шерил день рождения.
//          - это означает, что ДР - это ИЮЛЬ. тк если бы это был август, тогда из оставшихся 3-х чисел бы был выбор
//          между 15 августа и 17 августа, а июльское число из оставшихся 3х - одно - 16 июля

//        Когда у Шерил день рождения? - 16 июля
    }
}
