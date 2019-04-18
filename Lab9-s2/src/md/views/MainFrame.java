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

public class MainFrame extends JFrame {

	protected JButton btnApasa;

	public MainFrame() {

		setResizable(false);
		setSize(1200, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		btnApasa = new JButton("apasa");
		btnApasa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
//							btnApasa.setEnabled(false);
							MainFrame.this.setEnabled(false);
							AddCountryFrame frame = new AddCountryFrame(MainFrame.this);
							frame.addWindowListener(new java.awt.event.WindowAdapter() {
								@Override
								public void windowClosing(java.awt.event.WindowEvent windowEvent) {
//									btnApasa.setEnabled(true);
									MainFrame.this.setEnabled(true);
								}
							});
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});

		btnApasa.setBounds(527, 114, 89, 23);
		getContentPane().add(btnApasa);
		setVisible(true);

	}
}
