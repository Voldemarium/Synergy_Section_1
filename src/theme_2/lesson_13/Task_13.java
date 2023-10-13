package theme_2.lesson_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class Task_13 {
    public static void main(String[] args) {
//  1. С помощью цикла do..while, выведите римские цифры (код начинается 8544). Начало: char c = 8544; …
        char c = 8544;
        do {
            System.out.print(c + " ");
            c++;
        } while (c < 8556);
        System.out.println();
//  2. С помощью цикла do..while, выведите числа от -0.9 до 0.9
        int x = -9;
        do {
            System.out.print((double) x / 10 + " ");
            x++;
        } while (x <= 9);

//        double x = -0.9;
//        do {
//            MathContext context = new MathContext(1, RoundingMode.HALF_DOWN);
//            BigDecimal xBig = new BigDecimal(x, context);
//            DecimalFormat decimalFormat =new DecimalFormat("#.#");
//            String xStr = decimalFormat.format(xBig);
//            System.out.print(xStr + " ");
//            x += 0.1;
//        } while (x <= 0.9);

//  3. Пользователь вводит строку, выведите каждый второй символ (подсказка:str.charAt(i) )
        Scanner scanner = new Scanner(System.in);
//        System.out.println();
//        System.out.println("Enter line 1:  ");
//        String str1 = scanner.nextLine();
//        int i = 1;
//        do {
//            System.out.print(str1.charAt(i) + " ");
//            i += 2;
//        } while (i < str1.length());
//  4. Пользователь вводит строку. Выводите все слова на разных строках
     // (подсказка : if (str.charAt(i)==‘ ‘) System.out.println(); )
//        System.out.println();
//        System.out.println("Enter line 2: ");
//        String str2 = scanner.nextLine();
//        int j = 0;
//        do {
//            if (str2.charAt(j) == ' ') {
//                System.out.println();
//            } else {
//                System.out.print(str2.charAt(j));
//            }
//            j++;
//        } while (j < str2.length());
//  5. Пользователь вводит строку. Выведите первые 3 слова
//        System.out.println();
//        System.out.println("Enter line 3: ");
//        String str3 = scanner.nextLine();
//        int q = 0;
//        int sumSpace = 0;
//        do {
//            if (str3.charAt(q) == ' ') {
//                sumSpace++;
//                if (sumSpace > 2) {
//                    break;
//                }
//            }
//            System.out.print(str3.charAt(q));
//            q++;
//        } while (q < str3.length());
//  6. Пользователь вводит строку, выведите ее задом-наперёд.
//        System.out.println();
//        System.out.println("Enter line 4: ");
//        String str4 = scanner.nextLine();
//        int w = str4.length() - 1;
//        do {
//            System.out.print(str4.charAt(w));
//            w--;
//        } while (w >= 0);
//  7. Пользователь вводит букву. Выведите любое слово, начинающуюся на эту букву
        System.out.println();
        System.out.println("Enter english letter: ");
        char ch = scanner.nextLine().charAt(0);
        String chStr = String.valueOf(ch).toUpperCase();
        String page1 = downloadWebPage("https://randomword.com/words/" + ch + ".html");
        int startIndex = page1.indexOf("letter " + chStr);
        startIndex += 10;
        int r = startIndex;
        int endIndex = 0;
        do {
          if (page1.charAt(r) == ',') {
              endIndex = r;
              break;
          }
          r++;
        } while (r < page1.length());
        String word = page1.substring(startIndex, endIndex);
        System.out.println(word);
//  8. Пользователь вводит цифру: выведите страну, телефонный код которого начинается на эту цифру
        System.out.println();
        System.out.println("Enter first digit of country telephone code: ");
        int firstNumber = scanner.nextInt();
        String page2 = downloadWebPage("https://teadmiseks.ee/ru/poleznoe/telefonnye-kody/");
        int endIndex2 = page2.indexOf("</td><td>+" + firstNumber);
        if (endIndex2 != -1) {
            int t = endIndex2;
            int startIndex2 = 0;
            do {
                if (page2.charAt(t) == '>') {
                    startIndex2 = t + 1;
                    break;
                }
                t--;
            } while (t > 0);
            String country = page2.substring(startIndex2, endIndex2);
            System.out.println("country: " + country);
        } else {
            System.out.println("This digit is not in first digit of country telephone code");
        }

//  9. Пользователь вводит цифру. Если она от 0 до 6 - пусть вводит еще. Если 9 -конец.
//   Если 7,8 - пусть вводит строки до тех пор, пока не введет «стоп» (на этом все).
        System.out.println("Enter one digit: ");
        int digit = scanner.nextInt();
        do {
            if (digit >= 0 && digit <= 6) {
                System.out.println("Enter one digit again: ");
                digit = scanner.nextInt();
            } else if (digit == 7 || digit == 8) {
                String str;
                scanner.nextLine(); //очистка буфера ввода
                do {
                    System.out.println("Enter line: ");
                    str = scanner.nextLine();
                } while (!str.equals("стоп"));
                break;
            }
        } while (digit != 9);
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
