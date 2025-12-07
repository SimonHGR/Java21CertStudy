package s4objectoriented;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// NOTE, in general, a big reason for immutability is to avoid errors, in a class such
// as this there should be data validation at every proposed creation/change. This is
// elided to avoid clutter, but that's not a "good example"!!!!

// if a class is not final, a mutable subclass can be created which could be used to
// usurp the assumptions made by the rest of the system.
final class Student {
  // using final on these fields is a good idea and might make some optimizations, but
  // is not necessarily vital for immutability. Remember that final fields must be
  // initialized exactly once before completion of the constructor sequence
  private String name;
  private double gpa;
  private List<String> courses;

  public Student(String name, double gpa, String ... courses) {
    this.name = name;
    this.gpa = gpa;

    // List.of makes an unmodifiable list containing the (potentially modifiable) vararg elements
    this.courses = List.of(courses);

    // Arrays.asList wraps a "view" around the provided array--if the caller retains a reference
    // to the array, they can still mutate our data!
//    this.courses = Arrays.asList(courses);

    // if provided a List that might or might not be unmodifiable, use List.copyOf to get a reference
    // to a definitely unmodifiable list. If it already were unmodifiable, the reference is returned
    // directly (see below)
  }

  public Student(String name, double gpa, List<String> courses) {
    this.name = name;
    this.gpa = gpa;
    this.courses = List.copyOf(courses); // ensure our courses are unmodifiable
  }

  public String getName() {
    return name;
  }

  public double getGpa() {
    return gpa;
  }

  // getter methods that return references to members might cause breaches in immutability
  // imagine this were not an unmodifiable list, the caller could call myStudent.getCourses().clear()
  // and destroy the data. In this situation, Collections.unmodifiableList(courses) would provide a
  // "proxy" that allows reading the list, but not changing it. Alternatively (but expensively) a
  // "defensive copy" might be made and returned.
  public List<String> getCourses() {
    return courses;
  }

  // immutable data needs to be able to represent changes, this is done by creating a new object
  // representing the change. Java's convention is "with" methods
  public Student withName(String name) {
    // we can reuse all this data, since it will never be changed (far more efficient than
    // making defensive copies!)
    return new Student(name, this.gpa, this.courses);
  }

  public Student withGpa(double gpa) {
    return new Student(this.name, gpa, this.courses);
  }

  public Student withCourses(List<String> courses) {
    // the called constructor will wrap courses with List.copyOf...
    return new Student(this.name, this.gpa, courses);
  }

  // we don't have to replace the entire course list
  public Student withCourse(String course) {
    List<String> courses = new ArrayList<>(this.courses);
    courses.add(course);
    // again, courses will be List.copyOf in the constructor
    return new Student(this.name, this.gpa, courses);
  }

}

public class E7Immutable {
}
