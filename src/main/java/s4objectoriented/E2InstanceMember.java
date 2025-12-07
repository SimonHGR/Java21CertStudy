package s4objectoriented;

import java.util.Iterator;

class MyList<E> implements Iterable<E> {
  private E[] data = (E[])new Object[10];
  private int count = 0;

  public void add(E e) {
    data[count++] = e; // ignoring overflow!
  }
  public E get(int idx) {
    return data[idx]; // ignoring range!
  }

  // the Iterator requires privileged access to the specific instance
  // of MyList that it iterates, to allow it to get the data
  // It must be a separate object so each client's progress through
  // iteration is kept
  // Note: this class would normally be private!!!
  public class MyIterator implements Iterator<E> {
    private int progress = 0;
    // referece to the MyList to be iterated???
    // that's: MyList MyList.this

    @Override
//    public boolean hasNext() {
//      return progress < MyList.this.count;
//    }
    public boolean hasNext() { return progress < count; }

    @Override
    public E next(/*MyIterator this*/) {
      // data refers to the data array member of the "enclosing instance"
      return data[progress++];
// longhand, or disambiguating form
//      return MyList.this.data[progress++]; \
    }

    // default constructor (as every constructor) carries a reference to the
    // enclosing instance -- this Iterator object HAS A reference to the
    // enclosing instance, but this is handled "automagically"
//    public MyIterator() {} // implicitly identical to the following:
    public MyIterator(MyList<E> MyList.this) {}
  }

  @Override
  public Iterator<E> iterator() {
//    return new MyIterator();
// again, the longhand / disambiguating form
    return this.new MyIterator();
  }
}

public class E2InstanceMember {
  public static void main(String[] args) {
    MyList<String> names1 = new MyList<>();
    names1.add("Inaya");
    names1.add("Hua");
    names1.add("Ayo");

    MyList<String> names2 = new MyList<>();
    names2.add("Ishan");
    names2.add("Siobhan");

    Iterator<String> n1ia = names1.iterator();
//    Iterator<String> n1ib = names1.iterator();

    // if the constructor and type is visible (which is unusual)
    // we can create an instance of the inner type with an explicit
    // reference to an outer object, but we MUST have that prefix
    // object
    Iterator<String> n1ib = names1.new MyIterator();

    Iterator<String> n2i = names2.iterator();

    // Each iterator iterates the particular MyList it was created for,
    // and the two created on names1 maintain independent progress
    // of that iteration (yes, we're cheating by not checking "hasNext"
    // but that's just to keep this code less cluttered
    System.out.println("> " + n1ia.next());
    System.out.println(">>>                        " + n2i.next());
    System.out.println("> " + n1ia.next());
    System.out.println(">>            " + n1ib.next());
    System.out.println(">>            " + n1ib.next());
    System.out.println("> " + n1ia.next());
    System.out.println(">>            " + n1ib.next());
    System.out.println(">>>                        " + n2i.next());

    System.out.println("-------------------");
    names1.forEach(System.out::println);
    System.out.println("-------------------");
    names2.forEach(System.out::println);
  }
}
