package theme_2.lesson_12;

import java.io.*;
import java.net.URL;

public class Task_12 {
    public static void main(String[] args) throws IOException {
//  1. Выведите числа от двух в десятой степени до десяти в четвертой степени
        for (int i = 10; i >= 4; i--) {
            System.out.println(Math.pow(2, i));
        }
//  2. Сохраните миллион файлов. Получилось?
//        for (int i = 1; i <= 1_000_000; i++) {
//            File file = new File("./src/theme_2/lesson_3/files/file_" + i + ".txt");
//            file.createNewFile();
//        }
//        Получилось, но заняло много времени (минут 15)
//  3. Выведите буквы от а до я (подсказка: for (char letter=’а’; letter<=’я’; letter++) )
        for (int letter = 'а'; letter <= 'я'; letter++) {
            System.out.print((char) letter + " ");
        }
        System.out.println();
//  4.  выведите десять букв в алфавите после буквы й
        for (int letter = 'й' + 1; letter <= 'й' + 10; letter++) {
            System.out.print((char) letter + " ");
        }
        System.out.println();
//  5. выведите десять букв в алфавите, идущие до буквы ю
        for (int letter = 'ю' - 10; letter <= 'ю' - 1; letter++) {
            System.out.print((char) letter + " ");
        }
        System.out.println();
//  6. выведите каждую вторую букву алфавита (а, в, д)
        for (int letter = 'а'; letter <= 'я'; letter = letter + 2) {
            System.out.print((char) letter + " ");
        }
        System.out.println();
//  7. Выведите каждую третью букву латинского алфавита
        for (int letter = 'a'; letter <= 'z'; letter = letter + 3) {
            System.out.print((char) letter + " ");
        }
        System.out.println();
//  8. выведите греческий алфавит (коды с 945 по 969) через запятую (α, β, …)
        for (int letter = 945; letter <= 969; letter++) {
            if (letter < 969) {
                System.out.print((char) letter + ", ");
            } else {
                System.out.print((char) letter);
            }
        }
        System.out.println();
//  9. Выведите в файл list.html список :
//<ul>
//<li> 1 element </li>
//<li> 2 element </li>
//…
//<li> 100 element </li>
//</ul>
        //  Запись в файл
        PrintWriter writer = new PrintWriter("./src/theme_2/lesson_3/files/list.html");
        writer.println("<ul>");
        for (int i = 1; i <= 100; i++) {
            writer.println("<li> " + i + " element </li>");
        }
        writer.println("</ul>");
        writer.close();
//  10. Выведите курс валют за 1 число каждого месяца в 2014 году
        for (int month = 1; month <= 12; month++) {
            String monthStr = month < 10 ? "0" + month : String.valueOf(month);
            String url = "https://www.cbr.ru/scripts/XML_dynamic.asp" +
                    "?date_req1=01/" + monthStr + "/2014&date_req2=01/" + monthStr + "/2014" +
                    "&VAL_NM_RQ=R01235";
            String pageXML1 = downloadWebPage(url);
            // Последняя котировка на странице;
            int startIndex1 = pageXML1.lastIndexOf("<Value>");
            if (startIndex1 != -1) {
                int endIndex1 = pageXML1.lastIndexOf("</Value>");
                String courseStr1 = pageXML1.substring(startIndex1 + 7, endIndex1);
                double course1 = Double.parseDouble(courseStr1.replace(',', '.'));
                System.out.println("01/" + monthStr + "/2014: " + course1);
            }
        }
//  11. Выведите курс валют за 1 февраля каждого года с 1994 до текущего года
        for (int year = 1994; year <= 2023; year++) {
            String url = "https://www.cbr.ru/scripts/XML_dynamic.asp" +
                    "?date_req1=01/02/" + year + "&date_req2=01/02/" + year + "&VAL_NM_RQ=R01235";
            String pageXML1 = downloadWebPage(url);
            // Последняя котировка на странице;
            int startIndex1 = pageXML1.lastIndexOf("<Value>");
            if (startIndex1 != -1) {
                int endIndex1 = pageXML1.lastIndexOf("</Value>");
                String courseStr1 = pageXML1.substring(startIndex1 + 7, endIndex1);
                double course1 = Double.parseDouble(courseStr1.replace(',', '.'));
                System.out.println("01/02/" + year + ": " + course1);
            }
        }

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
