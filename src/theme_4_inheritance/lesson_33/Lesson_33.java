package theme_4_inheritance.lesson_33;

import utils.DownloadPage;

import java.io.IOException;
import java.util.Scanner;

public class Lesson_33 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Input digit:");
            char ch = scanner.next().charAt(0);
            if (!Character.isDigit(ch)) {
                throw new RuntimeException("this is not digit");
            }
            int num = ch - 48;
            System.out.println("squared is " + num * num);
        } catch (RuntimeException e) {
            System.out.println("there is some error!!!");
            System.out.println(e.getMessage());
        }
        System.out.println("it's done");

//          Получение данных c ЦБ РФ, используя XML (динамики котировок доллара США:)
        DownloadPage downloadPage = new DownloadPage();
        String page = "";
        try {
            String url = "https://www.cbr.ru/scripts/XML_dynamic.asp?date_req1=28/09/2023&date_req2=29/09/2023&VAL_NM_RQ=R01235";
            page = downloadPage.downloadWebPage(url);
        } catch (Exception exception) {
//            System.out.println("There is some error! " + exception.getMessage());
            throw new CbrNotAvailableException(exception);
        }

        // Последняя котировка на странице 1;
        int startIndex = page.lastIndexOf("<Value>") + 7;
        int endIndex = page.lastIndexOf("</Value>");
        String courseStr = page.substring(startIndex, endIndex);
        double course = Double.parseDouble(courseStr.replace(',', '.'));
        System.out.println(course);

// -----------------------------------------------------------------
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
        ITunesMoviePlayer moviePlayer = new ITunesMoviePlayer();
        moviePlayer.playMovie(movies[chosenIndex].name);

//  -----------------------------------------------------------------------
        try {
            twoWords();
        } catch (WrongWordsCountException e) {
            if (e.wordsCount > 2) {
                System.out.println("too many words");
            } else {
                System.out.println("too few words");
            }
        }
    }

    static void twoWords() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter 2 words: ");
        String line = scanner.nextLine();
        String[] words = line.split(" ");
        if (words.length != 2) {
            throw new WrongWordsCountException(words.length);
        }
        System.out.println(words[1] + "-" + words[0]);
        int lettersCount = words[1].length() + words[0].length();
        System.out.println("sum of letters: " + lettersCount);
    }
}
