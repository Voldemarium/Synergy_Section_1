package theme_3_OOP.lesson_25;

import java.util.Scanner;

public class Lesson_25 {
    public static void main(String[] args) {
//  1. Чертим диагонали
        int size = 20;
        for (int row = 0; row < size; row++) {
            for (int col= 0; col < size; col++) {
                if (row == col) {
                    System.out.print("\\");
                } else if (row + col == size - 1) {
                    System.out.print("/");
                } else {
                    System.out.print("0");
                }
            }
            System.out.println();
        }

//  2. Выведите таблицу умножения 1-9
        printMultiplicationTable(9);

        // Выведите таблицу умножения 1-20
        printMultiplicationTable(20);

//  3. Игра "Морской бой"
        int size2 = 10;
        char[][] battleField = new char[size2][size2];
        printColNumber(size2);
        for (int row = 0; row < size2; row++) {
            printRowNumber(row);
            //расстановка кораблей
            for (int col = 0; col < size2; col++) {
                boolean sergey1 = row == 0 && col < 4;
                boolean sergey2 = col == 3 && row >= 2 && row <= 4;
                boolean olga1 = col == 7 && row >= 5 && row <= 7;
                boolean olga2 = row == 9 && col >= 1 && col <= 4;

                if (sergey1 || sergey2) {
                    System.out.print("[C]");
                    battleField[row][col] = 'C';
                } else if (olga1 || olga2) {
                    System.out.print("[O]");
                    battleField[row][col] = 'O';
                } else {
                    System.out.print("[ ]");
                    battleField[row][col] = '-';
                }
            }
            System.out.println();
        }
        //определим кол-во жизней у участников (по кол-ву и величине кораблей
        int olgaShipLives = 7;


        //play
        while (olgaShipLives > 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Sergey, make your turn: ");
            System.out.println("row num: ");
            int selectedRow = scanner.nextInt() - 1;
            System.out.println("col num: ");
            int selectedCol = scanner.nextInt() - 1;
//        boolean olga1 = selectedCol == 7 && selectedRow >= 5 && selectedRow <= 7;
//        boolean olga2 = selectedRow == 9 && selectedCol >= 1 && selectedCol <= 4;
            if (battleField[selectedRow][selectedCol] == 'O') {
                battleField[selectedRow][selectedCol] = 'X';
                olgaShipLives--;
                System.out.println("wounded!");
            } else {
                System.out.println("past");
            }
            if (olgaShipLives == 0) {
                System.out.println("Sergey, you win!");
            }
        }


    }

    private static void printRowNumber(int row) {
        System.out.print(row + 1 + " "); //нумерация строк
        if (row + 1 < 10) {
            System.out.print(" ");
        }
    }

    private static void printColNumber(int size2) {
        System.out.print("  ");
        if (size2 >= 10) {
            System.out.print(" ");
        }
        for (int i = 1; i <= size2; i++) {
            System.out.print(" " + i + " "); //нумерация столбцов
        }
        System.out.println();
    }


    private static void printMultiplicationTable(int end) {
        for (int i = 1; i <= end; i++) {
            for (int j = 1; j <= end; j++) {
//                System.out.print(i + "*" + j + "=" + (i * j) + " ");
                int mult = i * j;
                System.out.print(mult);
                //выводим необходимое количество пробелов в зависимости от числа цифр
//                String str = String.valueOf(mult);
//                for (int k = 0; k < 4 - str.length(); k++) {
//                    System.out.print(" ");
//                }

                //выводим необходимое количество пробелов в зависимости от числа цифр (int)log10(mult)
                for (int k = 0; k < 3 - (int) Math.log10(mult); k++) {
                    System.out.print(" ");
                }

//                if (mult >= 100) {
//                    System.out.print(mult + " ");
//                } else if (mult >= 10){
//                    System.out.print(mult + "  ");
//                } else {
//                    System.out.print(mult + "   ");
//                }
            }
            System.out.println();
        }


    }
}
