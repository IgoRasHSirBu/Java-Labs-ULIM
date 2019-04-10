package kek;

import java.util.Scanner;
public class Main {

    static double ariaDreptunghi(double a, double b) {
        return a*b;
    }

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        System.out.println("Introduceți lungimea primei laturi a Dreptunghiului");
        double c = read.nextDouble();
        System.out.println("Introduceți lungimea al doilea laturi a Dreptunghiului");
        double d = read.nextDouble();

        if (c > 0 && d > 0) {
            System.out.println("Aria Dreptunghiului cu laturiile " + c + " și " + d + " este egală cu " + ariaDreptunghi(c, d));
        } else {
            System.out.println("Lungimea laturiilor trebuie sa fie mai mare ca 0!");
        }

    }
}
