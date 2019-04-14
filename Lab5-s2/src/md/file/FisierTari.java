package md.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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

	public void afisareFisier() throws IOException {

		if (fileIsAssigned) {
			System.out.println("[----------------------------------------------------]");

			FileInputStream fileInputStream = new FileInputStream(fileDeTari);
			ObjectInputStream objInputStream = new ObjectInputStream(fileInputStream);

			Country country;
			try {
				while (true) {
					country = (Country) objInputStream.readObject();
					if (country != null) {
						System.out.println("------------------------------------------------------");
						country.showDataOfCountry();
					}
				}
			} catch (ClassNotFoundException | java.io.EOFException end) {
				System.out.println("------------------------------------------------------");
			} finally {
				objInputStream.close();
			}

			meniu.pauseMenu();
		} else {
			meniu.errorOP(5);
			meniu.pauseMenu();
		}
	}

	public void addDateInFisier() throws IOException {

		File dateInFile;
		if (fileIsAssigned) {

			dateInFile = new File(assignedFile.getName());

			ObjectOutputStream objOutStream;

			if (dateInFile.length() == 0L) {
				objOutStream = new ObjectOutputStream(new FileOutputStream(dateInFile));
			} else {
				objOutStream = new AppendableObjectOutputStream(new FileOutputStream(dateInFile, true));
			}

			CountryFactory countryFactory = new CountryFactory();
			EuropeanCountry europeanCountry;
			AsianCountry asianCountry;
			EuropeanUnionCountry euUnionCountry;

			meniu.clrscr();
			System.out.println("------------------ [Introducere date] ----------------");
			System.out.println(">>Introduceți tipul Țării:");
			System.out.println(
					">\"EuropeanCountry\"\n>\"AsianCountry\"\n>\"EuropeanUnionCountry\"\n>\"Country\" (alt tip)");
			System.out.println("------------------------------------------------------");
			System.out.println(">Introduceți alegerea: ");

			String typeCountry = read.nextLine();

			Country country = countryFactory.getCountry(typeCountry);

			if (country != null) {
				System.out.println(">Introduceți numele Țării:");
				country.setName(read.nextLine());

				System.out.println(">Introduceți capitala Țării:");
				country.setCapital(read.nextLine());

				if (country.getClass() == Country.class) {
					System.out.println(">Introduceți continentul Țării:");
					country.setContinent(read.nextLine());
				}

				System.out.println(">Introduceți populația Țării:");
				country.setPopulation(read.nextDouble());
				read.nextLine();

				System.out.println(">Introduceți liderul Țării:");
				country.setLeader(read.nextLine());

				System.out.println(">Introduceți guvernul Țării:");
				country.setGovernment(read.nextLine());

				if (country.getClass() == EuropeanCountry.class) {

					europeanCountry = (EuropeanCountry) country;

					System.out.println(">Introduceți valuta Țării:");
					europeanCountry.setCurrency(read.nextLine());

					System.out.println(">Introduceți suprafața Țării:");
					europeanCountry.setArea(read.nextDouble());
					read.nextLine();

				}
				if (country.getClass() == AsianCountry.class) {
					asianCountry = (AsianCountry) country;

					System.out.println(">Introduceți valuta Țării:");
					asianCountry.setCurrency(read.nextLine());

					System.out.println(">Introduceți suprafața Țării:");
					asianCountry.setArea(read.nextDouble());
					read.nextLine();
				}
				if (country.getClass() == EuropeanUnionCountry.class) {
					euUnionCountry = (EuropeanUnionCountry) country;// same addres

					System.out.println(">Introduceți valuta Țării:");
					euUnionCountry.setCurrency(read.nextLine());

					System.out.println(">Introduceți suprafața Țării:");
					euUnionCountry.setArea(read.nextDouble());
					read.nextLine();

					System.out.println(">Introduceți anul intrării în UE a Țării:");
					euUnionCountry.setYearMember(read.nextInt());
					read.nextLine();

				}

				objOutStream.writeObject(country);
				System.out.println("------------------------------------------------------");
				System.out.println(">A fost introdusă o țară");
				meniu.pauseMenu();
				meniu.clrscr();

			} else {
				meniu.errorOP(6);
				meniu.pauseMenu();
			}
			objOutStream.close();
		} else {
			meniu.errorOP(3);
			meniu.pauseMenu();
		}
	}

	public void afisareTariDinContinentul(String continent) throws IOException {
		if (fileIsAssigned) {

			ObjectInputStream objInputStream = new ObjectInputStream(new FileInputStream(fileDeTari));
			Country country;
			try {
				System.out.println("[============== Afișarea rezultatului ===============]");
				System.out.println("[----------------------------------------------------]");
				while (true) {
					country = (Country) objInputStream.readObject();
					if (country != null) {
						if (country.getContinent().equalsIgnoreCase(continent)) {
							System.out.println("------------------------------------------------------");
							country.showDataOfCountry();
						}
					}
				}
			} catch (ClassNotFoundException | java.io.EOFException end) {
				System.out.println("------------------------------------------------------");
			} finally {
				objInputStream.close();
			}

		} else {
			meniu.errorOP(3);
		}
	}

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