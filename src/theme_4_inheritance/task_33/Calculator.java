package theme_4_inheritance.task_33;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    Scanner scanner = new Scanner(System.in);
    int x;
    int y;
    char operator;

    public Calculator() {
        this.x = inputInt();
        this.operator = inputOperator();
        this.y = inputInt();
    }

    private int inputInt() {
        int x = 0;
        boolean inputInt = false;
        while (!inputInt) {
            try {
                System.out.println("Enter number int: ");
                x = scanner.nextInt();
                inputInt = true;

            } catch (InputMismatchException e) {
                System.out.println("input is incorrect!!!");
                scanner.nextLine();
            }
        }
        return x;
    }

    private char inputOperator() {
        char operator = 0;
        boolean inputChar = false;
        while (!inputChar) {
                System.out.println("Enter operator: ");
                operator = scanner.next().charAt(0);
                if (operator == '+' || operator == '-' || operator == '*' || operator == '/') {
                    inputChar = true;
                } else {
                    System.out.println("input is incorrect!!!");
                    scanner.nextLine();
                }
        }
        return operator;
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
