package s10serialzation;

import java.io.*;

class MySerializable implements Serializable {
  int x;
  public MySerializable(int x) {
    this.x = x;
  }

  private void writeObject(ObjectOutputStream iis) throws IOException {
    System.out.println("in writeObject");
    int rnd = (int)(Math.random() * 100000);
    System.out.println("rand is " + rnd);
    iis.writeInt(rnd);
    iis.defaultWriteObject();
  }

  private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
    System.out.println("in readObject");
    int r = ois.readInt();
    System.out.println("random read is " + r);
    ois.defaultReadObject();
  }

  @Override
  public String toString() {
    return "MySerializable{" +
        "x=" + x +
        '}';
  }
}
public class ReadObject {
  public static void main(String[] args) throws Throwable {
    MySerializable ms = new MySerializable(99);
    FileOutputStream baos = new FileOutputStream("data.dat");
    ObjectOutputStream oos = new ObjectOutputStream(baos);
    oos.writeObject(ms);
    oos.close();
    System.out.println("--------------------");
    FileInputStream bais = new FileInputStream("data.dat");
    ObjectInputStream ois = new ObjectInputStream(bais);
    MySerializable ms2 = (MySerializable) ois.readObject();
    System.out.println(ms2);

  }
}
