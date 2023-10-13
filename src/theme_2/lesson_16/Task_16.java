package theme_2.lesson_16;

import java.util.Scanner;

public class Task_16 {
    public static void main(String[] args) {
//   1. Пользователь вводит пять строк. Выведите слово, состоящие из первой буквы каждый строки
        Scanner scanner = new Scanner(System.in);
        char[] charsWords = new char[5];
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter line " + (i + 1) + ":");
            String str = scanner.nextLine();
            charsWords[i]= str.charAt(0);
        }
        String word = new String(charsWords);
        System.out.println(word);
//  2. Посчитайте количество нулей в числе
        int x = 100;
        String xStr = String.valueOf(100);
        int sumNull = 0;
        for (int i = 0; i < xStr.length(); i++) {
            if (xStr.charAt(i) == '0') {
                sumNull++;
            }
        }
        System.out.println("sumNull = " + sumNull);
//  3. Найдите первую гласную букву в слове
        String str = "success";
        char firstVowel = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' ||
                    str.charAt(i) == 'o' || str.charAt(i) == 'u' || str.charAt(i) == 'y') {
                firstVowel = str.charAt(i);
                break;
            }
        }
        System.out.println("firstVowel: " + firstVowel);
//  4. Посчитайте количество согласных букв в слове
        int sumConsonants = 0;
        for (int i = 0; i < str.length(); i++) {
            if (!(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' ||
                    str.charAt(i) == 'o' || str.charAt(i) == 'u' || str.charAt(i) == 'y')) {
                sumConsonants++;
            }
        }
        System.out.println("sumConsonants = " + sumConsonants);
//  5. Выведите слово наоборот, при этом столбиком
        for (int i = str.length() - 1; i >= 0; i--) {
            System.out.println(str.charAt(i));
        }
//  6. Замените все гласные в слове на ‘у’
        char[] chars = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' ||
                    str.charAt(i) == 'o' || str.charAt(i) == 'u') {
                chars[i] = 'y';
            }
        }
        String newStr = new String(chars);
        System.out.println(newStr);
//    7. Пользователь вводит дробное число, выведите его дробную часть
        System.out.println("Enter fractional number: ");
        double y = scanner.nextDouble();
        String strY = String.valueOf(y);
        int dotIndex = 0;
        int i = 0;
        while (i < strY.length() && dotIndex == 0) {
            if (strY.charAt(i) == '.') {
                dotIndex = i;
            }
            i++;
        }

        char[] fractPart = new char[strY.length() - dotIndex - 1];
        for (int j = dotIndex + 1; j < strY.length(); j++) {
            fractPart[j - dotIndex - 1] = strY.charAt(j);
        }
        String fractPartStr = new String(fractPart);
        System.out.println("fractional part: " + fractPartStr);
//   8. Пользователь вводит предложение. Замените в каждом слове этого предложения, последн** д** бук** на **
        System.out.println("Enter sentence: ");
        scanner.nextLine();
        String line = scanner.nextLine();
        char[] charsOfLine = line.toCharArray();
        for (int j = 0; j < charsOfLine.length; j++) {
            char ch = line.charAt(j);
            if (!((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || ch == '-')) {
                charsOfLine[j - 1] = '*';
                if (j - 2 >= 0) {
                    charsOfLine[j - 2] = '*';
                }
            }
        }
        String newLine = new String(charsOfLine);
        System.out.println(newLine);
    }
}
