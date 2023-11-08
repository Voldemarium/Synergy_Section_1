package theme_4_inheritance.task_29;

public class Character {
    String firstName;
    String lastName;
    int age;

    public Character(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    void printInfo() {
        System.out.println(this.firstName + " " + this.lastName + ", " + age + " years");
    }
}
