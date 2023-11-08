package theme_4_inheritance.task_29;

public class User {
    String firstName;
    String lastName;
    int age;

    public User(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    void printInfoUser(){
        System.out.println(firstName + " " + lastName + ", age: " + age);
    }
}
