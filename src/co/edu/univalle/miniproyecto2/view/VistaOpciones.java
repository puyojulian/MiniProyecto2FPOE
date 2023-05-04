/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.univalle.miniproyecto2.view;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
/**
 *
 * @author Sebastián
 */
public class VistaOpciones extends JFrame{
    
    private JPanel jpContenido;
    private JPanel jpBotones;
    
    private JButton btnAudio;
    private JButton btnJvsPC;
    private JButton btnJvsJ;
    private JButton btnNumRonda1;
    private JButton btnNumRonda2;
    private JButton btnNumRonda3;
    private JButton btnNumRonda4;
    
    JPanelImage imagenDeFondo1;

    public VistaOpciones() {
        setTitle("Options | Tic Tac Toe");
        setSize(540, 680);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        inicializarComponentes();
        setVisible(true);
    }
    
    private void inicializarComponentes() {
        jpContenido = new JPanel();
        jpContenido.setLayout(null);
        jpContenido.setSize(getWidth(),getHeight());
        
        imagenDeFondo1 = new JPanelImage("/co/edu/univalle/miniproyecto2/images/wood1_45.png");
        imagenDeFondo1.setSize(jpContenido.getWidth(), jpContenido.getHeight());
        imagenDeFondo1.setBounds(0, 0, jpContenido.getWidth(), jpContenido.getHeight());
        
        add(jpContenido);
        
        
        btnAudio = new JButton("Audio");
        btnAudio.setFont(new java.awt.Font("Arial", 0, 25));
        btnAudio.setBounds(225,25, 75,30);
//        btnAudio.setBackground(new java.awt.Color(178, 221, 185));
        btnAudio.setForeground(new java.awt.Color(0, 0, 0));
        btnAudio.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        
        btnNumRonda1 = new JButton("1");
        btnNumRonda1.setFont(new java.awt.Font("Arial", 0, 35));
        
        btnNumRonda2 = new JButton("2");
        btnNumRonda2.setFont(new java.awt.Font("Arial", 0, 35));
        
        btnNumRonda3 = new JButton("3");
        btnNumRonda3.setFont(new java.awt.Font("Arial", 0, 35));
        
        btnNumRonda4 = new JButton("4");
        btnNumRonda4.setFont(new java.awt.Font("Arial", 0, 35));
        
        btnJvsPC = new JButton("J vs PC");
        btnJvsPC.setFont(new java.awt.Font("Arial", 0, 20));
        btnJvsPC.setBounds(150,300, 115,35);
//        btnJvsPC.setBackground(new java.awt.Color(178, 221, 185));

        btnJvsJ = new JButton("J vs J");
        btnJvsJ.setFont(new java.awt.Font("Arial", 0, 20));
        btnJvsJ.setBounds(270,300, 115,35);
//        btnJvsJ.setBackground(new java.awt.Color(178, 221, 185));
        
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
        jpContenido.add(imagenDeFondo1);
        jpBotones.setBackground(Color.DARK_GRAY);
    }
    
}
