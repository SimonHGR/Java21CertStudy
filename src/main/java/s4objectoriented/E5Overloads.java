package s4objectoriented;

public class E5Overloads {
  public static void doStuff(int a, int b) { System.out.println("doStuff(int, int)");}
//  public static void doStuff(int a, long b) { System.out.println("doStuff(int, long)");}
//  public static void doStuff(int a, double b) { System.out.println("doStuff(int, long)");}
//  public static void doStuff(long a, int b) { System.out.println("doStuff(long, int)");}
//  public static void doStuff(Integer a, Integer b) { System.out.println("doStuff(Integer, Integer)");}
//  public static void doStuff(Number a, Integer b) { System.out.println("doStuff(Number, Integer)");}
//  public static void doStuff(Integer a, Number b) { System.out.println("doStuff(Integer, Number)");}
//  public static void doStuff(int... a) { System.out.println("doStuff(int...)");}
//  public static void doStuff(Integer... a) { System.out.println("doStuff(int...)");}
//  public static void doStuff(Integer n, Integer... a) { System.out.println("doStuff(int...)");}
//  public static void doStuff(int a, int... b) { System.out.println("doStuff(int, int...)");}

  public static void main(String[] args) {
    doStuff(1,1);
  }
  /*
  1) exact match?
  1a) widening match?
  1b) ambiguity??? QUIT
  2) boxing??
  2a) widening
  2b) ambiguity?? QUIT
  3) varargs
  3b) ambiguity?? QUIT
   */
}
