/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.univalle.miniproyecto2.view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author julia
 */
public class VistaJuego extends JFrame {
    
    private JPanel jpContenido;
    private JPanel jpCuadricula;
    
    private JLabel lblNombre;
    private JLabel lblContadorJ1;
    private JLabel lblContadorJ2;
    
    private JButton btnPosicion[][];
    private JButton btnPausa;
    
    private int contadorJ1;
    private int contadorJ2;
    
    public VistaJuego() {
        setTitle("Game | Tic Tac Toe");
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
        
        jpCuadricula = new JPanel();
        jpCuadricula.setLayout(new GridLayout(3,3));
        jpCuadricula.setSize(270,340);
        jpCuadricula.setBounds((jpContenido.getWidth()/2)-(jpCuadricula.getWidth()/2),(jpContenido.getHeight()/2)-(jpCuadricula.getHeight()/2),jpCuadricula.getWidth(),jpCuadricula.getHeight());
                     
        lblNombre = new JLabel("");
        lblContadorJ1 = new JLabel(""+contadorJ1);
        lblContadorJ2 = new JLabel(""+contadorJ2);
        
        btnPosicion = new JButton[3][3];
        
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                btnPosicion[i][j] = new JButton("x");
                jpCuadricula.add(btnPosicion[i][j]);
            }
        }
        
        jpContenido.add(jpCuadricula);
        
        btnPausa = new JButton("Pausa");
    }
    
}
