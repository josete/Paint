/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels;

import Formas.Circulo;
import Formas.Cuadrado;
import Formas.Linea;
import Formas.Poligono;
import Formas.RectanguloRedondeado;
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
import javax.swing.BorderFactory;
import javax.swing.JPanel;

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
    static public boolean poligono=false;
    private Shape forma = null;
    Point in;
    Point f;
    int clicks=0;
    Point[] puntos=null;
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
        /*g.setColor(colorR);
         g.fillRect(squareX, squareY, squareW, squareH);
         g.setColor(colorB);
         g.drawRect(squareX, squareY, squareW, squareH);*/
        Graphics2D g2 = (Graphics2D) g;
        if (forma != null) {
            if (forma instanceof Linea) {
                g2.setColor(colorB);
                g2.draw(forma);
            } else {
                /*String tamanio = String.valueOf(PanelBarrasDeslizantesBorde.getTamanioBorde());
                System.out.println(tamanio);
                g2.setStroke(new BasicStroke(PanelBarrasDeslizantesBorde.getTamanioBorde()));*/
                g2.setColor(colorB);
                System.out.println(forma);
                g2.draw(forma);
                g2.setColor(colorR);
                g2.fill(forma);
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int OFFSET = 1;
        if (cuadrado) {
            f = new Point(e.getX(), e.getY());
            Cuadrado rec = new Cuadrado(in, f, colorR, colorB);
            forma = rec.devolverCuadrado();
            //this.repaint();
            repaint(in.x, in.y, rec.getAncho() + OFFSET, rec.getAlto() + OFFSET);
        }else if(linea){
             f = new Point(e.getX(), e.getY());
             Linea l = new Linea(in,f);
             forma = l.devolverLinea();
             repaint(in.x, in.y,l.calcularLargo()+OFFSET,l.calcularAlto()+OFFSET);
        }else if(circulo){
            f = new Point(e.getX(), e.getY());
            Circulo c = new Circulo(in,f);
            forma = c.devolverElipse();
            repaint(in.x, in.y,c.calcularAncho()+OFFSET,c.calcularAlto()+OFFSET);
        }else if(cuadradoRedondeado){
            f = new Point(e.getX(), e.getY());
            RectanguloRedondeado rr = new RectanguloRedondeado(in,f);
            forma = rr.devolverRectangulo();
            repaint(in.x, in.y,rr.calcularLargo()+OFFSET,rr.calcularAlto()+OFFSET);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (cuadrado || linea || circulo || cuadradoRedondeado) {
            in = new Point(e.getX(), e.getY());
        }else if(poligono){
            System.out.println(clicks);
            System.out.println(PanelBarrasDeslizantesLados.getLados());
            if(puntos==null){;
                puntos = new Point[PanelBarrasDeslizantesLados.getLados()+1];
            }
            puntos[clicks]=new Point(e.getX(), e.getY());
            if(clicks==PanelBarrasDeslizantesLados.getLados()){
                System.out.println(puntos.length);
                Poligono p= new Poligono(puntos, PanelBarrasDeslizantesLados.getLados());
                forma=p.devolverPoligono();
                repaint(puntos[0].x, puntos[0].y,500,500);
                clicks=0;
            }else{
                  clicks++;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

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
