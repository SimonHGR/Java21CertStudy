package s2datetimetext;

public class E6TextCompare {
  public static void main(String[] args) {
    String s1 = "Hello";
    s1.concat(" World"); // string is immutable
    System.out.println(s1);
    s1 = s1.concat(" Monde"); // but a reference can be overwritten
    System.out.println(s1);

    StringBuilder sb1 = new StringBuilder("Hello");
    sb1.append(" World"); // StringBuilder is mutable
    System.out.println(sb1);

    String s2 = "One";
    String s3 = s2; // Alias to the same object
    String s4 = new String("One");
    System.out.println(s2 == s3); // true
    System.out.println(s2 == s4); // false
    System.out.println(s2.equals(s4)); // true

    String s5 = "One"; // entry in constant pool (even if separately compiled)
    System.out.println(s2 == s5); // true

    System.out.println("Relative order of s2 and s4? " + s2.compareTo(s4));

    StringBuilder sb2 = new StringBuilder("Hello World");
    System.out.println(sb1 + " : " + sb2);
    System.out.println(sb1.equals(sb2)); // StringBuilder doesn't provide equals comparison
    System.out.println("Relative order of sb1 and sb2? " + sb1.compareTo(sb2)); // but does provide order

    System.out.println("---------------------");
    System.out.println(s2 == s4);
    String s6 = s4.intern();
    System.out.println(s2 == s4);
    System.out.println(s2 == s6);
  }
}
