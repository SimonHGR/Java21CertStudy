package s2datetimetext;

public class E8MoreDouble {
  public static void main(String[] args) {
    System.out.println(Double.parseDouble("NaN"));
//    System.out.println(Double.parseDouble("infinity"));
    System.out.println(Double.parseDouble("Infinity"));
    System.out.println(Double.parseDouble("-Infinity"));
    System.out.println(Double.parseDouble("+Infinity"));

    double inf = Double.parseDouble("Infinity");
    double max = Double.MAX_VALUE;
    System.out.println(inf);
    System.out.println(max);
    System.out.println(max == inf);

    double big = 1E+24;
    double bigger = big + 1;
    System.out.println(big == bigger);
  }
}
