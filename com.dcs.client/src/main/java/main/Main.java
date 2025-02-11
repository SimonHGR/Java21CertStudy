package main;

import utils.MyService;
import utils.Useful;

import java.lang.reflect.Field;
import java.util.ServiceLoader;

public class Main {
  public static void main(String[] args) throws Throwable {
    System.out.print("main.Main starting, message is ");
    System.out.println(utils.Useful.message);
    ServiceLoader<MyService> loader = ServiceLoader.load(MyService.class);
    for (MyService ms : loader) {
      System.out.println(ms.getMessage());
    }
//    System.out.println(Useful.secret);
    Class<?> cl = Useful.class;
    Field secretField = cl.getDeclaredField("secret");
    secretField.setAccessible(true);
    System.out.println(secretField.get(null));
  }
}
