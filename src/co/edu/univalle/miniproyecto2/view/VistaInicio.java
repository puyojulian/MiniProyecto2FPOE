/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.univalle.miniproyecto2.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.applet.AudioClip;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
/**
 *
 * @author Sebastián
 */
public class VistaInicio extends JFrame{
    
    private JPanel jpContenido;
    private JLabel lblTitulo;
    private JButton btnJugar;
    private JButton btnAudio;
    
    private boolean Musica = true;
    
    private JLabel lblImagenDeFondo1;

    ImageIcon btnIconPlay = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/PlayButton.png"));
    ImageIcon btnIconAudio = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/AudioButton.png"));
    ImageIcon btnIconMute = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/MuteButton.png"));

    public VistaInicio() {
        setTitle("Menu | Tic Tac Toe");
        setSize(544, 680);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        inicializarComponentes();
        setVisible(true);
        
        Musica(Musica);
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
        
        ManejadorDeEventos manejadorEventos = new ManejadorDeEventos();
        
        btnJugar.addActionListener(manejadorEventos);
        btnAudio.addActionListener(manejadorEventos);
    }

    private void Musica(boolean Musica){
        AudioClip sonidoFondo;
        sonidoFondo = java.applet.Applet.newAudioClip(getClass().getResource("/co/edu/univalle/miniproyecto2/sounds/sonidoFondo.wav"));
        if (Musica){
            sonidoFondo.loop();
            btnAudio.setIcon(new ImageIcon(btnIconAudio.getImage().getScaledInstance(btnAudio.getWidth(), btnAudio.getHeight(), Image.SCALE_SMOOTH)));
        } else {
            sonidoFondo.stop();
            btnAudio.setIcon(new ImageIcon(btnIconMute.getImage().getScaledInstance(btnAudio.getWidth(), btnAudio.getHeight(), Image.SCALE_SMOOTH)));
        }
    }
    
    class ManejadorDeEventos implements ActionListener, KeyListener{
        @Override
        public void actionPerformed(ActionEvent evento){
            if(evento.getSource() == btnJugar){                
                dispose();
                VistaOpciones vistaopciones = new VistaOpciones();
            }
            if(evento.getSource() == btnAudio){
                Musica = !Musica;
                Musica(Musica);
            }
        }
        
        @Override
        public void keyReleased(KeyEvent e) {
           /* System.out.println("Se liberó la tecla " + e.getKeyChar() +
                    " Con codigo " + e.getKeyCode());*/
        }
        
        @Override
        public void keyPressed(KeyEvent e) {
            /*System.out.println("Se presionó la tecla " + e.getKeyChar()+
                    " Con codigo " + e.getKeyCode());*/
        }
        
        @Override
        public void keyTyped(KeyEvent e) {
            /*System.out.println("Se digitó la tecla " + e.getKeyChar()+
                    " Con codigo " + e.getKeyCode());*/
        }
    }
    
}
