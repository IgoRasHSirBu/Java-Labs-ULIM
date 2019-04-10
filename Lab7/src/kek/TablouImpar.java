package kek;

import java.util.Scanner;

public class TablouImpar {

    private int erId;
    private int[] tablouInt;

    public TablouImpar(int a) {

        Scanner read = new Scanner(System.in);
        if (a > 0) {//verificarea lungimii
            this.tablouInt = new int[a];

            System.out.println("Introducerea datelor în tabel");

            for (int i = 0; i < tablouInt.length; i++) { //Introducerea elementelor

                System.out.print("M[" + (+i + 1) + "]= ");
                int j = read.nextInt();
                this.tablouInt[i] = j;
            }
        } else if(a == 0){
            this.erId = 1;
        } else {
            this.erId = 2;
        }
    }

    void erMesaj() {

        switch (this.erId) {
            case 1:
                System.out.println("Vectorul nu are elemente");
                break;
            case 2:
                System.out.println("Eroare! Lungimea tabloului trebuie să fie pozitivă sau 0 ");
                break;
        }
    }

    boolean verLungime() {

        if (this.erId == 0) {
            return true;
        }
        return false;
    }

     boolean verVectorImpar() {//verificăm dacă există măcar o singură cifră impară

         for (int i = 0; i < this.tablouInt.length; i++) {

             if (this.tablouInt[i] % 2 == 1 || this.tablouInt[i] % 2 == -1) {//poti fi negative/pozitive
                 return true;
             }
         }
         return false;
    }

     void afisVector() {//afisarea elementelor vectorului

         System.out.println("Vector cu " + this.tablouInt.length + " elemente:");

             for (int i = 0; i < this.tablouInt.length; i++) {

                 if (i > 0) {
                     System.out.print(" ");
                 }
                 System.out.print("[" + this.tablouInt[i] + "]");
             }
             System.out.println();
         }


    int prelucrareTab() {

        int y = 0;

        if (this.verVectorImpar()) {

            y = 1;

            for (int i = 0; i < this.tablouInt.length; i++) { //prelucrarea vectorului

                if (this.tablouInt[i] % 2 == 1 || this.tablouInt[i] % 2 == -1) { //poti fi negative/pozitive

                    y = y * this.tablouInt[i];
                }
            }
        }
        return y;
    }
}