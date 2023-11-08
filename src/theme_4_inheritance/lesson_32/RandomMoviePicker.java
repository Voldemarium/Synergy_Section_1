package theme_4_inheritance.lesson_32;

import utils.DownloadPage;

import java.io.IOException;

public class RandomMoviePicker {
    DownloadPage downloadPage = new DownloadPage();

    Movie[] getRandomMovieNames() {
        Movie[] movies = new Movie[5];

        String url = "https://randommer.io/random-movies";
        String page = null;
        try {
            page = downloadPage.downloadWebPage(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int endIndex = 0;
        int moviesFound = 0;
        for (int i = 0; i < movies.length; i++) {
            int captionIndex = page.indexOf("<div class=\"caption\">", endIndex);
            if (captionIndex == -1 && i == 0) {
//                throw new RuntimeException("Random movie not found. Something wrong with " + url + "?");
                throw new RandomMovieNotFoundException();
            } else {
                moviesFound++;
            }

            int startIndex = captionIndex + 52;
            endIndex = page.indexOf("</p>", startIndex);
            String movieName = page.substring(startIndex, endIndex);
            String nameWithoutYear = movieName.substring(0, movieName.length() - 7);
            String year = movieName.substring(movieName.length() - 5, movieName.length() -1);
            movies[i] = new Movie(nameWithoutYear, year);
        }
        if (moviesFound < 3) {
            throw new  TooFewMoviesFoundException(moviesFound);
        }

        return movies;
    }
}
