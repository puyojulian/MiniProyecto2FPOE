/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.univalle.miniproyecto2.view;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
/**
 *
 * @author Sebastián
 */
public class VistaOpciones extends JFrame{
    
    private JPanel jpContenido;
    private JPanel jpBotones;
    
    private JButton btnAudio;
    private JToggleButton btnJvsPC;
    private JToggleButton btnJvsJ;
    private JToggleButton btnNumRonda1;
    private JToggleButton btnNumRonda2;
    private JToggleButton btnNumRonda3;
    private JToggleButton btnNumRonda4;
    private JButton btnConfirmar;
    
    private JLabel lblImagenDeFondo1;
    private boolean Musica = true;
    
    ImageIcon btnIconAudio = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/AudioButton.png"));
    ImageIcon btnIconMute = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/MuteButton.png"));
    
    private VistaJuego vistaJuego;

    public VistaOpciones() {
        setTitle("Options | Tic Tac Toe");
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
        
        
        btnAudio = new JButton();
        btnAudio.setSize(50,50);
        btnAudio.setIcon(new ImageIcon(btnIconAudio.getImage().getScaledInstance(btnAudio.getWidth(), btnAudio.getHeight(), Image.SCALE_SMOOTH)));
        btnAudio.setBounds(jpContenido.getWidth()*1/2 - btnAudio.getWidth()/2,jpContenido.getHeight()*2/12 - btnAudio.getHeight()/2,btnAudio.getWidth(),btnAudio.getHeight());
        btnAudio.setOpaque(false);
        btnAudio.setContentAreaFilled(false);
        btnAudio.setBorderPainted(false);
        
        btnNumRonda1 = new JToggleButton("1");
        btnNumRonda1.setFont(new java.awt.Font("Arial", 0, 35));
        
        btnNumRonda2 = new JToggleButton("2");
        btnNumRonda2.setFont(new java.awt.Font("Arial", 0, 35));
        
        btnNumRonda3 = new JToggleButton("3");
        btnNumRonda3.setFont(new java.awt.Font("Arial", 0, 35));
        
        btnNumRonda4 = new JToggleButton("4");
        btnNumRonda4.setFont(new java.awt.Font("Arial", 0, 35));
        
        btnJvsPC = new JToggleButton("J vs PC");
        btnJvsPC.setFont(new java.awt.Font("Arial", 0, 20));
        btnJvsPC.setBounds(150,300, 115,35);

        btnJvsJ = new JToggleButton("J vs J");
        btnJvsJ.setFont(new java.awt.Font("Arial", 0, 20));
        btnJvsJ.setBounds(270,300, 115,35);
        
        ImageIcon btnIconConfirm = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/ConfirmButton.png"));
        btnConfirmar = new JButton();
        btnConfirmar.setSize(80,80);
        btnConfirmar.setIcon(new ImageIcon(btnIconConfirm.getImage().getScaledInstance(btnConfirmar.getWidth(), btnConfirmar.getHeight(), Image.SCALE_SMOOTH)));
        btnConfirmar.setBounds(jpContenido.getWidth()*1/2 - btnConfirmar.getWidth()/2,jpContenido.getHeight()*9/12 - btnConfirmar.getHeight()/2,btnConfirmar.getWidth(),btnConfirmar.getHeight());
        btnConfirmar.setOpaque(false);
        btnConfirmar.setContentAreaFilled(false);
        btnConfirmar.setBorderPainted(false);
        
        jpBotones = new JPanel();
        jpBotones.setBounds(150,340,235,35);
        
        GridLayout GridBotones;
        GridBotones = new GridLayout(1,4,5,0);
        jpBotones.setLayout(GridBotones);
        jpBotones.add(btnNumRonda1);
        jpBotones.add(btnNumRonda2);
        jpBotones.add(btnNumRonda3);
        jpBotones.add(btnNumRonda4);
        
        jpContenido.add(btnAudio);
        jpContenido.add(jpBotones);
        jpContenido.add(btnJvsPC);
        jpContenido.add(btnJvsJ);
        jpContenido.add(btnConfirmar);
        jpContenido.add(lblImagenDeFondo1);
        jpBotones.setBackground(Color.DARK_GRAY);
        
        VistaOpciones.ManejadorDeEventos manejadorEventos = new VistaOpciones.ManejadorDeEventos();
        
        btnAudio.addActionListener(manejadorEventos);
        btnJvsJ.addActionListener(manejadorEventos);
        btnJvsPC.addActionListener(manejadorEventos);
        btnNumRonda1.addActionListener(manejadorEventos);
        btnNumRonda2.addActionListener(manejadorEventos);
        btnNumRonda3.addActionListener(manejadorEventos);
        btnNumRonda4.addActionListener(manejadorEventos);
        btnConfirmar.addActionListener(manejadorEventos);
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
                if(evento.getSource() == btnAudio){
                Musica = !Musica;
                Musica(Musica);
            }
                if(evento.getSource() == btnJvsJ) {                
                btnJvsPC.setSelected(false);
            }
            else if(evento.getSource() == btnJvsPC) {
                btnJvsJ.setSelected(false);
            }
            else if(evento.getSource() == btnNumRonda1) {                
                btnNumRonda2.setSelected(false);
                btnNumRonda3.setSelected(false);
                btnNumRonda4.setSelected(false);
            }
            else if(evento.getSource() == btnNumRonda2) {                
                btnNumRonda1.setSelected(false);
                btnNumRonda3.setSelected(false);
                btnNumRonda4.setSelected(false);
            }
            else if(evento.getSource() == btnNumRonda3) {                
                btnNumRonda1.setSelected(false);
                btnNumRonda2.setSelected(false);
                btnNumRonda4.setSelected(false);
            }
            else if(evento.getSource() == btnNumRonda4) {                
                btnNumRonda1.setSelected(false);
                btnNumRonda2.setSelected(false);
                btnNumRonda3.setSelected(false);
            }
            if(evento.getSource() == btnConfirmar) {
                if(btnJvsJ.isSelected() && btnNumRonda1.isSelected()) {
                    vistaJuego = new VistaJuego(1,"JvsJ");
                    dispose();
                }
                else if(btnJvsJ.isSelected() && btnNumRonda2.isSelected()) {
                    vistaJuego = new VistaJuego(2,"JvsJ");
                    dispose();
                }
                else if(btnJvsJ.isSelected() && btnNumRonda3.isSelected()) {
                    vistaJuego = new VistaJuego(3,"JvsJ");
                    dispose();
                }
                else if(btnJvsJ.isSelected() && btnNumRonda4.isSelected()) {
                    vistaJuego = new VistaJuego(4,"JvsJ");
                    dispose();
                }
                else if(btnJvsPC.isSelected() && btnNumRonda1.isSelected()) {
                    vistaJuego = new VistaJuego(1,"JvsPC");
                    dispose();
                }
                else if(btnJvsPC.isSelected() && btnNumRonda2.isSelected()) {
                    vistaJuego = new VistaJuego(2,"JvsPC");
                    dispose();
                }
                else if(btnJvsPC.isSelected() && btnNumRonda3.isSelected()) {
                    vistaJuego = new VistaJuego(3,"JvsPC");
                    dispose();
                }
                else if(btnJvsPC.isSelected() && btnNumRonda4.isSelected()) {
                    vistaJuego = new VistaJuego(4,"JvsPC");
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(null,
                    "Selecciona una categoría.", 
                    "Parámetro Necesario",
                    JOptionPane.ERROR_MESSAGE);
                }
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
