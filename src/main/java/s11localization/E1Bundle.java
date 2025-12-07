package s11localization;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class E1Bundle {
  public static void main(String[] args) {
    ResourceBundle bundle = ResourceBundle.getBundle("com.myresources.Labels");
    System.out.println("---------- Default ------------");
    String name = bundle.getString("name");
    System.out.println("name is " + name);
    System.out.println("flavor is " + bundle.getString("flavor"));

    System.out.println("---------- French Canadian ------------");
    bundle = ResourceBundle.getBundle("com.myresources.Labels", Locale.CANADA_FRENCH);
    name = bundle.getString("name");
    System.out.println("name is " + name);
    System.out.println("flavor is " + bundle.getString("flavor"));

    System.out.println("---------- French ------------");
    bundle = ResourceBundle.getBundle("com.myresources.Labels", Locale.FRENCH);
    name = bundle.getString("name");
    System.out.println("name is " + name);
    System.out.println("flavor is " + bundle.getString("flavor"));

    System.out.println("---------- Missing item ------------");
    try {
      String bad = bundle.getString("missing");
    } catch (MissingResourceException mre) {
      System.out.println(mre);
    }
    System.out.println("---------- Missing bundle ------------");
    try {
      bundle = ResourceBundle.getBundle("bad.Labels");
    } catch (MissingResourceException mre) {
      System.out.println(mre);
    }
  }
}
