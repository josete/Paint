/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Funcionalidad;

import Panels.Tapiz;

/**
 *
 * @author Familia
 */
public class SeleccionForma {
    
    public static void activarCuadrado(){
        Tapiz.linea =  false;
        Tapiz.circulo = false;
        Tapiz.cuadrado=true;
    }
    
    public static void activarLinea(){
        Tapiz.cuadrado =  false;
        Tapiz.circulo = false;
        Tapiz.linea=true;
    }
    
    public static void activarCirculo(){
        Tapiz.linea =  false;
        Tapiz.cuadrado = false;
        Tapiz.circulo=true;
    }
}
