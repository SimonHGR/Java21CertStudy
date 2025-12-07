package s7streams;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;

public class E1LambdaContext {
  BiFunction<Integer, Integer, Integer> adder1 = (a, b) -> a + b;
  BinaryOperator<Integer> adder2 = (a, b) -> a + b;
  IntBinaryOperator adder3 = (a, b) -> a + b;
//  Object obj = (a, b) -> a + b; // NO CONTEXT
  Object obj = (IntBinaryOperator)(a, b) -> a + b; // cast provides context
}
