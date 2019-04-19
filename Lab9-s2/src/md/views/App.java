package md.views;

import java.awt.EventQueue;

public class App {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame jMainFrame = new MainFrame();
					jMainFrame.setTitle("Country DataBase @Alpha-0.33");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
