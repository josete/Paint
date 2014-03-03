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
public class PanelSeleccionar extends JPanel implements ActionListener{

     public PanelSeleccionar() {
        super(new GridLayout(2, 4));
        String[] imagenes = {"/imagenes/stock_draw_selection.png"};
        ImageIcon icon = new javax.swing.ImageIcon(getClass().getResource(imagenes[0]));
        JButton botonBorrar = new JButton("Seleccionar");
        botonBorrar.setIcon(icon);
        botonBorrar.addActionListener(this);
        this.add(botonBorrar);

    }
     
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();
        if (boton.getText().equals("Seleccionar")) {
            SeleccionForma.seleccionar();
        }
    }
    
}
