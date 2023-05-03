/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.univalle.miniproyecto2.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
/**
 *
 * @author Sebastián
 */
public class VistaOpciones extends JFrame{
    
    private JPanel jpContenido;
    private JButton btnAudio;
    private JButton btnJvsPC;
    private JButton btnJvsJ;
    private JButton btnNumRonda1;
    private JButton btnNumRonda2;
    private JButton btnNumRonda3;
    private JButton btnNumRonda4;

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
        
    }
}
