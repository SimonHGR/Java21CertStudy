package s7streams;

import s7streams.utils.*;

public class E3Reductions {
  public static void main(String[] args) {
    // reduction to a count of courses

    // with build in sum operation
    System.out.println(School.SCHOOL.getStudents().stream()
        .mapToLong(s -> s.courses().size())
        .sum());
    System.out.println("---------------------------");

    // with SummaryStatistics
    System.out.println(School.SCHOOL.getStudents().stream()
        .mapToLong(s -> s.courses().size())
        .summaryStatistics());
    System.out.println("---------------------------");

    // with reduce, using two arguments: "identity" (zero)
    // and the binary operator that simply adds
    System.out.println(School.SCHOOL.getStudents().stream()
        .mapToLong(s -> s.courses().size())
        .reduce(0L, (a, b) -> a + b));
    System.out.println("---------------------------");

    // with reduce using a single argument, no identity is
    // provided, so we get an OptionalLong instead of a
    // guaranteed result
    System.out.println(School.SCHOOL.getStudents().stream()
        .mapToLong(s -> s.courses().size())
        .reduce((a, b) -> a + b)
        .orElse(0));
    System.out.println("---------------------------");

    // Finding an average grade
    // note that "average" requires sum and count to
    // calculate incrementally
    // Three argument reduce, collects to a different type (and
    // different intermediate type). Still works in parallel
    // as the third argument can combine the per-thread
    // intermediate results
    School.SCHOOL.getStudents().stream()
//        .parallel() // see the messages when this is uncommented
        .map(s -> s.gpa()) // note this maps to Double not double
        .reduce(new Average(0, 0),
            Average::include,
            Average::merge)
        .mean() // Method on Average object, returns an OptionalDouble
        .ifPresentOrElse(m -> System.out.println("average grade is " + m),
            () -> System.out.println("No grades to average"));
    System.out.println("---------------------------");

    // Collect operations work with mutable intermediate result types
    School.SCHOOL.getStudents().stream()
//        .parallel() // see the messages when this is uncommented
        .mapToDouble(s -> s.gpa())
        .collect(MAverage::new, MAverage::include, MAverage::merge)
        .mean()
        .ifPresentOrElse(m -> System.out.println("average grade is " + m),
            () -> System.out.println("No grades to average"));
  }
}
