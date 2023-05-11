/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.univalle.miniproyecto2.sounds;

import java.applet.AudioClip;

/**
 *
 * @author julia
 */
public class Music {
    
    private AudioClip sonidoFondo;
    private boolean state;
    
    public Music(boolean state) {
        sonidoFondo = java.applet.Applet.newAudioClip(getClass().getResource("/co/edu/univalle/miniproyecto2/sounds/sonidoFondo.wav"));
        this.state = state;
    }
    
    public void playStop(boolean state){
        setState(state);
        if (state){
            sonidoFondo.loop();
        } else {
            sonidoFondo.stop();
        }
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public boolean isState() {
        return state;
    }
}
