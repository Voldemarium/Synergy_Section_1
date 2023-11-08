package theme_4_inheritance.lesson_34;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Lesson_34 {
    public static void main(String[] args) throws IOException {
        try {
            twoWords();
        } catch (WrongWordsCountException e) {
            if (e.wordsCount > 2) {
                System.out.println("too many words");
            } else {
                System.out.println("too few words");
            }
        } finally {
            System.out.println("this is finally block");
        }

//  ---------------------------------------------------------------------------
//Scanner scanner = new Scanner(System.in);
        RandomMoviePicker moviePicker = new RandomMoviePicker();
        Movie[] movies = moviePicker.getRandomMovieNames();
        System.out.println("Chose film to watch: ");
        for (int i = 0; i < movies.length; i++) {
            int number = i + 1;
            System.out.println(number + ": " + movies[i].name + "(" + movies[i].year + ")");
        }

        Scanner scanner = new Scanner(System.in);
        BufferedWriter writer = new BufferedWriter(new FileWriter("./src/theme_4_inheritance/lesson_34/out.txt"));
        try {
            System.out.println("x: ");
            int x = scanner.nextInt();
            System.out.println("y: ");
            int y = scanner.nextInt();
            // Запись в файл
            writer.write(x + "/" + y + "=" + x / y);
        } catch (Exception e) {
            writer.write("There is error: " + e + ": " + e.getMessage());
            throw e;
        } finally {
            writer.close();
            System.out.println("written to out.txt");
        }

        try (BufferedWriter writer2 = new BufferedWriter(new FileWriter("./src/theme_4_inheritance/lesson_34/out.txt"))) {
            System.out.println("x: ");
            int x = scanner.nextInt();
            System.out.println("y: ");
            int y = scanner.nextInt();
            // Запись в файл
            writer2.write(x + "/" + y + "=" + x / y);
        } catch (Exception e) {
            throw e;
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
