/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package co.edu.univalle.miniproyecto2;

import co.edu.univalle.miniproyecto2.sounds.Music;
import co.edu.univalle.miniproyecto2.view.VistaEstadisticas;
import co.edu.univalle.miniproyecto2.view.VistaInicio;
import co.edu.univalle.miniproyecto2.view.VistaJuego;
import co.edu.univalle.miniproyecto2.view.VistaOpciones;

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
//        VistaJuego vistaJuego = new VistaJuego();
//        VistaEstadisticas vistaEstadisticas = new VistaEstadisticas();

    }
    
}
