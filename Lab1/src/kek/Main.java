package kek;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        double y,x;
        Scanner read = new Scanner(System.in);

        System.out.println("Ecuația : (sin(3x)+4x)/(X^5+4x)");
        System.out.println("Introduceți valoarea lui x: ");
        x = read.nextDouble();

        if (x == 0) {
            System.out.println("Eroare! Caz exceptat 0/0 !");
        } else {
            y = (Math.sin(3 * x) + 4 * x) / (x * x * x * x * x + 4 * x);
            System.out.println("Rezultatul este egal cu " + y);
        }
    }
}
