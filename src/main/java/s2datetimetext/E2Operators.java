package s2datetimetext;

import java.util.Random;

public class E2Operators {
  public static void main(String[] args) {
    int x1 = 10;
    System.out.println(x1++);
    System.out.println(++x1);
//    x1++ = 10; // ++ / -- does not produce an "l-value"

    int x2 = 10;
    x1 = x2 *= 2; // expands KINDOF x2 = x2 * 2 BUT "x2" is ONLY EVALUATED ONCE
    // myArr[x2++] *= 2;  AFFECTS ONLY ONE CELL, x2++ only happens once
    System.out.println(x1);

    // % in Java is "remainder" NOT "mod"
    int [] ia = {1,2,3};
    int s = new Random().nextInt(1_000) - 500;
    System.out.println(ia[s % ia.length]); // might be out of range / negative
  }
}
