package md.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Font;

public class MainFrame extends JFrame {
	private JTable tableForCountryData;

	public MainFrame() {

		// Initialize
		setResizable(false);
		setSize(1200, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JScrollPane scrollPaneForTable = new JScrollPane();
		scrollPaneForTable.setBounds(140, 249, 1045, 511);
		getContentPane().add(scrollPaneForTable);

		tableForCountryData = new JTable();
		scrollPaneForTable.setViewportView(tableForCountryData);

		JPanel panelMenu = new JPanel();
		panelMenu.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMenu.setBounds(10, 11, 290, 220);
		getContentPane().add(panelMenu);
		panelMenu.setLayout(null);

		JButton btnOpenFile = new JButton("Open File");

		btnOpenFile.setBounds(70, 25, 150, 40);
		panelMenu.add(btnOpenFile);

		JButton btnSave = new JButton("Save");
		btnSave.setBounds(70, 90, 150, 40);
		panelMenu.add(btnSave);

		JButton btnSaveAs = new JButton("Save As");
		btnSaveAs.setBounds(70, 155, 150, 40);
		panelMenu.add(btnSaveAs);

		JPanel panelInfo = new JPanel();
		panelInfo.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelInfo.setBounds(610, 11, 575, 220);
		getContentPane().add(panelInfo);
		panelInfo.setLayout(null);
		
		JLabel lblNumberOfCountries = new JLabel("Number of Countries:");
		lblNumberOfCountries.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumberOfCountries.setBounds(10, 25, 555, 40);
		panelInfo.add(lblNumberOfCountries);
		
		JLabel lblMaxCountryPop = new JLabel("Country with max population:");
		lblMaxCountryPop.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMaxCountryPop.setBounds(10, 90, 555, 40);
		panelInfo.add(lblMaxCountryPop);
		
		JLabel lblMinCountryPop = new JLabel("Country with min population:");
		lblMinCountryPop.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMinCountryPop.setBounds(10, 155, 555, 40);
		panelInfo.add(lblMinCountryPop);

		JPanel panelTabelMenu = new JPanel();
		panelTabelMenu.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTabelMenu.setBounds(10, 250, 120, 511);
		getContentPane().add(panelTabelMenu);
		panelTabelMenu.setLayout(null);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(10, 11, 100, 40);
		panelTabelMenu.add(btnAdd);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(10, 62, 100, 40);
		panelTabelMenu.add(btnRemove);

		JPanel panelQuery = new JPanel();
		panelQuery.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelQuery.setBounds(310, 11, 290, 220);
		getContentPane().add(panelQuery);
		panelQuery.setLayout(null);
		
		JButton btnShowEuropeanCountries = new JButton("Show European Countries");
		btnShowEuropeanCountries.setBounds(70, 25, 160, 40);
		panelQuery.add(btnShowEuropeanCountries);
		
		JButton btnShowAsianCountries = new JButton("Show Asian Countries");
		btnShowAsianCountries.setBounds(70, 90, 160, 40);
		panelQuery.add(btnShowAsianCountries);
		
		JButton btnShowOtherCountries = new JButton("Show other Countries");
		btnShowOtherCountries.setBounds(70, 155, 160, 40);
		panelQuery.add(btnShowOtherCountries);
		setVisible(true);

	}
}
