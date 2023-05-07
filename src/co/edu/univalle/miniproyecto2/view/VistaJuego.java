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
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 *
 * @author Julian Puyo
 */
public class VistaJuego extends JFrame {
    
//    private JLayeredPane lContenido;
    
    private JPanel jpContenido;
    private JPanel jpPausa;
    private CustomPaintedJPanel jpCuadricula;
    
    private JLabel lblNombre;
    private JLabel lblImagenDeFondo1;
    
    private JToggleButton btnContadorJ1;
    private JToggleButton btnContadorJ2;
    
    private JButton btnPosicion[][];
    private JButton btnPausa;
    private JButton btnPausaReplay;
    private JButton btnPausaContinuar;
    private JButton btnPausaAudio;
    
    private int numeroRondas;
    private int jugadorDeTurno;
    private int ganador;
    
    private String modoDeJuego;
    
    private Juego juego;
    private VistaEstadisticas vistaestadisticas;
    
//    private JInternalFrame pausa;
    
    private VistaEstadisticas vistaEstadisticas;
    
    
    
    public VistaJuego(int numeroRondas, String modoDeJuego) {
        setTitle("Game | Tic Tac Toe");
        setSize(544, 680);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        jugadorDeTurno = 1;
        ganador = 0;
        
        this.numeroRondas = numeroRondas;
        this.modoDeJuego = modoDeJuego;
        
        inicializarComponentes();
        setVisible(true);
    }

