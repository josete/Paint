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
import Funcionalidad.MoverFigura;
import Funcionalidad.Objeto;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
    static public boolean poligono = false;
    static public boolean curva = false;
    static public boolean freeLine = false;
    static public boolean seleccionar = false;
    private Shape forma = null;
    Point in;
    Point f;
    int clicks = 0;
    int lados = 0;
    //Point[] puntos=null;
    ArrayList<Point> puntos = new ArrayList();
    public static ArrayList<Objeto> dibujos = new ArrayList();
    //Variables
    int x = 0;
    int y = 0;
    int alto = 0;
    int ancho = 0;
    Linea lC;
    int grosor;
    GeneralPath gp = null;
    boolean algo = false;
    int contadorLados = 1;
    static BufferedImage imagen;

    public Tapiz() {
        setBorder(BorderFactory.createLineBorder(colorB));
        PanelBotonesColores2.botonBorde.setBackground(colorB);
        PanelBotonesColores2.botonRelleno.setBackground(colorR);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        imagen = new BufferedImage(1024, 600, BufferedImage.TYPE_INT_RGB);
    }

    public Dimension getPreferredSize() {
        return new Dimension(250, 200);
    }

    @SuppressWarnings("empty-statement")
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if (forma != null) {
            if (forma instanceof Line2D || forma instanceof QuadCurve2D || forma instanceof GeneralPath) {
                float[] dash = {PanelBarrasDeslizantesRayas.getLados()};
                grosor = (int) PanelBarrasDeslizantesBorde.getTamanioBorde();
                try {
                    g2.setStroke(new BasicStroke(grosor, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10, dash, 0));
                } catch (Exception e) {
                    g2.setStroke(new BasicStroke(grosor));
                }

                g2.setColor(colorB);
                g2.draw(forma);
                for (int i = 0; i < dibujos.size(); i++) {
                    if (dibujos.get(i).getForma() instanceof Line2D || dibujos.get(i).getForma() instanceof QuadCurve2D || dibujos.get(i).getForma() instanceof GeneralPath) {
                        try {
                            float d = (float) dibujos.get(i).getDash();
                            dash[0] = d;
                            g2.setStroke(new BasicStroke(grosor, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10, dash, 0));
                        } catch (Exception e) {
                            g2.setStroke(new BasicStroke(grosor));
                        }
                        if (!dibujos.get(i).isRelleno()) {
                            g2.fill(dibujos.get(i).getForma());
                        }
                        g2.draw(dibujos.get(i).getForma());
                    } else {
                        g2.setColor(dibujos.get(i).getFondo());
                        g2.fill(dibujos.get(i).getForma());
                        g2.setStroke(new BasicStroke(dibujos.get(i).getGrosor()));
                        g2.setColor(dibujos.get(i).getLinea());
                        g2.draw(dibujos.get(i).getForma());
                    }
                }
            } else {
                grosor = (int) PanelBarrasDeslizantesBorde.getTamanioBorde();
                float[] dash = {PanelBarrasDeslizantesRayas.getLados()};
                grosor = (int) PanelBarrasDeslizantesBorde.getTamanioBorde();
                try {
                    g2.setStroke(new BasicStroke(grosor, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10, dash, 0));
                } catch (Exception e) {
                    g2.setStroke(new BasicStroke(grosor));
                }
                g2.setColor(colorR);
                g2.fill(forma);
                g2.setColor(colorB);
                g2.draw(forma);
                for (int i = 0; i < dibujos.size(); i++) {
                    g2.setColor(dibujos.get(i).getFondo());
                    g2.fill(dibujos.get(i).getForma());

                }
                for (int i = 0; i < dibujos.size(); i++) {
                    try {
                            float d = (float)dibujos.get(i).getDash();
                            dash[0]=d;
                            g2.setStroke(new BasicStroke(grosor, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10, dash, 0));
                        } catch (Exception e) {
                            g2.setStroke(new BasicStroke(grosor));
                        }
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
            f = new Point(e.getX(), e.getY());
            Cuadrado rec = new Cuadrado(in, f, colorR, colorB);
            x = rec.getInicio().x;
            y = rec.getInicio().y;
            alto = rec.getAlto();
            ancho = rec.getAncho();
            forma = rec.devolverCuadrado();
        } else if (linea || curva) {
            f = new Point(e.getX(), e.getY());
            Linea l = new Linea(in, f);
            lC = l;
            forma = l.devolverLinea();
        } else if (circulo) {
            repaint(x, y, ancho + OFFSET, alto + OFFSET);
            f = new Point(e.getX(), e.getY());
            Circulo c = new Circulo(in, f);
            x = c.getInicio().x;
            y = c.getInicio().y;
            alto = c.getAlto();
            ancho = c.getAncho();
            forma = c.devolverElipse();
        } else if (cuadradoRedondeado) {
            f = new Point(e.getX(), e.getY());
            RectanguloRedondeado rr = new RectanguloRedondeado(in, f);
            forma = rr.devolverRectangulo();
        } else if (freeLine) {
            forma = gp;
            gp.lineTo((int) e.getX(), (int) e.getY());
        } else if (seleccionar) {
            System.out.println(dibujos.size());
            //if(MoverFigura.saberSiDentro(e.getPoint())){
            this.setCursor(new Cursor(Cursor.MOVE_CURSOR));
            forma = MoverFigura.mover(e.getPoint());
            //}
        } else if (poligono) {
            forma = gp;
            /*int contadorLados = 1;
             Point punto = new Point(e.getX(), e.getY());
             gp.append(new Line2D.Double(in, punto),true);*/
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
                dibujos.add(new Objeto(forma, true, (int) PanelBarrasDeslizantesBorde.getTamanioBorde(), colorR, colorB, (int) PanelBarrasDeslizantesRayas.getLados()));
                repaint();
            } else {
                Curva curva2 = new Curva(lC.getInicio().x, lC.getInicio().y, e.getX(), e.getY(), lC.getFin().x, lC.getFin().y);
                forma = curva2.devolverLinea();
                //dibujos.add(new Objeto(forma, true, (int) PanelBarrasDeslizantesBorde.getTamanioBorde(), colorR, colorB));
                repaint();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (cuadrado || linea || circulo || cuadradoRedondeado || curva) {
            in = new Point(e.getX(), e.getY());
        } else if (freeLine) {
            gp = new GeneralPath();
            gp.moveTo((int) e.getX(), (int) e.getY());
        } else if (seleccionar) {
            MoverFigura.setP1p(e.getPoint());
        } else if (poligono) {
            if (contadorLados == 1) {
                gp = new GeneralPath();
                gp.moveTo((int) e.getX(), (int) e.getY());
                in = new Point(e.getX(), e.getY());
                f = new Point(e.getX(), e.getY());
                gp.append(new Line2D.Double(in, f), true);
            } else {
                Point punto2 = new Point(e.getX(), e.getY());
                gp.append(new Line2D.Double(f, punto2), true);
                f = punto2;
            }

            if (e.getClickCount() == 2) {
                gp.closePath();
                forma = gp;
                gp = null;
                dibujos.add(new Objeto(forma, false, (int) PanelBarrasDeslizantesBorde.getTamanioBorde(), colorR, colorB, (int) PanelBarrasDeslizantesRayas.getLados()));
                contadorLados = 0;
            }

            System.out.println(contadorLados);
            contadorLados++;

        }
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (curva || poligono) {
        } else {
            dibujos.add(new Objeto(forma, true, (int) PanelBarrasDeslizantesBorde.getTamanioBorde(), colorR, colorB, (int) PanelBarrasDeslizantesRayas.getLados()));
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
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
