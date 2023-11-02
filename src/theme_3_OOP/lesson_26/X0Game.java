package theme_3_OOP.lesson_26;

import java.util.Scanner;

public class X0Game {
    FieldX0 gameField;
    Scanner scanner = new Scanner(System.in);
    char whoMakeNextTurn;
    boolean gameOver = false;
    void setupNewGame() {
        System.out.println("Will play new X0 game");
        this.gameField = new FieldX0();
        this.gameField.initField();
    }
    void play() {
        this.setupNewGame();
        System.out.println("Who will make first turn: ");
        char first = this.scanner.next().charAt(0);
        if (first == 'X' || first == '0') {
            this.whoMakeNextTurn = first;
        } else {
            System.out.println("I recognizing only X and 0 (zero). So first will be X");
            this.whoMakeNextTurn = 'X';
        }
        while (!gameOver) {
            turn();
            //Проверка на условия завершения игры
            this.gameOver = this.gameField.isGameOver(this.whoMakeNextTurn);
            if (this.gameOver) {
                System.out.println(this.whoMakeNextTurn + " win!");
            }
            if (this.whoMakeNextTurn == 'X') {
                this.whoMakeNextTurn = '0';
            } else {
                this.whoMakeNextTurn = 'X';
            }
        }
        System.out.println("Game over.");
    }

    //Ход игрока
    void turn() {
        System.out.println(this.whoMakeNextTurn + ", your turn. ");
        System.out.print("Chose row: ");
        int rowNumber = this.scanner.nextInt();
        System.out.print("Chose column: ");
        int colNumber = this.scanner.nextInt();
        int rowIndex = rowNumber - 1;
        int colIndex = colNumber - 1;
        if (this.gameField.isPlaceFree(rowIndex, colIndex)) {  //если ячейка свободна
            this.gameField.setValue(rowIndex, colIndex, whoMakeNextTurn);
            this.gameField.printField();
        } else {                                              //если ячейка уже занята
            System.out.println("Wrong number (maybe this place is not free?). Make turn again");
                    turn();     // рекурсия метода
        }
    }
}
