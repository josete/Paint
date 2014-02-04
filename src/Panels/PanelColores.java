/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Panels;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Familia
 */
public class PanelColores extends JPanel{
    
    public PanelColores() {
        super(new GridLayout(2,4));
        setBorder(BorderFactory.createLineBorder(Color.black));
        crearBotones();
    }


    public void crearBotones() {
        Color[] colores = {Color.BLACK, Color.BLUE,Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};
        for (int i = 0; i < colores.length; i++) {
            JButton boton = new JButton();
            boton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton boton = (JButton) e.getSource();
                    Tapiz.color = boton.getBackground();
                }
            }); 
            boton.setBackground(colores[i]);
            this.add(boton);
        }
    }
    
}
