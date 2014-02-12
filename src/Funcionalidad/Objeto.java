/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidad;

import java.awt.Shape;

/**
 *
 * @author dam
 */
public class Objeto {
    
    Shape forma;
    boolean visible;

    public Objeto(Shape forma, boolean visible) {
        this.forma = forma;
        this.visible = visible;
    }

    public Shape getForma() {
        return forma;
    }

    public void setForma(Shape forma) {
        this.forma = forma;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    
}
