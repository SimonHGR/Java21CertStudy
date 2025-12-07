package s7streams.utils;

import java.util.List;

public record Student(String name, double gpa, List<String> courses) {
  public Student {
    courses = List.copyOf(courses);
  }
  public Student(String name, double gpa, String ... courses) {
    this(name, gpa, List.of(courses));
  }
  public String course(int idx) {
    return courses.get(idx);
  }
}
