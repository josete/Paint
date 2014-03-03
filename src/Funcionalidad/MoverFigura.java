/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidad;

import Formas.Circulo;
import Formas.Cuadrado;
import Formas.Linea;
import Formas.RectanguloRedondeado;
import Panels.Tapiz;
import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;

/**
 *
 * @author Familia
 */
public class MoverFigura {

    static double x0;
    static double y0;
    static int  ancho;
    static int  alto;
    static Shape forma = null;

    static double xi;
    static double yi;

    public static boolean saberSiDentro(Point p) {
        double x = p.getX();
        double y = p.getY();
        boolean dentro = false;
        int numero= Tapiz.dibujos.size()-1;
        //for (int i = 0; i < Tapiz.dibujos.size(); i++) {
            x0 = Tapiz.dibujos.get(numero).getForma().getBounds2D().getX();
            y0 = Tapiz.dibujos.get(numero).getForma().getBounds2D().getY();
            ancho = (int)Tapiz.dibujos.get(numero).getForma().getBounds2D().getWidth();
            alto = (int)Tapiz.dibujos.get(numero).getForma().getBounds2D().getHeight();
            double xf = x0 + ancho;
            double yf = y0 + alto;
            if (x >= x0 && x <= xf) {
                if (y >= y0 && y <= yf) {
                    dentro = true;
                    forma = Tapiz.dibujos.get(numero).getForma();
                }
            //}
        }

        Tapiz.dibujos.remove(numero);
        
        if (dentro) {
            
        }

        return dentro;
    }

    public static Shape mover(Point p) {

        double destinox = (p.getX()-xi)+x0;
        double destinoy = (p.getY()-yi)+y0;
        
        Point p0 = new Point((int)destinox, (int)destinoy);
        Point pf = new Point((int)destinox+ancho, (int)destinoy+alto);
        
        
        if(forma instanceof Rectangle){
            forma = new Cuadrado(p0, pf, Color.black, Color.black).devolverCuadrado();
        }else if(forma instanceof Ellipse2D){
            forma = new Circulo(p0, pf).devolverElipse();
        }else if(forma instanceof RoundRectangle2D){
            forma = new RectanguloRedondeado(p0, pf).devolverRectangulo();
        }else if(forma instanceof Line2D){
            forma = new Linea(p0, pf).devolverLinea();
        }
        
        return forma;
    }

    public static void setP1p(Point p) {
        if (saberSiDentro(p)) {
            xi = p.getX();
            yi = p.getY();
        }
    }

    public static Shape devolverForma() {
        return forma;
    }
}
