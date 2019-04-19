package md.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import md.common.country.*;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class AddCountryFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldCapital;
	private JTextField textFieldLeader;
	private JTextField textFieldGovernment;
	private JTextField textFieldContinent;
	private JTextField textFieldPopulation;
	private JTextField textFieldCurrency;
	private JTextField textFieldYearMember;
	private JPanel panelAddCountryMenu;
	private JComboBox<String> comboBoxCountryType;
	private JLabel lblSelectCountryType;
	private JLabel lblCapital;
	private JLabel lblLeader;
	private JLabel lblGovernment;
	private JLabel lblContinent;
	private JLabel lblName;
	private JLabel lblPopulation;
	private JLabel lblCurrency;
	private JLabel lblEuYearMember;
	private JButton btnClose;
	private JButton btnAdd;
	private JTextField textFieldArea;
	private JLabel lblArea;

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AddCountryFrame frame = new AddCountryFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public AddCountryFrame(MainFrame parrent) {// TODO: add components
		init(parrent);
	}

	private void init(MainFrame parrent) {
		setSize(600, 800);
		this.setTitle("Country DataBase: Add Country");
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelAddCountryMenu = new JPanel();
		panelAddCountryMenu.setBounds(10, 11, 564, 739);
		contentPane.add(panelAddCountryMenu);
		panelAddCountryMenu.setLayout(null);

		comboBoxCountryType = new JComboBox<>();
		comboBoxCountryType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String seletctedType = (String) comboBoxCountryType.getSelectedItem();
				if (seletctedType.equals("Country")) {
					textFieldCurrency.setEnabled(false);
					lblCurrency.setEnabled(false);
					textFieldYearMember.setEnabled(false);
					lblEuYearMember.setEnabled(false);
					textFieldContinent.setEnabled(true);
					lblContinent.setEnabled(true);
					textFieldContinent.setText(null);
					textFieldArea.setEnabled(false);
					lblArea.setEnabled(false);

				}
				if (seletctedType.equals("European Country")) {
					textFieldCurrency.setEnabled(true);
					textFieldYearMember.setEnabled(false);
					textFieldContinent.setEnabled(false);
					lblContinent.setEnabled(false);
					textFieldArea.setEnabled(true);
					lblArea.setEnabled(true);
					lblCurrency.setEnabled(true);
					lblEuYearMember.setEnabled(false);
					textFieldContinent.setText("Europa");
				}
				if (seletctedType.equals("Asian Country")) {
					textFieldCurrency.setEnabled(true);
					textFieldYearMember.setEnabled(false);
					textFieldContinent.setEnabled(false);
					lblContinent.setEnabled(false);
					textFieldArea.setEnabled(true);
					lblArea.setEnabled(true);
					lblCurrency.setEnabled(true);
					lblEuYearMember.setEnabled(false);
					textFieldContinent.setText("Asia");
				}
				if (seletctedType.equals("EU Country")) {
					textFieldCurrency.setEnabled(true);
					textFieldYearMember.setEnabled(true);
					textFieldContinent.setEnabled(false);
					lblContinent.setEnabled(false);
					textFieldArea.setEnabled(true);
					lblArea.setEnabled(true);
					lblCurrency.setEnabled(true);
					lblEuYearMember.setEnabled(true);
					textFieldContinent.setText("Europa");
				}
			}
		});
		comboBoxCountryType.setMaximumRowCount(4);
		comboBoxCountryType.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Country", "European Country", "Asian Country", "EU Country" }));
		comboBoxCountryType.setFont(new Font("Tahoma", Font.BOLD, 16));
		comboBoxCountryType.setBounds(283, 11, 271, 53);
		panelAddCountryMenu.add(comboBoxCountryType);

		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Tahoma", Font.BOLD, 16));
		textFieldName.setBounds(283, 75, 271, 53);
		panelAddCountryMenu.add(textFieldName);
		textFieldName.setColumns(10);

		textFieldCapital = new JTextField();
		textFieldCapital.setFont(new Font("Tahoma", Font.BOLD, 16));
		textFieldCapital.setBounds(283, 139, 271, 53);
		panelAddCountryMenu.add(textFieldCapital);
		textFieldCapital.setColumns(10);

		textFieldLeader = new JTextField();
		textFieldLeader.setFont(new Font("Tahoma", Font.BOLD, 16));
		textFieldLeader.setBounds(283, 203, 271, 53);
		panelAddCountryMenu.add(textFieldLeader);
		textFieldLeader.setColumns(10);

		textFieldGovernment = new JTextField();
		textFieldGovernment.setFont(new Font("Tahoma", Font.BOLD, 16));
		textFieldGovernment.setBounds(283, 267, 271, 53);
		panelAddCountryMenu.add(textFieldGovernment);
		textFieldGovernment.setColumns(10);

		textFieldContinent = new JTextField();
		textFieldContinent.setFont(new Font("Tahoma", Font.BOLD, 16));
		textFieldContinent.setBounds(283, 331, 271, 53);
		panelAddCountryMenu.add(textFieldContinent);
		textFieldContinent.setColumns(10);

		textFieldPopulation = new JTextField();
		textFieldPopulation.setFont(new Font("Tahoma", Font.BOLD, 16));
		textFieldPopulation.setBounds(283, 395, 271, 53);
		panelAddCountryMenu.add(textFieldPopulation);
		textFieldPopulation.setColumns(10);

		textFieldCurrency = new JTextField();
		textFieldCurrency.setFont(new Font("Tahoma", Font.BOLD, 16));
		textFieldCurrency.setEnabled(false);
		textFieldCurrency.setBounds(283, 459, 271, 53);
		panelAddCountryMenu.add(textFieldCurrency);
		textFieldCurrency.setColumns(10);

		textFieldYearMember = new JTextField();
		textFieldYearMember.setFont(new Font("Tahoma", Font.BOLD, 16));
		textFieldYearMember.setEnabled(false);
		textFieldYearMember.setBounds(283, 523, 271, 53);
		panelAddCountryMenu.add(textFieldYearMember);
		textFieldYearMember.setColumns(10);

		lblSelectCountryType = new JLabel("Select Country Type:");
		lblSelectCountryType.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSelectCountryType.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSelectCountryType.setBounds(10, 11, 263, 53);
		panelAddCountryMenu.add(lblSelectCountryType);

		lblCapital = new JLabel("Capital:");
		lblCapital.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCapital.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCapital.setBounds(10, 139, 263, 53);
		panelAddCountryMenu.add(lblCapital);

		lblLeader = new JLabel("Leader:");
		lblLeader.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLeader.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLeader.setBounds(10, 203, 263, 53);
		panelAddCountryMenu.add(lblLeader);

		lblGovernment = new JLabel("Government:");
		lblGovernment.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGovernment.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGovernment.setBounds(10, 265, 263, 56);
		panelAddCountryMenu.add(lblGovernment);

		lblContinent = new JLabel("Continent:");
		lblContinent.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContinent.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblContinent.setBounds(10, 331, 263, 53);
		panelAddCountryMenu.add(lblContinent);

		lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(10, 75, 263, 53);
		panelAddCountryMenu.add(lblName);

		lblPopulation = new JLabel("Population:");
		lblPopulation.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPopulation.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPopulation.setBounds(10, 395, 263, 53);
		panelAddCountryMenu.add(lblPopulation);

		lblCurrency = new JLabel("Currency:");
		lblCurrency.setEnabled(false);
		lblCurrency.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCurrency.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCurrency.setBounds(10, 458, 263, 54);
		panelAddCountryMenu.add(lblCurrency);

		lblEuYearMember = new JLabel("EU Year Member:");
		lblEuYearMember.setEnabled(false);
		lblEuYearMember.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEuYearMember.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEuYearMember.setBounds(10, 523, 263, 45);
		panelAddCountryMenu.add(lblEuYearMember);

		btnClose = new JButton("Close");// close AddCountryFrame
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				parrent.updateAllPanels(false, false);// Enable panels of MainFrame
				AddCountryFrame.this.dispose();
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClose.setBounds(283, 640, 130, 40);
		panelAddCountryMenu.add(btnClose);

		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Country> countryList = parrent.getCountryList();
				// create new instance of country
				String seletctedType = (String) comboBoxCountryType.getSelectedItem();// find country type
				if (seletctedType.equals("Country")) {
					Double population;
					try {
						population = Double.valueOf(textFieldPopulation.getText());
					} catch (NumberFormatException e) {
						population = 0.0;
					}
					Country newCountry = new Country(textFieldName.getText(), population, textFieldCapital.getText(),
							textFieldContinent.getText(), textFieldGovernment.getText(), textFieldLeader.getText());
					countryList.add(newCountry);
				}
				if (seletctedType.equals("European Country")) {
					Double population, area;
					try {
						population = Double.valueOf(textFieldPopulation.getText());
					} catch (NumberFormatException e) {
						population = 0.0;
					}
					try {
						area = Double.valueOf(textFieldArea.getText());
					} catch (NumberFormatException e) {
						area = 0.0;
					}
					EuropeanCountry newCountry = new EuropeanCountry(textFieldName.getText(), population,
							textFieldCapital.getText(), textFieldContinent.getText(), textFieldGovernment.getText(),
							textFieldLeader.getText(), area, textFieldCurrency.getText());
					countryList.add(newCountry);
				}
				if (seletctedType.equals("Asian Country")) {
					Double population, area;
					try {
						population = Double.valueOf(textFieldPopulation.getText());
					} catch (NumberFormatException e) {
						population = 0.0;
					}
					try {
						area = Double.valueOf(textFieldArea.getText());
					} catch (NumberFormatException e) {
						area = 0.0;
					}
					AsianCountry newCountry = new AsianCountry(textFieldName.getText(), population,
							textFieldCapital.getText(), textFieldContinent.getText(), textFieldGovernment.getText(),
							textFieldLeader.getText(), area, textFieldCurrency.getText());
					countryList.add(newCountry);
				}
				if (seletctedType.equals("EU Country")) {
					Double population, area;
					int year;
					try {
						population = Double.valueOf(textFieldPopulation.getText());
					} catch (NumberFormatException e) {
						population = 0.0;
					}
					try {
						area = Double.valueOf(textFieldArea.getText());
					} catch (NumberFormatException e) {
						area = 0.0;
					}
					try {
						year = Integer.valueOf(textFieldYearMember.getText());
					} catch (NumberFormatException e) {
						year = 0;
					}
					EuropeanUnionCountry newCountry = new EuropeanUnionCountry(textFieldName.getText(), population,
							textFieldCapital.getText(), textFieldContinent.getText(), textFieldGovernment.getText(),
							textFieldLeader.getText(), area, textFieldCurrency.getText(), year);
					countryList.add(newCountry);
				}
				JOptionPane.showMessageDialog(parrent, "New Country was added!");
				parrent.updateAllPanels(false, false);// Enable panels of MainFrame
				parrent.updatePanelInfo();
				parrent.updateDataTabel();
				AddCountryFrame.this.dispose();
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdd.setBounds(424, 640, 130, 40);
		panelAddCountryMenu.add(btnAdd);

		textFieldArea = new JTextField();
		textFieldArea.setFont(new Font("Tahoma", Font.BOLD, 16));
		textFieldArea.setEnabled(false);
		textFieldArea.setBounds(283, 587, 271, 45);
		panelAddCountryMenu.add(textFieldArea);
		textFieldArea.setColumns(10);

		lblArea = new JLabel("Area:");
		lblArea.setEnabled(false);
		lblArea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblArea.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblArea.setBounds(10, 587, 263, 45);
		panelAddCountryMenu.add(lblArea);

		setVisible(true);
	}
}
