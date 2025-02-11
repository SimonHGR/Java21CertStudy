package threading;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

class Task implements Runnable {
  private static int nextId = 0;
  private String name = "Task-" + nextId++;
  @Override
  public void run() {
    Thread t = Thread.currentThread();
    try {
      // name is empty by default in virtual thread
      System.out.println(name + " starting in thread [" + t.getName() + "]");
      System.out.println("Priority is " + t.getPriority());
      for (int i = 0; i < 10; i++) {
        Thread.sleep(ThreadLocalRandom.current().nextInt(4) * 1000);
        System.out.println(name + " tick!");
      }
    } catch (InterruptedException ie) {
      System.out.println(name + " was requested to shutdown!");
    }
  }
}

public class Simple {
  public static void main(String[] args) throws InterruptedException {
    final int TASK_COUNT = 4;
//    Thread.Builder builder = Thread.ofPlatform();
    // the virtual thread
    Thread.Builder builder = Thread.ofVirtual();
    List<Thread> threadList = new ArrayList<>();
    for (int idx = 0; idx < TASK_COUNT; idx++) {
      Thread t = builder.unstarted(new Task());
      threadList.add(t);
      // ineffective with virtual thread
      t.setPriority(4);
// not legal for virtual thread, default for platform
//      t.setDaemon(false);
      t.start();
    }
    System.out.println("Waiting for tasks to complete");
    // this is necessary for virtual threads, but with platform threads
    // the jvm waits for non-daemon (which is default) to all complete
    Iterator<Thread> it = threadList.iterator();
    while (it.hasNext()) {
      it.next().join();
      it.remove();
    }
    System.out.println("Tasks completed, exiting!");
  }
}
