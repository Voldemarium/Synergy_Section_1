package theme_4_inheritance.task_32;

import java.util.Scanner;

public class Calculator {
    Scanner scanner = new Scanner(System.in);
    int x;
    int y;
    char operator;

    public Calculator() {
        System.out.println("Enter number int x: ");
        this.x = scanner.nextInt();
        System.out.println("Enter operator: ");
        this.operator = scanner.next().charAt(0);
        System.out.println("Enter number int y: ");
        this.y = scanner.nextInt();
    }

    public double getResult() {
        if (operator == '+') {
            return this.x + this.y;
        } else if (operator == '-') {
            return this.x - this.y;
        } else if (operator == '*') {
            return this.x * this.y;
        } else if (operator == '/') {
            return (double) this.x / this.y;
        } else {
            throw new IncorrectInputException(" Operator should be '+' or '-' or '*' or '/'");
        }
    }
}
