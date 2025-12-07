package s4objectoriented;

// in Java, "private" means "accessible anywhere within the enclosing TOP LEVEL curlies"
// it's not restricted to a class, nor is it nested, but all the types grouped by that
// top-level type (including the top level type) have mutual access
// This is avery powerful design feature for building closely cooperating classes,
// such as builders and iterators

class OuterNest {
  private static String os = "Outer String private member";
  static void showAll() {
    System.out.println(OuterNest.os + ", "
        + Nested.is);
//        + OuterNest.Nested.is); // fully qualified :)
  }

  static class Nested {
    private static String is = "Inner String private member";
    static void showAll() {
      System.out.println(OuterNest.os + ", " + Nested.is);
    }
  }
}

public class E1NestedOrInnerAccess {
  public static void main(String[] args) {
    OuterNest.showAll();
    OuterNest.Nested.showAll();

    // "nested" classes just have scoped names and mutual access rights
    OuterNest o = new OuterNest();
    OuterNest.Nested oi = new OuterNest.Nested();
  }
}
