package s4objectoriented;

// records are implicitly final, may not use extends
// but are permitted to implement interfaces
// they automatically get equals, hashCode, toString
// and accessor methods, but these may be replaced
// if desired
record Customer(String name, int creditLimit) {
  static {
    System.out.println("initializing Customer");
  }
  // Compact constructor -- this OR canonical constructor is permitted, not both
  Customer {
    if (name == null || name.length() == 0) throw new IllegalArgumentException("Bad name");
    // falls through to compiler-generated code that assigns the fields
    // any interaction with the final fields of the components is prohibited here
  }
  // Canonical constructor, formal parameter list must EXACTLY match components (including the names)
//  Customer(String name, int creditLimit) {
//    // user code, e.g. validation is permitted here
//    //assignment to the fields created from the components is mandatory here
//    if (name == null || name.length() == 0) throw new IllegalArgumentException("Bad name");
//    this.name = name;
//    this.creditLimit = creditLimit;
//  }

  // Additional, overloaded constructors are permitted, but must delegate
  // eventually to the canonical / compact form
  Customer(String name) {
    this(name, 1000);
  }
  Customer() { this("Unknonwn"); }

  // a replacement for the name accessor method.
  // must be public, return String, take no arguments, and not use throws
  @Override
  public String name() {
    // this is a replacement, there is no super to delegate to
//    String bad = super.name();
    return "Mr/Ms/Mx " + name;
  }
}
public class E4Records {
  public static void main(String[] args) {
    Customer c1 = new Customer("Ishan", 1000);
    Customer c2 = new Customer("Ishan");

    // toString method for free
    System.out.println("Customer c1 is " + c1);
    System.out.println("Customer c2 is " + c2);

    // equals method based on components for free
    System.out.println("Customer c1.equals(c2)? " + (c1.equals(c2)));
  }
}
