package theme_6_data_structures.lesson_47;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.name.length() - p2.name.length();
    }
}
