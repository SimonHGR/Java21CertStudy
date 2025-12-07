package hello;

sealed interface X permits Y {}
record Y(String name) implements X {}
public class Hello {
  public static void main(String[] args) {
    X thing = new Y(", World!");
    System.out.println(switch(thing) {
      case Y(String name) -> "Hello" + name;
      case X x -> "Huh";
    });
  }
}
