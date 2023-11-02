package theme_3_OOP.lesson_24;

import java.io.IOException;
import java.util.Scanner;

public class Lesson_24 {
    public static void main(String[] args) throws IOException {
        ITunesMusicPlayer player = new ITunesMusicPlayer();
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Which song you are looking for?");
//        String searchRequest = scanner.nextLine();
//        player.playSong(searchRequest);
          player.playSong("love", 10);

    }
}
