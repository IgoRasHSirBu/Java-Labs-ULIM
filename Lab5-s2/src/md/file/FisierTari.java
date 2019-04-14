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

	public void eliminareTara() throws IOException {

		if (fileIsAssigned) {

			this.afisareFisier();
			System.out.println("------------------------------------------------------");
			System.out.println("Introduceți numele țării pentru ștergere ");
			String countryNameToDelete = read.next();
			read.nextLine();
			System.out.println("<--------------------Căutare Țară-------------------->");

			File tempFile = new File("temp");
			ObjectInputStream objInputStream = new ObjectInputStream(new FileInputStream(fileDeTari));
//			ObjectOutputStream objOutputStream = new ObjectOutputStream(new FileOutputStream(tempFile));

			Country country;
			boolean exitsCountry = false;
			try {
				// editam numele dupa conditie
				if (countryNameToDelete.length() > 3) {
					countryNameToDelete = countryNameToDelete.substring(0, 1).toUpperCase()
							+ countryNameToDelete.substring(1, 3);
				} else {
					countryNameToDelete = countryNameToDelete.substring(0, 1).toUpperCase();
				}
				// afisarea tarei care va fi strearsa din file
				System.out.println(countryNameToDelete);
				while (true) {
					country = (Country) objInputStream.readObject();
					if (country != null) {
						if (country.getName().equalsIgnoreCase(countryNameToDelete)) {
							System.out.println("------------------------------------------------------");
							country.showDataOfCountry();
							exitsCountry = true;
							break;
						}
					}
				}
			} catch (ClassNotFoundException | java.io.EOFException end) {
				System.out.println("------------------------------------------------------");
			} finally {
				objInputStream.close();
			}

			if (exitsCountry) {

				ObjectOutputStream objOutputStreamHeader = new ObjectOutputStream(new FileOutputStream(tempFile));
				AppendableObjectOutputStream objOutStreamAppend = new AppendableObjectOutputStream(
						new FileOutputStream(tempFile, true));
				ObjectInputStream objInputStreamCopy = new ObjectInputStream(new FileInputStream(fileDeTari));
				boolean exitsHeader = false;

				// citirea obiectelor fara obj cu numele == countryNameToDelete in temp file
				try {

					while (true) {
						country = (Country) objInputStreamCopy.readObject();
						if (country != null) {
							if (!(country.getName().equalsIgnoreCase(countryNameToDelete))) {
								if (exitsHeader) {
									objOutStreamAppend.writeObject(country);
								} else {
									objOutputStreamHeader.writeObject(country);
									objOutputStreamHeader.close();
									exitsHeader = true;
								}
							}
						}
					}

				} catch (ClassNotFoundException | java.io.EOFException end) {

				} finally {
					objOutStreamAppend.close();
					objInputStreamCopy.close();
					exitsHeader = false;
				}

//				// copierea din temp in file original si stergerea temp
				objInputStreamCopy = new ObjectInputStream(new FileInputStream(tempFile));
				objOutputStreamHeader = new ObjectOutputStream(new FileOutputStream(fileDeTari));
				objOutStreamAppend = new AppendableObjectOutputStream(new FileOutputStream(fileDeTari, true));

				try {
					while (true) {
						country = (Country) objInputStreamCopy.readObject();
						if (country != null) {
							if (exitsHeader) {
								objOutStreamAppend.writeObject(country);
							} else {
								objOutputStreamHeader.writeObject(country);
								objOutputStreamHeader.close();
								exitsHeader = true;
							}
						}
					}

				} catch (ClassNotFoundException | java.io.EOFException end) {

				} catch (Exception ex) {
//hmmm sterge toate inafara de una :h mm
				} finally {
					objOutStreamAppend.close();
					objInputStreamCopy.close();
					tempFile.delete();
				}

				System.out.println("------------------------------------------------------");
				System.out.println(">Țara a fost ștersă!");
			} else {
				System.out.println("------------------------------------------------------");
				System.out.println(">Țara nu a fost ștersă sau nu există!");
			}

			meniu.pauseMenu();
		} else {
			meniu.errorOP(5);
			meniu.pauseMenu();
		}
	}

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