package theme_3_OOP.task_22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Task_22 {
    public static void main(String[] args) throws IOException {
//    1. Пользователь вводит 10 слов в массив. Найдите первое слово, в котором есть две гласные буквы подряд
        Scanner scanner = new Scanner(System.in);
        String[] words = new String[10];
        System.out.println("Enter ten words:");
        for (int i = 0; i < words.length; i++) {
            System.out.println("Enter word " + (i + 1) + ":");
            words[i] = scanner.next();
        }

        String firstWordWith2Vowels = null;
        outer_loop:
        for (String wordCurrent : words) {
            for (int j = 0; j < wordCurrent.length(); j++) {
                if (isVowel(Character.toLowerCase(wordCurrent.charAt(j)))) {
                    if (j != wordCurrent.length() - 1) {
                        if (isVowel(Character.toLowerCase(wordCurrent.charAt(j + 1)))) {
                            firstWordWith2Vowels = wordCurrent;
                            break outer_loop;
                        }
                    }
                }
            }
        }
        System.out.println("first word with 2 vowels: " + firstWordWith2Vowels);

//  2. Пользователь вводит массив чисел. Найдите первое четное число
        int[] arrayInt = new int[7];
        for (int i = 0; i < arrayInt.length; i++) {
            System.out.println("Enter number " + (i + 1) + ":");
            arrayInt[i] = scanner.nextInt();
        }
        int firstEvenNumber = 0;
        for (int j : arrayInt) {
            if (j % 2 == 0) {
                firstEvenNumber = j;
                break;
            }
        }
        System.out.println("first even Number: " + firstEvenNumber);

//  3. Найдите первое чётное число в массиве, которое больше 100
        int[] arrayInt2 = new int[]{2, 4, 122, 233, 34, 34, 345};
        int firstEvenNumberOver100 = 0;
        for (int k : arrayInt2) {
            if (k % 2 == 0 && k > 100) {
                firstEvenNumberOver100 = k;
                break;
            }
        }
        System.out.println("first even number over 100: " + firstEvenNumberOver100);

//  4. Найдите последнее слово в массиве, которое написано ЗаБоРчИкОм (что б узнать, заглавная ли буква,
        //используйте Character.isUpperCase(letter))
        String[] arrayWords = new String[]{"first", "SeCoNd", "third", "FoUrTh", "FiFtH", "sixth"};
        String lastWordLikeAFence = null;
        for (int i = arrayWords.length - 1; i >= 0; i--) {
            boolean wordLikeAFence = true;
            for (int j = 0; j < arrayWords[i].length(); j += 2) {
                boolean currentCharisUpperCase = Character.isUpperCase(arrayWords[i].charAt(j));
                if (!((j + 1 < arrayWords[i].length() && currentCharisUpperCase
                        && Character.isLowerCase(arrayWords[i].charAt(j + 1)))
                        || (j + 1 == arrayWords[i].length() && currentCharisUpperCase))) {
                    wordLikeAFence = false;
                }
            }
            if (wordLikeAFence) {
                lastWordLikeAFence = arrayWords[i];
                break;
            }
        }
        System.out.println("last word like a fence: " + lastWordLikeAFence);

//  5. Выводите числа от 1 до того момента, как сумма всех цифр в числе не будет равна 20 (пример такого числа - 875)
        int number = 1;
        int sumDigits;
        do {
            sumDigits = 0;
            String numberString = String.valueOf(number);
            for (int i = 0; i < numberString.length(); i++) {
                sumDigits += Integer.parseInt(String.valueOf(numberString.charAt(i)));
            }
            System.out.println("number = " + number + ", sumDigits = " + sumDigits);
            number++;
        } while (sumDigits != 20);

//  6. Выведите все даты невисокосного года. В январе 31 день, феврале -28, далее чередуется -в марте 31, в апреле 30...
        for (int month = 1; month <= 12; month++) {
            String monthStr = month < 10 ? "0" + month : String.valueOf(month);
            for (int day = 1; day <= 31; day++) {
                String dayStr = day < 10 ? "0" + day : String.valueOf(day);
                System.out.println(dayStr + "." + monthStr);

                if ((month == 2 && day == 28)
                        || ((month == 4 || month == 6 || month == 9 || month == 11) && day == 30)) {
                    break;
                }
            }
        }

//  7. Сохраняйте снимки NASA с 1 января до того момента, пока в поле Explanation нет слова “Earth”
        //  API NASA
        String urlPage = "https://api.nasa.gov/planetary/apod?start_date=2023-01-01&end_date=2023-10-25&api_key=DEMO_KEY";
        String page = downloadWebPage(urlPage);
        System.out.println(page);
        int urlStart = 0;
        int urlEnd = 0;
        int countPictures = 1;

        while (urlStart != 1) {
            urlStart = page.indexOf("\"explanation\":", urlEnd);
            if (urlStart != -1) {
                urlEnd = page.indexOf("\"hdurl\":", urlStart);
                String explanation = page.substring(urlStart + 15, urlEnd - 2);
                System.out.println(explanation);
               // Если в explanation есть слово “Earth”, то выходим из цикла
                if (explanation.contains("Earth")) {
                    break;
                }
            } else {
                break;
            }
                urlStart = page.indexOf("\"url\":", urlEnd);
                if (urlStart != -1) {
                urlEnd = page.indexOf("jpg", urlStart);
                String urlPicture = page.substring(urlStart + 7, urlEnd + 3);
                System.out.println(urlPicture);

                // Скачаем картинку по ссылке:
                try (InputStream in = new URL(urlPicture).openStream()) {
                    Path picturePath = Paths.get("./src/theme_3_OOP/task_22/files/picture" + countPictures + ".jpg");
                    if (Files.exists(picturePath)) {
                        Files.delete(picturePath);
                    }
                    Files.copy(in, picturePath);
                }
                System.out.println("Picture saved!");
                countPictures++;
            }
        }
    }


    static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'y';
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
