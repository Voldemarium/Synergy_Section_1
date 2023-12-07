package theme_6_data_structures.lesson_52;

public class Person implements Comparable<Person>{
    String name;
    int grade;

    public Person(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }

    @Override
    public int compareTo(Person p) {
        return this.name.compareTo(p.name);
//        return p.grade - this.grade;
    }
}
