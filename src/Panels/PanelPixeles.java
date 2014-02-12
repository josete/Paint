/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author dam
 */
public class PanelPixeles extends JPanel{
    
    static JLabel label;
    static int x=0;
    static int y=0;
    public PanelPixeles() {
        label = new JLabel("x: "+x+" y: "+y);
        this.add(label);
    }
    
    public static void setX(int x2){
        x=x2;
    }
    
    public static void setY(int y2){
        y=y2;
    }
    
    public static void repintar(){
        label.setText("x: "+x+" y: "+y);
    }
    
    
}
