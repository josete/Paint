/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels;

import Funcionalidad.SeleccionForma;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author dam
 */
public class PanelFormas extends JPanel implements ActionListener{
    
    public PanelFormas(){
        super(new GridLayout(2,3));
        crearBotones();
    }

    private void crearBotones() {
       String[] nombres = {"Cuadrado","Cuadrado redondeado","Elipse","Arco","Linea","Curva"};
       for(int i=0;i<6;i++){
           JButton boton = new JButton(nombres[i]);
           boton.addActionListener(this);
           this.add(boton);
       }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton)e.getSource();
        if(boton.getText().equals("Cuadrado")){
            SeleccionForma.activarCuadrado();
        }
    }
    
    
    
    
    
}
