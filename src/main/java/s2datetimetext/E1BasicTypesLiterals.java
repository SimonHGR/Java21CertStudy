package s2datetimetext;

public class E1BasicTypesLiterals {
  public static void main(String[] args) {
//    int x1;
//    System.out.println(x1);
//    int x1 = 123;
//    int xBad = 123_456_789_000; // literal is too big for int
//    long xBad = 123_456_789_000; // really, it's the *literal* that's too big for int
    var x2 = 123_456_789_000L; // also l
    var x3 = 123_456_789_000.; // also D/d
    var x4 = 123_456_789_000F; // also f

    Object obj = 3.14F;
    System.out.println(obj.getClass().getName());

    int x5 = 010; // 8!!!!
    System.out.println("010 -> " + x5);
    int x6 = 0x10; // 16
    System.out.println("0x10 -> " + x6);
    int x7 = 0b10; // 2 :)
    System.out.println("0b10 -> " + x7);
    int x8 = 0_1_0_1; // 65
    System.out.println("0_1_0_1 -> " + x8);
//    int xBad = _123; // _ must come between digits

    short s1 = 9; // OK
//    int x9 = 9;
//    short sBad = x9; // NOT "constant expression of type int", not OK

    final int x9 = 9;
    short s2 = x9 + 1; // now it's a "constant expression of type int", OK

//    final long x10 = 9;
//    short sBad = x10 + 1; // NOT "constant expression of type int", fails

//    final short x10 = 9;
//    short sBad = x10 + 1L; // operand conversion to largest operand, but at least int, therefore LONG, not OK

    final short x10 = 9;
    short s3 = (short)(x10 + 1L); // casts cover most plausible sins

//    short s4 = 1, s5 = 2;
//    short sBad = s4 + s5; // "at least int", not OK

    Object l1 = 99;
    System.out.println(l1.getClass());

//    Long lBad = 99; // NOT ok -- autoboxing cannot change "underlying type"
    // Class hierarchy has Number as parent of Integer, Long, etc. the concrete types are *siblings*

    var something = mightBeNull();
//    var bad;
//    bad = 10;
//    var bad = null;

    Integer xI = Integer.valueOf("99"); // conversion
    int xi2 = xI; // auto-unboxing
    long ll1 = xi2; // promotion aka "widening promotion"

  } // main ends  here!!!

//  int getNum() {
//    if (Math.random() > 0.5) {
//      return 0;
//    }
//  }

  public static String mightBeNull() {
    return null;
  }
}
