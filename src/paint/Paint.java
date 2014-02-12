/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package paint;

import Panels.PanelBarrasDeslizantesBorde;
import Panels.PanelBarrasDeslizantesLados;
import Panels.PanelBotonesColores2;
import Panels.PanelColores;
import Panels.PanelFormas;
import Panels.PanelPixeles;
import Panels.Tapiz;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
        //Colores y formas
        JPanel colores = new JPanel();
        colores.setLayout(new BorderLayout());
        colores.add(new PanelBotonesColores2(),BorderLayout.CENTER);
        colores.add(new PanelColores(),BorderLayout.EAST);
        colores.add(new PanelFormas(),BorderLayout.WEST);
        f.add(colores,BorderLayout.NORTH);
        //Tapiz
        f.add(new Tapiz(),BorderLayout.CENTER);
        f.pack();
        f.setVisible(true);
        //Barras deslizantes
        JPanel panelBarras = new JPanel(new BorderLayout());
        panelBarras.add(new PanelBarrasDeslizantesLados(),BorderLayout.NORTH);
        panelBarras.add(new PanelBarrasDeslizantesBorde(),BorderLayout.SOUTH);
        f.add(panelBarras,BorderLayout.WEST);
        //Panel pixeles
        f.add(new PanelPixeles(),BorderLayout.SOUTH);
    }
    
}
