package md.views;

import java.awt.EventQueue;

public class App {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame jMainFrame = new MainFrame();
					jMainFrame.setTitle("Country DataBase @Alpha-0.25");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

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

	}

}
