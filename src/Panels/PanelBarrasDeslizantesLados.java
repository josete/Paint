/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author dam
 */
public class PanelBarrasDeslizantesLados extends JPanel implements ChangeListener{
    
    JSlider slider;
    static int lados;
    public PanelBarrasDeslizantesLados(){
        JLabel label = new JLabel("Numero de lados");
        this.add(label);
        slider = new JSlider(JSlider.VERTICAL, 0, 20, 0); 
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
        lados=slider.getValue();
    }
    
    public static int getLados(){
        return lados;
    }
    
}
