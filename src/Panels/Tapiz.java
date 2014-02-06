/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author Familia
 */
public class Tapiz extends JPanel {

    private int squareX = 50;
    private int squareY = 50;
    private int squareW = 20;
    private int squareH = 20;
    static public Color colorR=Color.red;
    static public Color colorB=Color.black;

    public Tapiz() {

        setBorder(BorderFactory.createLineBorder(colorB));

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                moveSquare(e.getX(), e.getY());
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                moveSquare(e.getX(), e.getY());
            }
        });
    }

        private void moveSquare(int x, int y) {
        int OFFSET = 1;
        if ((squareX != x) || (squareY != y)) {
            repaint(squareX, squareY, squareW + OFFSET, squareH + OFFSET);
            squareX = x;
            squareY = y;
            repaint(squareX, squareY, squareW + OFFSET, squareH + OFFSET);
        }

    }
        
        public Dimension getPreferredSize() {
        return new Dimension(250, 200);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(colorR);
        g.fillRect(squareX, squareY, squareW, squareH);
        g.setColor(colorB);
        g.drawRect(squareX, squareY, squareW, squareH);
    }
    }
    
