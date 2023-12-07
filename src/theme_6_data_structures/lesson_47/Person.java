package theme_6_data_structures.lesson_47;

public class Person implements Comparable<Person>{
    String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person person) {
        return this.name.length() - person.name.length();
    }
}
