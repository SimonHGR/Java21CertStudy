package s4objectoriented;

@FunctionalInterface
interface F1 {
  void doStuff();
}

@FunctionalInterface
interface F2 {
  void doStuff();
  default void doMoreStuff() {}
  static void doStaticStuff() {}
  private void doPrivateStuff() {}
}

interface F3 {
  void doStuff();
}

@FunctionalInterface
interface F4 extends F3 {}

@FunctionalInterface
interface F5 extends F3, F4 {}

// But these are not OK:
//@FunctionalInterface

//interface FBad1 {} // zero abstract methods
//@FunctionalInterface
//interface FBad2 extends F3 {
//  void doStuff1(); // this is a second abstract method

//}

public class E13FunctionalInterfaces {
}
