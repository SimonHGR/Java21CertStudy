package s11localization;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Locale;

public class E2SimpleFormat {
  public static void main(String[] args) {
    // DateTimeFormatter "M" -> ??? "m" -> ???
    String phase = "Waxing Gibbous";
    LocalDate ld = LocalDate.of(2025, Month.FEBRUARY, 7);
    System.out.printf("On %TB %Te, %TY, the moon was %s\n", ld, ld, ld, phase);

    NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.GERMANY);
    System.out.println(nf.format(123456));
    NumberFormat nf2 = NumberFormat.getPercentInstance();
    System.out.println(nf2.format(0.98));

    try {
      String value = "  1,234";
      int valNumeric = Integer.valueOf(value);
    } catch (NumberFormatException nfe) {
      System.out.println(nfe);
    }
  }
}
