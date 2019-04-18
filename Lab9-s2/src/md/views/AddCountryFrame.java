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

public class AddCountryFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCountryFrame frame = new AddCountryFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddCountryFrame() {// TODO: add components

//		init();
		setSize(600, 800);
		this.setTitle("Country DataBase: Add Country");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelAddCountryMenu = new JPanel();
		panelAddCountryMenu.setBounds(10, 11, 564, 739);
		contentPane.add(panelAddCountryMenu);
		panelAddCountryMenu.setLayout(null);

		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setMaximumRowCount(3);
		comboBox.setModel(
				new DefaultComboBoxModel<String>(new String[] { "Country", "European Country", "Asian Country" }));
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox.setBounds(272, 11, 282, 53);
		panelAddCountryMenu.add(comboBox);
	}

	private void init() {

	}
}
