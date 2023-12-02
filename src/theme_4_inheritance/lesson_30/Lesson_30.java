package theme_4_inheritance.lesson_30;

import java.io.IOException;

public class Lesson_30 {
    public static void main(String[] args) {
//        ITunesMoviePlayer player = new ITunesMoviePlayer();
//        try {
//            player.playMovie("This is the road to hell");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        ItunesPreviewPlayer player = new ItunesPreviewPlayer();
        try {
            player.play("Terminator");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
