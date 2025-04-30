package s4objectoriented;

import java.util.ArrayList;
import java.util.List;

public class ListIsList {
  public static void breakMyList(List l, int n) {
    l.add(n);
  }
  public static void main(String[] args) {
    List<String> names = new ArrayList<>();
    names.add("Inaya");
//    names.add(99);

    List<Integer> nums = new ArrayList<>(/*List.of(99, "Hua")*/);
//    nums.add("Inaya");
//    nums.withDayOfMonth(2);
    nums.add(99);

    breakMyList(names, 99);

    System.out.println(names.get(0));
//    System.out.println(names.get(1));
    String s = names.get(1);
    System.out.println(names);
  }
}
