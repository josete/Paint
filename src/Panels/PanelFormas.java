/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author dam
 */
public class PanelFormas extends JPanel{
    
    public PanelFormas(){
        super(new GridLayout(2,3));
        crearBotones();
    }

    private void crearBotones() {
       String[] nombres = {"Cuadrado","Cuadrado redondeado","Elipse","Arco","Linea","Curva"}; 
       for(int i=0;i<6;i++){
           this.add(new JButton(nombres[i]));
       }
    }
    
    
    
    
    
}
