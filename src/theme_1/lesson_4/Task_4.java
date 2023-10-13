package theme_1.lesson_4;

import java.util.Scanner;

public class Task_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//  1.Составьте программу, которая переводит переменную из byte в short
        System.out.println("Input byte variable");
        byte by = scanner.nextByte();
        short by_s = by;
        System.out.println(by_s);
//  2.Составьте программу, которая переводит переменную из short в int
        System.out.println("Input short variable");
        short sh = scanner.nextShort();
        int sh_i = sh;
        System.out.println(sh_i);
//  3.Составьте программу, которая переводит переменную из int в long
        System.out.println("Input int variable");
        int i = scanner.nextInt();
        long i_l = i;
        System.out.println(i_l);
//  4.Составьте программу, которая переводит переменную из long в int
        System.out.println("Input long variable");
        long l = scanner.nextLong();
        int l_i = (int) l;
        System.out.println(l_i);
//  5.Составьте программу, которая переводит переменную из float в double
        System.out.println("Input float variable");
        float f = scanner.nextFloat();
        double f_d = f;
        System.out.println(f_d);
//  6.Составьте программу, которая переводит переменную из double в float
        System.out.println("Input double variable");
        double d = scanner.nextDouble();
        float d_f = (float) d;
        System.out.println(d_f);
//  7.Придумайте способ переводить из int в boolean и наоборот.
        System.out.println("Input int variable");
        int i_1 = scanner.nextInt();
        boolean i_b = i_1 != 0;
        System.out.println(i_b);

        System.out.println("Input boolean variable");
        boolean b = scanner.nextBoolean();
        int b_i;
        if (b) {
            b_i = 1;
        } else {
            b_i = 0;
        }
        System.out.println(b_i);

//  8.Придумайте способ переводить из String в boolean
        System.out.println("Input String variable");
        String s = scanner.next();
        boolean s_b = s.equals("true")  || Integer.parseInt(s) != 0;
        System.out.println(s_b);

//  9. Переведите переменную из char в string
        System.out.println("Input char variable");
        char ch = scanner.next().charAt(0);
        String ch_s = String.valueOf(ch);
        System.out.println(ch_s);

//  10. Переведите переменную из char в int и наоборот.
        System.out.println("Input char variable");
        char c = scanner.next().charAt(0);
        int c_i = Integer.valueOf(c);
        System.out.println(c_i);

        System.out.println("Input int variable");
        int i_2 = scanner.nextInt();
        char i_ch = (char) i_2;
        System.out.println(i_ch);
// 11. Пусть int равен от 30 до 150. Переведите каждый int в char, и выведите
//     таблицу, где на каждой строчке есть int и соответствующий ему char
        int j= 30;
        while (j <= 150) {
            System.out.println(j + " " + (char)j);
            j++;
        }
    }

}
