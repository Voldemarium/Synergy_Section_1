package theme_3_OOP.task_24;

import java.util.Arrays;

public class Task_24 {
    public static void main(String[] args) {
//  1. Реализуйте методы, max(x,y) - для целых, вещественных чисел, и для строк (в случае строк-возвращает самую длинную)
        System.out.println(max(5,6));
        System.out.println(max("one","three"));

//  2. Реализуйте методы and(boolean x, boolean y), and(boolean x, int y), and(int x, boolean y),
    // который будет возвращать логическое И. Целые числа равные 0 трактовать как false, остальные true.
        System.out.println(and(true, true));
        System.out.println(and(true, 0));
        System.out.println(and(0, true));
        System.out.println(and(3, true));
//  3. Реализуйте методы join(String s1, String s2), join(String s1, String s2, String s3),
    //..join(String s1, String s2, String s3, String s4) - которые склеивают строки
        System.out.println(join("one", "two"));
        System.out.println(join("one", "owo", "three"));
        System.out.println(join("one", "two", "three", "four"));
//  4. Реализуйте методы merge(int[]array1, int[]array2), merge(int[] array1, int[]array2, int[] array3),
    // merge(int[] array1, int[] array2, int[] array3, int[] array4) - который возвращает новый массив, в котором он
    // соединяет все предыдущие (было 3 массива по 10 элементов, станет массив с 30 элементами
        int[] array1 = new int[] {-1, 0, 1, 2, 3, 4};
        int[] array2 = new int[] {5, 6, 7, 8, 9, 10};
        int[] array3 = new int[] {11, 12, 13, 14};
        int[] array4 = new int[] {15, 16, 17, 18, 19, 20};
        int[] newArray1 = merge(array1, array2);
        System.out.println(Arrays.toString(newArray1));
        int[] newArray2 = merge(array1, array2, array3);
        System.out.println(Arrays.toString(newArray2));
        int[] newArray3 = merge(array1, array2, array3, array4);
        System.out.println(Arrays.toString(newArray3));

    }
    static int max(int x, int y) {
        return Math.max(x, y);
    }
    static String max(String x, String y) {
        if (x.length() > y.length()){
            return x;
        } else {
            return y;
        }
    }

    static boolean and(boolean x, boolean y) {
      return x & y;
    }
    static boolean and(boolean x, int y) {
        boolean yBoolean = y != 0;
        return x & yBoolean;
    }
    static boolean and(int x, boolean y) {
        boolean xBoolean = x != 0;
        return xBoolean & y;
    }

    static String join(String s1, String s2) {
        return s1 + s2;
    }
    static String join(String s1, String s2, String s3) {
        return s1 + s2 + s3;
    }
    static String join(String s1, String s2, String s3, String s4) {
        return s1 + s2 + s3 + s4;
    }

    static int[] merge(int[]array1, int[]array2) {
        int[] newArray = new int[array1.length + array2.length];
        System.arraycopy(array1, 0, newArray, 0, array1.length);
        System.arraycopy(array2, 0, newArray, array1.length, array2.length);
        return newArray;
    }

    static int[] merge(int[]array1, int[]array2, int[]array3) {
        int[] newArray = new int[array1.length + array2.length + array3.length];
        System.arraycopy(array1, 0, newArray, 0, array1.length);
        System.arraycopy(array2, 0, newArray, array1.length, array2.length);
        System.arraycopy(array3, 0, newArray, array1.length + array2.length, array3.length);
        return newArray;
    }

    static int[] merge(int[]array1, int[]array2, int[]array3, int[]array4) {
        int[] newArray = new int[array1.length + array2.length + array3.length + array4.length];
        System.arraycopy(array1, 0, newArray, 0, array1.length);
        System.arraycopy(array2, 0, newArray, array1.length, array2.length);
        System.arraycopy(array3, 0, newArray, array1.length + array2.length, array3.length);
        System.arraycopy(array4, 0, newArray, array1.length + array2.length + array3.length, array4.length);
        return newArray;
    }

}
