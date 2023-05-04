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

    public VistaInicio() {
        setTitle("Menu | Tic Tac Toe");
        setSize(540, 680);
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
        lblTitulo.setFont(new Font("Arial", Font.PLAIN, 60));
        lblTitulo.setBounds(0,210, 540,185);
        lblTitulo.setForeground(Color.BLACK);
        
        btnJugar = new JButton("JUGAR");
        btnJugar.setFont(new java.awt.Font("Arial", 0, 25));
        btnJugar.setBounds(165,450, 210,50);
//        btnJugar.setBackground(new java.awt.Color(178, 221, 185));
        btnJugar.setForeground(new java.awt.Color(0, 0, 0));
        btnJugar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        
        btnAudio = new JButton("Audio");
        btnAudio.setFont(new java.awt.Font("Arial", 0, 25));
        btnAudio.setBounds(235,25, 75,30);
//        btnAudio.setBackground(new java.awt.Color(178, 221, 185));
        btnAudio.setForeground(new java.awt.Color(0, 0, 0));
        btnAudio.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        
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
        } else {
            sonidoFondo.stop();
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
