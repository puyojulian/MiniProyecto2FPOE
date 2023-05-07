/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.univalle.miniproyecto2.view;

import co.edu.univalle.miniproyecto2.logic.Juego;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.SwingConstants.CENTER;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author julia
 */
public class VistaEstadisticas extends JFrame{
    
    private JPanel jpContenido;
    
    private JLabel lblNombre;
    private JLabel lblContadorJ1;
    private JLabel lblContadorJ2;

    private JButton btnInicio;
    private JButton btnReintentar;
    private JButton btnTerminar;
    
    private int contadorJ1;
    private int contadorJ2;
    private int numeroRondas;
    
    private String modoDeJuego;
    
    private JLabel lblImagenDeFondo1;
    
    public VistaEstadisticas(int contadorJ1, int contadorJ2,int numeroRondas,String modoDeJuego) {
        this.contadorJ1 = contadorJ1;
        this.contadorJ2 = contadorJ2;
        this.numeroRondas = numeroRondas;
        this.modoDeJuego = modoDeJuego;
        
        setTitle("Game | Tic Tac Toe");
        setSize(544, 680);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
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
        
        
        lblNombre = new JLabel("RESUMEN DEL JUEGO",CENTER);
        lblNombre.setFont(new Font("Showcard Gothic", Font.PLAIN, 40));
        lblNombre.setSize(jpContenido.getWidth(), 80);
        lblNombre.setForeground(Color.YELLOW);
        lblNombre.setBounds(jpContenido.getWidth()/2 - lblNombre.getWidth()/2, jpContenido.getHeight()*1/8, lblNombre.getWidth(), lblNombre.getHeight());
        
        
        lblContadorJ1 = new JLabel("Jugador 1: " + contadorJ1,CENTER);
        lblContadorJ1.setFont(new Font("Showcard Gothic", Font.PLAIN, 40));
        lblContadorJ1.setSize(jpContenido.getWidth(), 45);
        lblContadorJ1.setBounds(jpContenido.getWidth()/2 - lblContadorJ1.getWidth()/2, jpContenido.getHeight()*1/4, lblContadorJ1.getWidth(), lblContadorJ1.getHeight());
        
        lblContadorJ2 = new JLabel("Jugador 2: " + contadorJ2,CENTER);
        lblContadorJ2.setFont(new Font("Showcard Gothic", Font.PLAIN, 40));
        lblContadorJ2.setSize(jpContenido.getWidth(), 45);
        lblContadorJ2.setBounds(jpContenido.getWidth()/2 - lblContadorJ2.getWidth()/2, jpContenido.getHeight()*2/4, lblContadorJ2.getWidth(), lblContadorJ2.getHeight());
        
        ImageIcon btnIconInicio = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/HomeButton.png"));
        btnInicio = new JButton();
        btnInicio.setSize(100, 100);
        btnInicio.setIcon(new ImageIcon(btnIconInicio.getImage().getScaledInstance(btnInicio.getWidth(), btnInicio.getHeight(), Image.SCALE_SMOOTH)));
        btnInicio.setBounds(jpContenido.getWidth()*1/4 - btnInicio.getWidth()/2, jpContenido.getHeight()*3/4, btnInicio.getWidth(), btnInicio.getHeight());
        btnInicio.setOpaque(false);
        btnInicio.setContentAreaFilled(false);
        btnInicio.setBorderPainted(false);
        
        ImageIcon btnIconReintentar = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/ReplayButton.png"));
        btnReintentar = new JButton();
        btnReintentar.setSize(100, 100);
        btnReintentar.setIcon(new ImageIcon(btnIconReintentar.getImage().getScaledInstance(btnReintentar.getWidth(), btnReintentar.getHeight(), Image.SCALE_SMOOTH)));
        btnReintentar.setBounds(jpContenido.getWidth()*2/4 - btnReintentar.getWidth()/2, jpContenido.getHeight()*3/4, btnReintentar.getWidth(), btnReintentar.getHeight());
        btnReintentar.setOpaque(false);
        btnReintentar.setContentAreaFilled(false);
        btnReintentar.setBorderPainted(false);
        
        ImageIcon btnIconTerminar = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/TurnOnOffButton.png"));
        btnTerminar = new JButton();
        btnTerminar.setSize(100, 100);
        btnTerminar.setIcon(new ImageIcon(btnIconTerminar.getImage().getScaledInstance(btnTerminar.getWidth(), btnTerminar.getHeight(), Image.SCALE_SMOOTH)));
        btnTerminar.setBounds(jpContenido.getWidth()*3/4 - btnTerminar.getWidth()/2, jpContenido.getHeight()*3/4, btnTerminar.getWidth(), btnTerminar.getHeight());
        btnTerminar.setOpaque(false);
        btnTerminar.setContentAreaFilled(false);
        btnTerminar.setBorderPainted(false);
        
        jpContenido.add(lblNombre);
        jpContenido.add(lblContadorJ1);
        jpContenido.add(lblContadorJ2);
        jpContenido.add(btnInicio);
        jpContenido.add(btnReintentar);
        jpContenido.add(btnTerminar);
        jpContenido.add(lblImagenDeFondo1);
        
        add(jpContenido);
        
        VistaEstadisticas.ManejadorDeEventos manejadoraDeEventos = new VistaEstadisticas.ManejadorDeEventos();
        VistaEstadisticas.MouseEventHandler mouseEventHandler = new VistaEstadisticas.MouseEventHandler();
        
        btnInicio.addActionListener(manejadoraDeEventos);
        btnReintentar.addActionListener(manejadoraDeEventos);
        btnTerminar.addActionListener(manejadoraDeEventos);
        btnInicio.addMouseListener(mouseEventHandler);
        btnReintentar.addMouseListener(mouseEventHandler);
        btnTerminar.addMouseListener(mouseEventHandler);
    }
    
