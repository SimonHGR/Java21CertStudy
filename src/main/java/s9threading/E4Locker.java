package s9threading;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class E4Locker {
  public static void main(String[] args) throws InterruptedException {
    Lock lock = new ReentrantLock();

    Runnable task1 = () -> {
      System.out.println("Task 1 (greedy) starting");
      lock.lock();
      try {
        System.out.println("Task 1 locked");
        try {
          Thread.sleep(2000 + ThreadLocalRandom.current().nextInt(2000));
        } catch (InterruptedException ie) {
          System.out.println("Task 1 interrupted??!!");
          return;
        }
        System.out.println("Task 1 released lock");
      } finally {
        lock.unlock();
      }
    };
    Runnable task2 = () -> {
      System.out.println("Task 2 (not-greedy) starting");
      try {
        Thread.sleep(100 + ThreadLocalRandom.current().nextInt(500));
        boolean succeeded = false;
        while (!succeeded) {
          boolean lockedOk;
          if (lockedOk = lock.tryLock()) {
            try {
              System.out.println("Task 2 got the lock!");
              succeeded = true;
              // doing stuff!
            } finally {
              System.out.println("Task 2, work done, releasing lock");
              lock.unlock();
            }
          } else {
            System.out.println("Task 2, failed to get lock waiting to retry :(");
            Thread.sleep(100 + ThreadLocalRandom.current().nextInt(500));
          }
        }
      } catch (InterruptedException ie) {
        System.out.println("Task 2 interrupted??!!");
      }
    };

    Thread.Builder tb = Thread.ofPlatform().name("Task", 1);
    Thread thread1 = tb.start(task1);
    Thread thread2 = tb.start(task2);
    thread1.join();
    thread2.join();
    System.out.println("Tasks all finished, shutting down");
  }
}
