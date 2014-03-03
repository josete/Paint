/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidad;

import Formas.Cuadrado;
import Panels.Tapiz;
import java.awt.Color;
import java.awt.Point;
import java.awt.Shape;

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
        int numero= 0;
        for (int i = 0; i < Tapiz.dibujos.size(); i++) {
            x0 = Tapiz.dibujos.get(i).getForma().getBounds2D().getX();
            y0 = Tapiz.dibujos.get(i).getForma().getBounds2D().getY();
            ancho = (int)Tapiz.dibujos.get(i).getForma().getBounds2D().getWidth();
            alto = (int)Tapiz.dibujos.get(i).getForma().getBounds2D().getHeight();
            double xf = x0 + ancho;
            double yf = y0 + alto;
            if (x >= x0 && x <= xf) {
                if (y >= y0 && y <= yf) {
                    dentro = true;
                    forma = Tapiz.dibujos.get(i).getForma();
                    numero = i;
                }
            }
        }

        Tapiz.dibujos.remove(numero);
        
        if (dentro) {
            System.out.println("El raton está dentro");
        }

        return dentro;
    }

    public static Shape mover(Point p) {

        double destinox = (p.getX()-xi)+x0;
        double destinoy = (p.getY()-yi)+y0;
        
        Point p0 = new Point((int)destinox, (int)destinoy);
        Point pf = new Point((int)destinox+ancho, (int)destinoy+alto);
        
        forma = new Cuadrado(p0, pf, Color.black, Color.black).devolverCuadrado();
        
        
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
