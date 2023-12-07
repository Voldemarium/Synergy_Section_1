package theme_6_data_structures.task_50;

import java.util.Comparator;
import java.util.TreeSet;

public class Task_50 {
    public static void main(String[] args) {
//  Вам нужно реализовать класс, создать сет студентов и попробуйте его поместить в TreeSet
        // Способ 1 - сортировка по именам через Comparator
        TreeSet<Student> treeSet1 = new TreeSet<>(Comparator.comparing(student -> student.name));
        treeSet1.add(new Student("Ivan Ivanov", 2));
        treeSet1.add(new Student("Petr Kozlov", 4));
        treeSet1.add(new Student("Ivan Sokolov", 3));
        System.out.println(treeSet1);
        // Способ 2 (implements Comparable<Student> - сортировка по грейду)
        TreeSet<Student> treeSet2 = new TreeSet<>();
        treeSet2.add(new Student("Ivan Ivanov", 2));
        treeSet2.add(new Student("Petr Kozlov", 4));
        treeSet2.add(new Student("Ivan Sokolov", 3));
        System.out.println(treeSet2);
    }
}
