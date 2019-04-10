package kek;

import java.util.Scanner;

public class Main {

   private static boolean myContains(String str, char c) {//metodă proprie care caută caracterul

        for (int i = 0; i< str.length(); i++) {

            if (str.charAt(i) == c) {
                return true;
            }
        }
      return false;
    }

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        char c = 'm';

        System.out.println("Introduceți șirul: ");
        String str = read.nextLine();

        if (myContains(str,c)) {

            System.out.println("Stringul conține litera m");
        } else {
            System.out.println("Stringul nu conține litera m");
        }
    }
}
