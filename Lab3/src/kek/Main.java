package kek;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int n;
        double y = 0;
        Scanner read = new Scanner(System.in);

        System.out.println("Entroduceți valoarea lui n");
        n = read.nextInt();
        if (n >= 0) {
            for (int i = 0; i <= n; i++) {
                y = y + (Math.pow(-1, i)) / (Math.pow(2, i));
            }
            System.out.println("Suma a primelor " + ++n + " numere din șir este " + y);
        } else {
            System.out.println("Eroare! n nu poate fi negativ!");
        }
    }
}