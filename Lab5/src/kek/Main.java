package kek;
import java.util.Scanner;

public class Main {

    static boolean verVectorImpar(int[] ar) {//verificăm dacă există măcar o singură cifră impară

        for (int i = 0; i < ar.length; i++) {

            if (ar[i] % 2 == 1 || ar[i] % 2 == -1) {//poti fi negative/pozitive
                return true;
            }
        }
        return false;
    }

    static void afisVector(int[] ar) {//afisarea elementelor vectorului

        System.out.println("Vector cu "+ar.length+" elemente:");

        for (int i = 0; i < ar.length; i++) {

            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print("[" + ar[i] + "]");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);

        int y = 0;

        System.out.println("Introduceți lungimea tabloului ");
        int ln = read.nextInt();
        int[] arrayInt;

        if (ln > 0) {//verificarea lungimii
            arrayInt = new int[ln];

            System.out.println("Introducerea datelor în tabel");

            for (int i = 0; i < arrayInt.length; i++) { //Introducerea elementelor

                System.out.print("M[" + (+i + 1)+"]= ");
                int j = read.nextInt();
                arrayInt[i] = j;
            }

            afisVector(arrayInt);

            if (verVectorImpar(arrayInt)) {

                y = 1;

                for (int i = 0; i < arrayInt.length; i++) { //prelucrarea vectorului

                    if (arrayInt[i] % 2 == 1 || arrayInt[i] % 2 == -1) { //poti fi negative/pozitive

                        y = y * arrayInt[i];
                    }
                }
            }
            System.out.println("Produsul numerelor impare din vector este " + y);
        } else if (ln == 0) {
            System.out.println("Vectorul nu are elemente");
        } else {
            System.out.println("Eroare! Lungimea tabloului trebuie să fie pozitivă sau 0 ");
        }
    }
}
