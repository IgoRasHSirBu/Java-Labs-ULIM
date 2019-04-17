package md.views;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class App {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					JFrame mainFrame = new JFrame("Country DataBase @Alpha-0.07");
					mainFrame.setResizable(false);
					mainFrame.setSize(1200, 800);
					mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					mainFrame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
