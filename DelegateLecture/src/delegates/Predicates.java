package delegates;

import java.time.Clock;
import java.util.Scanner;
import java.util.function.*;

public class Predicates {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Input 1 or 2: ");
        int input = reader.nextInt();

        Predicate<Integer> p;
        switch (input) {
        case 1:
            p = x -> thing1(x);
            break;
        case 2:
        default:
            p = x -> thing2(x);
            break;
        }

        System.out.print("Input a value: ");
        int input2 = reader.nextInt();

        doStuff(p, input2);

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
            System.out.println(p.test(input));
        }
    }
}