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
public class PanelFormas extends JPanel implements ActionListener{
    
    public PanelFormas(){
        super(new GridLayout(2,3));
        crearBotones();
    }

    private void crearBotones() {
       String[] nombres = {"Cuadrado","Cuadrado redondeado","Elipse","Arco","Linea","Curva"};
       String[] imagenes = {"/imagenes/frame_edit.png","/imagenes/stock_draw_rounded_rectangle.png","/imagenes/stock_draw_ellipse.png","/imagenes/stock_draw_curve.png","/imagenes/stock_draw_line.png","/imagenes/stock_draw_curve.png"};
       for(int i=0;i<6;i++){
           ImageIcon icon = new javax.swing.ImageIcon(getClass().getResource(imagenes[i]));
           JButton boton = new JButton(nombres[i]);
           boton.setIcon(icon);
           boton.addActionListener(this);
           this.add(boton);
       }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton)e.getSource();
        if(boton.getText().equals("Cuadrado")){
            SeleccionForma.activarCuadrado();
        }else if(boton.getText().equals("Linea")){
            SeleccionForma.activarLinea();
        }else if(boton.getText().equals("Elipse")){
            SeleccionForma.activarCirculo();
        }
    }
    
    
    
    
    
}
