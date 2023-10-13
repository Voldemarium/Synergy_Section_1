package theme_2.lesson_14;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task_14 {
    public static void main(String[] args) throws FileNotFoundException {
//  1. Пользователь вводит 10 чисел, сохраните их в массив
        Scanner scanner = new Scanner(System.in);
        int[] arrayInt1 = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter number " + (i + 1) + ":");
            arrayInt1[i] = scanner.nextInt();
        }
//  2. Сохраните 10 чисел в массив, выведите их с конца
        int[] arrayInt2 = new int[]{3, 5, 7, 8, 9, 10, 1, 2, 4, 11};
        for (int i = arrayInt2.length - 1; i >= 0; i--) {
            System.out.print(arrayInt2[i] + " ");
        }
        System.out.println();
//  3. Сохраните 10 строк в массив, выведите с конца каждую вторую
        String[] arrayStr = new String[]{"cat", "dog", "cow", "bag", "box", "bite", "table", "window", "floor", "wall"};
        for (int i = arrayStr.length - 2; i >= 0; i -= 2) {
            if (i != 0) {
                System.out.print(arrayStr[i] + ", ");
            } else {
                System.out.print(arrayStr[i]);
            }
        }
//  4. В файле 10 дробных чисел. Считайте в массив, выведите те, что больше числа пи.
        String fileName = "./src/theme_2/lesson_14/files/doubles.txt";
        InputStream stream = new FileInputStream(fileName);
        Scanner scanFile = new Scanner(stream);
        double[] arrayDouble = new double[10];
        for (int i = 0; i < 10; i++) {
            arrayDouble[i] = Double.parseDouble(scanFile.nextLine());
        }
        System.out.println();
        for (int i = 0; i < arrayDouble.length; i++) {
            if (arrayDouble[i] > Math.PI) {
                System.out.print(arrayDouble[i] + " ");
            }
        }
//  5. Пользователь вводит буквы. Пока не введёт букву ‘ю’, сохраняйте буквы в массив char
        //  (пусть в нем будет 100 элементов максимум). Потом создайте новый массив char размером столько,
        //  сколько букв ввел пользователь. Скопируйте в него буквы из первого массива
        System.out.println();
        char[] arrayChar = new char[100];
        char c = 0;
        int count = 0;
        for (int i = 0; i < arrayChar.length && c != 'ю' ; i++) {
            System.out.println("Enter letter: ");
            c = scanner.next().charAt(0);
            arrayChar[i] = c;
            count++;
        }
        System.out.println(Arrays.toString(arrayChar));
        char[] arrayChar2 = new char[count];
        for (int i = 0; i < arrayChar2.length; i++) {
            arrayChar2[i] = arrayChar[i];
        }
        System.out.println(Arrays.toString(arrayChar2));
//  6. Есть 2 файла по 5 строк в каждом. Сохраните их в 2 массива. Создайте третий массив из 10 строк,
        // скопируйте в него строки из первых двух массивов.
        String fileName1 = "./src/theme_2/lesson_14/files/file1.txt";
        InputStream stream1 = new FileInputStream(fileName1);
        Scanner scanFile1 = new Scanner(stream1);
        String[] arrayStr1 = new String[5];

        String fileName2 = "./src/theme_2/lesson_14/files/file2.txt";
        InputStream stream2 = new FileInputStream(fileName2);
        Scanner scanFile2 = new Scanner(stream2);
        String[] arrayStr2 = new String[5];

        for (int i = 0; i < 5; i++) {
            arrayStr1[i] = scanFile1.nextLine();
            arrayStr2[i] = scanFile2.nextLine();
        }
        System.out.println(Arrays.toString(arrayStr1));
        System.out.println(Arrays.toString(arrayStr2));

        String[] arrayStr3 = new String[10];
        for (int i = 0; i < arrayStr3.length; i++) {
            if (i < 5) {
                arrayStr3[i] = arrayStr1[i];
            } else {
                arrayStr3[i] = arrayStr2[i - 5];
            }
        }
        System.out.println(Arrays.toString(arrayStr3));
//  7. Поле чудес. Игрок один пишет слово. Выводится: ##### (по количеству букв) Игрок два пытается угадать буквы.
//  Если угадал, буква открывается: #а#а#, ба#а#, ... банан
        System.out.println("Enter word: ");
        String word = scanner.next();
        char[] wordChars = word.toCharArray();
        char[] guessWordChars = new char[wordChars.length];
        for (int i = 0; i < word.length(); i++) {
            guessWordChars[i]= '#';
            System.out.print(guessWordChars[i]);
        }
        do {
            System.out.println();
            System.out.println("Try guess letter, enter letter: ");
            char ch = scanner.next().charAt(0);
            for (int i = 0; i < wordChars.length; i++) {
                if (ch == wordChars[i]) {
                     guessWordChars[i] = ch;
                    System.out.println("You guessed the letter!");
                }
            }
            for (int i = 0; i < guessWordChars.length; i++) {
                System.out.print(guessWordChars[i]);
            }
        } while (!Arrays.equals(wordChars, guessWordChars));
        System.out.println();
        System.out.println("You guessed the word!");
//  8. Поле чудес с соревнованием. Генерируете 1000 случайных слов на сайте-генераторе (пример:
        //https://sanstv.ru/randomWord, но в поисковике есть много подобных). Сохраняете их в файл.
        //Из файла считываете случайное, и выводите ####... игроки по очереди отгадывают букву.
        //Гласная - 1 балл, согласная - 2 балла, если буква встречается несколько раз -больше.
        // Можно угадать слово целиком - за каждую угаданную букву тогда начислять баллы(гласные 1, согласные 2).
        //  Если не угадал - минус 3 балла
        String page = downloadWebPage("https://sanstv.ru/randomWord/lang-en/strong-2/count-10/word_??????");
        String filePath = "./src/theme_2/lesson_14/files/words.txt";
        PrintWriter writer = new PrintWriter(filePath);
        int i = 0;
        for (int j = 0; j < 10; j++) {
            int urlStart = page.indexOf(" '>", i);
            int urlEnd = page.indexOf("</", urlStart);
            i = urlEnd;
            String currentWord = page.substring(urlStart + 3, urlEnd);
            // Запишем слово в файл
            writer.println(currentWord);
        }
        writer.close();

        String randomWord = null;
        int randomInt = new Random().nextInt(10);
        InputStream stream3 = new FileInputStream(filePath);
        Scanner scanFile3 = new Scanner(stream3);
        for (int j = 0; j < 10; j++) {
            if (j == randomInt) {
                randomWord = scanFile3.next();
                break;
            }
            scanFile3.next();
        }
        System.out.println(randomWord);

        assert randomWord != null;
        char[] randomWordChars = randomWord.toCharArray();
        char[] guessRandomWordChars = new char[randomWordChars.length];
        for (int q = 0; q < randomWord.length(); q++) {
            guessRandomWordChars[q] = '#';
            System.out.print(guessRandomWordChars[q]);
        }
        int[] countGamers = new int[2];
        boolean guessingWord = false;
        do {
            for (int w = 0; w < countGamers.length; w++) {
                System.out.println();
                // Можно угадать слово целиком - за каждую угаданную букву тогда начислять баллы(гласные 1, согласные 2).
                System.out.println("Gamer " + (w + 1) + ": Would you like to guess the whole word?:" +
                        " (enter \"yes\" or \"no\")");
                String answer = scanner.next();
                if (answer.equals("yes")) {
                    //Угадываем слово целиком?
                    System.out.println("Gamer " + (w + 1) + ": try guess word, enter word: ");
                    String yourWord = scanner.next();
                    if (yourWord.equals(randomWord)) {
                        System.out.println("You guessed word!");
                        guessingWord = true;
                        // Начисляем баллы за каждую угаданную букву т(гласные 1, согласные 2).
                        for (int j = 0; j < randomWord.length(); j++) {
                            if (randomWordChars[j] == 'a' || randomWordChars[j] == 'e'
                                    || randomWordChars[j] == 'i' || randomWordChars[j] == 'o'
                                    || randomWordChars[j] == 'u' || randomWordChars[j] == 'y'
                            ) {
                                countGamers[w]++;   //за гласные - 1 балл
                            } else {
                                countGamers[w] += 2; //за cогласные - 2 балла
                            }
                        }
                        break;
                    } else {
                        System.out.println("You not guessed word!");
                        countGamers[w] -= 3;  //  Если не угадал - минус 3 балла
                    }
                } else if (answer.equals("no")) {
                    System.out.println("Gamer " + (w + 1) + ": try guess letter, enter letter: ");
                    char ch = scanner.next().charAt(0);
                    boolean guessingLetter = false;
                    for (int j = 0; j < randomWordChars.length; j++) {
                        if (ch == randomWordChars[j]) {
                            guessRandomWordChars[j] = ch;
                            System.out.println("You guessed the letter!");
                            guessingLetter = true;
                            //Начисляем баллы: Гласная - 1 балл, согласная - 2 балла
                            if (randomWordChars[j] == 'a' || randomWordChars[j] == 'e'
                                    || randomWordChars[j] == 'i' || randomWordChars[j] == 'o'
                                    || randomWordChars[j] == 'u' || randomWordChars[j] == 'y'
                            ) {
                                countGamers[w]++;   //за гласные - 1 балл
                            } else {
                                countGamers[w] += 2; //за cогласные - 2 балла
                            }

                            countGamers[w]++;
                        }
                    }
                    if (!guessingLetter) {
                        System.out.println("No guessed!");
                    } else {
                        guessingWord = Arrays.equals(randomWordChars, guessRandomWordChars);
                        if (guessingWord) {
                            break;
                        }
                    }
                    for (int j = 0; j < guessRandomWordChars.length; j++) {
                        System.out.print(guessRandomWordChars[j]);
                    }
                } else {
                    System.out.println("You enter wrong string!");
                    break;
                }
            }
        } while (!guessingWord);
        System.out.println();
        System.out.println("You guessed the word!");
        System.out.println(Arrays.toString(countGamers));
    }

    static public String downloadWebPage(String url) {
        StringBuilder result = new StringBuilder();
        try (InputStream inputStream = new URL(url).openConnection().getInputStream()) {
            String line;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while ((line = bufferedReader.readLine()) != null) {
                result.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result.toString();
    }
}
