/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidad;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author dam
 */
public class Guardar {
    
    public static void guardar(BufferedImage imagen, String formato,String nombre){
        try {
            
            ImageIO.write(imagen, formato, new File(nombre));
        } catch (IOException ex) {
            Logger.getLogger(Guardar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
