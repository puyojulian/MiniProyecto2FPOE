/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.univalle.miniproyecto2.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
/**
 *
 * @author Sebastián
 */
public class VistaInicio extends JFrame{
    
    private JPanel jpContenido;
    private JLabel lblTitulo;
    private JButton btnJugar;
    private JButton btnAudio;

    public VistaInicio() {
        setTitle("Menu | Tic Tac Toe");
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
    }
    
}
