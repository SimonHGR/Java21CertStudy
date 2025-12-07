package s7streams.utils;

import java.util.OptionalDouble;

public class MAverage {
  private double sum;
  private long count;

  public MAverage() {this(0.0, 0L);}
  public MAverage(double sum, long count) {
    this.sum = sum;
    this.count = count;
  }

  public void include(double value) {
    this.sum += value;
    this.count++;
  }

  public void merge(MAverage other) {
    System.out.println("Calling MAverage.merge!!");
    this.sum += other.sum;
    this.count += other.count;
  }

  public OptionalDouble mean() {
    if (count != 0) return OptionalDouble.of(sum/count);
    else return OptionalDouble.empty();
  }
}
