package md.views;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import md.common.country.AsianCountry;
import md.common.country.Country;
import md.common.country.EuropeanCountry;
import md.common.country.EuropeanUnionCountry;

public class ShowCountryFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableDataCountry;
	private ArrayList<Country> countryList;
	private ArrayList<Country> countryListToShow;
	private DefaultTableModel dTabelDataModel;
	private JScrollPane scrollPaneForDataCountry;

	/**
	 * Create the frame.
	 */
	public ShowCountryFrame(MainFrame parrent, String typeOfCountry) {

		init(parrent, typeOfCountry);

	}

	private void init(MainFrame parrent, String typeOfCountry) {
		setTitle("Country DataBase: " + typeOfCountry);
		setResizable(false);
		setSize(1200, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPaneForDataCountry = new JScrollPane();
		scrollPaneForDataCountry.setBounds(10, 11, 1174, 549);
		contentPane.add(scrollPaneForDataCountry);

		String[] header = null;
		if (typeOfCountry.equals("European Countries") || typeOfCountry.equals("Asian Countries")) {
			header = new String[] { "No.", "Name", "Capital", "Leader", "Government", "Continent", "Population (Mln.)",
					"Currency", "Area" };
		}
		if (typeOfCountry.equals("EU Countries")) {
			header = new String[] { "No.", "Name", "Capital", "Leader", "Government", "Continent", "Population (Mln.)",
					"Currency", "Area", "Year Member" };
		}

		dTabelDataModel = new DefaultTableModel(header, 0);
		tableDataCountry = new JTable(dTabelDataModel);
		tableDataCountry.setEnabled(false);
		tableDataCountry.setFont(new Font("Tahoma", Font.BOLD, 14));
		scrollPaneForDataCountry.setViewportView(tableDataCountry);
		putDataInTable(parrent.getCountryList(), typeOfCountry);
		// center window
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		setVisible(true);

	}

	private void putDataInTable(ArrayList<Country> countryList, String typeOfCountry) {// countryFile.isAssigned
		// adding new/update rows
		if ((countryList != null) && (countryList.size() > 0)) {
			if (typeOfCountry.equals("European Countries")) {
				int ord = 1;
				for (int i = 0; i < countryList.size(); i++) {
					if (countryList.get(i).getClass() == EuropeanCountry.class
							|| countryList.get(i).getClass() == EuropeanUnionCountry.class) {
						EuropeanCountry c = (EuropeanCountry) countryList.get(i);
						dTabelDataModel.addRow(new String[] { Integer.toString(ord), c.getName(), c.getCapital(),
								c.getLeader(), c.getGovernment(), c.getContinent(), Double.toString(c.getPopulation()),
								c.getCurrency(), Double.toString(c.getArea()) });
						ord++;
					}
				}
			}
			if (typeOfCountry.equals("Asian Countries")) {
				int ord = 1;
				for (int i = 0; i < countryList.size(); i++) {
					if (countryList.get(i).getClass() == AsianCountry.class) {
						AsianCountry c = (AsianCountry) countryList.get(i);
						dTabelDataModel.addRow(new String[] { Integer.toString(ord), c.getName(), c.getCapital(),
								c.getLeader(), c.getGovernment(), c.getContinent(), Double.toString(c.getPopulation()),
								c.getCurrency(), Double.toString(c.getArea()) });
						ord++;
					}
				}
			}
			if (typeOfCountry.equals("EU Countries")) {
				int ord = 1;
				for (int i = 0; i < countryList.size(); i++) {
					if (countryList.get(i).getClass() == EuropeanUnionCountry.class) {
						EuropeanUnionCountry c = (EuropeanUnionCountry) countryList.get(i);
						dTabelDataModel.addRow(new String[] { Integer.toString(ord), c.getName(), c.getCapital(),
								c.getLeader(), c.getGovernment(), c.getContinent(), Double.toString(c.getPopulation()),
								c.getCurrency(), Double.toString(c.getArea()), Integer.toString(c.getYearMember()) });
						ord++;
					}
				}
			}
		}
	}
}
