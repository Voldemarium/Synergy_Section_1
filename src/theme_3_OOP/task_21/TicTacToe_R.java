package theme_3_OOP.task_21;

import java.util.Scanner;

public class TicTacToe_R {

    static final int SIZE = 3; // Размер игрового поля

    static final char EMPTY_CELL = '-'; // Символ пустой ячейки
    static final char CROSS = 'X'; // Символ крестика
    static final char NOUGHT = 'O'; // Символ нолика

    private static char[][] board; // Игровое поле (двумерный массив)
    private static char currentPlayer; // Текущий игрок

    public static void main(String[] args) {

        board = new char[SIZE][SIZE];
        currentPlayer = CROSS;

        initializeBoard();

        printBoard();

        while (!isGameFinished()) {
            makeMove();
            printBoard();
            switchPlayer();
        }

        if (isWinner(CROSS)) {
            System.out.println("Крестики победили!");
        } else if (isWinner(NOUGHT)) {
            System.out.println("Нолики победили!");
        } else {
            System.out.println("Ничья!");
        }
    }

    // Инициализация игрового поля пустыми
    private static void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = EMPTY_CELL;
            }
        }
    }

    // Вывод игрового поля на экран
    private static void printBoard() {
        StringBuilder sb = new StringBuilder();
        sb.append("---------\n");
        for (int i = 0; i < SIZE; i++) {
            sb.append("|");
            for (int j = 0; j < SIZE; j++) {
                sb.append(board[i][j]);
                sb.append("|");
            }
            sb.append("\n");
            sb.append("---------\n");
        }
        System.out.println(sb.toString());
    }

    // Ход игрока
    private static void makeMove() {
        Scanner scanner = new Scanner(System.in);
        int row, col;
        do {
            System.out.print("Игрок '" + currentPlayer + "', введите номер строки (0-" + (SIZE - 1) + "): ");
            row = scanner.nextInt();
            System.out.print("Игрок '" + currentPlayer + "', введите номер столбца (0-" + (SIZE - 1) + "): ");
            col = scanner.nextInt();
        } while (!isValidMove(row, col));
        board[row][col] = currentPlayer;
    }

    // Проверка валидности хода
    private static boolean isValidMove(int row, int col) {
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
            System.out.println("Неверные координаты!");
            return false;
        } else if (board[row][col] != EMPTY_CELL) {
            System.out.println("Выбранная ячейка уже занята!");
            return false;
        }
        return true;
    }

    // Смена игрока
    private static void switchPlayer() {
        currentPlayer = (currentPlayer == CROSS) ? NOUGHT : CROSS;
    }

    // Проверка окончания игры
    private static boolean isGameFinished() {
        return isFull() || isWinner(CROSS) || isWinner(NOUGHT);
    }

    // Проверка победителя
    private static boolean isWinner(char player) {
        for (int i = 0; i < SIZE; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true; // Горизонтальная линия
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true; // Вертикальная линия
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true; // Главная диагональ
        }
        return board[2][0] == player && board[1][1] == player && board[0][2] == player; // Побочная диагональ
// Нет победителя
    }

    // Проверка заполненности игрового поля
    private static boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == EMPTY_CELL) {
                    return false;
                }
            }
        }
        return true;
    }
}



//    В данной реализации мы используем класс StringBuilder для формирования игрового поля перед каждым
//    его выводом на экран. Программа сначала инициализирует игровое поле символами пустых ячеек (EMPTY_CELL).
//    Затем в цикле выводится текущее состояние поля. После каждого хода игрока проверяется, завершена ли игра
//    (isGameFinished()) и есть ли победитель (isWinner()). Если игра завершена, выводится соответствующее сообщение.
//    Если есть победитель, выводится сообщение о его победе.
