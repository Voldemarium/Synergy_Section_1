package theme_6_data_structures.lesson_46;

import java.util.*;

public class Lesson_46 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList<>();
        LinkedList linkedList = new LinkedList<>();
        long arrayInsertTime = getInsertTimeMs(arrayList);
        long linkedInsertTime = getInsertTimeMs(linkedList);
        System.out.println(arrayInsertTime);
        System.out.println(linkedInsertTime);
    }

    public static void insert(List list) {
        for (int i = 0; i < 100000; i++) {
            list.add(0, new Object());
        }
    }

    public static long getInsertTimeMs(List list) {
        Date startTime = new Date();
        insert(list);
        Date endTime = new Date();
        return endTime.getTime() - startTime.getTime();
    }
}
