package md.main;

import java.util.Scanner;

public class Menu {

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
		System.out.println(">Introduceți operația: "); // citirea operației dorite de către user

		return read.nextInt();
	}

	int opCreareFileMenu() {

		System.out.println("[================ Crearea fișierului ================]");
		System.out.println("Introduceți 1 Pentru a crea un fișier cu un nume propriu");
		System.out.println("Introduceți 2 Pentru a crea un fișier cu numele \"countries\"");
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

	void opAddCountriesMenu() {

		System.out.println("[=========== Adăugarea datelor în fișier ============]");
	}

	int opAddCountryMenu() {

		System.out.println("[========= [Adăugarea datelor despre Țară] ==========]");
		System.out.println("Introduceți 1 Pentru a adăuga o Țară");
		System.out.println("Introduceți 9 Pentru a reveni in meniul principal");
		System.out.println("Introduceți 0 Pentru a ieși din program");
		System.out.println("------------------------------------------------------");
		System.out.println(">Introduceți operația: ");

		return read.nextInt();
	}

	int opElimenareDateMenu() {

		System.out.println("[================ Eliminarea datelor ================]");
		System.out.println("Introduceți 1 Pentru a șterge fișierul");
		System.out.println("Introduceți 2 Pentru a șterge o Țără");
		System.out.println("Introduceți 9 Pentru a reveni in meniul principal");
		System.out.println("Introduceți 0 Pentru a ieși din program");
		System.out.println("------------------------------------------------------");
		System.out.println(">Introduceți operația: ");
		return read.nextInt();

	}

	int opPrelucrareDate() {

		System.out.println("[========== Prelucrarea datelor din fișier ==========]");
		System.out.println("Introduceți 1 Pentru a afișa țările din Europa");
		System.out.println("Introduceți 2 Pentru a afișa țările din Asia");
		System.out.println("Introduceți 9 Pentru a reveni in meniul principal");
		System.out.println("Introduceți 0 Pentru a ieși din program");
		System.out.println("------------------------------------------------------");
		System.out.println(">Introduceți operația: ");

		return read.nextInt();
	}

	String opAsociereFileMeniu() {

		System.out.println("[=============== Asociera unui fisier ===============]");
		System.out.println(">Introduceți numele fișierului");

		return read.next();
	}

	void opAfisareMeniu() {

		System.out.println("[========= Afișarea conținutului fișierului =========]");
	}

	void opEliminareCountryMeniu() {

		System.out.println("[============== Eliminarea unuei Țări ===============]");
	}

	void opStergereFisier() {
		System.out.println("[============== Ștergerea fișierului ================]");
	}

	public void pauseMenu() {

		System.out.println("[----------------------------------------------------]");
		System.out.println(">Introduceți 9 Pentru a continua!");

		read.next();
	}

	public void errorOP(int id) {// afisarea starii de erori

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
			break;
		case 6:
			System.out.println("[----------------------------------------------------]");
			System.out.println(" >Eroare nu s-a putut introduce Țara!");
		}
	}

	public void clrscr() {

		for (int i = 0; i < 30; i++) {
			System.out.println();
		}
	}
}