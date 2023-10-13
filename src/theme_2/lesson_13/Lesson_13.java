package theme_2.lesson_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class Lesson_13 {
    public static void main(String[] args) {
        for (int n = 2; n < 100; n++) {
            int x = 1;
            System.out.print("Dividers of " + n + ": ");
            do {
                if (n % x == 0) {
                    System.out.print(x + " ");
                }
                x++;
            } while (x < n);
            System.out.println();
        }
//------------------------------------------------------------------

//        int month = 1;
//        do {
//            int day = 1;
//            do {
//                String dayStr = day < 10 ? "0" + day : String.valueOf(day);
//                String monthStr = month < 10 ? "0" + month : String.valueOf(month);
//                String url = "https://www.cbr.ru/scripts/XML_dynamic.asp" +
//                        "?date_req1=" + dayStr + "/" + monthStr + "/2014" +
//                        "&date_req2=" + dayStr + "/" + monthStr + "/2014&VAL_NM_RQ=R01235";
//                String pageXML1 = downloadWebPage(url);
//                // Последняя котировка на странице;
//                int startIndex1 = pageXML1.lastIndexOf("<Value>");
//                if (startIndex1 != -1) { //if not exists  "<Value>"
//                    int endIndex1 = pageXML1.lastIndexOf("</Value>");
//                    String courseStr1 = pageXML1.substring(startIndex1 + 7, endIndex1);
//                    double course1 = Double.parseDouble(courseStr1.replace(',', '.'));
//                    System.out.println(dayStr + "/" + monthStr + "/2014: " + course1);
//                }
//                day++;
//            } while (day <= 31);
//            month++;
//        } while (month <= 12);
//------------------------------------------------------------------
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter expression: ");
        int x = scanner.nextInt();
        char operator = scanner.next().charAt(0);
        int y = scanner.nextInt();

//        if (operator == '+') {
//            System.out.println(x + y);
//        } else if (operator == '-') {
//            System.out.println(x - y);
//        } else if (operator == '*') {
//            System.out.println(x * y);
//        } else if (operator == '/') {
//            System.out.println(x / y);
//        } else {
//            System.out.println("Unknown operator");
//        }
        switch (operator) {
            case '+': System.out.println(x + y); break;
            case '-': System.out.println(x - y); break;
            case '*': System.out.println(x * y); break;
            case '/': System.out.println(x / y); break;
            default: System.out.println("Unknown operator");
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
