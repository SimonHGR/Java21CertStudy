package s7streams.utils;

import java.util.OptionalDouble;

public record Average(double sum, long count) {
  public OptionalDouble mean() {
    if (count > 0) return OptionalDouble.of(sum/count);
    else return OptionalDouble.empty();
  }
  public Average include(double value) {
    return new Average(sum + value, count + 1);
  }
  public Average merge(Average other) {
    System.out.println("Calling Average.merge!!");
    return new Average(this.sum + other.sum, this.count + other.count);
  }
}
