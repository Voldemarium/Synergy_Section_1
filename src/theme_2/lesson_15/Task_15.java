package theme_2.lesson_15;

import java.util.Arrays;
import java.util.Scanner;

public class Task_15 {
    public static void main(String[] args) {
//  1. Создайте final массив чисел. Увеличьте каждый его элемент вдвое.
        final int[] a = new int[]{1, 2, 3, 4, 5};
        for (int i = 0; i < a.length; i++) {
            a[i] *= 2;
        }
        System.out.println(Arrays.toString(a));

//  2. Найдите наибольшее число из трех, используя только final-переменные.
        final int x = 4;
        final int y = 7;
        final int z = 3;
        final int max;
        if (x > y && x > z) {
            max = x;
        } else if (y > x && y > z) {
            max = y;
        } else {
            max = z;
        }
        System.out.println("max = " + max);
//  3. Измените final переменную. Получилось?
//      Не получилось - ошибка при компиляции - Cannot assign a value to final variable 'x'

//  4. Пользователь вводит слово, подсчитайте количество уникальных букв в этом слове.
        //  (Повторяющиеся считаем за одну, в слове окно - три уникальные буквы, окн).
        //  Используйте только final-переменные. Подсказка: используйте массив.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter word: ");
        final String word = scanner.next();
        final int[] countLettersInWord = new int[1];

        final boolean[] visitedLetters = new boolean[2000];
        for (int i = 0; i < word.length(); i++) {
            final char currentLetter = word.charAt(i);
            if (!visitedLetters[currentLetter]) {
                visitedLetters[currentLetter] = true;
                countLettersInWord[0]++;
            }
        }
        System.out.println(countLettersInWord[0]);


    }
}
