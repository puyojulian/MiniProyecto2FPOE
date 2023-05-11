/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.univalle.miniproyecto2.view;

import co.edu.univalle.miniproyecto2.sounds.Music;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.applet.AudioClip;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.ImageIcon;
/**
 *
 * @author Sebastián
 */
public class VistaInicio extends JFrame{
    
    private JPanel jpContenido;
    private JLabel lblTitulo;
    private JButton btnJugar;
    private JButton btnAudio;
    
    private Music musica;
    
    private boolean estadoMusica;
    
    private JLabel lblImagenDeFondo1;

    ImageIcon btnIconPlay = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/PlayButton.png"));
    ImageIcon btnIconAudio = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/AudioButton.png"));
    ImageIcon btnIconMute = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/MuteButton.png"));

    public VistaInicio(Music musica) {
        setTitle("Menu | Tic Tac Toe");
        setSize(544, 680);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.musica = musica;
        estadoMusica = musica.isState();
        musica.playStop(estadoMusica);
        
        inicializarComponentes();
        setVisible(true);
    }
    
    private void inicializarComponentes() {
        jpContenido = new JPanel();
        jpContenido.setLayout(null);
        jpContenido.setSize(getWidth(),getHeight());
        
        ImageIcon imagenDeFondo1 = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/wood1_45.png"));
        lblImagenDeFondo1 = new JLabel();
        lblImagenDeFondo1.setSize(jpContenido.getWidth(), jpContenido.getHeight());
        lblImagenDeFondo1.setBounds(0, 0, jpContenido.getWidth(), jpContenido.getHeight());
        lblImagenDeFondo1.setIcon(new ImageIcon(imagenDeFondo1.getImage().getScaledInstance(lblImagenDeFondo1.getWidth(), lblImagenDeFondo1.getHeight(), Image.SCALE_SMOOTH)));
        
        add(jpContenido);
        
        lblTitulo = new JLabel("<html>TIC<p>TAC<p>TOE<html>",SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Showcard Gothic", Font.PLAIN, 60));
        lblTitulo.setBounds(0,210, 540,200);
        lblTitulo.setForeground(Color.BLACK);
        
        btnJugar = new JButton();
        btnJugar.setSize(80,80);
        btnJugar.setIcon(new ImageIcon(btnIconPlay.getImage().getScaledInstance(btnJugar.getWidth(), btnJugar.getHeight(), Image.SCALE_SMOOTH)));
        btnJugar.setBounds(jpContenido.getWidth()*1/2 - btnJugar.getWidth()/2,jpContenido.getHeight()*9/12 - btnJugar.getHeight()/2,btnJugar.getWidth(),btnJugar.getHeight());
        btnJugar.setOpaque(false);
        btnJugar.setContentAreaFilled(false);
        btnJugar.setBorderPainted(false);
        
        btnAudio = new JButton();
        btnAudio.setSize(50,50);
        btnAudio.setIcon(new ImageIcon(btnIconAudio.getImage().getScaledInstance(btnAudio.getWidth(), btnAudio.getHeight(), Image.SCALE_SMOOTH)));
        btnAudio.setBounds(jpContenido.getWidth()*1/2 - btnAudio.getWidth()/2,jpContenido.getHeight()*2/12 - btnAudio.getHeight()/2,btnAudio.getWidth(),btnAudio.getHeight());
        btnAudio.setOpaque(false);
        btnAudio.setContentAreaFilled(false);
        btnAudio.setBorderPainted(false);
        
        jpContenido.add(lblTitulo);
        jpContenido.add(btnJugar);
        jpContenido.add(btnAudio);
        jpContenido.add(lblImagenDeFondo1);
        
        VistaInicio.MouseEventHandler mouseEventHandler = new VistaInicio.MouseEventHandler(musica);

        btnJugar.addMouseListener(mouseEventHandler);
        btnAudio.addMouseListener(mouseEventHandler);
    }

//    public void Musica(boolean Musica){
//        AudioClip sonidoFondo;
//        sonidoFondo = java.applet.Applet.newAudioClip(getClass().getResource("/co/edu/univalle/miniproyecto2/sounds/sonidoFondo.wav"));
//        if (Musica){
//            sonidoFondo.loop();
//            btnAudio.setIcon(new ImageIcon(btnIconAudio.getImage().getScaledInstance(btnAudio.getWidth(), btnAudio.getHeight(), Image.SCALE_SMOOTH)));
//        } else {
//            sonidoFondo.stop();
//            btnAudio.setIcon(new ImageIcon(btnIconMute.getImage().getScaledInstance(btnAudio.getWidth(), btnAudio.getHeight(), Image.SCALE_SMOOTH)));
//        }
//    }
    
    public class MouseEventHandler implements MouseListener, MouseMotionListener {
        
        private Music musica;
        
        public MouseEventHandler(Music musica) {
            this.musica = musica;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
//            if(e.getSource() == btnAudio){
//                estadoMusica = !estadoMusica;
//                musica.playStop(estadoMusica);
//            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (estadoMusica){
                ImageIcon btnIconAudio = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/AudioButtonNoShadow.png"));
                btnAudio.setSize(46, 46);
                btnAudio.setIcon(new ImageIcon(btnIconAudio.getImage().getScaledInstance(btnAudio.getWidth(), btnAudio.getHeight(), Image.SCALE_SMOOTH)));
                btnAudio.setBounds(getWidth()/2 - btnAudio.getWidth()/2, getHeight()*2/12 - btnAudio.getWidth()/2, btnAudio.getWidth(), btnAudio.getHeight());
            } else {
                ImageIcon btnIconAudio = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/MuteButtonNoShadow.png"));
                btnAudio.setSize(46, 46);
                btnAudio.setIcon(new ImageIcon(btnIconAudio.getImage().getScaledInstance(btnAudio.getWidth(), btnAudio.getHeight(), Image.SCALE_SMOOTH)));
                btnAudio.setBounds(getWidth()/2 - btnAudio.getWidth()/2, getHeight()*2/12 - btnAudio.getWidth()/2, btnAudio.getWidth(), btnAudio.getHeight());
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if(e.getSource() == btnJugar){                
                dispose();
                VistaOpciones vistaOpciones = new VistaOpciones(musica);
            }
            else if ((e.getSource() == btnAudio) && (estadoMusica == true)){
                estadoMusica = !estadoMusica;
                musica.playStop(estadoMusica);
                ImageIcon btnIconAudio = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/MuteButtonLight.png"));
                btnAudio.setSize(66, 66);
                btnAudio.setIcon(new ImageIcon(btnIconAudio.getImage().getScaledInstance(btnAudio.getWidth(), btnAudio.getHeight(), Image.SCALE_SMOOTH)));
                btnAudio.setBounds(getWidth()/2 - btnAudio.getWidth()/2, getHeight()*2/12 - btnAudio.getWidth()/2, btnAudio.getWidth(), btnAudio.getHeight());
            } 
            else if ((e.getSource() == btnAudio) && (estadoMusica == false)){
                estadoMusica = !estadoMusica;
                musica.playStop(estadoMusica);
                ImageIcon btnIconAudio = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/AudioButtonLight.png"));
                btnAudio.setSize(66, 66);
                btnAudio.setIcon(new ImageIcon(btnIconAudio.getImage().getScaledInstance(btnAudio.getWidth(), btnAudio.getHeight(), Image.SCALE_SMOOTH)));
                btnAudio.setBounds(getWidth()/2 - btnAudio.getWidth()/2, getHeight()*2/12 - btnAudio.getWidth()/2, btnAudio.getWidth(), btnAudio.getHeight());
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if(e.getSource() == btnJugar){                
                ImageIcon btnIconJugar = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/PlayButtonLight.png"));
                btnJugar.setSize(106, 106);
                btnJugar.setIcon(new ImageIcon(btnIconJugar.getImage().getScaledInstance(btnJugar.getWidth(), btnJugar.getHeight(), Image.SCALE_SMOOTH)));
                btnJugar.setBounds(getWidth()/2 - btnJugar.getWidth()/2, getHeight()*9/12 - btnJugar.getWidth()/2, btnJugar.getWidth(), btnJugar.getHeight());
            }
            if(e.getSource() == btnAudio){ 
                if (estadoMusica){
                    ImageIcon btnIconAudio = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/AudioButtonLight.png"));
                    btnAudio.setSize(66, 66);
                    btnAudio.setIcon(new ImageIcon(btnIconAudio.getImage().getScaledInstance(btnAudio.getWidth(), btnAudio.getHeight(), Image.SCALE_SMOOTH)));
                    btnAudio.setBounds(getWidth()/2 - btnAudio.getWidth()/2, getHeight()*2/12 - btnAudio.getWidth()/2, btnAudio.getWidth(), btnAudio.getHeight());
                } else {
                    ImageIcon btnIconAudio = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/MuteButtonLight.png"));
                    btnAudio.setSize(66, 66);
                    btnAudio.setIcon(new ImageIcon(btnIconAudio.getImage().getScaledInstance(btnAudio.getWidth(), btnAudio.getHeight(), Image.SCALE_SMOOTH)));
                    btnAudio.setBounds(getWidth()/2 - btnAudio.getWidth()/2, getHeight()*2/12 - btnAudio.getWidth()/2, btnAudio.getWidth(), btnAudio.getHeight());
                }
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(e.getSource() == btnJugar){                
                ImageIcon btnIconJugar = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/PlayButton.png"));
                btnJugar.setSize(80, 80);
                btnJugar.setIcon(new ImageIcon(btnIconJugar.getImage().getScaledInstance(btnJugar.getWidth(), btnJugar.getHeight(), Image.SCALE_SMOOTH)));
                btnJugar.setBounds(getWidth()*1/2 - btnJugar.getWidth()/2,getHeight()*9/12 - btnJugar.getHeight()/2,btnJugar.getWidth(),btnJugar.getHeight());
            }
            if(e.getSource() == btnAudio){                
                if (estadoMusica){
                    ImageIcon btnIconAudio = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/AudioButton.png"));
                    btnAudio.setSize(50, 50);
                    btnAudio.setIcon(new ImageIcon(btnIconAudio.getImage().getScaledInstance(btnAudio.getWidth(), btnAudio.getHeight(), Image.SCALE_SMOOTH)));
                    btnAudio.setBounds(getWidth()*1/2 - btnAudio.getWidth()/2,getHeight()*2/12 - btnAudio.getHeight()/2,btnAudio.getWidth(),btnAudio.getHeight());
                } else {
                    ImageIcon btnIconAudio = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/MuteButton.png"));
                    btnAudio.setSize(50, 50);
                    btnAudio.setIcon(new ImageIcon(btnIconAudio.getImage().getScaledInstance(btnAudio.getWidth(), btnAudio.getHeight(), Image.SCALE_SMOOTH)));
                    btnAudio.setBounds(getWidth()*1/2 - btnAudio.getWidth()/2,getHeight()*2/12 - btnAudio.getHeight()/2,btnAudio.getWidth(),btnAudio.getHeight());
                }
            }
        }

        @Override
        public void mouseDragged(MouseEvent e) {
//            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void mouseMoved(MouseEvent e) {
//            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
    }
    
}
