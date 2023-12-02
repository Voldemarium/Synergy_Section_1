package utils;

import java.time.LocalDate;
import java.util.Random;

public class RandomDateGenerator {
    public LocalDate getRandomDate(int startYear, int endYear) {
        int difference = endYear - startYear;
        int randomYearDelta = new Random().nextInt(difference + 1);
        int randomYear = startYear + randomYearDelta;
        int randomMonth = new Random().nextInt(12) + 1;
        LocalDate date = LocalDate.of(randomYear, randomMonth, 1);
        int randomDay = new Random().nextInt(date.getDayOfMonth()) + 1;
        date = date.withDayOfMonth(randomDay);
        return date;
    }
}
