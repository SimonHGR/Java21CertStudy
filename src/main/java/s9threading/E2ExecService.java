package s9threading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class CTask implements Callable<String> {
  private static int nextID = 0;
  private int myID = nextID++;

  @Override
  public String call() throws InterruptedException {
    System.out.println("Task id " + myID +
        " starting, thread is " + Thread.currentThread().getName());

    Thread.sleep(ThreadLocalRandom.current().nextInt(2000) + 1000);

    System.out.println("Task id " + myID +
        " completing normally");
    return "Returned value from task ID " + myID;
  }
}

public class E2ExecService {
  public static void main(String[] args) throws InterruptedException, ExecutionException {
    List<Future<String>> lfs = new ArrayList<>();

    try (ExecutorService es = Executors.newVirtualThreadPerTaskExecutor();) {
      for (int i = 0; i < 5; i++) {
        lfs.add(es.submit(new CTask()));
      }
    } // auto-generated finally will close the E.S. which waits for every
    // submitted task to complete

    System.out.println("All tasks completed");
    for (Future<String> fs : lfs) {
      System.out.println(" -- " + fs.get());
    }
  }
}
