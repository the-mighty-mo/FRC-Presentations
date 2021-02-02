package delegates;

import java.util.Scanner;
import java.util.function.*;

/**
 * This class demonstrates how to use the Function object type.
 * <p>
 * A Function is a function that accepts a parameter and returns a value.
 */
public class Functions {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Input 1 or 2: ");
        int input = reader.nextInt();

        Function<Double, Double> f;
        switch (input) {
        case 1:
            f = d -> Math.toRadians(d); // create a function that points to Math.toRadians()
            break;
        case 2:
        default:
            f = d -> Math.toDegrees(d); // create a function that points to Math.toDegrees()
            break;
        }

        System.out.print("Input a value: ");
        int input2 = reader.nextInt();

        doStuff(f, input2); // pass the function to another method that will call it

        reader.close();
    }

    public static void doStuff(Function<Double, Double> p, double input) {
        for (int i = 0; i < 2; i++) {
            System.out.println(p.apply(input)); // apply the input to the function and get the result
            input += 1;
        }
    }
}