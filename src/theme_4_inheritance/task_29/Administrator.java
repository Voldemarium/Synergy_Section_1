package theme_4_inheritance.task_29;

public class Administrator extends User {
    int workExperience;

    public Administrator(String firstName, String lastName, int age, int workExperience) {
        super(firstName, lastName, age);
        this.workExperience = workExperience;
    }

    void printWorkExperience() {
        System.out.println("work experience - " + workExperience);
    }
}
