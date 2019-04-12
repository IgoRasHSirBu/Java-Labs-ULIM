package md.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import md.main.Menu;

public class FisierTari {

	File fileDeTari;
	File assignedFile;
	public boolean fileIsAssigned = false;
	Scanner read = new Scanner(System.in);
	String fileName = "countries.txt";// default
	Menu meniu = new Menu();

	public void creareFisier(String str) throws IOException {// creare file

		fileDeTari = new File(str);
		fileDeTari.createNewFile();// throws IOException

		if (fileDeTari.exists()) {
			System.out.println("------------------------------------------------------");
			System.out.println(">[Fișierul cu numele \"" + str + "\" a fost creat!]");
			System.out.println("------------------------------------------------------");
			System.out.println(">Doriți asocierea cu acest fișier?\n [ y ] DA [ n ] Nu : ");

			char op = read.next().charAt(0);

			if (op == 'y' || op == 'Y') {
				assignFile(str);
			} else {
				meniu.pauseMenu();
			}
		} else {
			meniu.errorOP(2);
			meniu.pauseMenu();
		}
	}

	public void afisareFisier() throws IOException {

		if (fileIsAssigned) {
			System.out.println("[----------------------------------------------------]");

			FileReader fileReader = new FileReader(assignedFile);
			BufferedReader fileReaderBuffer = new BufferedReader(fileReader);

			while (fileReaderBuffer.ready()) {
				System.out.println(fileReaderBuffer.readLine());
			}

			fileReaderBuffer.close();
			meniu.pauseMenu();
		} else {
			meniu.errorOP(5);
			meniu.pauseMenu();
		}
	}

//      void addDateInFisier() throws IOException {
//
//          File dateInFile;
//          if (fileIsAssigned) {
//
//              dateInFile = new File(assignedFile.getName());
//              FileWriter fileWritter = new FileWriter(dateInFile, true);//true pentru a face append la continutul deja existent in fisier
//              BufferedWriter fileWritterBuffer = new BufferedWriter(fileWritter);
//
//              String dataStudent;
//              int dataInt;
//              meniu.clrscr();
//              System.out.println("------------------ [Introducere date] ----------------");
//
//              System.out.println("Introduceți numărul studentului: ");
//              dataInt = read.nextInt();
//              read.nextLine();
//              fileWritterBuffer.write(dataInt + " \t");
//
//              System.out.println("Introduceți numele studentului: ");
//              dataStudent = read.nextLine();
//              fileWritterBuffer.write(dataStudent + " \t");
//
//              System.out.println("Introduceți prenumele studentului: ");
//              dataStudent = read.nextLine();
//              fileWritterBuffer.write(dataStudent + " \t");
//
//              System.out.println("Introduceți localitatea studentului: ");
//              dataStudent = read.nextLine();
//              fileWritterBuffer.write(dataStudent + " \t");
//
//              System.out.println("Introduceți adresa studentului: ");
//
//              dataStudent = read.nextLine();
//              fileWritterBuffer.write(dataStudent + " \t");
//
//              System.out.println("Introduceți telefonul studentului: ");
//              dataStudent = read.nextLine();
//              fileWritterBuffer.write(dataStudent + " \t");
//
//              System.out.println("Introduceți nota medie a studentului: ");
//              dataStudent = read.nextLine();
//              fileWritterBuffer.write(dataStudent + " ");
//
//              fileWritterBuffer.newLine();
//
//              System.out.println("------------------------------------------------------");
//              System.out.println(">A fost introdus un student");
//              meniu.pauseMenu();
//              meniu.clrscr();
//
//              fileWritterBuffer.flush();
//              fileWritterBuffer.close();
//
//          } else {
//              meniu.errorOP(3);
//              meniu.pauseMenu();
//          }
//      }

//      void prelucrareDateDinFisierV1() throws IOException {//afisarea studentilor din chisinau V1(cu folosirea metodei contains
//
//
//          if (fileIsAssigned) {
//              FileReader fileReader = new FileReader(fileDeTari);
//              BufferedReader fileReaderBuffer = new BufferedReader(fileReader);
//              String line;
//
//              System.out.println("[============== Afișarea rezultatului ===============]");
//              while ((line = fileReaderBuffer.readLine()) != null) {
//                  if (line.contains("Chișinău")) {
//                      System.out.println(line);
//                  }
//              }
//          } else {
//              meniu.errorOP(3);
//          }
//      }
//
//      void prelucrareDateDinFisierV2() throws IOException {
//
//          if (fileIsAssigned) {
//              FileReader fileReader = new FileReader(fileDeTari);
//              BufferedReader fileReaderBuffer = new BufferedReader(fileReader);
//              String line;
//
//              System.out.println("[============== Afișarea rezultatului ===============]");
//              while ((line = fileReaderBuffer.readLine()) != null) {
//                  for (int i = 0; i < line.length() - 8; i++) {
//                      if ((line.charAt(i) == 'C') && (line.charAt(i + 1) == 'h') && (line.charAt(i + 2) == 'i')
//                              && (line.charAt(i + 3) == 'ș') && (line.charAt(i + 4) == 'i') && (line.charAt(i + 5) == 'n')
//                              && (line.charAt(i + 6) == 'ă') && (line.charAt(i + 7) == 'u')) {
//                          System.out.println(line);
//                      }
//                  }
//              }
//
//          } else {
//              meniu.errorOP(3);
//          }
//      }
//
//      void prelucrareDateDinFisierV3() throws IOException {
//
//          if (fileIsAssigned) {
//              FileReader fileReader = new FileReader(fileDeTari);
//              BufferedReader fileReaderBuffer = new BufferedReader(fileReader);
//              String line;
//
//              System.out.println("[============== Afișarea rezultatului ===============]");
//              while ((line = fileReaderBuffer.readLine()) != null) {
//                  String linelower = line.toLowerCase();
//                  for (int i = 0; i < linelower.length() - 8; i++) {
//                      if ((linelower.charAt(i) == 'c') && (linelower.charAt(i + 1) == 'h') && (linelower.charAt(i + 2) == 'i')
//                              && (linelower.charAt(i + 3) == 'ș') || (linelower.charAt(i + 3) == 's') && (linelower.charAt(i + 4) == 'i')
//                              && (linelower.charAt(i + 5) == 'n')
//                              && (linelower.charAt(i + 6) == 'ă') || (linelower.charAt(i + 6) == 'a') && (linelower.charAt(i + 7) == 'u')) {
//                          System.out.println(line);
//                      }
//                  }
//              }
//          } else {
//              meniu.errorOP(3);
//          }
//      }

