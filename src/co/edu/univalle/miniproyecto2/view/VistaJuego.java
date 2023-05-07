/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.univalle.miniproyecto2.view;

import co.edu.univalle.miniproyecto2.logic.Juego;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 *
 * @author Julian Puyo
 */
public class VistaJuego extends JFrame {
    
    private JPanel jpContenido;
    private CustomPaintedJPanel jpCuadricula;
    
    private JLabel lblNombre;
    private JToggleButton btnContadorJ1;
    private JToggleButton btnContadorJ2;
    
    private JButton btnPosicion[][];
    private JButton btnPausa;
    
    private int contadorJ1;
    private int contadorJ2;
 
    private JLabel lblImagenDeFondo1;
    
    int numeroRondas;
    private String modoDeJuego;
    
    private Juego juego;
    
    private int jugadorDeTurno;
    
    private int ganador;
    
    public VistaJuego(int numeroRondas, String modoDeJuego) {
        setTitle("Game | Tic Tac Toe");
        setSize(544, 680);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        jugadorDeTurno = 1;
        ganador = 0;
        
        this.numeroRondas = numeroRondas;
        this.modoDeJuego = modoDeJuego;
        
        inicializarComponentes();
        setVisible(true);
    }

    private void inicializarComponentes() {
        
        juego = new Juego(numeroRondas, modoDeJuego);
        
        jpContenido = new JPanel();
        jpContenido.setLayout(null);
        jpContenido.setSize(getWidth(),getHeight());

        ActionEventHandler manejadoraDeEventos = new ActionEventHandler(juego);
        
        ImageIcon imagenDeFondo1 = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/wood1_45.png"));
        lblImagenDeFondo1 = new JLabel();
        lblImagenDeFondo1.setSize(jpContenido.getWidth(), jpContenido.getHeight());
        lblImagenDeFondo1.setBounds(0, 0, jpContenido.getWidth(), jpContenido.getHeight());
        lblImagenDeFondo1.setIcon(new ImageIcon(imagenDeFondo1.getImage().getScaledInstance(lblImagenDeFondo1.getWidth(), lblImagenDeFondo1.getHeight(), Image.SCALE_SMOOTH)));
                      
        jpCuadricula = new CustomPaintedJPanel("/co/edu/univalle/miniproyecto2/images/wood2_11.png");
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
        
        ImageIcon btnIconPausa = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/PauseButton.png"));
        btnPausa = new JButton();
        btnPausa.setSize(40,40);
        btnPausa.setIcon(new ImageIcon(btnIconPausa.getImage().getScaledInstance(btnPausa.getWidth(), btnPausa.getHeight(), Image.SCALE_SMOOTH)));
        btnPausa.setBounds(jpContenido.getWidth()*5/6 - btnPausa.getWidth()/2,jpContenido.getHeight()*1/12 - btnPausa.getHeight()/2,btnPausa.getWidth(),btnPausa.getHeight());
        btnPausa.setOpaque(false);
        btnPausa.setContentAreaFilled(false);
        btnPausa.setBorderPainted(false);
        btnPausa.addActionListener(manejadoraDeEventos);
                
        
        btnPosicion = new JButton[3][3];
        
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                btnPosicion[i][j] = new JButton("");
                btnPosicion[i][j].setOpaque(false);
                btnPosicion[i][j].setContentAreaFilled(false);
                btnPosicion[i][j].setBorderPainted(true);
                
                btnPosicion[i][j].addActionListener(manejadoraDeEventos);
                
                jpCuadricula.add(btnPosicion[i][j]);
            }
        }
        
        jpContenido.add(btnContadorJ1);
        jpContenido.add(btnContadorJ2);
        jpContenido.add(btnPausa);
        jpContenido.add(jpCuadricula);
        jpContenido.add(lblImagenDeFondo1);
        
        add(jpContenido);
    }
    
    public class ActionEventHandler implements ActionListener {
        
        private Juego juego;
        
        public ActionEventHandler(Juego juego) {
            this.juego = juego;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    if(e.getSource() == btnPosicion[i][j]) {
                        if (modoDeJuego == "JvsJ"){
                            actualizarBotones(juego.marcarSeleccion(jugadorDeTurno, i, j));
                            if(juego.isCambioRealizado()) {
                                if(jugadorDeTurno == 1) {
                                    jugadorDeTurno = 2;
                                }
                                else if(jugadorDeTurno == 2) {
                                    jugadorDeTurno =1;
                                }
                            }
                            ganador = juego.verificarGanador();
                            if(ganador == 1 || ganador == 2) {
                                JOptionPane.showMessageDialog(null, "¡¡GANASTE!! Jugador: " + jugadorDeTurno+".", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                        else if (modoDeJuego == "JvsPC"){
                            boolean resultado = false;
                            ganador = 0;
                            
                            actualizarBotones(juego.marcarSeleccion(jugadorDeTurno, i, j));
                            jugadorDeTurno = 2;
                            
                            if(ganador == 0) {
                                ganador = juego.verificarGanador();
                            }
                            
                            resultado = resultadoJvsPC();
                            
                            if(!resultado) {
                                JOptionPane msg = new JOptionPane("Turno de la PC", JOptionPane.WARNING_MESSAGE);
                                final JDialog dlg = msg.createDialog("Procesando");
                                dlg.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                                new Thread(new Runnable() {
                                  @Override
                                  public void run() {
                                    try {
                                      Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                      e.printStackTrace();
                                    }
                                    dlg.setVisible(false);
                                  }
                                }).start();
                                dlg.setVisible(true);
                            }
                            
                            actualizarBotones(juego.respuestaAleatoria(jugadorDeTurno));
                            jugadorDeTurno =1;
                            
                            if(ganador == 0) {
                                ganador = juego.verificarGanador();
                            }
                            
                            if(!resultado) {
                                resultadoJvsPC();
                            }
                        }
                        actualizarBotones(juego.verificarRonda(ganador));
                        btnContadorJ1.setText("" + juego.getContGanadorJ1());
                        btnContadorJ2.setText("" + juego.getContGanadorJ2());
                        
                        if(juego.juegoTerminado()){
                            JOptionPane.showMessageDialog(null, "Juego Terminado.", "THE END", JOptionPane.INFORMATION_MESSAGE);
                        }  
                    }
                }
            }
        }

        private void actualizarBotones(int[][] respPosicion) {
            for(int i=0;i<3;i++) {
                for(int j=0;j<3;j++) {
                    btnPosicion[i][j].setText(""+respPosicion[i][j]);
                }
            }
        }
        
        private boolean resultadoJvsPC() {
            if(ganador == 1) {
                JOptionPane.showMessageDialog(null, "¡¡GANASTE!!", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
            else if(ganador == 2) {
                JOptionPane.showMessageDialog(null, "Ganó la computadora.", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
            else if(juego.matrizLlena()) {
                JOptionPane.showMessageDialog(null, "Nadie Ganó.", "¿Empate?", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
            return false;
        }
        
    }    
}