    class ManejadorDeEventos implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evento){
            if(evento.getSource() == btnInicio){
                dispose();
                VistaInicio vistaInicio = new VistaInicio();
            }
            if(evento.getSource() == btnReintentar){
                dispose();
                VistaJuego vistaJuego = new VistaJuego(numeroRondas, modoDeJuego);
            }
            if(evento.getSource() == btnTerminar){
                System.exit(0);
            }
        }
    }
    
    public class MouseEventHandler implements MouseListener, MouseMotionListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if(e.getSource() == btnInicio){                
                ImageIcon btnIconInicio = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/HomeButtonNoShadow.png"));
                btnInicio.setSize(100, 100);
                btnInicio.setIcon(new ImageIcon(btnIconInicio.getImage().getScaledInstance(btnInicio.getWidth(), btnInicio.getHeight(), Image.SCALE_SMOOTH)));
                btnInicio.setBounds(jpContenido.getWidth()*1/4 - btnInicio.getWidth()/2, jpContenido.getHeight()*3/4, btnInicio.getWidth(), btnInicio.getHeight());
                btnInicio.setOpaque(false);
                btnInicio.setContentAreaFilled(false);
                btnInicio.setBorderPainted(false);
            }
            if(e.getSource() == btnReintentar){                
                ImageIcon btnIconReintentar = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/ReplayButtonNoShadow.png"));
                btnReintentar.setSize(100, 100);
                btnReintentar.setIcon(new ImageIcon(btnIconReintentar.getImage().getScaledInstance(btnReintentar.getWidth(), btnReintentar.getHeight(), Image.SCALE_SMOOTH)));
                btnReintentar.setBounds(jpContenido.getWidth()*2/4 - btnReintentar.getWidth()/2, jpContenido.getHeight()*3/4, btnReintentar.getWidth(), btnReintentar.getHeight());
                btnReintentar.setOpaque(false);
                btnReintentar.setContentAreaFilled(false);
                btnReintentar.setBorderPainted(false);
            }
            if(e.getSource() == btnTerminar){                
                ImageIcon btnIconTerminar = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/TurnOnOffButtonNoShadow.png"));
                btnTerminar.setSize(100, 100);
                btnTerminar.setIcon(new ImageIcon(btnIconTerminar.getImage().getScaledInstance(btnTerminar.getWidth(), btnTerminar.getHeight(), Image.SCALE_SMOOTH)));
                btnTerminar.setBounds(jpContenido.getWidth()*3/4 - btnTerminar.getWidth()/2, jpContenido.getHeight()*3/4, btnTerminar.getWidth(), btnTerminar.getHeight());
                btnTerminar.setOpaque(false);
                btnTerminar.setContentAreaFilled(false);
                btnTerminar.setBorderPainted(false);
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if(e.getSource() == btnInicio){                
                ImageIcon btnIconInicio = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/HomeButtonLight.png"));
                btnInicio.setSize(133, 133);
                btnInicio.setBounds(jpContenido.getWidth()*1/4 - btnInicio.getWidth()/2, jpContenido.getHeight()*3/4, btnInicio.getWidth(), btnInicio.getHeight());
                btnInicio.setOpaque(false);
                btnInicio.setContentAreaFilled(false);
                btnInicio.setBorderPainted(false);
                btnInicio.setIcon(new ImageIcon(btnIconInicio.getImage().getScaledInstance(btnInicio.getWidth(), btnInicio.getHeight(), Image.SCALE_SMOOTH)));
            }
            if(e.getSource() == btnReintentar){                
                ImageIcon btnIconReintentar = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/ReplayButtonLight.png"));
                btnReintentar.setSize(133, 133);
                btnReintentar.setIcon(new ImageIcon(btnIconReintentar.getImage().getScaledInstance(btnReintentar.getWidth(), btnReintentar.getHeight(), Image.SCALE_SMOOTH)));
                btnReintentar.setBounds(jpContenido.getWidth()*2/4 - btnReintentar.getWidth()/2, jpContenido.getHeight()*3/4, btnReintentar.getWidth(), btnReintentar.getHeight());
                btnReintentar.setOpaque(false);
                btnReintentar.setContentAreaFilled(false);
                btnReintentar.setBorderPainted(false);
            }
            if(e.getSource() == btnTerminar){                
                ImageIcon btnIconTerminar = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/TurnOnOffButtonLight.png"));
                btnTerminar.setSize(133, 133);
                btnTerminar.setIcon(new ImageIcon(btnIconTerminar.getImage().getScaledInstance(btnTerminar.getWidth(), btnTerminar.getHeight(), Image.SCALE_SMOOTH)));
                btnTerminar.setBounds(jpContenido.getWidth()*3/4 - btnTerminar.getWidth()/2, jpContenido.getHeight()*3/4, btnTerminar.getWidth(), btnTerminar.getHeight());
                btnTerminar.setOpaque(false);
                btnTerminar.setContentAreaFilled(false);
                btnTerminar.setBorderPainted(false);
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(e.getSource() == btnInicio){                
                ImageIcon btnIconInicio = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/HomeButton.png"));
                btnInicio.setSize(133, 133);
                btnInicio.setIcon(new ImageIcon(btnIconInicio.getImage().getScaledInstance(btnInicio.getWidth(), btnInicio.getHeight(), Image.SCALE_SMOOTH)));
                btnInicio.setBounds(jpContenido.getWidth()*1/4 - btnInicio.getWidth()/2, jpContenido.getHeight()*3/4, btnInicio.getWidth(), btnInicio.getHeight());
                btnInicio.setOpaque(false);
                btnInicio.setContentAreaFilled(false);
                btnInicio.setBorderPainted(false);
            }
            if(e.getSource() == btnReintentar){                
                ImageIcon btnIconReintentar = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/ReplayButton.png"));
                btnReintentar.setSize(133, 133);
                btnReintentar.setIcon(new ImageIcon(btnIconReintentar.getImage().getScaledInstance(btnReintentar.getWidth(), btnReintentar.getHeight(), Image.SCALE_SMOOTH)));
                btnReintentar.setBounds(jpContenido.getWidth()*2/4 - btnReintentar.getWidth()/2, jpContenido.getHeight()*3/4, btnReintentar.getWidth(), btnReintentar.getHeight());
                btnReintentar.setOpaque(false);
                btnReintentar.setContentAreaFilled(false);
                btnReintentar.setBorderPainted(false);
            }
            if(e.getSource() == btnTerminar){                
                ImageIcon btnIconTerminar = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/TurnOnOffButton.png"));
                btnTerminar.setSize(133, 133);
                btnTerminar.setIcon(new ImageIcon(btnIconTerminar.getImage().getScaledInstance(btnTerminar.getWidth(), btnTerminar.getHeight(), Image.SCALE_SMOOTH)));
                btnTerminar.setBounds(jpContenido.getWidth()*3/4 - btnTerminar.getWidth()/2, jpContenido.getHeight()*3/4, btnTerminar.getWidth(), btnTerminar.getHeight());
                btnTerminar.setOpaque(false);
                btnTerminar.setContentAreaFilled(false);
                btnTerminar.setBorderPainted(false);
            }
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
    }
}
