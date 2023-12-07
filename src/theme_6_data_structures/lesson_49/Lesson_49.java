package theme_6_data_structures.lesson_49;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class Lesson_49 {
    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(3);
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet);

        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(1);
        linkedHashSet.add(3);
        linkedHashSet.add(1);
        linkedHashSet.add(2);
        System.out.println(linkedHashSet);
    }
}
