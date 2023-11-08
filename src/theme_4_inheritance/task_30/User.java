package theme_4_inheritance.task_30;

public class User {
    String firstName;
    String lastName;
    int age;

    public User(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public static void printNameUser(User user){
        System.out.println(user.firstName + " " + user.lastName);
    }
}
