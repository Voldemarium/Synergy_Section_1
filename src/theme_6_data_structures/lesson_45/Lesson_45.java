package theme_6_data_structures.lesson_45;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Lesson_45 {
    public static void main(String[] args) {
//   В консоль вводится по одному числу.
//   Каждое число добавляется в список
//   Программа выводит отсортированные по возрастанию числа обратно в консоль
        ArrayList<Integer> numbers = new ArrayList<>();

        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Enter number int: ");
            numbers.add(in.nextInt());
//          Collections.sort(numbersList);
//          numbers.sort(null);
            numbers.sort(Comparator.comparingInt(i->i));
            System.out.println(numbers);
        }




    }
}
