package theme_3_OOP.lesson_26;

public class  FieldX0 {
    char[][] field;
    int size = 9;
    int minCountToWin = 5; //минимум знаков для победы

    //Заполняем массив пробелами
    void initField() {
        this.field = new char[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                field[row][col] = ' ';
            }
        }
        System.out.println("Field initialized");
        this.printField();
    }

    // Выводим игровое поле в консоль
    void printField() {
        System.out.print("   ");
        for (int i = 1; i <= size; i++) {
            System.out.print(i + "  "); //выводим номера столбцов
        }
        System.out.println();
        for (int row = 0; row < size; row++) {
            int rowNumber = row + 1;
            System.out.print(rowNumber + " ");  //выводим номера строк
            for (int col = 0; col < size; col++) {
                System.out.print("[" + this.field[row][col] + "]");
            }
            System.out.println();
        }
    }

    //Метод для распознавания, свободна ли ячейка
    boolean isPlaceFree(int rowIndex, int colIndex) {
        if (rowIndex < 0 || rowIndex >= size || colIndex < 0 || colIndex >= size) {
            return false;
        }
            return this.field[rowIndex][colIndex] == ' ';
        }

    void setValue(int rowIndex, int colIndex, char value) {
        this.field[rowIndex][colIndex] = value;
    }

    boolean isGameOver(char player) {
        for (int row=0; row < this.size; row++) {
            for (int col=0; col < this.size; col++) {
                if (checkRightDirection(row, col, player)) {
                    return true;
                } else if (checkDownDirection(row, col, player)) {
                    return true;
                } else if (checkRightDiagonal(row, col, player)) {
                    return true;
                } else if (checkLeftDiagonal(row, col, player)) {
                    return true;
                }
            }
        }
        return false;
    }
    //Проверяем строки - если справа от текущей ячейки достаточное для победы кол-во ячеек и аналогично заполненные ячейки
    boolean checkRightDirection(int row, int col, char player) {
        if (col > this.size - this.minCountToWin) {
            return false;
        }
        for (int i = col; i < col + this.minCountToWin; i++) {
            if (this.field[row][i] != player) {
                return false;
            }
        }
        return true;
    }
    //Проверяем столбцы - есть снизу от текущей ячейки достаточное для победы кол-во ячеек и аналогично заполненные ячейки
    boolean checkDownDirection(int row, int col, char player) {
        if (row > this.size - this.minCountToWin) {
            return false;
        }
        for (int i = row; i < row + this.minCountToWin; i++) {
            if (this.field[i][col] != player) {
                return false;
            }
        }
        return true;
    }
    boolean checkRightDiagonal(int row, int col, char player) {
        if (row > this.size - this.minCountToWin) {
            return false;
        }
        if (col > this.size - this.minCountToWin) {
            return false;
        }
        for (int shift = 0; shift < this.minCountToWin; shift++) {
            int rowToCheck = row + shift;
            int colToCheck = col + shift;
            if (this.field[rowToCheck][colToCheck] != player) {
                return false;
            }
        }
        return true;
    }
    boolean checkLeftDiagonal(int row, int col, char player) {
        if (row > this.size - this.minCountToWin) {
            return false;
        }
        if (col < this.minCountToWin - 1) {
            return false;
        }
        for (int shift = 0; shift < this.minCountToWin; shift++) {
            int rowToCheck = row + shift;
            int colToCheck = col - shift;
            if (this.field[rowToCheck][colToCheck] != player) {
                return false;
            }
        }
        return true;
    }
}
