package theme_6_data_structures.task_47;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Task_47 {
    public static void main(String[] args) {
//        Нужно отсортировать случайный список чисел.
//Числа нужно отсортировать следующим образом: Четные идут в начале по возрастанию, нечетные по убыванию в конце списка
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            int number = new Random().nextInt(20) + 1;
            numbers.add(number);
        }
        System.out.println(numbers);

        numbers.sort(new NumbersComparator());
        System.out.println(numbers);
    }
}
