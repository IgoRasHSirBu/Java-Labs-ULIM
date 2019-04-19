package md.common.file;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import md.common.country.Country;

/**
 * Operates with File and Country objects
 *
 * @author Fanncy
 */
public class CountryFile {

	private File countryFile;
	public boolean isAssigned;
	public String fileName;

	public CountryFile(File countryFile) {
		this.countryFile = countryFile;
		this.fileName = countryFile.getName();
		isAssigned = false;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Country> getData() {
		ArrayList<Country> countryList = new ArrayList<Country>();
		ObjectInputStream objectInputStream;
		try {
			objectInputStream = new ObjectInputStream(new FileInputStream(countryFile));
			try {
				countryList = (ArrayList<Country>) objectInputStream.readObject();
				if (countryList == null) {
					JOptionPane.showMessageDialog(null,
							"File : " + countryFile.getName() + " is is corrupted, please select another file");
					return null;
				}
				isAssigned = true;
				return countryList;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"File : " + countryFile.getName() + " is is corrupted, please select another file");
				this.countryFile = null;
				this.fileName = null;
				return null;
			} finally {
				objectInputStream.close();
			}
		} catch (FileNotFoundException e) {
			try {
				countryFile.createNewFile();
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "File : " + countryFile.getName() + " Cannot be created!");
				return null;
			}
			JOptionPane.showMessageDialog(null, "File : " + countryFile.getName() + " Has been created!");
			isAssigned = true;
			return new ArrayList<Country>();
		} catch (EOFException e) {
			if (countryList.isEmpty()) {
				JOptionPane.showMessageDialog(null, "File : " + countryFile.getName() + " is Empty!");
				return new ArrayList<Country>();
			} else {
				return countryList;
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,
					"File : " + countryFile.getName() + " is corrupted, please select another file");
			this.countryFile = null;
			this.fileName = null;
			return null;
		}

	}

	/**
	 * save curent data in file and update
	 */
	public void saveDataInFile(ArrayList<Country> countryList) {
		ObjectOutputStream objectOuputStream = null;
		try {
			objectOuputStream = new ObjectOutputStream(new FileOutputStream(countryFile));
			if (countryList != null)
				objectOuputStream.writeObject(countryList);
			objectOuputStream.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "File : " + countryFile.getName() + " Unknown Error Occurred!");
			e.printStackTrace();
		}
	}
}