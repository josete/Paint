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
    boolean relleno;
    int grosor;
    Color fondo;
    Color linea;
    int dash;

    public Objeto(Shape forma, boolean relleno, int grosor, Color fondo, Color linea, int dash) {
        this.forma = forma;
        this.relleno = relleno;
        this.grosor = grosor;
        this.fondo = fondo;
        this.linea = linea;
        this.dash = dash;
    }

    

    

    public Shape getForma() {
        return forma;
    }

    public void setForma(Shape forma) {
        this.forma = forma;
    }

    public boolean isVisible() {
        return relleno;
    }

    public void setVisible(boolean relleno) {
        this.relleno = relleno;
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

    public boolean isRelleno() {
        return relleno;
    }

    public void setRelleno(boolean relleno) {
        this.relleno = relleno;
    }

    public int getDash() {
        return dash;
    }

    public void setDash(int dash) {
        this.dash = dash;
    }
    
    
    
    
    
    
}
