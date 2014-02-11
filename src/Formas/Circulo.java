/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Formas;

import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author Familia
 */
public class Circulo {
    
    Point inicio;
    Point fin;
    int ancho;
    int alto;

    public Circulo(Point inicio, Point fin) {
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

    
    public Ellipse2D devolverElipse(){
        Ellipse2D e = new Ellipse2D.Double(inicio.x,inicio.y,calcularAncho(),calcularAlto());
        return e;
    }
    
    public int calcularAncho(){
        ancho = fin.x-inicio.x;
        return ancho;
    }
    
    public int calcularAlto(){
        
        alto = fin.y-inicio.y;
        return alto;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }
}
