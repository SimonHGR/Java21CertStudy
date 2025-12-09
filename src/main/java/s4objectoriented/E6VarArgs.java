package s4objectoriented;

import java.util.Arrays;

public class E6VarArgs {
//  public static int add(int [] a) {
  public static int add(int ... a) {
    int sum = 0;
    for (int x : a) {
      sum += x;
    }
    return sum;
  }

  public static void increment(int [] x) {
    System.out.println("x is " + Arrays.toString(x));
    x[0]++;
    System.out.println("x is " + Arrays.toString(x));
  }

  public static void main(String[] args) {
//    int [] numbers = new int[]{1,2,3,4,5,6,7,8,9,10};
    int [] numbers = {1,2,3,4,5,6,7,8,9,10};
    System.out.println("Sum of 1...10 is " + add(numbers));
//    System.out.println("Sum of 1...10 is " + add({1,2,3,4,5,6,7,8,9,10})); // no good!
    System.out.println("Sum of 1...10 is " + add(new int[]{1,2,3,4,5,6,7,8,9,10}));
    System.out.println("Sum of 1...10 is " + add(1,2,3,4,5,6,7,8,9,10)); // requires ...

    int[] x = {10};
    System.out.println("x in caller is " + Arrays.toString(x));
    increment(x);
    System.out.println("x in caller is " + Arrays.toString(x));
  }
}
