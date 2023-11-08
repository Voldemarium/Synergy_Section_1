package theme_4_inheritance.task_30;

public class Administrator extends User {
    int workExperience;

    public Administrator(String firstName, String lastName, int age, int workExperience) {
        super(firstName, lastName, age);
        this.workExperience = workExperience;
    }

    void printWorkExperience() {
        System.out.println("work experience - " + workExperience);
    }

    User getParent() {
        return new User(this.firstName, this.lastName, this.age);
    }
}
