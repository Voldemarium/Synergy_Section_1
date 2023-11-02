package theme_3_OOP.task_18;

import java.util.Arrays;

public class Task_18 {
    public static void main(String[] args) {
//  1.Напишите метод, который возвращает наибольшее из двух целых чисел
        int x1 = 5;
        int y1 = 8;
        int max1 = maxOfTwoInteger(x1, y1);
        System.out.println(max1);
//  2.Напишите метод, который возвращает наибольшее из двух дробных чисел
        double x2 = 5.5;
        double y2 = 8.6;
        double max2 = maxOfTwoDouble(x2, y2);
        System.out.println(max2);
//  3. Напишите метод, который возвращает самую длинную из трех строк
        String str1 = "I want to eat";
        String str2 = "I will go to work";
        String str3 = "I came home from work";
        String maxOfThreeLine = findMaxOfThreeLine(str1, str2, str3);
        System.out.println("maxOfThreeLine: " + maxOfThreeLine);
// 4. Из четырёх
        String str4 = "Will we work at seven p.m.?";
        String maxOfFourLine = findMaxOfFourLine(str1, str2, str3, str4);
        System.out.println("maxOfFourLine: " + maxOfFourLine);
//  5. Из пяти.
        String str5 = "I will be a programmer";
        String maxOfFiveLine = findMaxOfFiveLine(str1, str2, str3, str4, str5);
        System.out.println("maxOfFiveLine: " + maxOfFiveLine);
//  6. Напишите метод, который возвращает входящую строку, делая ее ЗаБоРчИкОм
        String str = "Working";
        String newStr = toUpperToLowerLine(str);
        System.out.println(newStr);
//  7. Напишите метод, который возвращает наибольший элемент массива
        int[] arrayInt1 = new int[]{-3, 5, -8, 10, 1, -4, 6};
        int max = findMaxNumberOfArray(arrayInt1);
        System.out.println("max of array = " + max);
//  8. Напишите метод, который принимает три массива, а возвращает массив, сумма элементов которого самая большая
        int[] arrayInt2 = new int[]{3, 4, 8, 2, 1, 4, 6};
        int[] arrayInt3 = new int[]{3, 2, 8, 10, 4, 42, -4};
        int[] arrayWithMaxSum = findArrayWithMaxSum(arrayInt1, arrayInt2, arrayInt3);
        System.out.println(Arrays.toString(arrayWithMaxSum));
//  9. Напишите метод, который принимает массив чисел, а возвращает исходный массив, но без отрицательных чисел
       int[] positiveNumbers = arrayWithoutNegativeNumbers(arrayInt1);
        System.out.println(Arrays.toString(positiveNumbers));
    }

    //  Метод, который возвращает наибольшее из двух целых чисел
    static int maxOfTwoInteger(int x, int y) {
        int max;
        if (x > y) {
            max = x;
        } else {
            max = y;
        }
        return max;
    }

    //  Метод, который возвращает наибольшее из двух дробных чисел
    static double maxOfTwoDouble(double x, double y) {
        double max;
        if (x > y) {
            max = x;
        } else {
            max = y;
        }
        return max;
    }

    //  Метод, который возвращает самую длинную из трех строк
    static String findMaxOfThreeLine(String str1, String str2, String str3) {
        if (str1.length() > str2.length() && str1.length() > str3.length()) {
            return str1;
        } else if (str2.length() > str1.length() && str2.length() > str3.length()) {
            return str2;
        } else {
            return str3;
        }
    }

    //  Метод, который возвращает самую длинную из четырех строк
    static String findMaxOfFourLine(String str1, String str2, String str3, String str4) {
        if (str1.length() > str2.length() && str1.length() > str3.length() && str1.length() > str4.length()) {
            return str1;
        } else if (str2.length() > str1.length() && str2.length() > str3.length() && str2.length() > str4.length()) {
            return str2;
        } else if (str3.length() > str1.length() && str3.length() > str2.length() && str3.length() > str4.length()) {
            return str3;
        } else {
            return str4;
        }
    }

    //  Метод, который возвращает самую длинную из пяти строк
    static String findMaxOfFiveLine(String str1, String str2, String str3, String str4, String str5) {
        if (str1.length() > str2.length() && str1.length() > str3.length()
                && str1.length() > str4.length() && str1.length() > str5.length()) {
            return str1;
        } else if (str2.length() > str1.length() && str2.length() > str3.length()
                && str2.length() > str4.length() && str2.length() > str5.length()) {
            return str2;
        } else if (str3.length() > str1.length() && str3.length() > str2.length()
                && str3.length() > str4.length() && str3.length() > str5.length()) {
            return str3;
        } else if (str4.length() > str1.length() && str4.length() > str2.length()
                && str4.length() > str3.length() && str4.length() > str5.length()) {
            return str4;
        } else {
            return str5;
        }
    }

    //  Метод возвращает входящую строку, делая ее ЗаБоРчИкОм
    static String toUpperToLowerLine(String str) {
//        String str ="Working";
        char[] chars = str.toCharArray();
        int size = chars.length;
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                chars[i] = Character.toUpperCase(chars[i]);
            } else {
                chars[i] = Character.toLowerCase(chars[i]);
            }
        }
        return new String(chars);
    }

    //    Метод возвращает наибольший элемент массива
    static int findMaxNumberOfArray(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int j : array) {
            if (j > max) {
                max = j;
            }
        }
        return max;
    }

//  Метод принимает три массива, а возвращает массив, сумма элементов которого самая большая
    static int[] findArrayWithMaxSum(int[] array1, int[] array2, int[] array3) {
        int sumArray1 = 0;
        for (int j : array1) {
            sumArray1 += j;
        }
        int sumArray2 = 0;
        for (int i = 0; i < array2.length; i++) {
            sumArray2 += array1[i];
        }
        int sumArray3 = 0;
        for (int i = 0; i < array3.length; i++) {
            sumArray3 += array1[i];
        }
        if (sumArray1 > sumArray2 && sumArray1 > sumArray3) {
            return array1;
        } else if (sumArray2 > sumArray1 && sumArray2 > sumArray3) {
            return array2;
        } else {
            return array3;
        }
    }
   // метод принимает массив чисел, а возвращает исходный массив, но без отрицательных чисел
    static int[] arrayWithoutNegativeNumbers(int[] array) {
        int countPositiveNumbers = 0;
        for (int k : array) {
            if (k >= 0) {
                countPositiveNumbers++;
            }
        }
        int[] positiveNumbers = new int[countPositiveNumbers];
        int j = 0;
        for (int k : array) {
            if (k >= 0) {
                positiveNumbers[j] = k;
                j++;
            }
        }
        return positiveNumbers;
    }
}


