/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Funcionalidad;

import Panels.Tapiz;
import java.awt.Color;

/**
 *
 * @author Familia
 */
public class SeleccionColor {
    
    
    public static void cambiarBorde(Color color){
        Tapiz.colorB = color;
    }
    
    public static void cambiarRelleno(Color color){
        Tapiz.colorR = color;
    }
    
}
