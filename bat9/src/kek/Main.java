package kek;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);

        try {

            int a = 10, b = 0;

            System.out.println("Rezultatul impărţirii 10/0 = ");
            System.out.println(a / b); //exc

        } catch (ArithmeticException e1) {

            System.out.println("Exc: Impărţirea la 0 nu există!" );

        } finally {

            System.out.println("[try 1 finisat]");

        }

        System.out.println("----------------------------------------------------------");

        // Metoda Math.sqrt nu returneaza exceptie!
        try {
            int nrNeg = -9;
            System.out.println("Radical din " + nrNeg + " este = " + Math.sqrt(nrNeg));
        } catch (Exception e2){

            System.out.println("Radical din numar negativ nu există!");
        } finally {
            System.out.println("[try 2 finisiat]");
        }

        System.out.println("----------------------------------------------------------");

        try {

            double numarNeg = -144;
            System.out.println("Radical din -144 = ");
            System.out.println(ExceptieRadicalNeg.getRez(-144));

        } catch (Exception e3) {

            System.out.println(e3);

        } finally {
            System.out.println("[try 3 finisat]");
        }

        System.out.println("----------------------------------------------------------");

        try {

            int[] tab = new int[4];
            System.out.println("Este creata un tablou cu 4 elemente");
            System.out.println("Are loc accesarea elementului tabloului cu indexul 5");
            System.out.println(tab[5]);

        } catch (ArrayIndexOutOfBoundsException e4) {

            System.out.println("Exc: Indexul tabloului este înafara lungimii tabloului!");

        } finally {

            System.out.println("[try 4 finisat]");

        }

        System.out.println("----------------------------------------------------------");

        try {

            String str = "\"Un şir de caractere!\"";
            System.out.println("Are loc accesarea elementului din înafara şirului");
            System.out.println(str);
            System.out.println("Elementrul cu indexul 30 din şir" + str.charAt(30));

        } catch (StringIndexOutOfBoundsException e5) {

            System.out.println("Exc: Este accesat un element din înafara şirului!");

        } finally {

            System.out.println("[try 5 finisat]");

        }

        System.out.println("----------------------------------------------------------");

        try {

            int a;
            System.out.println("Introduceţi o valoare! ");
            a = read.nextInt();

        } catch (java.util.InputMismatchException e6) {

            System.out.println("Exc: Valoarea introdusă nu este un număr!");

        } finally {

            System.out.println("[try 6 finisat]");

        }

        System.out.println("----------------------------------------------------------");

        try {

            String exStr = null;
            System.out.println(exStr.length());


        } catch (NullPointerException e7) {

            System.out.println("Exc: se apeleaza o metodă a unui obiect null");

        } finally {

            System.out.println("[try 7 finisat]");

        }

        System.out.println("----------------------------------------------------------");

        try {

            ImpartitorIntregi obj = new ImpartitorIntregi(10, 0);
            obj.getImpartire();

        } catch (ArithmeticException e8) {

            System.out.println(e8);

        } finally {

            System.out.println("[try 8 finisat]");

        }

        System.out.println("----------------------------------------------------------");

        try {

            System.out.println(generatorException(10, 0));

        } catch (Exception e9) {

            System.out.println(e9);

        } finally {

            System.out.println("[try 9 finisat]");

        }
    }

    static int generatorException(int a, int b) {

        if (b == 0) {
            throw new ArithmeticException("Excepţie! Împărţirea la zero!");
        } else {
            return (a / b);
        }
    }
}