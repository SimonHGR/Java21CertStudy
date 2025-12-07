package s3progflow;

public class E1IfElse {
  public static void main(String[] args) {
    double value = 0.25;
    if (value > 0.5)
      if (value > 0.75)
        System.out.println("Big");
    else
      System.out.println("Not very big");

    System.out.println("All done");

    final boolean DEBUG = false;
//    while(DEBUG) {
    if (false) {
      System.out.println("Never, but allowed"); // "conditional compilation"
    }

//    while (false)
//      System.out.println("Nope, not allowed");
  }
}
