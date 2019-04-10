package kek;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        double max, a, b, c, d;

        Scanner read = new Scanner(System.in);
        System.out.println("Introduceți primul număr");
        a = read.nextDouble();
        System.out.println("Introduceți al doilea număr");
        b = read.nextDouble();
        System.out.println("Introduceți al treilea număr");
        c = read.nextDouble();
        System.out.println("Introduceți al patrulea număr");
        d = read.nextDouble();

        max = a;

        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        if (d > max) {
            max = d;
        }

        System.out.println("Numărul, maximul este " + max);

    }
}
