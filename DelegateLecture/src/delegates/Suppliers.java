package delegates;

import java.time.Clock;
import java.util.Scanner;
import java.util.function.*;

public class Suppliers {
    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);
        System.out.print("Input 1 or 2: ");
        int input = reader.nextInt();

        Supplier<Long> s;
        switch (input) {
        case 1:
            s = () -> thing1();
            break;
        case 2:
        default:
            s = () -> thing2();
            System.out.println(thing2());
            break;
        }

        Thread.sleep(100);

        doStuff(s);

        reader.close();
    }

    public static long thing1() {
        return 3;
    }

    public static long thing2() {
        return Clock.systemUTC().millis();
    }

    public static void doStuff(Supplier<Long> s) {
        System.out.println(s.get());
    }
}