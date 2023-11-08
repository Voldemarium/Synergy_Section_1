package theme_4_inheritance.lesson_32;


import java.util.Scanner;

public class Lesson_32 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        if (y == 0) {
            RuntimeException e = new RuntimeException("Incorrect input. Cannot divide by 0");
            throw e;

        }

        System.out.println(x / y);

//  ------------------------------------------------------------------------
        RandomMoviePicker moviePicker = new RandomMoviePicker();
        Movie[] movies = moviePicker.getRandomMovieNames();
        System.out.println("Chose film to watch: ");
        for (int i = 0; i < movies.length; i++) {
            int number = i + 1;
            System.out.println(number + ": " + movies[i].name + "(" + movies[i].year + ")");
        }
        System.out.println("Enter film number: ");
        scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int chosenIndex = number - 1;

    }
}
