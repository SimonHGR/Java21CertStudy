package s3progflow;

import java.time.LocalDate;

public class E3PatternSwitch {
  public static void main(String[] args) {
    record Customer(String name, int credit) {}

    // 1 --------------------------------------------------------
//    Object obj = new Customer("Ayo", 1_000);
////    String obj = "";
//    switch (obj) {
//      // String literal pattern not permitted unless obj is String
//      case "Hello" -> System.out.println("Fails!");
//    }

    // 2 --------------------------------------------------------
//    String obj = "x";
//    switch (obj) {
//      case "Hello" -> System.out.println("Succeeds!");
//    }

    // 3 --------------------------------------------------------
//    Object obj = null; // OK if there's a case for it, Exception otherwise
//    Object obj = "Hello";
//    Object obj = LocalDate.now();
//    switch (obj) {
////      case null -> System.out.println("It's a null!");
//      case String s/*, StringBuilder s*/ -> System.out.println("A String! " + s.length());
////      default -> System.out.println("Something else"); // order of "dominating" cases matters
//      case null, default -> System.out.println("It's a null or something else!");
//    }

    // 4 --------------------------------------------------------
//    Object obj = "hello";
////    String s = null;
//    switch (obj) {
////      case CharSequence cs -> System.out.println("Some char sequence " + cs); // dominates String variants
//      case String s when s.length() > 3 -> {
////        s = null;
//        System.out.println("It's a longish String " + s);
//      }
//      case String s when s.length() > 3 -> {
////        s = null;
//        System.out.println("It's a longish String again!!! " + s);
////      case CharSequence cs -> System.out.println("Nope");
////      case Object o -> System.out.println("Something else"); // equivalent to default
//      }
//      case String s -> System.out.println("It's a short String " + s); // would dominate ...when s.length...
//      default -> System.out.println("Something else");
//    }

    // 5 --------------------------------------------------------
    Object obj = new Customer("Ayo", 1_000);
    switch (obj) {
//      case Customer(var name1, var credit) when credit > 500 ->
      case Customer(String name1, int credit) when credit > 500 ->
          System.out.println("Trustworthy Customer " + name1 + " with credit limit " + credit);
// This is clearly duplicating the previous, but guards are not compared to determine
// if one dominates another, only unguarded type matches and default can dominate
      case Customer(String name, int credit) when credit > 500 ->
          System.out.println("Trustworthy Customer " + name + " with credit limit " + credit);
// This is fine here, but would dominate the previous case, so cannot precede it
      case Customer c -> System.out.println("It's a customer " + c + " credit is " + c.credit());
      case null, default -> System.out.println("null, or something else");
    }
  }
}
