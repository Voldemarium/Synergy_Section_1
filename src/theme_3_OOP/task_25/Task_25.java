package theme_3_OOP.task_25;

import java.util.Arrays;

public class Task_25 {
    public static void main(String[] args) {
//  1. Выведите таблицу умножения 1-9
        printMultiplicationTable(9);

//  2. Выведите таблицу умножения 1-20
        printMultiplicationTable(20);

//  3. Создайте двумерный массив, задайте для него значения, выведите его элементы.
        int[][] array = new int[2][3];
        array[0][0] = 1;
        array[0][1] = 2;
        array[0][2] = 3;
        array[1][0] = 4;
        array[1][1] = 5;
        array[1][2] = 6;
        for (int i = 0; i < 2; i++) {
            System.out.println(Arrays.toString(array[i]));
        }

//  4. Создайте двумерный массив. Выведите его предпоследнюю строчку
        char[][] chars = new char[3][4];
        char currentChar = 65;
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                chars[i][j] = currentChar;
                currentChar++;
            }
        }
        System.out.println(Arrays.toString(chars[chars.length - 2]));

//  5. Создайте двумерный массив. Выведите его первый столбец
        for (char[] rowArray : chars) {
            System.out.println(rowArray[0]);
        }

//  6. создайте матрицу(двумерный массив) int[][], заполните ее таблицей умножения 1-9. Выведите ее.
        int[][] multiplicationTable = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                multiplicationTable[i][j] = (i + 1) * (j + 1);
            }
        }
        for (int[] rowArray : multiplicationTable) {
            System.out.println(Arrays.toString(rowArray));
        }

//  7. Создайте матрицу int[][], заполните ее календарем на текущий месяц:
    //пн вт ср чт пт сб вс
    //1   2   3  4   5 6   7   8   9 10 11  12
    //Выведите ее.
        int[][] calendarOfMonth = new int[6][7];
        System.out.println("october 2023:");
        System.out.println(" пн вт ср чт пт сб вс");
        int day = 1;
        for (int i = 0; i < calendarOfMonth.length; i++) {
            for (int j = 0; j < calendarOfMonth[i].length; j++) {
                if ((!(i == 0 && j < 6)) &&  day <= 31) {
                    calendarOfMonth[i][j] = day;
                    day++;
                }
            }
        }
        for (int[] rowArray : calendarOfMonth) {
            System.out.println(Arrays.toString(rowArray));
        }

//  8.Создайте матрицу char[][], проинициализируйте ее латинским алфавитом, выведите его. Подсказка -
     //можно получить первую букву как char ch = ‘a’, следующую -как ch + 1, и так далее.
        char[][] englishAlphabet = new char[2][13];
        getFillingArrayOfChars(englishAlphabet, 'A', 'Z');
        printArrayOfChars(englishAlphabet);

//  9.Предыдущее задание, но с русским алфавитом.
        char[][] russianAlphabet = new char[4][8];
        getFillingArrayOfChars(russianAlphabet, 'А', 'Я');
        printArrayOfChars(russianAlphabet);

    }

    private static void printArrayOfChars(char[][] alphabet) {
        for (char[] rowArray : alphabet) {
            System.out.println(Arrays.toString(rowArray));
        }
    }


    private static void getFillingArrayOfChars(char[][] alphabet, char startChar, char endChar) {
        for (int i = 0; i < alphabet.length; i++) {
            for (int j = 0; j < alphabet[i].length; j++) {
                if (startChar <= endChar) {
                    alphabet[i][j] = startChar;
                    startChar++;
                } else {
                    break;
                }
            }
        }
    }

    private static void printMultiplicationTable(int size) {
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                int mult = i * j;
                System.out.print(mult);
                //выводим необходимое количество пробелов в зависимости от числа цифр (int)log10(mult)
                for (int k = 0; k < 3 - (int) Math.log10(mult); k++) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
