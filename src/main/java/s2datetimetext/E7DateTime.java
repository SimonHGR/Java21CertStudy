package s2datetimetext;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class E7DateTime {
  public static void main(String[] args) {
    LocalDate feb28 = LocalDate.of(2025, 2, 28);
    feb28.plusDays(2); // date time elements are immutable
    LocalDate mar2 = feb28.plusDays(2);
    System.out.println(mar2);
    LocalDate mar4 = mar2.plus(2, ChronoUnit.DAYS);
    System.out.println(mar4);

    LocalDate apr4 = mar4.withMonth(Month.APRIL.getValue());
    System.out.println(apr4);

    feb28 = LocalDate.of(2025, 2, 28);
    System.out.println(feb28.withDayOfMonth(31));

    System.out.println("Day of week is " + feb28.get(ChronoField.DAY_OF_WEEK));
    System.out.println("Hour of day is " + feb28.get(ChronoField.HOUR_OF_DAY)); // Exception
  }
}
