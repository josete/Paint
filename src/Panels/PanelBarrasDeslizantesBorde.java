/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author dam
 */
public class PanelBarrasDeslizantesBorde extends JPanel implements ChangeListener{
    
    JSlider slider;
    static float borde;
    public PanelBarrasDeslizantesBorde(){
        //this.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel label = new JLabel("Ancho de borde");
        this.add(label);
        slider = new JSlider(JSlider.VERTICAL, 0, 40, 0); 
        slider.setInverted(false); 
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(5);
        slider.setMinorTickSpacing(5);
        slider.setPaintLabels(true);//Pintar los numeros en la pantalla
        slider.addChangeListener(this);
        this.add(slider);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        borde = slider.getValue();
    }
    
    public static float getTamanioBorde(){
        return borde;
    }
    
}
