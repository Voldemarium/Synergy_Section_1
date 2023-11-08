package theme_4_inheritance.lesson_31;

import utils.DownloadPage;

import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Lesson_31 {
    public static void main(String[] args) throws InterruptedException {
        //Местная дата и время
//     LocalDateTime - статические конструкторы (static constructor)
        LocalDate date = LocalDate.now(); // static constructor
        System.out.println(date);
        LocalTime time = LocalTime.now();
        System.out.println(time);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

//    LocalDateTime - информационные методы (get-methods)
        System.out.println(date.getYear());
        System.out.println(date.getMonth());               //месяц enum Month
        System.out.println(date.getMonthValue());          //месяц цифрой
        System.out.println(date.getDayOfMonth());
        System.out.println(date.getDayOfYear());
        System.out.println(date.getDayOfWeek());            //день enum DayOfWeek
        System.out.println(date.getDayOfWeek().getValue()); //день недели цифрой
        System.out.println(date.isLeapYear());              //високосный ли год
        System.out.println(date.lengthOfMonth());           //кол-во дней в текущем месяце
        System.out.println(date.lengthOfYear());            //кол-во дней в текущем году

//    LocalDateTime - методы сдвига даты (plus-minus-methods)
        System.out.println("---------------------------------------");
        LocalDate now = LocalDate.now();
        LocalDate plus20Days = now.plusDays(20);
        System.out.println(plus20Days);
        System.out.println(plus20Days.getDayOfYear());
        System.out.println(now.minusWeeks(4));
        System.out.println(now.minusMonths(2));
        System.out.println(now.minusYears(1));

//     Сравнение дат (позже-раньше)
        System.out.println("---------------------------------------");
        if (plus20Days.isAfter(now)) {                       //проверяем, этот день позже ли сравниваемой даты
            System.out.println("plus20Days.isAfter(now)");
        } else {
            System.out.println("not after of date " + now);
        }

        if (plus20Days.isBefore(now)) {                       //проверяем, этот день раньше ли сравниваемой даты
            System.out.println("plus20Days.isAfter(now)");
        } else {
            System.out.println("not before of date " + now);
        }

        if (plus20Days.isEqual(now)) {                       //проверяем, этот день совпадает ли со сравниваемой датой
            System.out.println("plus20Days.isEqual(now)");
        } else {
            System.out.println("not equal of date " + now);
        }

//     Вывод всех дат в году
        System.out.println("---------------------------------------");
        LocalDate currentDate = LocalDate.of(1999, 1, 1);
        System.out.println(currentDate);
        LocalDate endOf1999 = LocalDate.of(1999, 12, 31);
        System.out.println(endOf1999);

        while (currentDate.isBefore(endOf1999)) {
            System.out.println(currentDate);
            currentDate = currentDate.plusDays(1);
        }

//     Изменение даты постановкой
        System.out.println("---------------------------------------");
        LocalDate localDate_0 = LocalDate.of(0, 1, 1);
        System.out.println(localDate_0);
        System.out.println(localDate_0.withYear(2020));
        System.out.println(localDate_0.withMonth(12));
        System.out.println(localDate_0.withDayOfMonth(31));
        localDate_0 = localDate_0
                .withYear(2023)
                .withMonth(11)
                .withDayOfMonth(11);
        System.out.println(localDate_0);

        System.out.println("---------------------------------------");

//        Получение данных c ЦБ РФ, используя XML (динамики котировок доллара США:)
        DownloadPage downloadPage = new DownloadPage();

        LocalDate currentDate1 = LocalDate.of(2014, 12, 1);
        LocalDate lastDate = LocalDate.of(2014, 12, 10);

        while (currentDate1.isBefore(lastDate)) {
            String dateForUrl = currentDate1.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//                            getWithZero(currentDate1.getDayOfMonth()) + "/" +
//                            getWithZero(currentDate1.getMonthValue()) + "/" +
//                            currentDate1.getYear();
            String url = "https://www.cbr.ru/scripts/XML_dynamic.asp" +
                    "?date_req1=" + dateForUrl + "&date_req2=" + dateForUrl + "&VAL_NM_RQ=R01235";
            String page = null;
            try {
                page = downloadPage.downloadWebPage(url);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            // Последняя котировка на странице 1;
            int startIndex = page.lastIndexOf("<Value>");
            if (startIndex != -1) {
                int endIndex = page.lastIndexOf("</Value>");
                String courseStr = page.substring(startIndex + 7, endIndex);
                double course = Double.parseDouble(courseStr.replace(',', '.'));
                System.out.println(currentDate1 + ": " + course);
            }
            currentDate1 = currentDate1.plusDays(1);
        }
        System.out.println("---------------------------------------");
        System.out.println("---------------------------------------");
        System.out.println("---------------------------------------");
//     LocalTime
        LocalTime time1 = LocalTime.now();
        System.out.println(time1);
    //     get-methods
        System.out.println(time1.getHour());
        System.out.println(time1.getMinute());
        System.out.println(time1.getSecond()); //секунды
        System.out.println(time1.getNano());   //наносекунды
    //    LocalTime - методы сдвига времени (plus-minus-methods)
        System.out.println("---------------------------------------");
        System.out.println(time1.plusHours(2));
        System.out.println(time1.plusMinutes(30));
        System.out.println(time1.plusSeconds(22));
        System.out.println(time1.plusNanos(345));
    //   Изменение времени постановкой
        System.out.println(time1.withNano(0)); //вывод без наносекунд (при 0)
        System.out.println(time1.withHour(23));
    //   Constructors
        LocalTime time2 = LocalTime.of(22, 20, 55);
        System.out.println(time2);

//  LocalDateTime
        LocalDateTime localDateTime1 = LocalDateTime.of(2014, 11, 25, 8, 20);
        LocalDateTime localDateTime2 = LocalDateTime.of(2014, 11, 25,
                8, 20, 14, 345);
    // методы сдвига времени (plus-minus-methods)
        System.out.println(localDateTime1.plusHours(2));
        System.out.println(localDateTime1.plusDays(1));
//  DateTimeFormatter
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH:mm");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("dd:MM");
        System.out.println(localDateTime1.format(formatter1));
        System.out.println(localDateTime1.format(formatter2));
        System.out.println(localDateTime1.format(formatter3));

//  Unix epoch, timestamp - для простоты хранения времени в ПК
     // 0 - 01.01.1970 : 00 : 00
        System.out.println(System.currentTimeMillis()); //мск
        Thread.sleep(1000);
        System.out.println(System.currentTimeMillis()); //мск
        System.out.println(System.currentTimeMillis()/1000); //сек
        Thread.sleep(1000);
        System.out.println(System.currentTimeMillis()/1000); //сек

//  ZonedDateTime
        LocalDateTime localDateTime3 = LocalDateTime.now();
        ZoneId zoneId = ZoneId.of("Europe/Moscow");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime3, zoneId);
        System.out.println(zonedDateTime);
        ZonedDateTime tokyoTime = zonedDateTime.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));
        System.out.println(tokyoTime);
    }

    private static String getWithZero(int value) {
        return value < 10 ? "0" + value : String.valueOf(value);
    }


}
