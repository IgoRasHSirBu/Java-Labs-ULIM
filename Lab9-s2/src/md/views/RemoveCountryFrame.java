package md.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class RemoveCountryFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNameToFind;
	private JPanel panelMenu;
	private JButton btnFind;
	private JButton btnRemove;
	private JLabel lblNameOfCountry;
	private JPanel panelInfo;
	private JTextArea txtrInformationAboutCountry;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveCountryFrame frame = new RemoveCountryFrame();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public RemoveCountryFrame() {
		init();
	}

	private void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		btnFind.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnFind.setBounds(10, 62, 132, 40);
		panelMenu.add(btnFind);

		btnRemove = new JButton("Remove");
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
		txtrInformationAboutCountry.setText("Information about Country");
		txtrInformationAboutCountry.setFont(new Font("Arial Black", Font.BOLD, 11));
		txtrInformationAboutCountry.setEditable(false);
		txtrInformationAboutCountry.setBounds(10, 11, 264, 265);
		panelInfo.add(txtrInformationAboutCountry);

		setVisible(true);
	}
}
