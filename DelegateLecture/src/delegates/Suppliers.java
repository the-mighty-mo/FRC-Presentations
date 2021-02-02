package delegates;

import java.time.Clock;
import java.util.Scanner;
import java.util.function.*;

/**
 * This class demonstrates how to use the Supplier object type.
 * <p>
 * A Supplier is a function that accepts no parameters and returns a value.
 */
public class Suppliers {
    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);
        System.out.print("Input 1 or 2: ");
        int input = reader.nextInt();

        Supplier<Long> supplier;
        switch (input) {
        case 1:
            supplier = () -> thing1(); // create a supplier that points to thing1()
            break;
        case 2:
        default:
            supplier = () -> thing2(); // create a supplier that points to thing2()
            System.out.println(thing2()); // print the current time
            break;
        }

        Thread.sleep(100); // sleep so the system time changes from the thing2() print

        doStuff(supplier); // pass the supplier to another method that will use it

        reader.close();
    }

    public static long thing1() {
        return 3;
    }

    public static long thing2() {
        return Clock.systemUTC().millis();
    }

    public static void doStuff(Supplier<Long> s) {
        System.out.println(s.get()); // get the result of running the supplier and print it

        // You will notice that if s points to thing2(), the time it prints here will be different.
        // This is because the supplier calls the method instead of saving its value, so the return
        // value is dependent on when it is called if it depends on mutable values.
    }
}