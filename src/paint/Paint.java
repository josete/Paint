/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package paint;

import Panels.PanelColores;
import Panels.Tapiz;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Familia
 */
public class Paint {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
    private static void createAndShowGUI() {
        SwingUtilities.isEventDispatchThread();
        JFrame f = new JFrame("Paint");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setLayout(new BorderLayout());
        f.add(new PanelColores(),BorderLayout.NORTH);
        f.add(new Tapiz(),BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);
    }
    
}
