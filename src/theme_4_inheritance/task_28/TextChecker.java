package theme_4_inheritance.task_28;

public class TextChecker {
    String str;

    public TextChecker(String str) {
        //        Проверка текста на наличие иностранных букв вместо русской раскладки и цифр вместо нуля и буквы «з».
        //   Если обнаружена такая подмена-выбрасывается исключение
        for (int i = 0; i < str.length(); i++) {
           if (!((str.charAt(i) >= 'А' && str.charAt(i) <= 'Я') || (str.charAt(i) >= 'а' && str.charAt(i) <= 'я') ||
               str.charAt(i) == 0)) {
               if (str.charAt(i) >= '1' && str.charAt(i) <= '9') {
                   if (str.charAt(i) >= '3') {
                       throw new RuntimeException(str.charAt(i) + " - this is number '3', not letter 'з");
                   } else {
                       throw new RuntimeException(str.charAt(i) + " - this number is not '0");
                   }
               } else if ((str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
                       || (str.charAt(i) >= 'a' && str.charAt(i) <= 'z')) {
                   throw new RuntimeException(str.charAt(i) + " - this is not Russian letter");
               }
           }
        }
        this.str = str;
    }
}
