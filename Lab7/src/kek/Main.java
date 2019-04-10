package kek;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        TablouImpar tab;

        System.out.println("Introduceți lungimea tabloului");
        tab = new TablouImpar(read.nextInt());

        if (tab.verLungime()) {

            tab.afisVector();
            System.out.println("Produsul numerelor impare din vector este " + tab.prelucrareTab());

        } else {
            tab.erMesaj();
        }
    }
}