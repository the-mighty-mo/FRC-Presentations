package delegates;

import java.util.Scanner;
import java.util.function.*;

public class Functions {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Input 1 or 2: ");
        int input = reader.nextInt();

        Function<Double, Double> f;
        switch (input) {
        case 1:
            f = d -> Math.toRadians(d);
            break;
        case 2:
        default:
            f = d -> Math.toDegrees(d);
            break;
        }

        System.out.print("Input a value: ");
        int input2 = reader.nextInt();

        doStuff(f, input2);

        reader.close();
    }

    public static void doStuff(Function<Double, Double> p, double input) {
        for (int i = 0; i < 2; i++) {
            System.out.println(p.apply(input));
            input += 1;
        }
    }
}