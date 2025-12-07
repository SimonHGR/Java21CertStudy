package s7streams.utils;

import java.util.List;

public enum School {
  SCHOOL;
  private static List<Student> roster = List.of(
    new Student("Inaya", 3.8, "Math", "Physics", "Chemistry"),
    new Student("Ishan", 3.2, "Math", "Physics"),
    new Student("Siobhan", 2.8, "Art", "History of Art", "Journalism"),
    new Student("Ayo", 2.2, "Quantum Mechanics"),
    new Student("Hua", 3.6, "Math", "Quantum Mechanics")
  );

  public List<Student> getStudents() {
    return roster;
  }
}
