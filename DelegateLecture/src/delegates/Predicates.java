package delegates;

import java.time.Clock;
import java.util.Scanner;
import java.util.function.*;

/**
 * This class demonstrates how to use the Predicates object type.
 * <p>
 * A Predicates is a function that accepts a parameter and returns a boolean.
 */
public class Predicates {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Input 1 or 2: ");
        int input = reader.nextInt();

        Predicate<Integer> p;
        switch (input) {
        case 1:
            p = x -> thing1(x); // create a predicate that points to thing1()
            break;
        case 2:
        default:
            p = x -> thing2(x); // create a predicate that points to thing2()
            break;
        }

        System.out.print("Input a value: ");
        int input2 = reader.nextInt();

        doStuff(p, input2); // pass the predicate to another method that will call it

        reader.close();
    }

    public static boolean thing1(int modValue) {
        return Clock.systemUTC().millis() % modValue == 0;
    }

    public static boolean thing2(int modValue) {
        return Clock.systemUTC().millis() % 3 == 0 && thing1(modValue);
    }

    public static void doStuff(Predicate<Integer> p, int input) {
        for (int i = 0; i < 2; i++) {
            System.out.println(p.test(input)); // apply the input to the predicate and get the result
        }
    }
}