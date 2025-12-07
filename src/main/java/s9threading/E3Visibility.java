package s9threading;

import java.util.concurrent.atomic.AtomicInteger;

public class E3Visibility {
//  static int counter = 0;
//  static volatile int counter = 0;
  static AtomicInteger counter = new AtomicInteger();

  public static void main(String[] args) throws Throwable {
    Runnable task = () -> {
      System.out.println("Task starting");
//      while (counter < 1)
      while (counter.get() < 1)
        ;
      System.out.println("Task ending");
    };
    Thread t1 = Thread.ofPlatform()
        .start(task);
    Thread.sleep(100);
//    for (; counter < 10_000_000; counter++)
//    while (counter.getAndIncrement() < 10_000_000)
    while (counter.incrementAndGet() < 10_000_000)
      ;
    System.out.println("Counter is " + counter + ". main exiting.");

  }
}
