package s7streams;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class E5BadReduction {
  public static void main(String[] args) {
    var result = IntStream.generate(() ->  1)
        .parallel()
        .limit(100_000)
        .reduce(10_000, (a, b) -> a + b);
    System.out.println("sum is " + result);
    // ForkJoinPool.commonPool() by default :)
  }
}
