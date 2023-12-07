package theme_6_data_structures.lesson_48;

import java.util.PriorityQueue;

public class Lesson_48 {
    public static void main(String[] args) {
        PriorityQueue<Integer> queueInt = new PriorityQueue<>();
        queueInt.add(3);
        queueInt.add(5);
        queueInt.add(1);
        queueInt.add(8);
        while (!queueInt.isEmpty()) {
            System.out.println(queueInt.poll());
        }
        System.out.println(queueInt);

//  ============================================================
        PriorityQueue<Customer> queue = new PriorityQueue<>();
        queue.add(new Customer("Ivan Ivanov", 8));
        queue.add(new Customer("Petr Ivanov", 5));
        queue.add(new Customer("Sergey Ivanov", 6));
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
        System.out.println(queue);
    }
}
