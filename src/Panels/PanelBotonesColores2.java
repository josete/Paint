/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Panels;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Familia
 */
public class PanelBotonesColores2 extends JPanel implements ActionListener{
    
    static public boolean borde = false;
    static public boolean relleno = false;
    
    public PanelBotonesColores2(){
        super(new GridLayout(1,2));
        crearBotones();
    }
    
    public void crearBotones(){
        JButton botonBorde = new JButton("Color borde");
        this.add(botonBorde);
        botonBorde.addActionListener(this);
        
        JButton botonRelleno= new JButton("Color relleno");
        this.add(botonRelleno);
        botonRelleno.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton)e.getSource();
        if(boton.getText().equals("Color borde")){
            borde=true;
        }else if(boton.getText().equals("Color relleno")){
            relleno=true;
        }
    }
}
