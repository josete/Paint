/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidad;

import java.awt.Color;
import java.awt.Shape;

/**
 *
 * @author dam
 */
public class Objeto {
    
    Shape forma;
    boolean visible;
    int grosor;
    Color fondo;
    Color linea;

    public Objeto(Shape forma, boolean visible, int grosor, Color fondo, Color linea) {
        this.forma = forma;
        this.visible = visible;
        this.grosor = grosor;
        this.fondo = fondo;
        this.linea = linea;
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

    public int getGrosor() {
        return grosor;
    }

    public void setGrosor(int grosor) {
        this.grosor = grosor;
    }

    public Color getFondo() {
        return fondo;
    }

    public void setFondo(Color fondo) {
        this.fondo = fondo;
    }

    public Color getLinea() {
        return linea;
    }

    public void setLinea(Color linea) {
        this.linea = linea;
    }
    
    
    
    
    
}
