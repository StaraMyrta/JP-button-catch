package src;

import javax.swing.*;

/**
 * Klasa main zawierająca statyczną metodę main wywołującą działanie programu
 */

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try{
                Window window= new Window();
                window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                window.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace(System.err);
            }
        });
    }
}
