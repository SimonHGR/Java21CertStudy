package s4objectoriented;

// *only* a sealed type can have a permits clause
// generally a sealed type must have permitted children
// *but* if no permits clause is provided, any children
// declared in the same source file will be deemed to be
// permitted (treat this as a development convenience).
//
// An entire sealed hierarchy must exist in a restricted
// namespace. If the code is running under JPMS, this must
// be the module. If not under JPMS, everything must be in
// the same package
sealed interface Transporter permits Car, Truck/*, Bicycle*/ { }

// members of a sealed hierarchy must be one of sealed (with
// children of their own), final, non-sealed, or enum. Record
// types are implicitly final, and enums are "almost" final.
// The intention is to create a base type for which all possible
// (or almost all) assignable types are known, and any attempt to
// add new ones flags the compiler to tell us we need to take care
final class Car implements Transporter {
  private int seats;
  public Car(int seats) {
    this.seats = seats;
  }
  @Override
  public String toString() {
    return "Car{ seats=" + seats + "}";
  }

  public int getSeats() {
    return seats;
  }
}

// enums behave as if final (they can have subtypes, but only nested subtypes,
// so inheritance is tightly controled "right here" in the source-code)
//enum Truck implements Transporter {
//  BIG_VAN, BORROWED_SEMI;
//}

// records are also implicitly final, so can be used directly in sealed type hierarchies

// if a branch of the hierarchy is allowed to have uncontrolled children,
// it can be marked non-sealed
non-sealed class Truck implements Transporter {
  private int gvw;
  private int chassisWeight;

  public Truck(int gvw, int chassisWeight) {
    this.gvw = gvw;
    this.chassisWeight = chassisWeight;
  }

  public int getGvw() {
    return gvw;
  }

  public int getChassisWeight() {
    return chassisWeight;
  }

  public int getUsefulLoad() {
    return gvw - chassisWeight;
  }
}

// not mentioned in the permits clause, not permitted
//final class Bicycle implements Transporter {}

public class E9Sealed {
  public static final int FUEL_ALLOWANCE = 200 * 7; // 200 gallons at 7 lb/gallon

  public static boolean canCarry(Transporter t, int load) {
    // notice that the switch is considered to cover all input possibilities
    // because the sealed hierarchy tells that only two types of transporter
    // can exist
    return switch(t) {
      case Car c -> 170 * (c.getSeats() - 1) > load;
      case Truck tr -> tr.getUsefulLoad() - FUEL_ALLOWANCE > load;
    };
  }

  public static void main(String[] args) {

  }
}
