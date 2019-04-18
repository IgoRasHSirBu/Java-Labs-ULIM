package md.views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

public class MainFrame extends JFrame {

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

	public MainFrame() {

		// Initialize
		init();
	}

	public void init() {

		setResizable(false);
		setSize(1200, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		scrollPaneForTable = new JScrollPane();
		scrollPaneForTable.setBounds(140, 249, 1045, 511);
		getContentPane().add(scrollPaneForTable);

		tableForCountryData = new JTable();
		scrollPaneForTable.setViewportView(tableForCountryData);

		panelMenu = new JPanel();
		panelMenu.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMenu.setBounds(10, 11, 290, 220);
		getContentPane().add(panelMenu);
		panelMenu.setLayout(null);

		btnOpenFile = new JButton("Open File");

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
		lblNumberOfCountries.setBounds(10, 25, 555, 40);
		panelInfo.add(lblNumberOfCountries);

		lblMaxCountryPop = new JLabel("Country with max population:");
		lblMaxCountryPop.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMaxCountryPop.setBounds(10, 90, 555, 40);
		panelInfo.add(lblMaxCountryPop);

		lblMinCountryPop = new JLabel("Country with min population:");
		lblMinCountryPop.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMinCountryPop.setBounds(10, 155, 555, 40);
		panelInfo.add(lblMinCountryPop);

		panelTabelMenu = new JPanel();
		panelTabelMenu.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTabelMenu.setBounds(10, 250, 120, 511);
		getContentPane().add(panelTabelMenu);
		panelTabelMenu.setLayout(null);

		btnAdd = new JButton("Add");
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
}
