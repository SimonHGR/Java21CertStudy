package s5exceptions;

import java.sql.SQLException;

public class E1TryCatchFinally {
  public static void mightBreak() throws SQLException {
    if (Math.random() > 0.6) {
      System.out.println("Breaking!");
      throw new SQLException("DB busted!!");
    }
    if (Math.random() > 0.6) {
      System.out.println("Catastrophe!");
      throw new RuntimeException("That shouldn't happen!!");
    }
  }

  public static void useMightBreak() {
    try {
      System.out.println("Going for it");
      mightBreak();
      System.out.println("Successful return");
    } catch (SQLException e) {
      System.out.println("uh oh, got a problem, how do we recover? " + e);
    } finally {
      System.out.println("tidying up success, failure, or catastrophe");
    }
    System.out.println("continuing...");
  }

  public static void main(String[] args) {
    System.out.println("main starting");
    useMightBreak();
    System.out.println("main completing normally");
  }
}
