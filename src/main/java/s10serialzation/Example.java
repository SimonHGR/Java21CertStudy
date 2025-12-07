package s10serialzation;

import java.io.*;

class Thung {
  Thung(int p) {
    System.out.println("Thung(int " + p + ")");
  }
}

class Thang extends Thung {
  int x = 99;

  /*private*/ Thang() {
    super(1000);
    System.out.println("Thang() constructor");
  }

  Thang(int x) {
    super(2000);
    System.out.println("Thang(int " + x + ")");
  }
}

class Thing extends Thang implements Serializable {
    private static final long serialVersionUID = 1;
  int a;
//  static int b;
//  int y = 100;
  transient int z = 200;
  int newInt = 99;

  Thing(int x, int y, int z) {
    super(x);
    System.out.println("Thing constructor");
    this.x = x;
//    this.y = y;
    this.z = z;
  }

  @Override
//  public String toString() {
//    return "x = " + x + ", y = " + y + ", z = " + z + ", a = " + a;
//  }
//  public String toString() {
//    return "x = " + x + ", y REMOVED :) " + ", z = " + z + ", a = " + a;
//  }
  public String toString() {
    return "x = " + x + ", y REMOVED :) " + ", z = " + z + ", a = " + a + " newInt = " + newInt;
  }

  void doStuff() {}
//  static interface T {}
}

public class Example {
  public static void main(String[] args) throws Throwable {
//    Thing t = new Thing(1, 2, 3);
//    System.out.println(t);
////    ByteArrayOutputStream baos = new ByteArrayOutputStream();
//    FileOutputStream baos = new FileOutputStream("data.dat");
//    ObjectOutputStream oos = new ObjectOutputStream(baos);
//    oos.writeObject(t);
//    oos.close();
    System.out.println("--------------------");
//    ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
    FileInputStream bais = new FileInputStream("data.dat");
    ObjectInputStream ois = new ObjectInputStream(bais);
    Thing t1 = (Thing) ois.readObject();
    System.out.println(t1);
  }
}

