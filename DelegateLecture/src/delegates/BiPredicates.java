package delegates;

import java.time.Clock;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.*;

public class BiPredicates {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Input 1 or 2: ");
        int input = reader.nextInt();

        BiPredicate<Integer, Integer> p;
        switch (input) {
        case 1:
            p = (x, y) -> thing1(x, y);
            break;
        case 2:
        default:
            p = (x, y) -> thing2(x, y);
            break;
        }

        System.out.print("Input a value: ");
        int input2 = reader.nextInt();

        System.out.print("Input a value: ");
        int input3 = reader.nextInt();

        doStuff(p, input2, input3);
        reader.close();

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            list.add((int)(Math.random() * 30) + 1);
        }

        list.sort((x, y) -> x - y);

        for (int value : list) {
            System.out.print(value + " ");
        }
    }

    public static boolean thing1(int modValue, int modValue2) {
        return Clock.systemUTC().millis() % (modValue % modValue2) == 0;
    }

    public static boolean thing2(int modValue, int modValue2) {
        return Clock.systemUTC().millis() % 3 == 0 && thing1(modValue, modValue2);
    }

    public static void doStuff(BiPredicate<Integer, Integer> p, int input, int input2) {
        for (int i = 0; i < 2; i++) {
            System.out.println(p.test(input, input2));
            input++;
        }
    }
}