package md.main;

import md.file.FisierTari;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		Scanner read = new Scanner(System.in);
		int oper;
		Menu meniu = new Menu();
		String nameFile;
		FisierTari tariFile = new FisierTari();

		do {
			meniu.clrscr();
			tariFile.checkAssign();
			oper = meniu.mainMenu();
			switch (oper) {

			case 1:
				meniu.clrscr();
				tariFile.checkAssign();
				oper = meniu.opCreareFileMenu();

				switch (oper) {
				case 1:
					meniu.clrscr();
					tariFile.checkAssign();
					meniu.opCreareFileMenuF1();
					nameFile = read.next();
					read.nextLine();
					tariFile.creareFisier(nameFile);
					break;
				case 2:
					meniu.clrscr();
					tariFile.checkAssign();
					meniu.opCreareFileMenuF2();
					tariFile.creareFisier("countries");
					break;
				case 9:
					meniu.clrscr();
					break;
				default:
					if (oper != 0) {
						meniu.errorOP(1);
						meniu.pauseMenu();
						meniu.clrscr();
					}
					break;
				}
				break;
			case 2:
				meniu.clrscr();
				tariFile.checkAssign();
				meniu.opAfisareMeniu();
				tariFile.afisareFisier();
				break;
			case 3:// op adaugare tara
				meniu.clrscr();
				tariFile.checkAssign();
				meniu.opAddCountriesMenu();

				if (tariFile.fileIsAssigned) {
					do {
						oper = meniu.opAddCountryMenu();
						switch (oper) {
						case 1:
							tariFile.addDateInFisier();
							break;
						case 2:
							break;
						default:
							if ((oper != 0) && (oper != 9)) {
								meniu.errorOP(1);
								meniu.pauseMenu();
								meniu.clrscr();
							}
							break;
						}
					} while ((oper != 0) && (oper != 9));
				} else {
					meniu.errorOP(3);
					meniu.pauseMenu();
				}
				break;
			case 4:
				meniu.clrscr();
				tariFile.checkAssign();
				oper = meniu.opPrelucrareDate();
				switch (oper) {
				case 1:// afisarea tari din europa
					meniu.clrscr();
					tariFile.afisareTariDinContinentul("Europa");
					meniu.pauseMenu();
					break;
				case 2:// afisarea tari din asia
					meniu.clrscr();
					tariFile.afisareTariDinContinentul("Asia");
					meniu.pauseMenu();
					break;
				case 9:
					meniu.clrscr();
					break;
				default:
					if (oper != 0) {
						meniu.errorOP(1);
						meniu.pauseMenu();
						meniu.clrscr();
					}
					break;
				}
				break;
			case 5:
				meniu.clrscr();
				tariFile.checkAssign();
				nameFile = meniu.opAsociereFileMeniu();
				tariFile.assignFile(nameFile);
				break;
			case 6:

				meniu.clrscr();
				tariFile.checkAssign();
				oper = meniu.opElimenareDateMenu();

				switch (oper) {
				case 1:
					meniu.clrscr();
					meniu.opStergereFisier();
					tariFile.eliminareFisier();
					break;
				case 2:
					meniu.clrscr();
					meniu.opEliminareCountryMeniu();
//		TODO : 		tariFile.eliminareStudent();
					break;
				case 9:
					meniu.clrscr();
					break;
				default:
					if (oper != 0) {
						meniu.errorOP(1);
						meniu.pauseMenu();
						meniu.clrscr();
					}
				}

				break;
			default:
				if (oper != 0) {
					meniu.errorOP(1);
					meniu.pauseMenu();
					meniu.clrscr();
				}
				break;
			}
		} while (oper != 0);
	}
}