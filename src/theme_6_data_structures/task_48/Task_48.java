package theme_6_data_structures.task_48;

import java.util.PriorityQueue;

public class Task_48 {
    public static void main(String[] args) {
//  Напишите свой компаратор для типа Customer и используйте его в коде из урока.
        PriorityQueue<Customer> queue = new PriorityQueue<>(new CustomerComparator());
        queue.add(new Customer("Ivan Ivanov", 8));
        queue.add(new Customer("Petr Ivanov", 5));
        queue.add(new Customer("Sergey Ivanov", 6));
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
