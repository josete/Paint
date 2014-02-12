/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Formas;

import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;

/**
 *
 * @author Familia
 */
public class Poligono {
    
    ArrayList<Point> puntos;
    int lados;
    
    int[] x=null;
    int[] y=null;
    
    public Poligono(ArrayList<Point> puntos,int lados){
        this.puntos=puntos;
        this.lados=lados;
        getX();
        getY();
    }
    
    public void getX(){
        x = new int[puntos.size()];
        for(int i=0;i<puntos.size();i++){
            x[i]=(int) puntos.get(i).getX();
        }
    }
    
    public void getY(){
        y = new int[puntos.size()];
        for(int i=0;i<puntos.size();i++){
            y[i]=(int) puntos.get(i).getY();
        }
    }
    
    public Polygon devolverPoligono(){
        Polygon p = new Polygon(x, y, lados);
        return p;
    }
    
    
}
