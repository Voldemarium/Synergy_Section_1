package theme_4_inheritance.task_28;

import java.util.Scanner;

public class KeyboardSwitch {
    char[] russianCharsLower = new char[] {'ф', 'и', 'с', 'в', 'у', 'а', 'п', 'р', 'ш', 'о',
                                       'л', 'д', 'ь', 'т', 'щ', 'з', 'й', 'к', 'ы', 'е',
                                       'г', 'м', 'ц', 'ч', 'н', 'я'};
    char[] russianCharsUpper = new char[26];
    char[] englishCharsLower  = new char[26];
    char[] englishCharsUpper  = new char[26];
    Scanner scanner = new Scanner(System.in);
    String str;

    public KeyboardSwitch(String str) {
        initializationArrays();

        char[] chars = str.toCharArray();
        System.out.println("Enter language \"En\" or \"Ru\"");
        String language = scanner.next();

        if (language.equals("En")) {
            translateRu_En(chars);
        } else if (language.equals("Ru")) {
            translateEn_Ru(chars);
        }
        this.str = String.copyValueOf(chars);
    }

    private void translateEn_Ru(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                translate(englishCharsUpper, chars, i, russianCharsUpper);
            } else if (chars[i] >= 'a' && chars[i] <= 'z') {
                translate(englishCharsLower, chars, i, russianCharsLower);
            }
        }
    }

    private void translateRu_En(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'А' && chars[i] <= 'Я') {
                translate(russianCharsUpper, chars, i, englishCharsUpper);
            } else if (chars[i] >= 'а' && chars[i] <= 'я') {
                translate(russianCharsLower, chars, i, englishCharsLower);
            }
        }
    }

    private void translate(char[] chars_1, char[] chars, int i, char[] chars_2) {
        for (int j = 0; j < chars_1.length; j++) {
            if (chars_1[j] == chars[i]) {
                chars[i] = chars_2[j];
            }
        }
    }
    private void initializationArrays() {
        char enLower = 'a';
        for (int i = 0; i < englishCharsLower.length; i++) {
            englishCharsLower[i] = enLower;
            enLower++;
        }
        char enUpper = 'A';
        for (int i = 0; i < englishCharsUpper.length; i++) {
            englishCharsUpper[i] = enUpper;
            enUpper++;
        }
        for (int i = 0; i < russianCharsUpper.length; i++) {
            int shift = (int)'а' - (int)'А';
            russianCharsUpper[i] = (char) ((int)russianCharsLower[i] - shift);
        }
    }
}
