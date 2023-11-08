package theme_4_inheritance.lesson_34;

import utils.DownloadPage;

import java.io.IOException;

public class RandomMoviePicker {
    DownloadPage downloadPage = new DownloadPage();

    Movie[] getRandomMovieNames() {
        Movie[] movies = new Movie[5];

        String url = "https://randommer.io/random-moviesf";
        String page;
        try {
            page = downloadPage.downloadWebPage(url);
        } catch (IOException e) {
            Movie[] defaultMovies = new Movie[3];
            defaultMovies[0] = new Movie("The Terminator", "2003");
            defaultMovies[1] = new Movie("Alien", "1993");
            defaultMovies[2] = new Movie("Lier, lier", "2006");
            return defaultMovies;
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
            String year = movieName.substring(movieName.length() - 5, movieName.length() - 1);
            movies[i] = new Movie(nameWithoutYear, year);
        }
        if (moviesFound < 3) {
            throw new TooFewMoviesFoundException(moviesFound);
        }

        return movies;
    }
}
