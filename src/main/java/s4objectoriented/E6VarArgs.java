package s4objectoriented;

public class E6VarArgs {
//  public static int add(int [] a) {
  public static int add(int ... a) {
    int sum = 0;
    for (int x : a) {
      sum += x;
    }
    return sum;
  }

  public static void main(String[] args) {
//    int [] numbers = new int[]{1,2,3,4,5,6,7,8,9,10};
    int [] numbers = {1,2,3,4,5,6,7,8,9,10};
    System.out.println("Sum of 1...10 is " + add(numbers));
//    System.out.println("Sum of 1...10 is " + add({1,2,3,4,5,6,7,8,9,10})); // no good!
    System.out.println("Sum of 1...10 is " + add(new int[]{1,2,3,4,5,6,7,8,9,10}));
    System.out.println("Sum of 1...10 is " + add(1,2,3,4,5,6,7,8,9,10)); // requires ...
  }
}
