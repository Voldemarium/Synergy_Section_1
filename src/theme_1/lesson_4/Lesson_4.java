package theme_1.lesson_4;

import java.util.Scanner;

public class Lesson_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter credit sum: ");
        int creditSum = scanner.nextInt();
        System.out.println("Please enter credit percent: ");
        double percent = scanner.nextDouble();
        System.out.println(creditSum + creditSum * (percent / 100));
    }
}
