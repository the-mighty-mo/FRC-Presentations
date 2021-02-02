package delegates;

import java.util.Scanner;
import java.util.function.*;

public class Consumers {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Input 1 or 2: ");
        int input = reader.nextInt();

        Consumer<Integer> c;
        switch (input) {
        case 1:
            c = x -> thing1(x);
            break;
        case 2:
        default:
            c = x -> thing2(x);
            break;
        }

        System.out.print("Input a value: ");
        int input2 = reader.nextInt();

        doStuff(c, input2);

        reader.close();
    }

    public static void thing1(int i) {
        System.out.println(i);
    }

    public static void thing2(int i) {
        for (int j = 0; j < i; j++) {
            System.out.println(j);
        }
    }

    public static void doStuff(Consumer<Integer> c, int i) {
        for (int j = 0; j < 2; j++) {
            c.accept(i);
        }
    }
}