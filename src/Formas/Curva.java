/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Formas;

import java.awt.geom.Line2D;
import java.awt.geom.QuadCurve2D;

/**
 *
 * @author dam
 */
public class Curva {
    
    double x;
    double y;
    double controlX;
    double controlY;
    double ancho;
    double alto;

    public Curva(double x, double y, double controlX, double controlY, double ancho, double alto) {
        this.x = x;
        this.y = y;
        this.controlX = controlX;
        this.controlY = controlY;
        this.ancho = ancho;
        this.alto = alto;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getControlX() {
        return controlX;
    }

    public void setControlX(double controlX) {
        this.controlX = controlX;
    }

    public double getControlY() {
        return controlY;
    }

    public void setControlY(double controlY) {
        this.controlY = controlY;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getAlto() {
        return alto;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }



    
    public QuadCurve2D devolverLinea(){
        QuadCurve2D curva = new QuadCurve2D.Double(x,y,controlX,controlY,ancho,alto);
        return curva;
    }

}
