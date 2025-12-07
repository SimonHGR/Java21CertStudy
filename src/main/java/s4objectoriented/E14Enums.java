package s4objectoriented;

import java.util.Arrays;

interface Colored {
  boolean isRed();
  boolean isBlack();
}

// enums are "almost final", they cannot use an extends clause,
// nore be mentioned in an extends, but can have instances that
// are individually anonymous subtypes of the base enum.
// you cannot mark an enum final, it will be so automatically if,
// but only if, it has not subtypes (this one is not implicilty final)
// enums can implement interfaces
enum Suit implements Colored {
  HEART("Coeur") {
    @Override public boolean isBlack() { return false; }
    @Override public String toString() { // toString can be overridden, name() cannot
      return getAltName();
    }
  },
  DIAMOND {
    @Override public boolean isBlack() { return false; }
  },
  CLUB,
  SPADE;

  // static and instance fields are permitted
  private String altName;

  // all constructors must be private, and private
  // is default for these
  Suit(String altName) {
    this.altName = altName;
  }

  Suit() { }

  public boolean isBlack() { return true; }

  public final boolean isRed() { return !isBlack(); }

  public String getAltName() {
    return altName != null ? altName : name();
  }
}

public class E14Enums {
  public static void main(String[] args) {
    Suit [] suits = Suit.values();
    System.out.println(Arrays.toString(suits));

    Suit h = Suit.valueOf("HEART");
    Suit h1 = Suit.HEART;
    System.out.println("h.name() " + h.name());
    System.out.println("h.toString() " + h.toString());
    System.out.println("Class of Suit: " + Suit.class);
    System.out.println("Class of CLUB: " + Suit.CLUB.getClass());
    System.out.println("Class of HEART: " + Suit.HEART.getClass());

    // even after serialization/ deserialization
    System.out.println("all HEART instances are the same? " + (h == h1));

    System.out.println("CLUB is at position " + Suit.CLUB.ordinal());

  }
}
