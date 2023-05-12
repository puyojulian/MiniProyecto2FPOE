/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.univalle.miniproyecto2.view;

import co.edu.univalle.miniproyecto2.sounds.Music;
import java.applet.AudioClip;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;
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
    
    private Music musica;
    
    private boolean estadoMusica;
    
    private VistaJuego vistaJuego;

    public VistaOpciones(Music musica) {
        setTitle("Options | Tic Tac Toe");
        setSize(540, 680);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.musica = musica;
        estadoMusica = musica.isState();
        
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
        
        MouseEventHandler manejadoraDeEventosMouse = new MouseEventHandler();
        
        
        btnAudio = new JButton();
        btnAudio.setSize(50,50);
        ImageIcon btnIconAudio = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/AudioButton.png"));
        ImageIcon btnIconMute = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/MuteButton.png"));
        if(estadoMusica) {
            btnAudio.setIcon(new ImageIcon(btnIconAudio.getImage().getScaledInstance(btnAudio.getWidth(), btnAudio.getHeight(), Image.SCALE_SMOOTH)));

        }
        else {
            btnAudio.setIcon(new ImageIcon(btnIconMute.getImage().getScaledInstance(btnAudio.getWidth(), btnAudio.getHeight(), Image.SCALE_SMOOTH)));
        }
        btnAudio.setBounds(jpContenido.getWidth()*1/2 - btnAudio.getWidth()/2,jpContenido.getHeight()*2/12 - btnAudio.getHeight()/2,btnAudio.getWidth(),btnAudio.getHeight());
        btnAudio.setOpaque(false);
        btnAudio.setContentAreaFilled(false);
        btnAudio.setBorderPainted(false);
        btnAudio.addMouseListener(manejadoraDeEventosMouse);
        
        btnNumRonda1 = new JToggleButton("");
        ImageIcon btnIconRonda1 = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/Ronda1.png"));
        btnNumRonda1.setSize(75, 75);
        btnNumRonda1.setIcon(new ImageIcon(btnIconRonda1.getImage().getScaledInstance(btnNumRonda1.getWidth(), btnNumRonda1.getHeight(), Image.SCALE_SMOOTH)));
        btnNumRonda1.setOpaque(false);
        btnNumRonda1.setContentAreaFilled(false);
        btnNumRonda1.setBorderPainted(false);
        
        btnNumRonda2 = new JToggleButton("");
        ImageIcon btnIconRonda2 = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/Ronda2.png"));
        btnNumRonda2.setSize(75, 75);
        btnNumRonda2.setIcon(new ImageIcon(btnIconRonda2.getImage().getScaledInstance(btnNumRonda2.getWidth(), btnNumRonda2.getHeight(), Image.SCALE_SMOOTH)));
        btnNumRonda2.setOpaque(false);
        btnNumRonda2.setContentAreaFilled(false);
        btnNumRonda2.setBorderPainted(false);
        
        btnNumRonda3 = new JToggleButton("");
        ImageIcon btnIconRonda3 = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/Ronda3.png"));
        btnNumRonda3.setSize(75, 75);
        btnNumRonda3.setIcon(new ImageIcon(btnIconRonda3.getImage().getScaledInstance(btnNumRonda3.getWidth(), btnNumRonda3.getHeight(), Image.SCALE_SMOOTH)));
        btnNumRonda3.setOpaque(false);
        btnNumRonda3.setContentAreaFilled(false);
        btnNumRonda3.setBorderPainted(false);
        
        btnNumRonda4 = new JToggleButton("");
        ImageIcon btnIconRonda4 = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/Ronda4.png"));
        btnNumRonda4.setSize(75, 75);
        btnNumRonda4.setIcon(new ImageIcon(btnIconRonda4.getImage().getScaledInstance(btnNumRonda4.getWidth(), btnNumRonda4.getHeight(), Image.SCALE_SMOOTH)));
        btnNumRonda4.setOpaque(false);
        btnNumRonda4.setContentAreaFilled(false);
        btnNumRonda4.setBorderPainted(false);
        
        btnJvsPC = new JToggleButton("");
        btnJvsPC.setBounds(150,200, 115,115);
        ImageIcon btnIconJvsPC = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/PlayerVsPc.png"));
        btnJvsPC.setSize(150, 150);
        btnJvsPC.setIcon(new ImageIcon(btnIconJvsPC.getImage().getScaledInstance(btnJvsPC.getWidth(), btnJvsPC.getHeight(), Image.SCALE_SMOOTH)));
        btnJvsPC.setBounds(getWidth()*4/12 - btnJvsPC.getWidth()/2, getHeight()*5/13 - btnJvsPC.getWidth()/2, btnJvsPC.getWidth(), btnJvsPC.getHeight());
        btnJvsPC.setOpaque(false);
        btnJvsPC.setContentAreaFilled(false);
        btnJvsPC.setBorder(new LineBorder(Color.BLACK));

        btnJvsJ = new JToggleButton("");
        btnJvsJ.setBounds(270,200, 115,115);
        ImageIcon btnIconJvsJ = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/PlayerVsPlayer.png"));
        btnJvsJ.setSize(150, 150);
        btnJvsJ.setIcon(new ImageIcon(btnIconJvsJ.getImage().getScaledInstance(btnJvsJ.getWidth(), btnJvsJ.getHeight(), Image.SCALE_SMOOTH)));
        btnJvsJ.setBounds(getWidth()*8/12 - btnJvsJ.getWidth()/2, getHeight()*5/13 - btnJvsJ.getWidth()/2, btnJvsJ.getWidth(), btnJvsJ.getHeight());
        btnJvsJ.setOpaque(false);
        btnJvsJ.setBorder(new LineBorder(Color.BLACK));
        
        ImageIcon btnIconConfirm = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/ConfirmButton.png"));
        btnConfirmar = new JButton();
        btnConfirmar.setSize(80,80);
        btnConfirmar.setIcon(new ImageIcon(btnIconConfirm.getImage().getScaledInstance(btnConfirmar.getWidth(), btnConfirmar.getHeight(), Image.SCALE_SMOOTH)));
        btnConfirmar.setBounds(jpContenido.getWidth()*1/2 - btnConfirmar.getWidth()/2,jpContenido.getHeight()*9/12 - btnConfirmar.getHeight()/2,btnConfirmar.getWidth(),btnConfirmar.getHeight());
        btnConfirmar.setOpaque(false);
        btnConfirmar.setContentAreaFilled(false);
        btnConfirmar.setBorderPainted(false);
        btnConfirmar.addMouseListener(manejadoraDeEventosMouse);
        
        jpBotones = new JPanel();
        jpBotones.setBounds(115,380,310,75);
        
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
    
    class ManejadorDeEventos implements ActionListener, KeyListener{
        @Override
        public void actionPerformed(ActionEvent evento){

            if(evento.getSource() == btnJvsJ) { 
                ImageIcon btnIconJvsJ = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/PlayerVsPlayerSelected.png"));
                btnJvsJ.setSize(150, 150);
                btnJvsJ.setIcon(new ImageIcon(btnIconJvsJ.getImage().getScaledInstance(btnJvsJ.getWidth(), btnJvsJ.getHeight(), Image.SCALE_SMOOTH)));
                btnJvsJ.setBounds(getWidth()*8/12 - btnJvsJ.getWidth()/2, getHeight()*5/13 - btnJvsJ.getWidth()/2, btnJvsJ.getWidth(), btnJvsJ.getHeight());
                btnJvsPC.setSelected(false);
                ImageIcon btnIconJvsPC = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/PlayerVsPc.png"));
                btnJvsPC.setSize(150, 150);
                btnJvsPC.setIcon(new ImageIcon(btnIconJvsPC.getImage().getScaledInstance(btnJvsPC.getWidth(), btnJvsPC.getHeight(), Image.SCALE_SMOOTH)));
                btnJvsPC.setBounds(getWidth()*4/12 - btnJvsPC.getWidth()/2, getHeight()*5/13 - btnJvsPC.getWidth()/2, btnJvsPC.getWidth(), btnJvsPC.getHeight());
            }
            else if(evento.getSource() == btnJvsPC) {
                ImageIcon btnIconJvsPC = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/PlayerVsPc2.png"));
                btnJvsPC.setSize(150, 150);
                btnJvsPC.setIcon(new ImageIcon(btnIconJvsPC.getImage().getScaledInstance(btnJvsPC.getWidth(), btnJvsPC.getHeight(), Image.SCALE_SMOOTH)));
                btnJvsPC.setBounds(getWidth()*4/12 - btnJvsPC.getWidth()/2, getHeight()*5/13 - btnJvsPC.getWidth()/2, btnJvsPC.getWidth(), btnJvsPC.getHeight());
                btnJvsJ.setSelected(false);
                ImageIcon btnIconJvsJ = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/PlayerVsPlayer.png"));
                btnJvsJ.setSize(150, 150);
                btnJvsJ.setIcon(new ImageIcon(btnIconJvsJ.getImage().getScaledInstance(btnJvsJ.getWidth(), btnJvsJ.getHeight(), Image.SCALE_SMOOTH)));
                btnJvsJ.setBounds(getWidth()*8/12 - btnJvsJ.getWidth()/2, getHeight()*5/13 - btnJvsJ.getWidth()/2, btnJvsJ.getWidth(), btnJvsJ.getHeight());
            }
            else if(evento.getSource() == btnNumRonda1) {                
                btnNumRonda2.setSelected(false);
                ImageIcon btnIconRonda2 = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/Ronda2.png"));
                btnNumRonda2.setSize(75, 75);
                btnNumRonda2.setIcon(new ImageIcon(btnIconRonda2.getImage().getScaledInstance(btnNumRonda2.getWidth(), btnNumRonda2.getHeight(), Image.SCALE_SMOOTH)));
                
                btnNumRonda3.setSelected(false);
                ImageIcon btnIconRonda3 = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/Ronda3.png"));
                btnNumRonda3.setSize(75, 75);
                btnNumRonda3.setIcon(new ImageIcon(btnIconRonda3.getImage().getScaledInstance(btnNumRonda3.getWidth(), btnNumRonda3.getHeight(), Image.SCALE_SMOOTH)));
                
                btnNumRonda4.setSelected(false);
                ImageIcon btnIconRonda4 = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/Ronda4.png"));
                btnNumRonda4.setSize(75, 75);
                btnNumRonda4.setIcon(new ImageIcon(btnIconRonda4.getImage().getScaledInstance(btnNumRonda4.getWidth(), btnNumRonda4.getHeight(), Image.SCALE_SMOOTH)));
                
                ImageIcon btnIconRonda1 = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/Ronda1Selected.png"));
                btnNumRonda1.setSize(75, 75);
                btnNumRonda1.setIcon(new ImageIcon(btnIconRonda1.getImage().getScaledInstance(btnNumRonda1.getWidth(), btnNumRonda1.getHeight(), Image.SCALE_SMOOTH)));
            }
            else if(evento.getSource() == btnNumRonda2) {                
                btnNumRonda1.setSelected(false);
                ImageIcon btnIconRonda1 = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/Ronda1.png"));
                btnNumRonda1.setSize(75, 75);
                btnNumRonda1.setIcon(new ImageIcon(btnIconRonda1.getImage().getScaledInstance(btnNumRonda1.getWidth(), btnNumRonda1.getHeight(), Image.SCALE_SMOOTH)));
                
                btnNumRonda3.setSelected(false);
                ImageIcon btnIconRonda3 = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/Ronda3.png"));
                btnNumRonda3.setSize(75, 75);
                btnNumRonda3.setIcon(new ImageIcon(btnIconRonda3.getImage().getScaledInstance(btnNumRonda3.getWidth(), btnNumRonda3.getHeight(), Image.SCALE_SMOOTH)));
               
                btnNumRonda4.setSelected(false);
                ImageIcon btnIconRonda4 = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/Ronda4.png"));
                btnNumRonda4.setSize(75, 75);
                btnNumRonda4.setIcon(new ImageIcon(btnIconRonda4.getImage().getScaledInstance(btnNumRonda4.getWidth(), btnNumRonda4.getHeight(), Image.SCALE_SMOOTH)));
                
                ImageIcon btnIconRonda2 = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/Ronda2Selected.png"));
                btnNumRonda2.setSize(75, 75);
                btnNumRonda2.setIcon(new ImageIcon(btnIconRonda2.getImage().getScaledInstance(btnNumRonda2.getWidth(), btnNumRonda2.getHeight(), Image.SCALE_SMOOTH)));
            }
            else if(evento.getSource() == btnNumRonda3) {                
                btnNumRonda1.setSelected(false);
                ImageIcon btnIconRonda1 = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/Ronda1.png"));
                btnNumRonda1.setSize(75, 75);
                btnNumRonda1.setIcon(new ImageIcon(btnIconRonda1.getImage().getScaledInstance(btnNumRonda1.getWidth(), btnNumRonda1.getHeight(), Image.SCALE_SMOOTH)));
                
                btnNumRonda2.setSelected(false);
                ImageIcon btnIconRonda2 = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/Ronda2.png"));
                btnNumRonda2.setSize(75, 75);
                btnNumRonda2.setIcon(new ImageIcon(btnIconRonda2.getImage().getScaledInstance(btnNumRonda2.getWidth(), btnNumRonda2.getHeight(), Image.SCALE_SMOOTH)));
                
                btnNumRonda4.setSelected(false);
                ImageIcon btnIconRonda4 = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/Ronda4.png"));
                btnNumRonda4.setSize(75, 75);
                btnNumRonda4.setIcon(new ImageIcon(btnIconRonda4.getImage().getScaledInstance(btnNumRonda4.getWidth(), btnNumRonda4.getHeight(), Image.SCALE_SMOOTH)));
                
                ImageIcon btnIconRonda3 = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/Ronda3Selected.png"));
                btnNumRonda3.setSize(75, 75);
                btnNumRonda3.setIcon(new ImageIcon(btnIconRonda3.getImage().getScaledInstance(btnNumRonda3.getWidth(), btnNumRonda3.getHeight(), Image.SCALE_SMOOTH)));
            }
            else if(evento.getSource() == btnNumRonda4) {                
                btnNumRonda1.setSelected(false);
                ImageIcon btnIconRonda1 = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/Ronda1.png"));
                btnNumRonda1.setSize(75, 75);
                btnNumRonda1.setIcon(new ImageIcon(btnIconRonda1.getImage().getScaledInstance(btnNumRonda1.getWidth(), btnNumRonda1.getHeight(), Image.SCALE_SMOOTH)));
                
                btnNumRonda2.setSelected(false);
                ImageIcon btnIconRonda2 = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/Ronda2.png"));
                btnNumRonda2.setSize(75, 75);
                btnNumRonda2.setIcon(new ImageIcon(btnIconRonda2.getImage().getScaledInstance(btnNumRonda2.getWidth(), btnNumRonda2.getHeight(), Image.SCALE_SMOOTH)));
                
                btnNumRonda3.setSelected(false);
                ImageIcon btnIconRonda3 = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/Ronda3.png"));
                btnNumRonda3.setSize(75, 75);
                btnNumRonda3.setIcon(new ImageIcon(btnIconRonda3.getImage().getScaledInstance(btnNumRonda3.getWidth(), btnNumRonda3.getHeight(), Image.SCALE_SMOOTH)));
                
                ImageIcon btnIconRonda4 = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/Ronda4Selected.png"));
                btnNumRonda4.setSize(75, 75);
                btnNumRonda4.setIcon(new ImageIcon(btnIconRonda4.getImage().getScaledInstance(btnNumRonda4.getWidth(), btnNumRonda4.getHeight(), Image.SCALE_SMOOTH)));
            }
            if(evento.getSource() == btnConfirmar) {
                if(btnJvsJ.isSelected() && btnNumRonda1.isSelected()) {
                    try {
                        vistaJuego = new VistaJuego(1,"JvsJ", musica);
                    } catch (AWTException ex) {
                        Logger.getLogger(VistaOpciones.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    dispose();
                }
                else if(btnJvsJ.isSelected() && btnNumRonda2.isSelected()) {
                    try {
                        vistaJuego = new VistaJuego(2,"JvsJ", musica);
                    } catch (AWTException ex) {
                        Logger.getLogger(VistaOpciones.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    dispose();
                }
                else if(btnJvsJ.isSelected() && btnNumRonda3.isSelected()) {
                    try {
                        vistaJuego = new VistaJuego(3,"JvsJ", musica);
                    } catch (AWTException ex) {
                        Logger.getLogger(VistaOpciones.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    dispose();
                }
                else if(btnJvsJ.isSelected() && btnNumRonda4.isSelected()) {
                    try {
                        vistaJuego = new VistaJuego(4,"JvsJ", musica);
                    } catch (AWTException ex) {
                        Logger.getLogger(VistaOpciones.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    dispose();
                }
                else if(btnJvsPC.isSelected() && btnNumRonda1.isSelected()) {
                    try {
                        vistaJuego = new VistaJuego(1,"JvsPC", musica);
                    } catch (AWTException ex) {
                        Logger.getLogger(VistaOpciones.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    dispose();
                }
                else if(btnJvsPC.isSelected() && btnNumRonda2.isSelected()) {
                    try {
                        vistaJuego = new VistaJuego(2,"JvsPC", musica);
                    } catch (AWTException ex) {
                        Logger.getLogger(VistaOpciones.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    dispose();
                }
                else if(btnJvsPC.isSelected() && btnNumRonda3.isSelected()) {
                    try {
                        vistaJuego = new VistaJuego(3,"JvsPC", musica);
                    } catch (AWTException ex) {
                        Logger.getLogger(VistaOpciones.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    dispose();
                }
                else if(btnJvsPC.isSelected() && btnNumRonda4.isSelected()) {
                    try {
                        vistaJuego = new VistaJuego(4,"JvsPC", musica);
                    } catch (AWTException ex) {
                        Logger.getLogger(VistaOpciones.class.getName()).log(Level.SEVERE, null, ex);
                    }
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
    
    public class MouseEventHandler implements MouseListener, MouseMotionListener {

        @Override
        public void mouseClicked(MouseEvent e) {
//            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if(e.getSource() == btnConfirmar) {
                ImageIcon btnIconNoShadowConfirmar = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/ConfirmButtonNoShadow.png"));
                btnConfirmar.setSize(90,90);
                btnConfirmar.setIcon(new ImageIcon(btnIconNoShadowConfirmar.getImage().getScaledInstance(btnConfirmar.getWidth(), btnConfirmar.getHeight(), Image.SCALE_SMOOTH)));
                btnConfirmar.setBounds(getWidth()*1/2 - btnConfirmar.getWidth()/2, getHeight()*9/12 - btnConfirmar.getHeight()/2,btnConfirmar.getWidth(),btnConfirmar.getHeight());
                
            }
            else if ((e.getSource() == btnAudio) && (estadoMusica == true)){
                ImageIcon btnIconAudio = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/AudioButtonNoShadow.png"));
                btnAudio.setSize(60, 60);
                btnAudio.setIcon(new ImageIcon(btnIconAudio.getImage().getScaledInstance(btnAudio.getWidth(), btnAudio.getHeight(), Image.SCALE_SMOOTH)));
                btnAudio.setBounds(getWidth()*1/2 - btnAudio.getWidth()/2, getHeight()*2/12 - btnAudio.getHeight()/2,btnAudio.getWidth(),btnAudio.getHeight());
            } 
            else if ((e.getSource() == btnAudio) && (estadoMusica == false)){
                ImageIcon btnIconAudio = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/MuteButtonNoShadow.png"));
                btnAudio.setSize(60, 60);
                btnAudio.setIcon(new ImageIcon(btnIconAudio.getImage().getScaledInstance(btnAudio.getWidth(), btnAudio.getHeight(), Image.SCALE_SMOOTH)));
                btnAudio.setBounds(getWidth()*1/2 - btnAudio.getWidth()/2, getHeight()*2/12 - btnAudio.getHeight()/2,btnAudio.getWidth(),btnAudio.getHeight());
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if(e.getSource() == btnConfirmar) {
                ImageIcon btnIconLightConfirmar = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/ConfirmButtonLight.png"));
                btnConfirmar.setSize(100,100);
                btnConfirmar.setIcon(new ImageIcon(btnIconLightConfirmar.getImage().getScaledInstance(btnConfirmar.getWidth(), btnConfirmar.getHeight(), Image.SCALE_SMOOTH)));
                btnConfirmar.setBounds(getWidth()*1/2 - btnConfirmar.getWidth()/2, getHeight()*9/12 - btnConfirmar.getHeight()/2,btnConfirmar.getWidth(),btnConfirmar.getHeight());
            }
            else if ((e.getSource() == btnAudio) && (estadoMusica == true)){
                estadoMusica = !estadoMusica;
                musica.playStop(estadoMusica);
                ImageIcon btnIconAudio = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/MuteButtonLight.png"));
                btnAudio.setSize(70, 70);
                btnAudio.setIcon(new ImageIcon(btnIconAudio.getImage().getScaledInstance(btnAudio.getWidth(), btnAudio.getHeight(), Image.SCALE_SMOOTH)));
                btnAudio.setBounds(getWidth()*1/2 - btnAudio.getWidth()/2, getHeight()*2/12 - btnAudio.getHeight()/2,btnAudio.getWidth(),btnAudio.getHeight());
            } 
            else if ((e.getSource() == btnAudio) && (estadoMusica == false)){
                estadoMusica = !estadoMusica;
                musica.playStop(estadoMusica);
                ImageIcon btnIconAudio = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/AudioButtonLight.png"));
                btnAudio.setSize(70, 70);
                btnAudio.setIcon(new ImageIcon(btnIconAudio.getImage().getScaledInstance(btnAudio.getWidth(), btnAudio.getHeight(), Image.SCALE_SMOOTH)));
                btnAudio.setBounds(getWidth()*1/2 - btnAudio.getWidth()/2, getHeight()*2/12 - btnAudio.getHeight()/2,btnAudio.getWidth(),btnAudio.getHeight());
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if(e.getSource() == btnConfirmar) {
                ImageIcon btnIconLightConfirmar = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/ConfirmButtonLight.png"));
                btnConfirmar.setSize(100,100);
                btnConfirmar.setIcon(new ImageIcon(btnIconLightConfirmar.getImage().getScaledInstance(btnConfirmar.getWidth(), btnConfirmar.getHeight(), Image.SCALE_SMOOTH)));
                btnConfirmar.setBounds(getWidth()*1/2 - btnConfirmar.getWidth()/2, getHeight()*9/12 - btnConfirmar.getHeight()/2,btnConfirmar.getWidth(),btnConfirmar.getHeight());
            }
            else if ((e.getSource() == btnAudio) && (estadoMusica == true)){
                ImageIcon btnIconAudio = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/AudioButtonLight.png"));
                btnAudio.setSize(70, 70);
                btnAudio.setIcon(new ImageIcon(btnIconAudio.getImage().getScaledInstance(btnAudio.getWidth(), btnAudio.getHeight(), Image.SCALE_SMOOTH)));
                btnAudio.setBounds(getWidth()*1/2 - btnAudio.getWidth()/2, getHeight()*2/12 - btnAudio.getHeight()/2,btnAudio.getWidth(),btnAudio.getHeight());
            } 
            else if ((e.getSource() == btnAudio) && (estadoMusica == false)){
                ImageIcon btnIconAudio = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/MuteButtonLight.png"));
                btnAudio.setSize(70, 70);
                btnAudio.setIcon(new ImageIcon(btnIconAudio.getImage().getScaledInstance(btnAudio.getWidth(), btnAudio.getHeight(), Image.SCALE_SMOOTH)));
                btnAudio.setBounds(getWidth()*1/2 - btnAudio.getWidth()/2, getHeight()*2/12 - btnAudio.getHeight()/2,btnAudio.getWidth(),btnAudio.getHeight());
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(e.getSource() == btnConfirmar) {
                ImageIcon btnIconSalidoConfirmar = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/ConfirmButton.png"));
                btnConfirmar.setSize(80,80);
                btnConfirmar.setIcon(new ImageIcon(btnIconSalidoConfirmar.getImage().getScaledInstance(btnConfirmar.getWidth(), btnConfirmar.getHeight(), Image.SCALE_SMOOTH)));
                btnConfirmar.setBounds(getWidth()*1/2 - btnConfirmar.getWidth()/2, getHeight()*9/12 - btnConfirmar.getHeight()/2,btnConfirmar.getWidth(),btnConfirmar.getHeight());
            }
            else if ((e.getSource() == btnAudio) && (estadoMusica == true)){
                ImageIcon btnIconAudio = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/AudioButton.png"));
                btnAudio.setSize(50, 50);
                btnAudio.setIcon(new ImageIcon(btnIconAudio.getImage().getScaledInstance(btnAudio.getWidth(), btnAudio.getHeight(), Image.SCALE_SMOOTH)));
                btnAudio.setBounds(getWidth()*1/2 - btnAudio.getWidth()/2, getHeight()*2/12 - btnAudio.getHeight()/2,btnAudio.getWidth(),btnAudio.getHeight());
            } 
            else if ((e.getSource() == btnAudio) && (estadoMusica == false)){
                ImageIcon btnIconAudio = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/MuteButton.png"));
                btnAudio.setSize(50, 50);
                btnAudio.setIcon(new ImageIcon(btnIconAudio.getImage().getScaledInstance(btnAudio.getWidth(), btnAudio.getHeight(), Image.SCALE_SMOOTH)));
                btnAudio.setBounds(getWidth()*1/2 - btnAudio.getWidth()/2, getHeight()*2/12 - btnAudio.getHeight()/2,btnAudio.getWidth(),btnAudio.getHeight());
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
