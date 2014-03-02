/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidad;

import Panels.Tapiz;
import java.awt.Point;

/**
 *
 * @author Familia
 */
public class MoverFigura {

    public static void saberSiDentro(Point p) {
        double x = p.getX();
        double y = p.getY();
        boolean dentro = false;
        for (int i = 0; i < Tapiz.dibujos.size(); i++) {
            double x0 = Tapiz.dibujos.get(i).getForma().getBounds2D().getX();
            double y0 = Tapiz.dibujos.get(i).getForma().getBounds2D().getY();
            double ancho = Tapiz.dibujos.get(i).getForma().getBounds2D().getWidth();
            double alto = Tapiz.dibujos.get(i).getForma().getBounds2D().getHeight();
            double xf = x0 + ancho;
            double yf = y0 + alto;
            if (x >= x0 && x <= xf) {
                if (y >= y0 && y <= yf) {
                    dentro = true;
                }
            }
        }

        if (dentro) {
            System.out.println("El raton está dentro");
        }
    }
}