    private void inicializarComponentes() {
        
//        lContenido = new JLayeredPane();
//        lContenido.setBounds(0, 0, getWidth(), getHeight());
        
//        pausa = new JInternalFrame();
//        pausa.setTitle("Pause");
//        pausa.setSize(getWidth() - 100, getHeight() - 100);
//        pausa.setResizable(false);
//        pausa.setVisible(true);
        
        juego = new Juego(numeroRondas, modoDeJuego);
        
        jpContenido = new JPanel();
        jpContenido.setLayout(null);
        jpContenido.setSize(getWidth(),getHeight());
        
//        lContenido.add(jpContenido, 0, 0);

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
        
        btnContadorJ1 = new JToggleButton("");
        btnContadorJ1.setSize(60, 30);
        btnContadorJ1.setBounds(jpContenido.getWidth()*1/3 - btnContadorJ1.getWidth()/2,jpContenido.getHeight()*5/6,btnContadorJ1.getWidth(),btnContadorJ1.getHeight());
        
        btnContadorJ2 = new JToggleButton("");
        btnContadorJ2.setSize(60, 30);
        btnContadorJ2.setBounds(jpContenido.getWidth()*2/3 - btnContadorJ2.getWidth()/2,jpContenido.getHeight()*5/6,btnContadorJ2.getWidth(),btnContadorJ2.getHeight());
        
        ImageIcon btnIconPausa = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/PauseButton.png"));
        btnPausa = new JButton();
        btnPausa.setSize(40,40);
        btnPausa.setIcon(new ImageIcon(btnIconPausa.getImage().getScaledInstance(btnPausa.getWidth(), btnPausa.getHeight(), Image.SCALE_SMOOTH)));
        btnPausa.setBounds(jpContenido.getWidth()*5/6 - btnPausa.getWidth()/2,jpContenido.getHeight()*1/12 - btnPausa.getHeight()/2,btnPausa.getWidth(),btnPausa.getHeight());
        btnPausa.setOpaque(false);
        btnPausa.setContentAreaFilled(false);
        btnPausa.setBorderPainted(false);
        btnPausa.addActionListener(manejadoraDeEventos);
        
        ImageIcon btnIconReplay = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/PlayButton.png"));
        btnPausaReplay = new JButton();
        btnPausaReplay.setSize(100,100);
        btnPausaReplay.setIcon(new ImageIcon(btnIconReplay.getImage().getScaledInstance(btnPausaReplay.getWidth(), btnPausaReplay.getHeight(), Image.SCALE_SMOOTH)));
        btnPausaReplay.setBounds(jpContenido.getWidth()*2 - btnPausaReplay.getWidth()/2,jpContenido.getHeight()*2/4 - btnPausaReplay.getHeight()/2,btnPausaReplay.getWidth(),btnPausaReplay.getHeight());
        btnPausaReplay.setOpaque(false);
        btnPausaReplay.setContentAreaFilled(false);
        btnPausaReplay.setBorderPainted(false);
        btnPausaReplay.addActionListener(manejadoraDeEventos);
        
        ImageIcon btnIconPausaContinuar = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/ReplayButton.png"));
        btnPausaContinuar = new JButton();
        btnPausaContinuar.setSize(100,100);
        btnPausaContinuar.setIcon(new ImageIcon(btnIconPausaContinuar.getImage().getScaledInstance(btnPausaContinuar.getWidth(), btnPausaContinuar.getHeight(), Image.SCALE_SMOOTH)));
        btnPausaContinuar.setBounds(jpContenido.getWidth()*2- btnPausaContinuar.getWidth()/2,jpContenido.getHeight()*1/4 - btnPausaContinuar.getHeight()/2,btnPausaContinuar.getWidth(),btnPausaContinuar.getHeight());
        btnPausaContinuar.setOpaque(false);
        btnPausaContinuar.setContentAreaFilled(false);
        btnPausaContinuar.setBorderPainted(false);
        btnPausaContinuar.addActionListener(manejadoraDeEventos);
        
        ImageIcon btnIconAudio = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/AudioButton.png"));
        btnPausaAudio = new JButton();
        btnPausaAudio.setSize(100,100);
        btnPausaAudio.setIcon(new ImageIcon(btnIconAudio.getImage().getScaledInstance(btnPausaAudio.getWidth(), btnPausaAudio.getHeight(), Image.SCALE_SMOOTH)));
        btnPausaAudio.setBounds(jpContenido.getWidth()*2 - btnPausaAudio.getWidth()/2,jpContenido.getHeight()*3/4 - btnPausaAudio.getHeight()/2,btnPausaAudio.getWidth(),btnPausaAudio.getHeight());
        btnPausaAudio.setOpaque(false);
        btnPausaAudio.setContentAreaFilled(false);
        btnPausaAudio.setBorderPainted(false);
        btnPausaAudio.addActionListener(manejadoraDeEventos);
                
        
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
        
//        jpPausa = new JPanel();
//        jpPausa.setLayout(null);
//        jpPausa.setSize(pausa.getWidth(),pausa.getHeight());
//        jpPausa.setBounds(0, 0, pausa.getWidth(), pausa.getHeight());
//        
//        jpPausa.add(btnPausaReplay);
//        jpPausa.add(btnPausaContinuar);
//        jpPausa.add(btnPausaAudio);
        
//        pausa.add(jpPausa);
        
        jpContenido.add(btnContadorJ1);
        jpContenido.add(btnContadorJ2);
        jpContenido.add(btnPausa);
        jpContenido.add(jpCuadricula);
        jpContenido.add(lblImagenDeFondo1);
        
//        add(pausa);
        add(jpContenido);
//        add(lContenido);
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
                                JOptionPane.showMessageDialog(null, "¡¡GANASTE!! Jugador: " + ganador+".", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                        else if (modoDeJuego == "JvsPC" && (btnPosicion[i][j].getText().equals("0") || btnPosicion[i][j].getText().equals(""))){
                            System.out.println(":(");
                            boolean resultado = false;
                            ganador = 0;
                           
                            actualizarBotones(juego.marcarSeleccion(jugadorDeTurno, i, j));
                            jugadorDeTurno = 2;
                            
                            if(ganador == 0) {
                                ganador = juego.verificarGanador();
                            }
                            
                            resultado = resultadoJvsPC();
                            
                            if(!resultado) {
                                JOptionPane msg = new JOptionPane("Turno de la PC", JOptionPane.INFORMATION_MESSAGE);
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
                            dispose();
                            vistaestadisticas = new VistaEstadisticas(juego.getContGanadorJ1(),juego.getContGanadorJ2(), numeroRondas, modoDeJuego);
                        }  
                    }
                }
            }
            if(e.getSource() == btnPausa) {
//                lContenido.add(jpPausa, 1, 0);
                
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
