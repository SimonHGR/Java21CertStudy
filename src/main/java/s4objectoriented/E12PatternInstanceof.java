package s4objectoriented;

import java.util.List;
import java.util.ArrayList;

public class E12PatternInstanceof {
  public static void main(String[] args) {
    Object obj = "Hello";
    // OLD
    boolean lngString = false;
    if (obj instanceof String) {
      String s = (String)obj;
      if (s.length() > 3) {
        lngString = true;
      }
    }
    System.out.println(lngString ? "It's a longish String" : "Short, or not a String");

    // NEW, note scope of "pattern variable" s is determined to be
    // only where it has *definitely* been initialized
    System.out.println(obj instanceof String s && s.length() > 3 ? "It's a longish String" : "Short, or not a String");

    // Limitations with generics
    Object stuff = new ArrayList<String>();
    if (stuff instanceof List) {
      System.out.println("Yes, it's a list, raw, no pattern");
    }

    if (stuff instanceof List l) {
//      String o = (String)l.get(0);
      System.out.println("Yes, it's a list, raw, in a pattern");
    }

    if (stuff instanceof List<?> lq) {
      Object o = lq.get(0);
      System.out.println("Also, it's a list, raw, wildcard (still unhelpful)");
    }

//    if (stuff instanceof List<String> ls) {
//      System.out.println("Can't do this, runtime doesn't know what type of list this is");
//    }

    // However, if the base type makes the generic type unambiguous, we can do this:
    Iterable<String> stuff2 = new ArrayList<String>();
    if (stuff2 instanceof List<String> ls) {
      String s = ls.get(0);
      System.out.println("if stuff 2 were a list at all, it can only contain strings, so this works");
    }
  }
}
