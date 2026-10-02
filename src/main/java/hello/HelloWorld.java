package hello;

import org.joda.time.LocalTime;

public class HelloWorld {
  public static void main(String[] args) {
    String name = System.getenv("APP_NAME");

        if (name == null || name.isEmpty()) {
            name = "GitHub Actions";
        }
    System.out.println(greeter.greet(name));
  }
}