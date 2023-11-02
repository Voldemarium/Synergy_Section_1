package theme_3_OOP.task_21;

import java.util.Scanner;

public class TicTacToe {
    static final int SIZE = 3; // Размер игрового поля
    static StringBuilder builderBoard = new StringBuilder(); // игровое поле в виде StringBuilder
    static char[][] boardArray = new char[SIZE][SIZE];  // игровое поле в виде двумерного массива
    static char currentPlayer; // Текущий игрок
    static int indexBuilderCurrent; // Текущий индекс в StringBuilder
    public static void main(String[] args) {
        initializeAndPrintBoard();
        System.out.println(builderBoard);

        currentPlayer = 'X';

        while (!isGameFinished()) {
            makeMove();
            System.out.println(builderBoard);
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

    //  Формируем игровое поле в виде StringBuilder
    private static void initializeAndPrintBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                builderBoard.append("|").append(" ");
            }
            builderBoard.append("|").append("\n");
        }
    }
    // Ход игрока
    private static void makeMove() {
        Scanner scanner = new Scanner(System.in);
        int row, col;
        do {
            System.out.print("Игрок '" + currentPlayer + "', введите номер строки (1-" + SIZE + "): ");
            row = scanner.nextInt();
            System.out.print("Игрок '" + currentPlayer + "', введите номер столбца (1-" + SIZE + "): ");
            col = scanner.nextInt();
        } while (!isValidMove(row, col));
        builderBoard.replace(indexBuilderCurrent, indexBuilderCurrent + 1, String.valueOf(currentPlayer));
    }

    // Проверка валидности хода
    private static boolean isValidMove(int row, int col) {
        indexBuilderCurrent = 1 + ((row - 1) * ((2 * SIZE) + 2)) + (2 * (col - 1));
        if (row < 1 || row > SIZE || col < 1 || col > SIZE) {
            System.out.println("Неверные координаты!");
            return false;
        } else if (builderBoard.charAt(indexBuilderCurrent) != ' ') {
            System.out.println("Выбранная ячейка уже занята!");
            return false;
        }
        return true;
    }

    // Смена игрока
    private static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? '0' : 'X';
    }

    // Проверка победителя по горизонтальным линиям и заполнение массива данными для последующих проверок
    // по вертикальным и диагональным линиям
    private static boolean isWin(char player) {
        boolean isWin = false;
        int n = 1;
        for (int i = 0; i < SIZE; i++) {
            boolean isWinCurrent = true;
            for (int j = 0; j < SIZE; j++) {
                boardArray[i][j] = builderBoard.charAt(n);
                if (builderBoard.charAt(n) != player) {
                    isWinCurrent = false;
                }
                n += 2;
            }
            if (isWinCurrent) {
                isWin = true;
            }
            n += 2;
        }

        if(isWinVertOrDiagonal(player)) {
            isWin = true;
        }
        return isWin;
    }

    // Проверка победителя по вертикальным и диагональным линиям
    private static boolean isWinVertOrDiagonal(char player) {
        boolean isWin = false;
        boolean isWinVert = false;
        boolean isWinDiagonal1 = true;
        boolean isWinDiagonal2 = true;
        for (int j = 0; j < SIZE; j++) {
            boolean isWinVertCurrent = true;
            for (int i = 0; i < SIZE; i++) {
                if (boardArray[i][j] != player) {
                    isWinVertCurrent = false;
                    break;
                }
            }
            if (isWinVertCurrent) {
                isWinVert = true;
            }
            if (boardArray[j][j] != player) {  // проверка 1-ой диагонали
                isWinDiagonal1 = false;
            }
            if (boardArray[j][SIZE - j - 1] != player) {  // проверка 2-ой диагонали
                isWinDiagonal2 = false;
            }
        }
        if (isWinVert || isWinDiagonal1 || isWinDiagonal2) {
            isWin = true;
        }
        return isWin;
    }

    // Проверка полной заполненности игрового поля
    private static boolean isFull() {
        int n = 1;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (builderBoard.charAt(n) == ' ') {
                    return false;
                }
                n += 2;
            }
            n += 2;
        }
        return true;
    }

    // Проверка окончания игры
    private static boolean isGameFinished() {
        return isFull() || isWin('X') || isWin('0');
    }
}
