package theme_3_OOP.task_26;

import java.util.Arrays;
import java.util.Scanner;

public class SnakeGame {
    static  final int SIZE = 20; // Размер игрового поля
    Snake snake = new Snake();
    Fruit fruit = new Fruit();
    Wall wall = new Wall();
    Scanner scanner = new Scanner(System.in);

    public void startPlay() {
        init();
        printBoard();

        while (!isEndGame()) {
            makeMove();
            if (isWall() || isSnake()) {
                System.out.println("Game over!");
                break;
            }
            printBoard();
        }
    }

    private void init() {
        initPositionOfTheSnake();
        initPositionOfTWall();
        initPositionOfFruit();
    }

    private boolean isEndGame() {
        if (isWin()) {
            System.out.println("You are win!!!");
        }
        return isWall() || isWin() || isSnake();
    }

    private boolean isWall() {
        boolean isWall = snake.array[0][0] < 0 || snake.array[0][1] < 0 || snake.array[0][0] > SIZE - 1 || snake.array[0][1] > SIZE - 1;
        for (int[] ints : wall.array) {
            if (Arrays.equals(snake.array[0], ints)) {
                isWall = true;
                System.out.println("Wall!!!");
                break;
            }
        }
        return isWall;
    }

    private boolean isWin() {
        return snake.currentLength == snake.startLength + Fruit.amount;
    }

    private void initPositionOfTheSnake() {
        int startRow = SIZE / 2 - 1;
        int j = snake.startLength - 1;
        for (int i = 0; i < snake.startLength; i++) {
            snake.array[i] = new int[]{startRow, j};
            j--;
        }
    }

    private void initPositionOfTWall() {
        int startCol = SIZE / 2 - 1;
        for (int i = 0; i < wall.array.length; i++) {
            wall.array[i] = new int[]{i, startCol};
        }
    }

    private void initPositionOfFruit() {
        for (int i = 0; i < Fruit.amount; i++) {
            int row = (int) (Math.random() * SIZE);
            int col = (int) (Math.random() * SIZE);
            if (!checkCoordinateFruit(i, row, col)) {
                i--;
            } else {
                fruit.array[i] = new int[]{row, col};
            }
        }
    }

    private boolean checkCoordinateFruit(int i, int row, int col) {
        boolean check = true;
        for (int j = 0; j < i; j++) {
            if (fruit.array[j][0] == row && fruit.array[j][1] == col) { // если координаты совпадали с координатами других фруктов
                check = false;
                break;
            }
        }
        for (int j = 0; j < snake.startLength; j++) {
            if (snake.array[j][0] == row && snake.array[j][1] == col) {  // если координаты совпадали с координатами змейки
                check = false;
                break;
            }
        }
        for (int[] ints : wall.array) {
            if (ints[0] == row && ints[1] == col) {  // если координаты совпадали с координатами стен
                check = false;
                break;
            }
        }
        return check;
    }


    public void printBoard() {
        char[][] boardArray = new char[SIZE][SIZE];  //игровое поле в виде двумерного массива
        //заполняем игровое поле змейкой
        for (int i = 0; i < snake.currentLength; i++) {
            boardArray[snake.array[i][0]][snake.array[i][1]] = snake.symbol;
        }
        //заполняем игровое поле стенами
        for (int[] ints : wall.array) {
            boardArray[ints[0]][ints[1]] = wall.symbol;
        }
        //заполняем игровое поле фруктами
        for (int i = 0; i < Fruit.amount; i++) {
            if (fruit.array[i] != null) {
                boardArray[fruit.array[i][0]][fruit.array[i][1]] = fruit.symbol;
            }
        }

        System.out.print("    ");
        for (int i = 1; i <= SIZE; i++) {
            System.out.print(i + " ");      //выводим номера столбцов
            //выводим необходимое количество пробелов в зависимости от числа цифр в номере
            if (i <= 9) {
                System.out.print(" ");
            }
        }
        System.out.println();
        for (int row = 0; row < SIZE; row++) {
            int rowNumber = row + 1;
            System.out.print(rowNumber + " ");  //выводим номера строк
            if (row + 1 <= 9) {
                System.out.print(" ");
            }
            for (int col = 0; col < SIZE; col++) {
                System.out.print("[" + boardArray[row][col] + "]");
            }
            System.out.println();
        }
    }

    // Ход игрока
    private void makeMove() {
        System.out.println("Make a move: enter l = \"left\", r = \"right\" or s = \"straight\"");
        char move = scanner.next().charAt(0);

        //Сохраняем координаты положения змейки в массив
        int[][] lastSnake = getLastSnake();

        if (move == 'l' || move == 'r' || move == 's') {
            if (snake.array[0][0] == snake.array[1][0]) {     //если row головы и тела змейки равны (горизонтально)
                if (snake.array[0][1] > snake.array[1][1]) {  //если тело слева от головы
                    if (move == 'l') {
                            snake.array[0][0]--;

                    } else if (move == 'r') {
                        snake.array[0][0]++;
                    } else {
                        snake.array[0][1]++;
                    }
                } else {
                    if (move == 'l') {
                        snake.array[0][0]++;
                    } else if (move == 'r') {
                        snake.array[0][0]--;
                    } else {
                        snake.array[0][1]--;
                    }
                }
            } else {       //если col головы и тела змейки равны (вертикально)
                if (snake.array[0][0] < snake.array[1][0]) {  //если тело снизу от головы
                    if (move == 'l') {
                        snake.array[0][1]--;
                    } else if (move == 'r') {
                        snake.array[0][1]++;
                    } else {
                        snake.array[0][0]--;
                    }
                } else {
                    if (move == 'l') {
                        snake.array[0][1]++;
                    } else if (move == 'r') {
                        snake.array[0][1]--;
                    } else {
                        snake.array[0][0]++;
                    }
                }
            }
        } else {
            System.out.println("wrong symbol!");
            makeMove();
        }

//       if (isSnake()) {
//
//       }

        //передвижение тела и хвоста змейки за головой
        moveSnake(lastSnake);

        // Если сьели фрукт
        eatFruit(lastSnake);
    }

    private boolean isSnake() {
        boolean isSnake = false;
        for (int i = 2; i < snake.currentLength; i++) {
            if (Arrays.equals(snake.array[0], snake.array[i])) {
                System.out.println("Snake ran into itself!!!");
                isSnake = true;
                break;
            }
        }
        return isSnake;
    }

    private void moveSnake(int[][] lastSnake) {
        if (!Arrays.equals(snake.array[0], lastSnake[0])) {
            for (int i = 1; i < snake.currentLength; i++) {
                snake.array[i] = lastSnake[i - 1].clone();
            }
        }
    }

    private void eatFruit(int[][] lastSnake) {
        for (int i = 0; i < Fruit.amount; i++) {
            if (fruit.array[i] != null && snake.array[0][0] == fruit.array[i][0] && snake.array[0][1] == fruit.array[i][1]) {
                snake.array[snake.currentLength] = lastSnake[snake.currentLength - 1].clone();
                fruit.array[i] = null;
                snake.currentLength++;
            }
        }
    }

    private int[][] getLastSnake() {
        int[][] lastSnake = new int[snake.array.length][2];
        for (int i = 0; i < snake.array.length; i++) {
            lastSnake[i] = snake.array[i].clone();
        }
        return lastSnake;
    }

}
