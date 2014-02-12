/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Formas;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

/**
 *
 * @author Familia
 */
public class Cuadrado{
    
    Point inicio;
    Point fin;
    Color colorR;
    Color colorB;
    int ancho;
    int alto;

    public Cuadrado(Point inicio, Point fin, Color colorR, Color colorB) {
        this.inicio = inicio;
        this.fin = fin;
        this.colorR = colorR;
        this.colorB = colorB;
    }

    public Cuadrado() {
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

    public Color getColorR() {
        return colorR;
    }

    public void setColorR(Color colorR) {
        this.colorR = colorR;
    }

    public Color getColorB() {
        return colorB;
    }

    public void setColorB(Color colorB) {
        this.colorB = colorB;
    }
    
    public Rectangle devolverCuadrado(){
        calcularCambio();
        Rectangle rec = new Rectangle(inicio.x,inicio.y,calcularAncho(),calcularAlto());
        return rec;
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
    
    
    public void calcularCambio(){
        Point intermedio;
        if(fin.x<inicio.x){
            intermedio = fin;
            fin=inicio;
            inicio=intermedio;
        }/*else if(fin.y>inicio.y){
            intermedio = fin;
            fin=inicio;
            inicio=intermedio;
        }*/
    }
    
    
    
}
