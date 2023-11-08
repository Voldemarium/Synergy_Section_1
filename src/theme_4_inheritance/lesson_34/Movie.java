package theme_4_inheritance.lesson_34;

public class Movie {
    String name;
    String year;

    public Movie(String name, String year) {
        this.name = name;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
