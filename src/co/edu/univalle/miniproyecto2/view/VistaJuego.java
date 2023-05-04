/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.univalle.miniproyecto2.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 *
 * @author Julian Puyo
 */
public class VistaJuego extends JFrame {
    
    private JPanel jpContenido;
    private JPanel jpCuadricula;
    
    private JLabel lblNombre;
    private JToggleButton btnContadorJ1;
    private JToggleButton btnContadorJ2;
    
    private JButton btnPosicion[][];
    private JButton btnPausa;
    
    private int contadorJ1;
    private int contadorJ2;
 
    private JLabel lblImagenDeFondo1;
    
    public VistaJuego() {
        setTitle("Game | Tic Tac Toe");
        setSize(544, 680);
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

        
        ImageIcon imagenDeFondo1 = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/wood1_45.png"));
        lblImagenDeFondo1 = new JLabel();
        lblImagenDeFondo1.setSize(jpContenido.getWidth(), jpContenido.getHeight());
        lblImagenDeFondo1.setBounds(0, 0, jpContenido.getWidth(), jpContenido.getHeight());
        lblImagenDeFondo1.setIcon(new ImageIcon(imagenDeFondo1.getImage().getScaledInstance(lblImagenDeFondo1.getWidth(), lblImagenDeFondo1.getHeight(), Image.SCALE_SMOOTH)));
                      
        jpCuadricula = new JPanel();
        jpCuadricula.setLayout(new GridLayout(3,3));
        jpCuadricula.setSize(300,300);
        jpCuadricula.setBounds((jpContenido.getWidth()/2)-(jpCuadricula.getWidth()/2),(jpContenido.getHeight()/2)-(jpCuadricula.getHeight()/2),jpCuadricula.getWidth(),jpCuadricula.getHeight());
                     
        lblNombre = new JLabel("");
        
        btnContadorJ1 = new JToggleButton(""+contadorJ1);
        btnContadorJ1.setSize(60, 30);
        btnContadorJ1.setBounds(jpContenido.getWidth()*1/3 - btnContadorJ1.getWidth()/2,jpContenido.getHeight()*5/6,btnContadorJ1.getWidth(),btnContadorJ1.getHeight());
//        btnContadorJ1.setBackground(Color.GRAY);
        
        btnContadorJ2 = new JToggleButton(""+contadorJ2);
        btnContadorJ2.setSize(60, 30);
        btnContadorJ2.setBounds(jpContenido.getWidth()*2/3 - btnContadorJ2.getWidth()/2,jpContenido.getHeight()*5/6,btnContadorJ2.getWidth(),btnContadorJ2.getHeight());
//        btnContadorJ2.setBackground(Color.GREEN);
        
        btnPausa = new JButton("Pause");
        btnPausa.setSize(68,24);
//        btnPausa.setContentAreaFilled(false);
        btnPausa.setFont(new Font("Arial", Font.BOLD, 9));
        btnPausa.setBounds(jpContenido.getWidth()*5/6 - btnPausa.getWidth()/2,jpContenido.getHeight()*1/12 - btnPausa.getHeight()/2,btnPausa.getWidth(),btnPausa.getHeight());
        
        
        btnPosicion = new JButton[3][3];
        
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                btnPosicion[i][j] = new JButton("x");
                jpCuadricula.add(btnPosicion[i][j]);
            }
        }
        
        
        jpContenido.add(jpCuadricula);
        jpContenido.add(btnContadorJ1);
        jpContenido.add(btnContadorJ2);
        jpContenido.add(btnPausa);
        jpContenido.add(lblImagenDeFondo1);
            
        add(jpContenido);
             
    }
    
}
