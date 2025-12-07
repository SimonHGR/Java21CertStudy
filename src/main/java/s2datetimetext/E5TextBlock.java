package s2datetimetext;

public class E5TextBlock {
  public static void main(String[] args) {
//    String msg = """// can't have anything here!
//    String msg = """
//    """;
    String msg = """   
        """; // common leading whitespace, and first newline, are elided
    System.out.println(msg.length()); // -> 0
    msg = """
        trailing whitespace elided       
          inconsistent leading whitespace retained
        these are not\n\n""\"raw""\" strings
        """;
    System.out.println(msg);
    msg = """
        123         
        456         """;
    System.out.println("[" + msg + "], len is " + msg.length());
  }
}
