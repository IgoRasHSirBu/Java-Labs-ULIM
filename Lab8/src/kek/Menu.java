package kek;

import java.util.Scanner;

 class Menu {

   private Scanner read = new Scanner(System.in);

     int mainMenu() {

         System.out.println("[================= Meniul Principal =================]");
         System.out.println("Introduceți 1 Pentru crearea fișierului ");
         System.out.println("Introduceți 2 Pentru afișarea conținutului fișierului");
         System.out.println("Introduceți 3 Pentru adăugarea datelor în fișier");
         System.out.println("Introduceți 4 Pentru prelucrarea  datelor din fișier");
         System.out.println("Introduceți 5 pentru a asocia un nume de fișier");
         System.out.println("Introduceți 6 pentru eliminarea datelor");
         System.out.println("Introduceți 0 Pentru ieșirea din program");
         System.out.println("------------------------------------------------------");
         System.out.println(">Introduceți operația: ");  //citirea operației dorite de către user

         return read.nextInt();
     }

     int opCreareFileMenu() {

         System.out.println("[================ Crearea fișierului ================]");
         System.out.println("Introduceți 1 Pentru a crea un fișier cu un nume propriu");
         System.out.println("Introduceți 2 Pentru a crea un fișier cu numele \"studenti.txt\"");
         System.out.println("Introduceți 9 Pentru a reveni in meniul principal");
         System.out.println("Introduceți 0 Pentru ieșirea din program");
         System.out.println("------------------------------------------------------");
         System.out.println(">Introduceți operația: ");

         return read.nextInt();
     }

     void opCreareFileMenuF1() {

         System.out.println("[=============== Crearea fișierului =================]");
         System.out.println(">Introduceti numele fișierului");
     }

     void opCreareFileMenuF2() {

         System.out.println("[=============== Crearea fișierului =================]");
     }

     void opAddStudentsMenu() {

         System.out.println("[=========== Adăugarea datelor în fișier ============]");
     }

     int opAddStudentMenu() {

         System.out.println("[====== [Adăugarea datelor despre un studenț] =======]");
         System.out.println("Introduceți 1 Pentru a adăuga un student");
         System.out.println("Introduceți 9 Pentru a reveni in meniul principal");
         System.out.println("Introduceți 0 Pentru a ieși din program");
         System.out.println("------------------------------------------------------");
         System.out.println(">Introduceți operația: ");

         return read.nextInt();
     }

     int opElimenareDateMenu() {

         System.out.println("[================ Eliminarea datelor ================]");
         System.out.println("Introduceți 1 Pentru a șterge fișierul");
         System.out.println("Introduceți 2 Pentru a șterge un student ");
         System.out.println("Introduceți 9 Pentru a reveni in meniul principal");
         System.out.println("Introduceți 0 Pentru a ieși din program");
         System.out.println("------------------------------------------------------");
         System.out.println(">Introduceți operația: ");
         return read.nextInt();

     }

     int opPrelucrareDate() {

         System.out.println("[========== Prelucrarea datelor din fișier ==========]");
         System.out.println("Introduceți 1 Pentru a afișa studenții din Chișinău V1");
         System.out.println("Introduceți 2 Pentru a afișa studenții din Chișinău V2");
         System.out.println("Introduceți 3 Pentru a afișa studenții din Chișinău V3");
         System.out.println("Introduceți 9 Pentru a reveni in meniul principal");
         System.out.println("Introduceți 0 Pentru a ieși din program");
         System.out.println("------------------------------------------------------");
         System.out.println(">Introduceți operația: ");

         return read.nextInt();
     }

     String opAsociereFileMeniu() {

         System.out.println("[=============== Asociera unui fisier ===============]");
         System.out.println(">Introduceti numele fișierului");

         return read.next();
     }

     void opAfisareMeniu() {

         System.out.println("[========= Afișarea conținutului fișierului =========]");
     }

     void opEliminareStudentMeniu() {

         System.out.println("[============= Eliminarea unui Student ==============]");
     }

     void opStergereFisier() {
         System.out.println("[============== Ștergerea fișierului ================]");
     }

     void pauseMenu() {

         System.out.println("[----------------------------------------------------]");
         System.out.println(">Introduceți 9 Pentru a continua!");

         read.next();
     }

     void errorOP(int id) {//afisarea starii de erori

         switch (id) {
             case 1:
                 System.out.println("[----------------------------------------------------]");
                 System.out.println(" >Operație greșită! ");
                 break;
             case 2:
                 System.out.println("[----------------------------------------------------]");
                 System.out.println(" >Fișierul nu a fost creat!");
                 break;
             case 3:
                 System.out.println("[----------------------------------------------------]");
                 System.out.println(" >Eroare nu este asociat nici-un fișier!");
                 break;
             case 4:
                 System.out.println("[----------------------------------------------------]");
                 System.out.println(" >Eroare nu s-a putut crea/asocia fișierul!");
                 break;
             case 5:
                 System.out.println("[----------------------------------------------------]");
                 System.out.println(" >Eroare nu s-a putut afișa, nu este asociat nici-un fișier!");
         }
     }

     void clrscr() {

         for (int i = 0; i < 30; i++) {
             System.out.println();
         }
     }
}