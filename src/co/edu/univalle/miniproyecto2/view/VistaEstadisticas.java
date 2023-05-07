/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.univalle.miniproyecto2.view;

import co.edu.univalle.miniproyecto2.logic.Juego;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
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
    
    private JLabel lblImagenDeFondo1;
    
    public VistaEstadisticas(int contadorJ1, int contadorJ2) {
        this.contadorJ1 = contadorJ1;
        this.contadorJ2 = contadorJ2;
        
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
        lblContadorJ1.setSize(jpContenido.getWidth(), 40);
        lblContadorJ1.setBounds(jpContenido.getWidth()/2 - lblContadorJ1.getWidth()/2, jpContenido.getHeight()*1/4, lblContadorJ1.getWidth(), lblContadorJ1.getHeight());
        
        lblContadorJ2 = new JLabel("Jugador 2: " + contadorJ2,CENTER);
        lblContadorJ2.setSize(jpContenido.getWidth(), 40);
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
    }
    
}
