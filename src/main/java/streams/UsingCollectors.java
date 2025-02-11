package streams;

import java.util.function.Function;
import java.util.stream.Collectors;

public class UsingCollectors {
  // Get a letter grade for a student
  public static String getGrade(Student s) {
    double gpa = s.gpa();
    if (gpa > 3.7) return "A";
    if (gpa > 3.5) return "B";
    if (gpa > 3.0) return "C";
    return "D";
  }

  public static void main(String[] args) {
    // get a list of students against each letter grade
    School.SCHOOL.getStudents().stream()
        .collect(Collectors.groupingBy(UsingCollectors::getGrade))
        .entrySet() // extract the entry set from the generated Map<String, List<Student>>
        .forEach(e -> System.out.println("Students " + e.getValue() + " have grade " + e.getKey()));
    System.out.println("---------------------------");

    // get a List of the students' names against each letter grade
    School.SCHOOL.getStudents().stream()
        .collect(Collectors.groupingBy(UsingCollectors::getGrade,
            // "downstream" collector processes elements that would otherwise
            // have been placed into the list. Collectors.mapping requires *another*
            // downstream collector to make a single item for the map's value from
            // the potentially many items coming along
            Collectors.mapping(s -> s.name(), Collectors.toList())))
        .entrySet() // extract the entry set from the generated Map<String, List<Student>>
        .forEach(e -> System.out.println("Students " + e.getValue() + " have grade " + e.getKey()));
    System.out.println("---------------------------");

    // get a a String with comma separated student's names against each letter grade
    School.SCHOOL.getStudents().stream()
        .collect(Collectors.groupingBy(UsingCollectors::getGrade,
            // "downstream" collector processes elements that would otherwise
            // have been placed into the list. Collectors.mapping requires *another*
            // downstream collector to make a single item for the map's value from
            // the potentially many items coming along
            Collectors.mapping(s -> s.name(), Collectors.joining(", "))))
        .entrySet() // extract the entry set from the generated Map<String, List<Student>>
        .forEach(e -> System.out.println("Students " + e.getValue() + " have grade " + e.getKey()));

  }
}
