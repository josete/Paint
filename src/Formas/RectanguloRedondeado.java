/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Formas;

import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;

/**
 *
 * @author dam
 */
public class RectanguloRedondeado {
    Point inicio;
    Point fin;

    public RectanguloRedondeado(Point inicio, Point fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    public Point getInicio() {
        return inicio;
    }

    public void setInicio(Point inicio) {
        this.inicio = inicio;
    }

    public Point getFin() {
        return fin;
    }

    public void setFin(Point fin) {
        this.fin = fin;
    }

    
    public RoundRectangle2D devolverRectangulo(){
        RoundRectangle2D rr = new RoundRectangle2D.Double(inicio.x,inicio.y,fin.x,fin.y,50,50);
        return rr;
    }
    
    public int calcularLargo(){  
        int largo = fin.x-inicio.x;
        return largo;
    }
    
    public int calcularAlto(){
        int alto = fin.y-inicio.y;
        return alto;
    }

 
    
}
