package theme_2.lesson_16;

import java.util.Arrays;

public class Lesson_16 {
    public static void main(String[] args) {
        String str ="Working";
        char[] chars = str.toCharArray();
        int size = chars.length;
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                chars[i] = Character.toUpperCase(chars[i]);
            } else {
                chars[i] = Character.toLowerCase(chars[i]);
            }
        }
        for (int i = 0; i < size; i++) {
            System.out.print(chars[i]);
        }
        System.out.println();
//  ----------------------------------------------------
        String str2 ="23.343";
        int dotIndex = 0;
        int i = 0;
        while (i < str2.length() && dotIndex == 0) {
            if (str2.charAt(i) == '.') {
                dotIndex = i;
            }
            i++;
        }
        System.out.println(dotIndex);
        char[] intPart = new char[dotIndex];
        char[] fractPart = new char[str2.length() - dotIndex - 1];
        for (int j = 0; j < dotIndex; j++) {
            intPart[j] = str2.charAt(j);
        }
        System.out.println(intPart);

        for (int j = dotIndex + 1; j < str2.length(); j++) {
            fractPart[j - dotIndex  - 1] = str2.charAt(j);
        }
        System.out.println(fractPart);
//    ----------------------------------------------------
        String line = "We are champions.";

        int firstSpace = 0;
        while (line.charAt(firstSpace) != ' ' && firstSpace < line.length()) {
            firstSpace++;
        }
        char[] firstWord = new char[firstSpace];
        for (int j = 0; j < firstSpace; j++) {
            firstWord[j] = line.charAt(j);
        }
        System.out.println(firstWord);

        int lastSpace = line.length() - 1;
        while (line.charAt(lastSpace) != ' ' && lastSpace > 0) {
            lastSpace--;
        }
        char[] lastWord = new char[line.length() - lastSpace - 1];
        for (int j = lastSpace + 1; j < line.length(); j++) {
            lastWord[j - lastSpace - 1] = line.charAt(j);
        }
        System.out.println(lastWord);
//    ----------------------------------------------------------------
        String text = "First sentence. Second sentence. Third sentence.";
        int start = 0;
        for (int j = 0; j < text.length() - 1; j++) {
            if (text.charAt(j) == '.' && text.charAt(j + 1) == ' ') {
                System.out.println(text.substring(start, j));
                start = j + 2;
            }
        }
        System.out.println(text.substring(start, text.length() - 1));
//    ----выведем все слова из строки---------------------------------------------------------------
        String[] words = new String[10];
        int countOfWords = 0;
        int start2 = 0;
        for (int j = 0; j < line.length(); j++) {
            char ch = line.charAt(j);
            if (!((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || ch == '-')) {
                String word = line.substring(start2, j);
                words[countOfWords] = word;
                countOfWords++;
                start2 = j + 1;
            }
        }
        System.out.println(Arrays.toString(words));
    }
}
