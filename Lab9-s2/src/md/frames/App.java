package md.frames;

import javax.swing.*;
import java.awt.*;

public class App {
    private JPanel panelMain;


    public static void main(String[] args) {

        JFrame frameMain = new JFrame("Country DataBase @Alpha-0.06");
        frameMain.setContentPane(new App().panelMain);
        frameMain.setSize(1200, 800);
        frameMain.setLocationRelativeTo(null);
        frameMain.setVisible(true);
        frameMain.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);



    }
}
