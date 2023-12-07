package theme_6_data_structures.task_46;

import java.util.ArrayList;
import java.util.LinkedList;

public class Task_46 {
    public static void main(String[] args) {
//   1. Как реализуется Array List?
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("one");
        arrayList.add("two");
        arrayList.add("three");
        System.out.println(arrayList);
        arrayList.remove(0);
        arrayList.add("four");
        arrayList.remove("two");
        System.out.println(arrayList);
//   2. Как реализуется Linked List?
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("one");
        linkedList.add("two");
        linkedList.addFirst("null");
        linkedList.addLast("three");
        System.out.println(linkedList);
        linkedList.removeFirst();
        linkedList.removeLast();
        System.out.println(linkedList);
//   3. Сравните их реализации
    }
}
