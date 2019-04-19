package md.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import md.common.country.*;
import md.common.file.CountryFile;

public class MainFrame extends JFrame {

	// Components of layout
	private JTable tableForCountryData;
	private JScrollPane scrollPaneForTable;
	private JPanel panelMenu;
	private JButton btnOpenFile;
	private JButton btnSave;
	private JButton btnSaveAs;
	private JPanel panelInfo;
	private JLabel lblNumberOfCountries;
	private JLabel lblMaxCountryPop;
	private JLabel lblMinCountryPop;
	private JPanel panelTabelMenu;
	private JButton btnAdd;
	private JButton btnRemove;
	private JPanel panelQuery;
	private JButton btnShowEuropeanCountries;
	private JButton btnShowAsianCountries;
	private JButton btnShowOtherCountries;
	private JLabel lblWorkingInFile;

	// var declaration
	private CountryFile countryFile;
	private DefaultTableModel dTabelDataModel;
	private ArrayList<Country> countryList;

	// Constructor
	public MainFrame() {
		// Initialize
		init();
		updateAllPanels(true, false);
	}

	/**
	 * Initialize components of layout
	 */
	private void init() {

		setResizable(false);
		setSize(1200, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		scrollPaneForTable = new JScrollPane();
		scrollPaneForTable.setBounds(140, 249, 1045, 511);
		getContentPane().add(scrollPaneForTable);

		// Table Initialize
		String[] header = { "No.", "Name", "Capital", "Leader", "Government", "Continent", "Population (Mln.)" };
		dTabelDataModel = new DefaultTableModel(header, 0);
		tableForCountryData = new JTable(dTabelDataModel);
		scrollPaneForTable.setViewportView(tableForCountryData);

		panelMenu = new JPanel();
		panelMenu.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMenu.setBounds(10, 11, 290, 220);
		getContentPane().add(panelMenu);
		panelMenu.setLayout(null);

		// add listener for openFile button
		btnOpenFile = new JButton("Open File");
		btnOpenFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(MainFrame.this);

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					countryFile = new CountryFile(fc.getSelectedFile());
					countryList = countryFile.getData();// and check if it is corrupted
					updateAllPanels(false, false);
					updatePanelInfo();
					updateDataTabel();
				}
			}
		});

		btnOpenFile.setBounds(70, 25, 150, 40);
		panelMenu.add(btnOpenFile);

		btnSave = new JButton("Save");
		btnSave.setBounds(70, 90, 150, 40);
		panelMenu.add(btnSave);

		btnSaveAs = new JButton("Save As");
		btnSaveAs.setBounds(70, 155, 150, 40);
		panelMenu.add(btnSaveAs);

		panelInfo = new JPanel();
		panelInfo.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelInfo.setBounds(610, 11, 575, 220);
		getContentPane().add(panelInfo);
		panelInfo.setLayout(null);

		lblNumberOfCountries = new JLabel("Number of Countries:");
		lblNumberOfCountries.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumberOfCountries.setBounds(10, 65, 555, 40);
		panelInfo.add(lblNumberOfCountries);

		lblMaxCountryPop = new JLabel("Country with max population:");
		lblMaxCountryPop.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMaxCountryPop.setBounds(10, 145, 555, 40);
		panelInfo.add(lblMaxCountryPop);

		lblMinCountryPop = new JLabel("Country with min population:");
		lblMinCountryPop.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMinCountryPop.setBounds(10, 105, 555, 40);
		panelInfo.add(lblMinCountryPop);

		lblWorkingInFile = new JLabel("Working in File:");
		lblWorkingInFile.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWorkingInFile.setBounds(10, 25, 555, 40);
		panelInfo.add(lblWorkingInFile);

		panelTabelMenu = new JPanel();
		panelTabelMenu.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTabelMenu.setBounds(10, 250, 120, 511);
		getContentPane().add(panelTabelMenu);
		panelTabelMenu.setLayout(null);

		btnAdd = new JButton("Add");// open AddCountryFrame
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {// MainFrame.this - Accessing methods
				AddCountryFrame addCountryFrame = new AddCountryFrame(MainFrame.this);
				updateAllPanels(true, true);
				addCountryFrame.addWindowListener(new java.awt.event.WindowAdapter() {
					@Override // JFrame can be closed by btn
					public void windowClosing(java.awt.event.WindowEvent windowEvent) {
						updateAllPanels(false, false);
					}
				});
			}
		});
		btnAdd.setBounds(10, 11, 100, 40);
		panelTabelMenu.add(btnAdd);

		btnRemove = new JButton("Remove");
		btnRemove.setBounds(10, 62, 100, 40);
		panelTabelMenu.add(btnRemove);

		panelQuery = new JPanel();
		panelQuery.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelQuery.setBounds(310, 11, 290, 220);
		getContentPane().add(panelQuery);
		panelQuery.setLayout(null);

		btnShowEuropeanCountries = new JButton("Show European Countries");
		btnShowEuropeanCountries.setBounds(70, 25, 160, 40);
		panelQuery.add(btnShowEuropeanCountries);

		btnShowAsianCountries = new JButton("Show Asian Countries");
		btnShowAsianCountries.setBounds(70, 90, 160, 40);
		panelQuery.add(btnShowAsianCountries);

		btnShowOtherCountries = new JButton("Show other Countries");
		btnShowOtherCountries.setBounds(70, 155, 160, 40);
		panelQuery.add(btnShowOtherCountries);
		setVisible(true);
	}

	/**
	 * Update date in to tabel
	 */
	public void updateDataTabel() {
		// deleting all rows
		for (int i = dTabelDataModel.getRowCount() - 1; i >= 0; i--) {
			dTabelDataModel.removeRow(i);
		}
		// adding new/update rows
		if ((countryList.size() > 0) && countryFile.isAssigned) {
			for (int i = 0; i < countryList.size(); i++) {
				dTabelDataModel.addRow(new String[] { Integer.toString(i + 1), countryList.get(i).getName(),
						countryList.get(i).getCapital(), countryList.get(i).getLeader(),
						countryList.get(i).getGovernment(), countryList.get(i).getContinent(),
						Double.toString(countryList.get(i).getPopulation()) });
			}
		}
	}

	/**
	 * Enable/Disable components
	 */
	public void updateAllPanels(boolean disable, boolean disableBtnOpenFile) {
		if (countryFile == null || !countryFile.isAssigned || disable) {
			if (disableBtnOpenFile) {
				btnOpenFile.setEnabled(false);// to prevent opening a new file
			}
			btnAdd.setEnabled(false);
			btnRemove.setEnabled(false);
			btnShowAsianCountries.setEnabled(false);
			btnShowEuropeanCountries.setEnabled(false);
			btnShowOtherCountries.setEnabled(false);
			tableForCountryData.setEnabled(false);
			btnSave.setEnabled(false);
			btnSaveAs.setEnabled(false);
			lblWorkingInFile.setEnabled(false);
			lblNumberOfCountries.setEnabled(false);
			lblMinCountryPop.setEnabled(false);
			lblMaxCountryPop.setEnabled(false);
		} else {
			btnOpenFile.setEnabled(true);
			btnAdd.setEnabled(true);
			btnRemove.setEnabled(true);
			btnShowAsianCountries.setEnabled(true);
			btnShowEuropeanCountries.setEnabled(true);
			btnShowOtherCountries.setEnabled(true);
			tableForCountryData.setEnabled(true);
			btnSave.setEnabled(true);
			btnSaveAs.setEnabled(true);
			lblWorkingInFile.setEnabled(true);
			lblNumberOfCountries.setEnabled(true);
			lblMinCountryPop.setEnabled(true);
			lblMaxCountryPop.setEnabled(true);
		}
	}

	/**
	 * Update panel info
	 */
	public void updatePanelInfo() {
		if (countryFile.isAssigned) {
			lblWorkingInFile.setText("Working in File: \"" + countryFile.fileName + "\"");
		} else {
			lblWorkingInFile.setText("Working in File: ");
		}
		if ((countryList.size() > 0)) {
			ArrayList<Country> sortedCountries = new ArrayList<Country>(countryList);
			sortedCountries.sort(new PopulationComparator());
			int max = sortedCountries.size() - 1;
			int min = 0;
			lblMaxCountryPop.setText("Country with max population: " + sortedCountries.get(max).getName() + " "
					+ sortedCountries.get(max).getPopulation() + " Mln.");
			lblMinCountryPop.setText("Country with min population: " + sortedCountries.get(min).getName() + " "
					+ sortedCountries.get(min).getPopulation() + " Mln.");
			lblNumberOfCountries.setText("Number of Countries: " + countryList.size());
		} else {
			lblNumberOfCountries.setText("Number of Countries: ");
			lblMaxCountryPop.setText("Country with max population: ");
			lblMinCountryPop.setText("Country with min population: ");
		}
	}

	/**
	 * 
	 * @return countryList
	 */
	public ArrayList<Country> getCountryList() {
		return this.countryList;
	}
}
