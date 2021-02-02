package delegates;

import java.util.Scanner;

/**
 * This class demonstrates how to use the Runnable object type.
 * <p>
 * A Runnable is a function that accepts no parameters and returns no value.
 */
public class Runnables {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Input 1 or 2: ");
        int input = reader.nextInt();

        Runnable r;
        switch (input) {
        case 1:
            r = () -> { // create a runnable that runs thing1() and thing2()
                thing1();
                thing2();
            };
            break;
        case 2:
        default:
            r = () -> thing2(); // create a runnable that runs thing2()
            break;
        }

        doStuff(r); // pass the runnable to another method that will call it

        reader.close();
    }

    public static void thing1() {
        System.out.println("hello");
    }

    public static void thing2() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }

    public static void doStuff(Runnable r) {
        for (int i = 0; i < 2; i++) {
            r.run(); // run the runnable
        }
    }
}