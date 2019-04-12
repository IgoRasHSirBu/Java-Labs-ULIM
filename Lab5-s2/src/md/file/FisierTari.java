package md.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import md.country.AsianCountry;
import md.country.Country;
import md.country.EuropeanCountry;
import md.country.EuropeanUnionCountry;
import md.factory.CountryFactory;
import md.main.Menu;

public class FisierTari {

	File fileDeTari;
	File assignedFile;
	public boolean fileIsAssigned = false;
	Scanner read = new Scanner(System.in);
	String fileName = "countries";// default
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
			read.nextLine();

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
//TODO: read from deseralization
//	public void afisareFisier() throws IOException {
//
//		if (fileIsAssigned) {
//			System.out.println("[----------------------------------------------------]");
//
//			FileReader fileReader = new FileReader(assignedFile);
//			BufferedReader fileReaderBuffer = new BufferedReader(fileReader);
//
//			while (fileReaderBuffer.ready()) {
//				System.out.println(fileReaderBuffer.readLine());
//			}
//
//			fileReaderBuffer.close();
//			meniu.pauseMenu();
//		} else {
//			meniu.errorOP(5);
//			meniu.pauseMenu();
//		}
//	}

	public void addDateInFisier() throws IOException {

		File dateInFile;
		if (fileIsAssigned) {

			dateInFile = new File(assignedFile.getName());

			FileOutputStream fileOutStream = new FileOutputStream(dateInFile);
			ObjectOutputStream objOutStream = new ObjectOutputStream(fileOutStream);

			CountryFactory countryFactory = new CountryFactory();
			EuropeanCountry europeanCountry;
			AsianCountry asianCountry;
			EuropeanUnionCountry euUnionCountry;

			meniu.clrscr();
			System.out.println("------------------ [Introducere date] ----------------");

			System.out.println(">>Introduceți tipul Țării:");
			System.out.println(">\"EuropeanCountry\"\n>\"AsianCountry\"\n>\"EuropeanUnionCountry\"\n>\"Country\" (alt tip)");
			
			String typeCountry = read.nextLine();

			Country country = countryFactory.getCountry(typeCountry);
			
			if(country != null) {
				System.out.println(">Introduceți numele Țării:");
				country.setName(read.nextLine());
				
				System.out.println(">Introduceți capitala Țării:");//hmmm
				country.setCapital(read.nextLine());
				
				System.out.println(">Introduceți continentul Țării:");
				country.setContinent(read.nextLine());
				
				System.out.println(">Introduceți populația Țării:");
				country.setPopulation(read.nextDouble());
				read.nextLine();
				
				System.out.println(">Introduceți liderul Țării:");
				country.setLeader(read.nextLine());
				
				System.out.println(">Introduceți guvernul Țării:");
				country.setGovernment(read.nextLine());
				
			} else {
				meniu.errorOP(6);
				meniu.pauseMenu();
			}
			
			objOutStream.writeObject(country);
			
			
//			if (country instanceof EuropeanCountry) {
//				europeanCountry = new EuropeanCountry();
//			}
//			if (country instanceof AsianCountry) {
//				asianCountry = new AsianCountry();
//			}
//			if (country instanceof EuropeanUnionCountry) {
//				euUnionCountry = new EuropeanUnionCountry();
//			}

			System.out.println("------------------------------------------------------");
			System.out.println(">A fost introdusă o țară");
			meniu.pauseMenu();
			meniu.clrscr();

			objOutStream.close();
		} else {
			meniu.errorOP(3);
			meniu.pauseMenu();
		}
	}

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