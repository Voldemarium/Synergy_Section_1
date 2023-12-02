package theme_4_inheritance.task_31;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class Task_31 {
    public static void main(String[] args) {
//  1. Выведите все даты текущего года
        int currentYear = LocalDate.now().getYear();
        LocalDate currentDate = LocalDate.of(currentYear, 1, 1);
        LocalDate endOfCurrentYear = LocalDate.of(currentYear, 12, 31);
        while (currentDate.isBefore(endOfCurrentYear.plusDays(1))) {
            System.out.println(currentDate);
            currentDate = currentDate.plusDays(1);
        }

//  2. “Нарисуйте” календарь:
        //январь
        //пн вт ср чт пт сб вс
        //1  2   3   4  5   6
        //... и так далее
        LocalDate currentDate2 = LocalDate.of(2023, 1, 1);
        LocalDate endOf2023 = LocalDate.of(2023, 12, 31);
        while (currentDate2.isBefore(endOf2023.plusDays(1))) {
            if (currentDate2.getDayOfMonth() == 1) {
                String[] months = new String[] {"январь", "февраль", "март", "апрель", "май", "июнь",
                        "июль", "август", "сентябрь", "октябрь", "ноябрь", "декабрь"};
                String month = months[currentDate2.getMonthValue() - 1];
                System.out.println("        " + month);
                System.out.println(" пн вт ср чт пт сб вс");
                for (int i = 1; i < currentDate2.getDayOfWeek().getValue(); i++) {
                    System.out.print("   ");
                }

            }
            System.out.print(" " + currentDate2.getDayOfMonth());
            if (currentDate2.getDayOfMonth() < 10) {
                System.out.print(" ");
            }
            if (currentDate2.getDayOfWeek().getValue() == 7) {
                System.out.println();
            } else if (currentDate2.plusDays(1).getDayOfMonth() == 1) {
                System.out.println();
            }
            currentDate2 = currentDate2.plusDays(1);
        }

//  3. В 12 часов 1 января 2020 года вы вылетаете из Москвы во Владивосток, длительность полета составляет
        //10 часов 15 минут. Вопрос в том, во сколько вы приедете во Владивосток? Используйте ZonedDateTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        ZonedDateTime departureFromMoscow = ZonedDateTime.of(
                LocalDateTime.of(2020, 1, 1, 12, 0),
                ZoneId.of("Europe/Moscow"));
        ZonedDateTime arrivalToVladivostok = departureFromMoscow
                .withZoneSameInstant(ZoneId.of("Asia/Vladivostok")).plusHours(10).plusMinutes(15);
        System.out.println("departure from Moscow: " + departureFromMoscow.format(formatter)
                + ", arrival to Vladivostok " + arrivalToVladivostok.format(formatter));

//  4.Пользователь вводит дату, вывести все числа с 1 января того же года до этой даты
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter year: ");
        int year = scanner.nextInt();
        System.out.println("Enter month: ");
        int month = scanner.nextInt();
        System.out.println("Enter day: ");
        int day = scanner.nextInt();
        LocalDate lastDate = LocalDate.of(year, month, day);
        LocalDate currentDate1 = LocalDate.of(year, 1, 1);
        while (currentDate1.isBefore(lastDate)) {
            System.out.println(currentDate1);
            currentDate1 = currentDate1.plusDays(1);

        }
//  5.Калькулятор полетов. Пользователь вводит, из какого часового пояса он вылетает (в формате Europe/Moscow,
        //Asia/Vladivostokи так далее.. можно нагуглить для каждого города), во сколько, сколько будет лететь. Напишите
        //местное время прилета
        FlightCalculator flightCalculator = new FlightCalculator();
        System.out.println("departure time: " + flightCalculator.departureTime.format(formatter));
        System.out.println("time in flight: " + flightCalculator.hoursInFlight + "h "
                + flightCalculator.minutesInFlight + "min");

        ZonedDateTime arrivalTime = flightCalculator.getArrivalTime();
        System.out.println("arrival time: " + arrivalTime.format(formatter));

//  6. Реализуйте класс DatePeriod, в котором будет две LocalDate. Переделайте анализатор курса валют, что б он на вход
   // принимал DatePeriod
        DatePeriod datePeriod = new DatePeriod(
                LocalDate.of(2023, 11, 1),
                LocalDate.of(2023, 11, 12));
        CurrencyCourse currencyCourse = new CurrencyCourse(datePeriod);
        String[][] courses = currencyCourse.setCurrencyCourse();
        for (String[] course : courses) {
            System.out.println(Arrays.toString(course));
        }
    }
}
