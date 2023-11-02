package theme_3_OOP.lesson_18;

import java.util.Scanner;

public class Lesson_18 {
    public static void main(String[] args) {
        int x= readNumber();
        int y= readNumber();
        int max =findMax1(x, y);
        System.out.println("biggest number: " + max);
    }
    static int readNumber(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number: ");
        int input = scanner.nextInt();
        return input;
    }

    static int findMax1(int x, int y) {
        int max;
        if (x > y){
            max = x;
        } else {
            max = y;
        }
        return max;
    }
    static int findMax2(int x, int y) {
        if (x > y){
            return x;
        } else {
            return y;
        }
    }
}
