package s5exceptions;

import java.io.IOException;
import java.sql.SQLException;

class MyResource implements AutoCloseable {
  private static int nextID = 0;
  private int myID = nextID++;
  { System.out.println("Created resource, id = " + myID); }

  @Override
  public void close() throws Exception {
    System.out.println("closing id " + myID);
    if (Math.random() > 0.7) {
      System.out.println("exception closing id " + myID);
      throw new IOException("Close failure in id " + myID);
    }
    System.out.println("success closing id " + myID);
  }
}

public class E2TWR {
  public static void main(String[] args) {
    System.out.println("starting");
    MyResource mr0 = new MyResource();
    try {
      try (MyResource mr1 = new MyResource();
           MyResource mr2 = new MyResource();
           mr0;
      ) {
        System.out.println("running try");
        if (Math.random() > 0.6) {
          System.out.println("business problem!");
          throw new SQLException("DB broke!");
        }
        System.out.println("try completed normally");
      }
    } catch (Exception e) {
      System.out.println("Problem(s):");
      e.printStackTrace();
    }
    System.out.println("main completed");
  }
}
