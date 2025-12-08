package s3progflow;

import java.util.Set;

public class FH {
//  static final int x = 10;
  public static void main(String[] args) {
//    final int x;
//    x = 20;
//    System.out.println(x);

    Set<String> names = Set.of("Hua", "Inaya", "Ishan");
    for (final String n : names) {
      System.out.println(n);
    }
  }
}
