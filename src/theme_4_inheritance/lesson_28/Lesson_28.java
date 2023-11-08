package theme_4_inheritance.lesson_28;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Lesson_28 {
    public static void main(String[] args) throws IOException {
//        ITunesMoviePlayer moviePlayer = new ITunesMoviePlayer();
//        moviePlayer.playMovie("Terminator");
        RandomMoviePicker moviePicker = new RandomMoviePicker();
        Movie[] movies = moviePicker.getRandomMovieNames();
        System.out.println("Chose film to watch: ");
        for (int i = 0; i < movies.length; i++) {
            int number = i + 1;
            System.out.println(number + ": " + movies[i].name + "(" + movies[i].year + ")");
        }
        System.out.println("Enter film number: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int chosenIndex = number -1;

        ITunesMoviePlayer moviePlayer = new ITunesMoviePlayer();
        moviePlayer.playMovie(movies[chosenIndex].name);
    }
}
