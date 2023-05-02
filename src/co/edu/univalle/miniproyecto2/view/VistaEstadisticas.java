/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.univalle.miniproyecto2.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
    
    public VistaEstadisticas() {
        setTitle("Game | Tic Tac Toe");
        setSize(540, 680);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
        inicializarComponentes();
        setVisible(true);
    }

    private void inicializarComponentes() {
        jpContenido = new JPanel();
        
        lblNombre = new JLabel();
        lblContadorJ1 = new JLabel();
        lblContadorJ2 = new JLabel();
        
        btnInicio = new JButton();
        btnReintentar = new JButton();
        btnTerminar = new JButton();
    }
    
}
