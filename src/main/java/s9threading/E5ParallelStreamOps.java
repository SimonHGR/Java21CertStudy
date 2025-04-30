package s9threading;

import java.util.concurrent.atomic.LongAdder;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class E5ParallelStreamOps {
  public static void main(String[] args) {
    IntConsumer intCons = x -> {
      System.out.println(Thread.currentThread().getName() + " gets " + x);
    };

    // in sequential mode, main thread (a single thread) processes everything
    // in parallel mode, the main thread remains involved, but threads of the
    // ForkJoinPool.commonPool() are also involved
    // Notice that the sharding brings more data than is needed into play,
    // and then limit cuts it off. Sometimes parallel mode isn't faster...
//    long c = IntStream.iterate(0, x -> x + 1) // simple counting
//        .parallel()
//        .limit(100)
//        .peek(intCons)
//        .filter(x -> true)
////        .limit(100)
//        .count();
//    System.out.println(c);

    System.out.println("---------------------------");
    // parallel mode should not mutate data, only create new values
    // from input data and an operation. If we do mutate data,
    // we're subject to all the nasty rules about timing, transactional
    // integrity, and visibility. This counts correctly in single-thread
    // model, but parallel mode fails horribly.
    // Note:
    // - the LongAdder works correctly across threads (and scales well)
    // - the correct count before the limit is actually larger than the
    //   intended count, some excess data is being created for the shards
    //   and is then abandoned
    long [] counter = {0L, 0L};
    LongAdder before = new LongAdder();
    LongAdder after = new LongAdder();
    long start = System.nanoTime();
    long count = IntStream.generate(() -> 1)
        .parallel()
        .peek(x -> counter[0]++)
        .peek(x -> before.increment())
        // this larger limit is likely more representative (but time consuming in execution)
        // notice that the parallel "benefit" is likely greater as the data volume increases
        // (but this is not always the case, much can depend on algorithm and situation)
//        .limit(1_000_000_000L)
        // smaller limit is easier to tinker with
        .limit(1_000_000L)
        .peek(x -> counter[1]++)
        .peek(x -> after.increment())
        .filter(x -> true) // foil the optimizer
        .count();
    long elapsed = System.nanoTime() - start;
    System.out.printf("count = %,d, counter[0] = %,d counter[1] = %,d, before = %,d, after = %,d\n",
        count, counter[0], counter[1], before.sum(), after.sum());
    System.out.printf("Time taken: %7.3f\n", (elapsed / 1_000_000_000.0));

    System.out.println("---------------------------");
    // Even though data is sharded, the stream infrastructure keeps track of
    // order and restores it at collections. Maintaining order can be very
    // memory intensive, so unordered() can turn it off. Some data sources
    // might not be ordered, and some terminal operations might not.
//    System.out.println("Order at collection");
//    String res = IntStream.iterate(0, x -> (x + 1) % 26)
////        .parallel()
////        .unordered()
//        .limit(26 * 2)
//        .mapToObj(x -> "" + (char)(x + 'A'))
//        .peek(x -> System.out.print(x))
//        .collect(Collectors.joining());
//    System.out.println("\n" + res);
//    System.out.println("---------------------------");
//
    // sorting can't handle unbounded data
    // this version runs forever, comment it out when satisfied!
//    ThreadLocalRandom.current().doubles()
//        .forEach(System.out::println);
//    System.out.println("---------------------------");

    // then try this one... nothing happens, till it eventually
    // runs out of memory.
    // Test 2, comment out the filter--notice that it fails
    // immediately. The sort works out that it cannot possibly
    // handle the unbounded stream so fails immediately
//    ThreadLocalRandom.current().doubles()
//        .filter(x -> true)
//        .sorted()
//        .forEach(System.out::println);

  }
}
