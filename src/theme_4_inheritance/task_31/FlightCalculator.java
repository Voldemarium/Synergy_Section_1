package theme_4_inheritance.task_31;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class FlightCalculator {
    ZonedDateTime departureTime;
    String arrivalZone;
    int hoursInFlight;
    int minutesInFlight;
    Scanner scanner = new Scanner(System.in);

    public FlightCalculator() {
        System.out.println("Enter place, date and time of departure");
        this.departureTime = getZonedDateTimeFromScanner();
        System.out.println("Enter hours in flight: ");
        this.hoursInFlight = scanner.nextInt();
        System.out.println("Enter minutes in flight: ");
        this.minutesInFlight = scanner.nextInt();
        System.out.println("Enter place of arrival in the format \"Europe/Moscow\": ");
        this.arrivalZone = scanner.next();
    }

    private ZonedDateTime getZonedDateTimeFromScanner() {
        System.out.println("Enter place in the format \"Europe/Moscow\": ");
        String zone1 = scanner.next();
        System.out.println("Enter year: ");
        int year1 = scanner.nextInt();
        System.out.println("Enter month: ");
        int month1 = scanner.nextInt();
        System.out.println("Enter day: ");
        int day1 = scanner.nextInt();
        System.out.println("Enter hours: ");
        int hours1 = scanner.nextInt();
        System.out.println("Enter minutes: ");
        int minutes1 = scanner.nextInt();
        return ZonedDateTime.of(LocalDateTime.of(year1, month1, day1, hours1, minutes1), ZoneId.of(zone1));
    }

    public ZonedDateTime getArrivalTime() {
        return departureTime
                .withZoneSameInstant(ZoneId.of(this.arrivalZone))
                .plusHours(hoursInFlight)
                .plusMinutes(minutesInFlight);
    }
}
