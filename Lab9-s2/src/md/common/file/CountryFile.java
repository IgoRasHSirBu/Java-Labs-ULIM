package md.common.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import md.common.country.*;

/**
 * Operates with File and Country objects
 *
 * @author Fanncy
 */
public class CountryFile {

    File fileDeTari;
    public boolean fileIsAssigned = false;
    String fileName = "countries";// default path




//    /**
//     * Displays all data from file
//     *
//     * @throws IOException
//     */
//    public void afisareFisier() throws IOException {
//
//        if (fileIsAssigned) {
//            System.out.println("[----------------------------------------------------]");
//            // check if file is empty or not
//            if (fileDeTari.length() != 0L) {
//                FileInputStream fileInputStream = new FileInputStream(fileDeTari);
//                ObjectInputStream objInputStream = new ObjectInputStream(fileInputStream);
//
//                Country country;
//                try {
//                    while (true) {
//                        country = (Country) objInputStream.readObject();
//                        if (country != null) {
//                            System.out.println("------------------------------------------------------");
//                            country.getDataOfCountry();
//                        }
//                    }
//                } catch (ClassNotFoundException | java.io.EOFException end) {
//                    System.out.println("------------------------------------------------------");
//                } finally {
//                    objInputStream.close();
//                }
//            }
//
//        } else {
//        }
//    }
//
//    /**
//     * Adds new country object to file
//     *
//     * @throws IOException
//     */
//    public void addDateInFisier() throws IOException {
//
//        File dateInFile;
//        if (fileIsAssigned) {
//            dateInFile = new File(fileDeTari.getName());
//
//            ObjectOutputStream objOutStream;
//            // check if file is empty or not, if append is required for new objects
//            if (dateInFile.length() == 0L) {
//                objOutStream = new ObjectOutputStream(new FileOutputStream(dateInFile));
//            } else {
//                objOutStream = new AppendableObjectOutputStream(new FileOutputStream(dateInFile, true));
//            }
//
//            CountryFactory countryFactory = new CountryFactory();// pattern for country objects
//            EuropeanCountry europeanCountry;
//            AsianCountry asianCountry;
//            EuropeanUnionCountry euUnionCountry;
//
//            System.out.println("------------------ [Introducere date] ----------------");
//            System.out.println(">>Introduceți tipul Țării:");
//            System.out.println(
//                    ">\"European Country\"\n>\"Asian Country\"\n>\"European Union Country\"\n>\"Country\" (alt tip)");
//            System.out.println("------------------------------------------------------");
//            System.out.println(">Introduceți alegerea: ");
//
//            String typeCountry = read.nextLine();
//
//            Country country = countryFactory.getCountry(typeCountry);// get new country object
//
//            // Entering data for new country
//            if (country != null) {
//                System.out.println(">Introduceți numele Țării:");
//                country.setName(read.nextLine());
//
//                System.out.println(">Introduceți capitala Țării:");
//                country.setCapital(read.nextLine());
//
//                if (country.getClass() == Country.class) {// check for additional members
//                    System.out.println(">Introduceți continentul Țării:");
//                    country.setContinent(read.nextLine());
//                }
//
//                System.out.println(">Introduceți populația Țării:");
//                country.setPopulation(read.nextDouble());
//                read.nextLine();
//
//                System.out.println(">Introduceți liderul Țării:");
//                country.setLeader(read.nextLine());
//
//                System.out.println(">Introduceți guvernul Țării:");
//                country.setGovernment(read.nextLine());
//
//                if (country.getClass() == EuropeanCountry.class) {// check for additional members
//
//                    europeanCountry = (EuropeanCountry) country;
//
//                    System.out.println(">Introduceți valuta Țării:");
//                    europeanCountry.setCurrency(read.nextLine());
//
//                    System.out.println(">Introduceți suprafața Țării:");
//                    europeanCountry.setArea(read.nextDouble());
//                    read.nextLine();
//
//                }
//                if (country.getClass() == AsianCountry.class) {// check for additional members
//                    asianCountry = (AsianCountry) country;
//
//                    System.out.println(">Introduceți valuta Țării:");
//                    asianCountry.setCurrency(read.nextLine());
//
//                    System.out.println(">Introduceți suprafața Țării:");
//                    asianCountry.setArea(read.nextDouble());
//                    read.nextLine();
//                }
//                if (country.getClass() == EuropeanUnionCountry.class) {// check for additional members
//                    euUnionCountry = (EuropeanUnionCountry) country;// same address
//
//                    System.out.println(">Introduceți valuta Țării:");
//                    euUnionCountry.setCurrency(read.nextLine());
//
//                    System.out.println(">Introduceți suprafața Țării:");
//                    euUnionCountry.setArea(read.nextDouble());
//                    read.nextLine();
//
//                    System.out.println(">Introduceți anul intrării în UE a Țării:");
//                    euUnionCountry.setYearMember(read.nextInt());
//                    read.nextLine();
//
//                }
//
//                objOutStream.writeObject(country);
//                System.out.println("------------------------------------------------------");
//                System.out.println(">A fost introdusă o țară");
//
//            } else {
//            }
//            objOutStream.close();
//        } else {
//        }
//    }
//
//    /**
//     * Display all countries witch specified continent
//     *
//     * @param continent of country to display
//     * @throws IOException
//     */
//    public void afisareTariDinContinentul(String continent) throws IOException {
//        if (fileIsAssigned) {
//            ObjectInputStream objInputStream = new ObjectInputStream(new FileInputStream(fileDeTari));
//            Country country;
//            try {
//                System.out.println("[============== Afișarea rezultatului ===============]");
//                System.out.println("[----------------------------------------------------]");
//                while (true) {
//                    country = (Country) objInputStream.readObject();
//                    if (country != null) {
//                        if (country.getContinent().equalsIgnoreCase(continent)) {
//                            System.out.println("------------------------------------------------------");
//                            country.getDataOfCountry();
//                        }
//                    }
//                }
//            } catch (ClassNotFoundException | java.io.EOFException end) {
//                System.out.println("------------------------------------------------------");
//            } finally {
//                objInputStream.close();
//            }
//
//        } else {
//        }
//    }
//
//    /**
//     * Deletes current file
//     */
//    public void eliminareFisier() {
//
//        if (fileIsAssigned) {
//            fileDeTari.delete();
//            System.out.println(fileDeTari.getAbsolutePath());
//            fileIsAssigned = false;
//            System.out.println("------------------------------------------------------");
//            System.out.println(">Fișierul asociat a fost șters!");
//        } else {
//        }
//    }
//
//    /**
//     * Deletes specified country
//     *
//     * @throws IOException
//     */
//    public void eliminareTara() throws IOException {
//
//        if (fileIsAssigned) {
//
//            this.afisareFisier();
//            System.out.println("------------------------------------------------------");
//            System.out.println("Introduceți numele țării pentru ștergere ");
//            String countryNameToDelete = read.next();
//            read.nextLine();
//            System.out.println("<--------------------Căutare Țară-------------------->");
//
//            File tempFile = new File("temp");
//            ObjectInputStream objInputStream = new ObjectInputStream(new FileInputStream(fileDeTari));
//
//            Country country;
//            boolean exitsCountry = false;
//            try {
//                // Edits the name of country ex: Moldova -> Mol
//                if (countryNameToDelete.length() >= 3) {
//                    countryNameToDelete = countryNameToDelete.substring(0, 1).toUpperCase()
//                            + countryNameToDelete.substring(1, 3);
//                } else {
//                    countryNameToDelete = "Unknown";
//                }
//                // Displays country which will be deleted
//                System.out.println(countryNameToDelete);
//                while (true) {
//                    country = (Country) objInputStream.readObject();
//                    if (country != null) {
//                        if (country.getName().equalsIgnoreCase(countryNameToDelete)) {
//                            System.out.println("------------------------------------------------------");
//                            country.getDataOfCountry();
//                            exitsCountry = true;
//                            break;
//                        }
//                    }
//                }
//            } catch (ClassNotFoundException | java.io.EOFException end) {
//                System.out.println("------------------------------------------------------");
//            } finally {
//                objInputStream.close();
//            }
//
//            if (exitsCountry) {
//
//                ObjectOutputStream objOutputStreamHeader = new ObjectOutputStream(new FileOutputStream(tempFile));
//                AppendableObjectOutputStream objOutStreamAppend = new AppendableObjectOutputStream(
//                        new FileOutputStream(tempFile, true));
//                ObjectInputStream objInputStreamCopy = new ObjectInputStream(new FileInputStream(fileDeTari));
//                boolean exitsHeader = false;
//
//                // Copy all object to temp file without == countryNameToDelete
//                try {
//                    while (true) {
//                        country = (Country) objInputStreamCopy.readObject();
//                        if (country != null) {
//                            if (!(country.getName().equalsIgnoreCase(countryNameToDelete))) {
//                                if (exitsHeader) {
//                                    objOutStreamAppend.writeObject(country);
//                                } else {
//                                    objOutputStreamHeader.writeObject(country);
//                                    objOutputStreamHeader.close();
//                                    exitsHeader = true;
//                                }
//                            }
//                        }
//                    }
//
//                } catch (ClassNotFoundException | java.io.EOFException end) {
//                } finally {
//                    objOutStreamAppend.close();
//                    objInputStreamCopy.close();
//                    exitsHeader = false;
//                }
//
//                // Copy all obj from temp file in current file
//                objInputStreamCopy = new ObjectInputStream(new FileInputStream(tempFile));
//                objOutputStreamHeader = new ObjectOutputStream(new FileOutputStream(fileDeTari));
//                objOutStreamAppend = new AppendableObjectOutputStream(new FileOutputStream(fileDeTari, true));
//
//                try {
//                    while (true) {
//                        country = (Country) objInputStreamCopy.readObject();
//                        if (country != null) {
//                            if (exitsHeader) {
//                                objOutStreamAppend.writeObject(country);
//                            } else {
//                                objOutputStreamHeader.writeObject(country);
//                                objOutputStreamHeader.close();
//                                exitsHeader = true;
//                            }
//                        }
//                    }
//                } catch (ClassNotFoundException | java.io.EOFException end) {
//                } catch (Exception ex) {
//                } finally {
//                    objOutStreamAppend.close();
//                    objInputStreamCopy.close();
//                    tempFile.delete();
//                }
//                System.out.println("------------------------------------------------------");
//                System.out.println(">Țara a fost ștersă!");
//            } else {
//                System.out.println("------------------------------------------------------");
//                System.out.println(">Țara nu a fost ștersă sau nu există!");
//            }
//        } else {
//        }
//    }
//
//    /**
//     * Assigns new file or create new file if the assigned file dosen't exists
//     *
//     * @param str - path/name of the file(when create new file)
//     * @throws IOException
//     */
//    public void assignFile(String str) throws IOException {
//
//        fileDeTari = new File(str);
//        fileName = str;
//
//        if (fileDeTari.exists()) {
//            System.out.println("------------------------------------------------------");
//            System.out.println(">Fișierul cu numele \"" + str + "\" a fost asociat!");
//
//            fileIsAssigned = true;
//
//        } else {
//            fileDeTari.createNewFile();
//            if (fileDeTari.exists()) {
//                System.out.println("------------------------------------------------------");
//                System.out.println(">Fișierul \"" + fileName + "\" nu exista\n >Fișierul cu numele \"" + fileName
//                        + "\" a fost creat și asociat!");
//
//                fileIsAssigned = true;
//
//            } else {
//            }
//        }
//    }
}