/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels;

import Funcionalidad.Guardar;
import paint.Paint;
import Funcionalidad.SeleccionForma;
import java.awt.Graphics;
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
public class PanelGuardar  extends JPanel implements ActionListener {

    
    public PanelGuardar() {
        super(new GridLayout(2, 4));
        //String[] imagenes = {"/imagenes/borrar.png"};
        //ImageIcon icon = new javax.swing.ImageIcon(getClass().getResource(imagenes[0]));
        JButton botonGuardar = new JButton("Guardar");
        //botonBorrar.setIcon(icon);
        botonGuardar.addActionListener(this);
        this.add(botonGuardar);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();
        if (boton.getText().equals("Guardar")) {
            Graphics g = Tapiz.imagen.getGraphics();
            Paint.p.paint(g);
            Guardar.guardar(Tapiz.imagen, "jpg", "fichero.jpg");
        }
    }
    
}
