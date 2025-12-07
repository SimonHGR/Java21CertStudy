package s4objectoriented;

/*
1) if this class has not yet been initialized, run static initialization, parents first,
     then backwards down the hierarchy, execute static initializer blocks and field initializations
     in order, top to bottom in each class
2) new allocates *and zeroes* all the memory for the entire object
3) execution enters the targeted constructor
4)   Either implicit call to super(), explicit call to super(...),
            or explicit call to this(...) which must lead to super somewhere
5)   upon return from super, run *instance initialization* top to bottom in the source of this class
6)   then run the body of that constructor
7)   if this constructor was called by delegation with this(...), return to the body of that constructor
       and run the rest of it (don't run super(...) twice, nor instance initialization twice)
8) return initialized object to the caller of new
*/

class Parent {
  static { System.out.println("Parent static init 1; stat = " + Parent.stat); }
  static String stat = "Parent static field";
  String name = getParentName();
  public String getName() {
    System.out.println("Parent.getName()");
    return name;
  }
  public Parent() {
    // implicit super();
    // implicit INSTANCE initlalization
    System.out.println("Parent() constructor; name is " + name
        + ", getName() is " + getName());
  }
  static { System.out.println("Parent static init 2; stat = " + stat); }
  public String getParentName() {
    System.out.println("Parent.getParentName()");
    return "ParentName";
  }
}

class Child extends Parent {
  static { System.out.println("Child static init 1; stat is " + Child.stat); }
  static String stat = "Static field in Child";
  { System.out.println("Child instance init 1; name is " + this.name); }
  private String name = "unset";
  { System.out.println("Child instance init 2; name is " + this.name); }
  public Child(String n) {
    // implicit super();
    // implicit INSTANCE initialization
    System.out.println("In body of Child(String) constructor; name is " + this.name);
  }
  public Child() {
    this("NoName");
    System.out.println("In body of Child() constructor; name is " + this.name);
  }
  public String getName() {
    System.out.println("Child.getName");
    return /*this.*/name;
  }
  static { System.out.println("Child static init 2; stat is " + stat); }
}

public class E3Initialization {
  static {
    System.out.println("Initializing E3Initialization");
  }
  public static void main(String[] args) {
    System.out.println("Main starting");
    Child c = null;
    System.out.println("Child class is: " + Child.class);
    System.out.println("--------------- About to instantiate Child");
    c = new Child("Inaya");
    System.out.println("\n--------------- Returned from instantiation, making another");
    c = new Child();
  }
}

class EnumLike {
  static {
    System.out.println("about to get going");
  }
  static EnumLike member = new EnumLike();
  static {
    System.out.println("running static initializer");
  }
  static String msg = "Not really";
  {
    System.out.println("running instance init, msg is " + EnumLike.msg);
  }
}

class TryEnumLike {
  public static void main(String[] args) {
    System.out.println("1");
    System.out.println(EnumLike.member);
    System.out.println("2");
  }
}
