package theme_4_inheritance.task_29;

public class Moderator extends User {
     int rating;

    public Moderator(String firstName, String lastName, int age, int rating) {
        super(firstName, lastName, age);
        this.rating = rating;
    }

    void printRating() {
         System.out.println("rating - " + rating);
     }
}
