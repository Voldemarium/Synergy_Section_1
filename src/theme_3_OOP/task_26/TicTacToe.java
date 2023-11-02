package theme_3_OOP.task_26;

import java.util.Scanner;

public class TicTacToe {
    final int SIZE = 5; // Размер игрового поля
    final int countWin = 4; // кол-во заполненных подряд клеток для победы
    char[][] boardArray = new char[SIZE][SIZE];  // игровое поле в виде двумерного массива
    char currentPlayer; // Текущий игрок
    Scanner scanner = new Scanner(System.in);

    public void startPlay() {
        printBoard();

        currentPlayer = chooseFirstPlayer();
        System.out.println("currentPlayer: " + currentPlayer);

        while (!isGameFinished()) {
            makeMove();
            printBoard();
            switchPlayer();
        }

        if (isWin('X')) {
            System.out.println("Крестики победили!");
        } else if (isWin('0')) {
            System.out.println("Нолики победили!");
        } else {
            System.out.println("Ничья!");
        }
    }

    //Выбор первого игрока
    private char chooseFirstPlayer() {
        System.out.println("Who will be the first player? (X or 0): ");
        char firstPlayer = scanner.next().charAt(0);
        while (firstPlayer != 'X' && firstPlayer != '0') {
            System.out.println("It is wrong character!. Enter again X or 0: ");
            firstPlayer = scanner.next().charAt(0);
        }
        return firstPlayer;
    }

    private void printBoard() {
        System.out.print("   ");
        for (int i = 1; i <= SIZE; i++) {
            System.out.print(i + "  "); //выводим номера столбцов
        }
        System.out.println();

        for (int row = 0; row < SIZE; row++) {
            int rowNumber = row + 1;
            System.out.print(rowNumber + " ");  //выводим номера строк
            for (int col = 0; col < SIZE; col++) {
                System.out.print("[" + boardArray[row][col] + "]");
            }
            System.out.println();
        }
    }

    // Ход игрока
    private void makeMove() {
        Scanner scanner = new Scanner(System.in);
        int row, col;
        do {
            System.out.print("Игрок '" + currentPlayer + "', введите номер строки (1-" + SIZE + "): ");
            row = scanner.nextInt();
            System.out.print("Игрок '" + currentPlayer + "', введите номер столбца (1-" + SIZE + "): ");
            col = scanner.nextInt();
        } while (!isValidMove(row, col));
        boardArray[row - 1][col - 1] = currentPlayer;
    }

    // Проверка валидности хода
    private boolean isValidMove(int row, int col) {
        if (row < 1 || row > SIZE || col < 1 || col > SIZE) {
            System.out.println("Неверные координаты!");
            return false;
        } else if (boardArray[row - 1][col - 1] == 'X' || boardArray[row - 1][col - 1] == '0') {
            System.out.println("Выбранная ячейка уже занята!");
            return false;
        }
        return true;
    }

    // Смена игрока
    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? '0' : 'X';
    }

    // Проверка победителя по горизонтальным линиям
    private boolean isWinHorizon(char player) {
        boolean isWinHorizon = false;
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col <= SIZE - countWin; col++) {
                boolean isWinHorizonCurrent = true;
                for (int i = col; i < col + countWin; i++) {
                    if (boardArray[row][i] != player) {
                        isWinHorizonCurrent = false;
                        break;
                    }
                }
                if (isWinHorizonCurrent) {
                    isWinHorizon = true;
                }
            }
        }
        return isWinHorizon;
    }

    // Проверка победителя по вертикальным линиям
    private boolean isWinVert(char player) {
        boolean isWinVert = false;
        for (int col = 0; col < SIZE; col++) {
            for (int row = 0; row <= SIZE - countWin; row++) {
                boolean isWinVertCurrent = true;
                for (int i = row; i < row + countWin; i++) {
                    if (boardArray[i][col] != player) {
                        isWinVertCurrent = false;
                        break;
                    }
                }
                if (isWinVertCurrent) {
                    isWinVert = true;
                }
            }
        }
        return isWinVert;
    }

    // Проверка победителя по главной диагонали
    private boolean isWinDiagonal_1(char player) {
        boolean isWinDiagonal_1 = false;
        for (int row = 0; row <= SIZE - countWin; row++) {
            for (int col = 0; col <= SIZE - countWin; col++) {
                boolean isWinDiagonal_1_cur = true;
                for (int shift = 0; shift < countWin; shift++) {
                    if (boardArray[row + shift][col + shift] != player) {
                        isWinDiagonal_1_cur = false;
                        break;
                    }
                }
                if (isWinDiagonal_1_cur) {
                    isWinDiagonal_1 = true;
                }
            }
        }
        return isWinDiagonal_1;
    }

    // Проверка победителя по второй диагонали
    private boolean isWinDiagonal_2(char player) {
        boolean isWinDiagonal_2 = false;
        for (int row = 0; row <= SIZE - countWin; row++) {
            for (int col = SIZE - 1; col >= countWin - 1; col--) {
                boolean isWinDiagonal_2_cur = true;
                for (int shift = 0; shift < countWin; shift++) {
                    if (boardArray[row + shift][col - shift] != player) {
                        isWinDiagonal_2_cur = false;
                        break;
                    }
                }
                if (isWinDiagonal_2_cur) {
                    isWinDiagonal_2 = true;
                }
            }
        }
        return isWinDiagonal_2;
    }

    private boolean isWin(char player) {
        return isWinHorizon(player) || isWinVert(player) || isWinDiagonal_1(player) || isWinDiagonal_2(player);
    }

    // Проверка полной заполненности игрового поля
    private boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (boardArray[i][j] != 'X' && boardArray[i][j] != '0') {
                    return false;
                }
            }
        }
        return true;
    }

    // Проверка окончания игры
    private boolean isGameFinished() {
        return isFull() || isWin('X') || isWin('0');
    }
}
