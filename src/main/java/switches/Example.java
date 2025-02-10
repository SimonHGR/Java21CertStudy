package switches;

public class Example {
  public static void main(String[] args) {
    record Customer(String name, int credit) {}

//    Object obj = "Hello";
//    Object obj = "He";
    Object obj = new Customer("Ayo", 1_000);
//    Object obj = null;
    switch (obj) {
// OK, but can't coexist with case null, default
//      case null -> System.out.println("It's a null!");

// String literal pattern not permitted unless obj is String
//      case "Hello" ->

// This is valid in itself, but domaintes all String, StringBuilder, etc so would have to
// be placed later, after those patterns
//      case CharSequence cs -> System.out.println("Some char sequence " + cs);
      case String s when s.length() > 3-> System.out.println("It's a longish String " + s);
      case String s -> System.out.println("It's a short String " + s);

      case Customer(String name, int credit) when credit > 500 ->
          System.out.println("Trustworthy Customer " + name + " with credit limit " + credit);
// This is clearly duplicating the previous, but guards are not compared to determine
// if one dominates another, only unguarded type matches and default can dominate
      case Customer(String name, int credit) when credit > 500 ->
          System.out.println("Trustworthy Customer " + name + " with credit limit " + credit);
// This is fine here, but would dominate the previous case, so cannot precede it
      case Customer c -> System.out.println("It's a customer " + c);

//      case Object o -> System.out.println("Something else"); // OK, but same as default
//      default -> System.out.println("Something else");
      case null, default -> System.out.println("null, or something else");
    }

  }
}