	public void eliminareFisier() {

		if (fileIsAssigned) {
			fileDeTari.delete();
			fileIsAssigned = false;
			System.out.println("------------------------------------------------------");
			System.out.println(">Fișierul asociat a fost șters!");
			meniu.pauseMenu();
		} else {
			meniu.errorOP(5);
			meniu.pauseMenu();
		}
	}

//	void eliminareStudent() throws IOException {
//
//		if (fileIsAssigned) {
//
//			this.afisareFisier();
//			System.out.println("------------------------------------------------------");
//			System.out.println("Introduceți numărul studentului pentru ștergere ");
//			String ord = read.next();
//			String ords = "";
//
//			File tempFile = new File("temp");
//			BufferedReader reader = new BufferedReader(new FileReader(fileDeTari));
//			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
//
//			String checkLine;
//			String linie;
//			boolean existId = false;
//
//			while ((checkLine = reader.readLine()) != null) {
//
//				for (int i = 0; i < checkLine.length(); i++) {
//
//					if (checkLine.charAt(i) == ' ') {
//						break;
//					} else {
//						ords = ords + checkLine.charAt(i);
//					}
//				}
//
//				if (ord.compareTo(ords) == 0) {
//					existId = true;
//					break;
//				}
//				ords = "";
//			}
//
//			if (existId) {
//
//				BufferedReader rewrite = new BufferedReader(new FileReader(fileDeTari));
//
//				while ((linie = rewrite.readLine()) != null) {
//					if (linie.equals(checkLine))
//						continue;
//					writer.write(linie);
//					writer.newLine();
//				}
//
//				System.out.println("------------------------------------------------------");
//				System.out.println(">Studentul a fost șters!");
//				rewrite.close();
//			} else {
//				System.out.println("------------------------------------------------------");
//				System.out.println(">Studentul nu a fost șters sau nu există!");
//			}
//
//			reader.close();
//			writer.close();
//			reader = new BufferedReader(new FileReader(tempFile));
//			writer = new BufferedWriter(new FileWriter(fileDeTari));
//
//			while ((linie = reader.readLine()) != null) {
//				if (linie.equals(checkLine))
//					continue;
//				writer.write(linie);
//				writer.newLine();
//			}
//			reader.close();
//			writer.close();
//			tempFile.delete();
//
//			meniu.pauseMenu();
//		} else {
//			meniu.errorOP(5);
//			meniu.pauseMenu();
//		}
//	}

	public void assignFile(String str) throws IOException {

		fileDeTari = new File(str);
		fileName = str;

		if (fileDeTari.exists()) {
			System.out.println("------------------------------------------------------");
			System.out.println(">Fișierul cu numele \"" + str + "\" a fost asociat!");

			assignedFile = new File(fileDeTari.getName());
			fileIsAssigned = true;

			meniu.pauseMenu();
		} else {
			fileDeTari.createNewFile();
			if (fileDeTari.exists()) {
				System.out.println("------------------------------------------------------");
				System.out.println(">Fișierul \"" + fileName + "\" nu exista\n >Fișierul cu numele \"" + fileName
						+ "\" a fost creat și asociat!");

				assignedFile = new File(fileDeTari.getName());
				fileIsAssigned = true;

				meniu.pauseMenu();
			} else {
				meniu.errorOP(4);
				meniu.pauseMenu();
			}
		}
	}

	public void checkAssign() {

		if (fileIsAssigned) {
			System.out.println("[-----------------------------------------------------");
			System.out.println(">[Este asociat fisierul: \"" + assignedFile.getName() + "\"]");
			System.out.println("-----------------------------------------------------]");
		}
	}
}