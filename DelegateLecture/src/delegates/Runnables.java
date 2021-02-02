package delegates;

import java.util.Scanner;

public class Runnables {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Input 1 or 2: ");
        int input = reader.nextInt();

        Runnable r;
        switch (input) {
        case 1:
            r = () -> {
                thing1();
                thing2();
            };
            break;
        case 2:
        default:
            r = () -> thing2();
            break;
        }

        doStuff(r);

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
            r.run();
        }
    }
}