package md.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
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
	private JComboBox<String> comboBox;
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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelAddCountryMenu = new JPanel();
		panelAddCountryMenu.setBounds(10, 11, 564, 739);
		contentPane.add(panelAddCountryMenu);
		panelAddCountryMenu.setLayout(null);

		comboBox = new JComboBox<>();
		comboBox.setMaximumRowCount(3);
		comboBox.setModel(
				new DefaultComboBoxModel<String>(new String[] { "Country", "European Country", "Asian Country" }));
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 16));
		comboBox.setBounds(283, 11, 271, 53);
		panelAddCountryMenu.add(comboBox);

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
		btnClose.setBounds(284, 587, 130, 40);
		panelAddCountryMenu.add(btnClose);

		btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdd.setBounds(424, 587, 130, 40);
		panelAddCountryMenu.add(btnAdd);

		setVisible(true);
	}
}
