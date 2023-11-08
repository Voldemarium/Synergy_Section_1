package theme_4_inheritance.task_29;

public class MainCharacter extends Character {
    int rating;

    public MainCharacter(String firstName, String lastName, int age, int rating) {
        super(firstName, lastName, age);
        this.rating = rating;
    }
}
