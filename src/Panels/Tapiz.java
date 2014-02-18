/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels;

import Formas.Circulo;
import Formas.Cuadrado;
import Formas.Curva;
import Formas.Linea;
import Formas.Poligono;
import Formas.RectanguloRedondeado;
import Funcionalidad.Objeto;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.awt.geom.QuadCurve2D;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import sun.awt.geom.Curve;

/**
 *
 * @author Familia
 */
public class Tapiz extends JPanel implements MouseListener, MouseMotionListener {

    private int squareX = 50;
    private int squareY = 50;
    private int squareW = 20;
    private int squareH = 20;
    static public Color colorR = Color.white;
    static public Color colorB = Color.black;
    static public boolean cuadrado = false;
    static public boolean linea = false;
    static public boolean circulo = false;
    static public boolean cuadradoRedondeado = false;
    static public boolean poligono = false;
    static public boolean curva = false;
    private Shape forma = null;
    Point in;
    Point f;
    int clicks = 0;
    int lados = 0;
    //Point[] puntos=null;
    ArrayList<Point> puntos = new ArrayList();
    ArrayList<Objeto> dibujos = new ArrayList();
    //Variables
    int x = 0;
    int y = 0;
    int alto = 0;
    int ancho = 0;
    Linea lC;

    public Tapiz() {

        setBorder(BorderFactory.createLineBorder(colorB));
        /*addMouseListener(new MouseAdapter() {
         public void mousePressed(MouseEvent e) {
         moveSquare(e.getX(), e.getY());
         }
         });

         addMouseMotionListener(new MouseAdapter() {
         public void mouseDragged(MouseEvent e) {
         moveSquare(e.getX(), e.getY());
         }
         });*/
        PanelBotonesColores2.botonBorde.setBackground(colorB);
        PanelBotonesColores2.botonRelleno.setBackground(colorR);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    /* private void moveSquare(int x, int y) {
     int OFFSET = 1;
     if ((squareX != x) || (squareY != y)) {
     repaint(squareX, squareY, squareW + OFFSET, squareH + OFFSET);
     squareX = x;
     squareY = y;
     repaint(squareX, squareY, squareW + OFFSET, squareH + OFFSET);
     }

     }*/
    public Dimension getPreferredSize() {
        return new Dimension(250, 200);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if (forma != null) {
            if (forma instanceof Line2D || forma instanceof QuadCurve2D) {
                g2.setColor(colorB);
                g2.draw(forma);
                for (int i = 0; i < dibujos.size(); i++) {
                    if (dibujos.get(i).getForma() instanceof Line2D || dibujos.get(i).getForma() instanceof QuadCurve2D) {
                        g2.setStroke(new BasicStroke(dibujos.get(i).getGrosor()));
                        g2.draw(dibujos.get(i).getForma());
                    }
                }
            } else {
                g2.setColor(colorR);
                g2.fill(forma);
                g2.setColor(colorB);
                g2.draw(forma);
                for (int i = 0; i < dibujos.size(); i++) {
                    g2.setColor(dibujos.get(i).getFondo());
                    g2.fill(dibujos.get(i).getForma());
                }
                for (int i = 0; i < dibujos.size(); i++) {
                    g2.setStroke(new BasicStroke(dibujos.get(i).getGrosor()));
                    g2.setColor(dibujos.get(i).getLinea());
                    g2.draw(dibujos.get(i).getForma());
                }
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int OFFSET = 1;
        if (cuadrado) {
            //repaint(x, y, ancho + OFFSET, alto + OFFSET);
            f = new Point(e.getX(), e.getY());
            Cuadrado rec = new Cuadrado(in, f, colorR, colorB);
            x = rec.getInicio().x;
            y = rec.getInicio().y;
            alto = rec.getAlto();
            ancho = rec.getAncho();
            forma = rec.devolverCuadrado();
            //repaint(e.getX(), e.getY(), rec.calcularAncho(), rec.calcularAlto());
        } else if (linea || curva) {
            f = new Point(e.getX(), e.getY());
            Linea l = new Linea(in, f);
            lC = l;
            forma = l.devolverLinea();
            //repaint(in.x, in.y, l.calcularLargo() + OFFSET, l.calcularAlto() + OFFSET);
        } else if (circulo) {
            repaint(x, y, ancho + OFFSET, alto + OFFSET);
            f = new Point(e.getX(), e.getY());
            Circulo c = new Circulo(in, f);
            x = c.getInicio().x;
            y = c.getInicio().y;
            alto = c.getAlto();
            ancho = c.getAncho();
            forma = c.devolverElipse();
            //repaint(in.x, in.y, c.calcularAncho(), c.calcularAlto());
        } else if (cuadradoRedondeado) {
            f = new Point(e.getX(), e.getY());
            RectanguloRedondeado rr = new RectanguloRedondeado(in, f);
            forma = rr.devolverRectangulo();
            //repaint(in.x, in.y, rr.calcularLargo() + OFFSET, rr.calcularAlto() + OFFSET);
        }
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

        PanelPixeles.setX(e.getX());
        PanelPixeles.setY(e.getY());
        PanelPixeles.repintar();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (curva) {
            if (e.getClickCount() == 2) {
                System.out.println(forma.getBounds2D().getY());
                Curva curva2 = new Curva(lC.getInicio().x, lC.getInicio().y, e.getX(), e.getY(), lC.getFin().x, lC.getFin().y);
                forma = curva2.devolverLinea();
                dibujos.add(new Objeto(forma, true, (int) PanelBarrasDeslizantesBorde.getTamanioBorde(), colorR, colorB));
                repaint();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (cuadrado || linea || circulo || cuadradoRedondeado || curva) {
            in = new Point(e.getX(), e.getY());
        } else if (poligono) {
            in = new Point(e.getX(), e.getY());
            puntos.add(in);
            lados++;
            if (e.getClickCount() == 2) {
                Poligono p = new Poligono(puntos, lados);
                forma = p.devolverPoligono();
                repaint(in.x, in.y, 800, 800);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (curva) {
        } else {
            dibujos.add(new Objeto(forma, true, (int) PanelBarrasDeslizantesBorde.getTamanioBorde(), colorR, colorB));
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public Shape getForma() {
        return forma;
    }
}
