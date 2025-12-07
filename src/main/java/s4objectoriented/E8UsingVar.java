package s4objectoriented;

public class E8UsingVar {
//  var bad = "Can't do this--local variables only with var";

  // can't use var for normal method formal params
  // (but we can use for inferrable lambda parameters)
//  public static void badMethod(var x) {}

  public static void main(String[] args) {
    // declare and initialize, type is inferred from right side
    var x = 99;

    // can do arrays
    var nums = new int[]{1,2,3,4};

    // but array base type must be explicit
    // this fails:
//    var badNums = {1,2,3,4};

    // Two curiosities:
    // 1) var is not a "keyword"
//    int goto = 99; // NOT allowed, goto is an (unused) keyword
    var var = "var"; // fine, var is context sensitive

    // 2) var can represent combinations of interfaces and one class type
    // called "non-denotable types"
    // In this example, both String and Integer (the boxed version of 99)
    // implement four common interfaces (two are relevant to the exam),
    // so the type of nonDenotable is:
    // Object & Serializable & Comparable [& Constable & ConstantDesc ]
    var nonDenotable = true ? "Hello" : 99;
    // and the compiler allows us to call methods on nonDenotable that are
    // provided by any of those interfaces (which would not be the case if
    // we had declared the variable simply as Object.
    // Serializable does not declare methods, but Comparable does
    nonDenotable.compareTo(null); // not actually a useful comparison!
  }
}
