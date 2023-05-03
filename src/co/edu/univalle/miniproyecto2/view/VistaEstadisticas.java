/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.univalle.miniproyecto2.view;

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
    
    public VistaEstadisticas() {
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
        
        
        lblNombre = new JLabel("RESUMEN DEL JUEGO",CENTER);
        lblNombre.setSize(jpContenido.getWidth(), 30);
        lblNombre.setBounds(jpContenido.getWidth()/2 - lblNombre.getWidth()/2, jpContenido.getHeight()*1/8, lblNombre.getWidth(), lblNombre.getHeight());
        
        
        lblContadorJ1 = new JLabel(""+contadorJ1,CENTER);
        lblContadorJ1.setSize(jpContenido.getWidth(), 30);
        lblContadorJ1.setBounds(jpContenido.getWidth()/2 - lblContadorJ1.getWidth()/2, jpContenido.getHeight()*1/4, lblContadorJ1.getWidth(), lblContadorJ1.getHeight());
        
        lblContadorJ2 = new JLabel(""+contadorJ1,CENTER);
        lblContadorJ2.setSize(jpContenido.getWidth(), 30);
        lblContadorJ2.setBounds(jpContenido.getWidth()/2 - lblContadorJ2.getWidth()/2, jpContenido.getHeight()*2/4, lblContadorJ2.getWidth(), lblContadorJ2.getHeight());
        
        btnInicio = new JButton("Inicio");
        btnInicio.setSize(100, 30);
        btnInicio.setBounds(jpContenido.getWidth()*1/4 - btnInicio.getWidth()/2, jpContenido.getHeight()*3/4, btnInicio.getWidth(), btnInicio.getHeight());
        
        btnReintentar = new JButton("Reintentar");
        btnReintentar.setSize(100, 30);
        btnReintentar.setBounds(jpContenido.getWidth()*2/4 - btnReintentar.getWidth()/2, jpContenido.getHeight()*3/4, btnReintentar.getWidth(), btnReintentar.getHeight());
        
        btnTerminar = new JButton("Terminar");
        btnTerminar.setSize(100, 30);
        btnTerminar.setBounds(jpContenido.getWidth()*3/4 - btnTerminar.getWidth()/2, jpContenido.getHeight()*3/4, btnTerminar.getWidth(), btnTerminar.getHeight());
        
        jpContenido.add(lblNombre);
        jpContenido.add(lblContadorJ1);
        jpContenido.add(lblContadorJ2);
        jpContenido.add(btnInicio);
        jpContenido.add(btnReintentar);
        jpContenido.add(btnTerminar);
        
        add(jpContenido);
    }
    
}