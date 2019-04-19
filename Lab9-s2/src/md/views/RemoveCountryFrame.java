package md.views;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import md.common.country.Country;

public class RemoveCountryFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNameToFind;
	private JPanel panelMenu;
	private JButton btnFind;
	private JButton btnRemove;
	private JLabel lblNameOfCountry;
	private JPanel panelInfo;
	private JTextArea txtrInformationAboutCountry;

	private Country foundedCountry;
	ArrayList<Country> countryList;

	public RemoveCountryFrame(MainFrame parrent) {
		init(parrent);
	}

	private void init(MainFrame parrent) {
		setTitle("Country DataBase: Remove Country");
		setSize(600, 400);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelMenu = new JPanel();
		panelMenu.setBounds(300, 11, 284, 349);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);

		textFieldNameToFind = new JTextField();
		textFieldNameToFind.setFont(new Font("Tahoma", Font.BOLD, 16));
		textFieldNameToFind.setBounds(10, 11, 264, 40);
		panelMenu.add(textFieldNameToFind);
		textFieldNameToFind.setColumns(10);

		btnFind = new JButton("Find");
		// find country
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String countryToFind = textFieldNameToFind.getText();
				foundedCountry = null;
				if (countryToFind.length() >= 3) {
					countryToFind = countryToFind.substring(0, 1).toUpperCase() + countryToFind.substring(1, 3);
				} else {
					countryToFind = "Unknown";// (same as in constructor)
					JOptionPane.showMessageDialog(null, "Set to \"Unknown\", Name must contains min 3 characters");
				}
				countryList = parrent.getCountryList();
				for (Country country : countryList) {
					if (countryToFind.equalsIgnoreCase(country.getName())) {
						foundedCountry = country;
						break;
					}
				}
				if (foundedCountry != null) {
					txtrInformationAboutCountry.setText("<Information about Country>" + "\nName: "
							+ foundedCountry.getName() + "\nCapital: " + foundedCountry.getCapital() + "\nLeader: "
							+ foundedCountry.getLeader() + "\nGovernment: " + foundedCountry.getGovernment()
							+ "\nContinent: " + foundedCountry.getContinent() + "\nPopulation: "
							+ foundedCountry.getPopulation());
					btnRemove.setEnabled(true);
				} else {
					txtrInformationAboutCountry.setText("<Information about Country>\nNo Country found");
				}
			}
		});
		btnFind.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnFind.setBounds(10, 62, 132, 40);
		panelMenu.add(btnFind);

		btnRemove = new JButton("Remove");
		// Delete selected Country from list
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtrInformationAboutCountry.setText(
						"<Information about Country>\nCountry " + foundedCountry.getName() + " has been deleted");
				btnRemove.setEnabled(false);
				countryList.remove(foundedCountry);
			}
		});
		btnRemove.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRemove.setEnabled(false);
		btnRemove.setBounds(142, 62, 132, 40);
		panelMenu.add(btnRemove);

		lblNameOfCountry = new JLabel("Name of Country:");
		lblNameOfCountry.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNameOfCountry.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNameOfCountry.setBounds(10, 22, 284, 40);
		contentPane.add(lblNameOfCountry);

		panelInfo = new JPanel();
		panelInfo.setBounds(10, 73, 284, 287);
		contentPane.add(panelInfo);
		panelInfo.setLayout(null);

		txtrInformationAboutCountry = new JTextArea();
		txtrInformationAboutCountry.setText("<Information about Country>");
		txtrInformationAboutCountry.setFont(new Font("Arial Black", Font.BOLD, 11));
		txtrInformationAboutCountry.setEditable(false);
		txtrInformationAboutCountry.setBounds(10, 11, 264, 265);
		panelInfo.add(txtrInformationAboutCountry);
		// center window
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		setVisible(true);
	}
}
