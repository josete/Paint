/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Formas;

import java.awt.Point;
import java.awt.Polygon;

/**
 *
 * @author Familia
 */
public class Poligono {
    
    Point[] puntos;
    int lados;
    
    int[] x=null;
    int[] y=null;
    
    public Poligono(Point[] puntos,int lados){
        this.puntos=puntos;
        this.lados=lados;
        getX();
        getY();
    }
    
    public void getX(){
        x = new int[puntos.length];
        for(int i=0;i<puntos.length;i++){
            x[i]=(int) puntos[i].getX();
        }
    }
    
    public void getY(){
        y = new int[puntos.length];
        for(int i=0;i<puntos.length;i++){
            y[i]=(int) puntos[i].getY();
        }
    }
    
    public Polygon devolverPoligono(){
        Polygon p = new Polygon(x, y, lados);
        return p;
    }
    
    
}
