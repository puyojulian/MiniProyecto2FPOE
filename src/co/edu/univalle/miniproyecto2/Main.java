/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package co.edu.univalle.miniproyecto2;

import co.edu.univalle.miniproyecto2.sounds.Music;
import co.edu.univalle.miniproyecto2.view.VistaInicio;

/**
 *
 * @author julia
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Music musica = new Music(true);
        VistaInicio vistaInicio = new VistaInicio(musica);
    }
    
}
