/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels;

import Funcionalidad.SeleccionForma;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author dam
 */
public class PanelLibre extends JPanel implements ActionListener {

    public PanelLibre() {
        super(new GridLayout(2, 4));
        String[] imagenes = {"/imagenes/stock_draw_freeform_line.png"};


        ImageIcon icon = new javax.swing.ImageIcon(getClass().getResource(imagenes[0]));
        JButton botonFree = new JButton("Free line");
        botonFree.addActionListener(this);
        botonFree.setIcon(icon);
        this.add(botonFree);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();
        if (boton.getText().equals("Free line")) {
            SeleccionForma.freeLine();
        }
    }
}
