package theme_6_data_structures.lesson_47;

import java.util.ArrayList;

public class Lesson_47 {
    public static void main(String[] args) {
        ArrayList<Person> arrayList = new ArrayList<>();

        Person p1 = new Person("Ivan");
        Person p2 = new Person("Michael");

        arrayList.add(p1);
        arrayList.add(p2);
        arrayList.sort(new PersonComparator());
        System.out.println(arrayList);

    }
}
