package md.main;

import md.file.FisierTari;
import java.io.IOException;
import java.util.Scanner;
/**
 * 
 * @author Fanncy
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {

		Scanner read = new Scanner(System.in);
		int oper;// oper for menu loop
		Menu meniu = new Menu();// menu obj
		String nameFile;
		FisierTari tariFile = new FisierTari();
		// menu loop :3
		do {
			meniu.clrscr();
			tariFile.checkAssign();
			oper = meniu.mainMenu();
			switch (oper) {// main menu

			case 1:// create new file
				meniu.clrscr();
				tariFile.checkAssign();
				oper = meniu.opCreareFileMenu();

				switch (oper) {
				case 1:// for own path
					meniu.clrscr();
					tariFile.checkAssign();
					meniu.opCreareFileMenuF1();
					nameFile = read.next();
					read.nextLine();
					tariFile.creareFisier(nameFile);
					break;
				case 2:// for default path
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
			case 2:// display all data from file
				meniu.clrscr();
				tariFile.checkAssign();
				meniu.opAfisareMeniu();
				tariFile.afisareFisier();
				break;
			case 3:// for adding a new country in file
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
			case 4:// display specific data from file
				meniu.clrscr();
				tariFile.checkAssign();
				oper = meniu.opPrelucrareDate();
				switch (oper) {
				case 1:// display "Europa" countries from file
					meniu.clrscr();
					tariFile.afisareTariDinContinentul("Europa");
					meniu.pauseMenu();
					break;
				case 2:// display "Asia" countries from file
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
			case 5:// assign a new file or create a new one
				meniu.clrscr();
				tariFile.checkAssign();
				nameFile = meniu.opAsociereFileMeniu();
				tariFile.assignFile(nameFile);
				break;
			case 6:// deleting data from file
				meniu.clrscr();
				tariFile.checkAssign();
				oper = meniu.opElimenareDateMenu();

				switch (oper) {
				case 1:// delete whole file
					meniu.clrscr();
					meniu.opStergereFisier();
					tariFile.eliminareFisier();
					break;
				case 2:// delete specific country from file
					meniu.clrscr();
					meniu.opEliminareCountryMeniu();
					tariFile.eliminareTara();
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
		read.close();
	}
}