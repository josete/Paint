/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Formas;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import javax.sound.sampled.Line;

/**
 *
 * @author Familia
 */
public class Linea {
    
    Point inicio;
    Point fin;

    public Linea(Point inicio, Point fin) {
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

    
    public Line2D devolverLinea(){
        Line2D linea = new Line2D.Double(inicio.x,inicio.y,fin.x,fin.y);
        return linea;
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
