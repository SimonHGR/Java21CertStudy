package s2datetimetext;

public class E3Booleans {
  public static void main(String[] args) {
    int x = 2;
    if (x != 0) {
      System.out.println("Not zero");
    }

//    if (x) { // NO, no conversion to boolean, no "truthy/falsy"
//      System.out.println("Not allowed");
//    }

    int minusOne = -1;
    System.out.println(Integer.toBinaryString(minusOne));
    System.out.println("-1 & 2 = " + (minusOne & x) + "; "
        + Integer.toBinaryString(minusOne & x)); // bitwise operations
    System.out.println("4 | 2 = " + (4 | x) + "; " + Integer.toBinaryString(4 | x)); // bitwise operations
    System.out.println("-1 ^ 2 = " + (-1 ^ x) + "; " + Integer.toBinaryString(-1 ^ x)); // bitwise operations
//    System.out.println("-1 && 2 = " + (minusOne && x)); // &&, || require [Bb]oolean
    System.out.println(Boolean.parseBoolean("true"));
    System.out.println(Boolean.parseBoolean("false"));
    System.out.println(Boolean.parseBoolean(" true "));



  }
}
