package s7streams;

import s7streams.utils.*;

public class E2BasicOps {
  public static void main(String[] args) {
    // simple use of map to turn a Student into a String
    School.SCHOOL.getStudents().stream()
        .map(s -> "Student name: " + s.name()
        + ", has grade " + s.gpa() + " and takes: "
        + s.courses())
        .forEachOrdered(System.out::println);

    System.out.println("---------------------------");
    // select only high average students using filter
    School.SCHOOL.getStudents().stream()
        .filter(s -> s.gpa() > 3.2)
        .map(s -> "Student name: " + s.name()
        + ", has grade " + s.gpa() + " and takes: "
        + s.courses())
        .forEachOrdered(System.out::println);

    System.out.println("---------------------------");
    // Show all courses, using flatMap to take single items and
    // turn them in to "many" (which can include zero
    School.SCHOOL.getStudents().stream()
        .flatMap(s -> s.courses().stream())
        .forEachOrdered(System.out::println);

    System.out.println("---------------------------");
//     mapping to a stream is not really very helpful (generally)
//    School.SCHOOL.getStudents().stream()
//        .map(s -> s.courses().stream())
//        .forEachOrdered(System.out::println);


    System.out.println("---------------------------");
    // Show all courses-student pairs, using flatMap. Notice
    // that the student is still in scope during the processing
    // of the stream of courses, so we can map that stream
    // and combine the course name with the student name
    School.SCHOOL.getStudents().stream()
        .flatMap((Student s) -> {
          return s.courses().stream().map(c -> "Student " + s.name()
              + " takes " + c);
        })
        .forEachOrdered(System.out::println);

    System.out.println("---------------------------");
    // Streams are lazy, nothing happens without a "pull" from
    // the terminal operation. Notice the outputs are interleved
    School.SCHOOL.getStudents().stream()
        .map(Student::name)
        .peek(s -> System.out.println("processing " + s))
        .forEach(System.out::println);

    System.out.println("---------------------------");
    // But without the terminal operation, nothing is processed at all
    School.SCHOOL.getStudents().stream()
        .map(Student::name)
        .peek(s -> System.out.println("processing " + s))
//        .forEach(System.out::println)
    ;

    System.out.println("---------------------------");
    // Several terminal operations are short-circuiting
    // which is possible because the stream is driven from
    // the terminal operation.
    System.out.println(School.SCHOOL.getStudents().stream()
        .peek(s -> System.out.println("processing " + s.name()))
        .allMatch(s -> s.gpa() > 3.5)); // only the first is;
  }
}
