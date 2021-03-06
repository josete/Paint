/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Funcionalidad;

import Panels.Tapiz;
import paint.Paint;

/**
 *
 * @author Familia
 */
public class SeleccionForma {
    
    public static void activarCuadrado(){
        Tapiz.linea =  false;
        Tapiz.circulo = false;
        Tapiz.cuadradoRedondeado=false;
        Tapiz.curva=false;
        Tapiz.freeLine=false;
        Tapiz.seleccionar=false;
        Tapiz.cuadrado=true;
    }
    
    public static void activarLinea(){
        Tapiz.cuadrado =  false;
        Tapiz.circulo = false;
        Tapiz.cuadradoRedondeado=false;
        Tapiz.curva=false;
        Tapiz.freeLine=false;
        Tapiz.seleccionar=false;
        Tapiz.linea=true;
    }
    
    public static void activarCirculo(){
        Tapiz.linea =  false;
        Tapiz.cuadrado = false;
        Tapiz.cuadradoRedondeado=false;
        Tapiz.curva=false;
        Tapiz.freeLine=false;
        Tapiz.seleccionar=false;
        Tapiz.circulo=true;
    }
    
    public static void activarCuadradoRedondeado(){
        Tapiz.linea =  false;
        Tapiz.cuadrado = false;
        Tapiz.circulo= false;
        Tapiz.curva=false;
        Tapiz.freeLine=false;
        Tapiz.seleccionar=false;
        Tapiz.cuadradoRedondeado=true;
    }
    
    public static void activarPoligono(){
        Tapiz.linea =  false;
        Tapiz.cuadrado = false;
        Tapiz.circulo= false;
        Tapiz.cuadradoRedondeado=false;
        Tapiz.curva=false;
        Tapiz.freeLine=false;
        Tapiz.seleccionar=false;
        Tapiz.poligono=true;
    }

    public static void activarCurva() {
        Tapiz.linea =  false;
        Tapiz.cuadrado = false;
        Tapiz.circulo= false;
        Tapiz.cuadradoRedondeado=false;
        Tapiz.poligono=false;
        Tapiz.freeLine=false;
        Tapiz.seleccionar=false;
        Tapiz.curva=true;
    }
    
    public static void freeLine(){
        Tapiz.linea =  false;
        Tapiz.cuadrado = false;
        Tapiz.circulo= false;
        Tapiz.cuadradoRedondeado=false;
        Tapiz.poligono=false;
        Tapiz.curva=false;
        Tapiz.seleccionar=false;
        Tapiz.freeLine=true;   
    }
    public static void borrar(){
            Tapiz.dibujos.clear();
            Paint.p.repaint();
    }

    public static void seleccionar() {
        Tapiz.linea =  false;
        Tapiz.cuadrado = false;
        Tapiz.circulo= false;
        Tapiz.cuadradoRedondeado=false;
        Tapiz.poligono=false;
        Tapiz.curva=false;
        Tapiz.freeLine=false;
        Tapiz.seleccionar=true;
    }
    
}
