package s9threading;

import java.util.concurrent.atomic.AtomicLong;

public class E6ReadModifyWrite {
//  private volatile static long count = 0;
  private static AtomicLong count = new AtomicLong();

  public static void main(String[] args) throws Throwable {
    Runnable task = () -> {
      for (int i = 0; i < 1_000_000; i++) {
//        count++;
        count.incrementAndGet();
      }
    };

    Thread t1 = new Thread(task);
    Thread t2 = new Thread(task);
    Thread t3 = new Thread(task);
    Thread t4 = new Thread(task);
    t1.start();
    t2.start();
    t3.start();
    t4.start();
    t1.join();
    t2.join();
    t3.join();
    t4.join();
    System.out.println(count);
  }
}
