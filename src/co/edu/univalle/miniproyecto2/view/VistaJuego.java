/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.univalle.miniproyecto2.view;

import co.edu.univalle.miniproyecto2.logic.Juego;
import co.edu.univalle.miniproyecto2.sounds.Music;
import java.applet.AudioClip;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    private JPanel jpContenido;
    private CustomPaintedJPanel jpPausa;
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
    
    private Music musica;
    
    private boolean estadoMusica;
    
    private Juego juego;
    
    private JInternalFrame pausa;
    
    private VistaEstadisticas vistaEstadisticas;
    
    public VistaJuego(int numeroRondas, String modoDeJuego, Music musica) throws AWTException {
        setTitle("Game | Tic Tac Toe");
        setSize(544, 680);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        jugadorDeTurno = 1;
        ganador = 0;
        
        this.numeroRondas = numeroRondas;
        this.modoDeJuego = modoDeJuego;
        
        this.musica = musica;
        estadoMusica = musica.isState();
        
        inicializarComponentes();
        setVisible(true);
    }

    private void inicializarComponentes() throws AWTException {        
        pausa = new JInternalFrame();
        pausa.setTitle("Pause");
        pausa.setSize(getWidth()*5/8, getHeight()*7/10); // 
        pausa.setResizable(false);
        pausa.setVisible(true);
        pausa.setBounds(getWidth()/2 - pausa.getWidth()/2, getHeight()/2 - pausa.getHeight()/2, pausa.getWidth(), pausa.getHeight());
        
        juego = new Juego(numeroRondas, modoDeJuego);
        
        jpContenido = new JPanel();
        jpContenido.setLayout(null);
        jpContenido.setSize(getWidth(),getHeight());

//        Robot robot = new Robot();
        
        ActionEventHandler manejadoraDeEventos = new ActionEventHandler(juego);
        
        MouseEventHandler manejadoraDeEventosMouse = new MouseEventHandler();
        
        KeyEventHandler manejadoraDeEventosKey = new KeyEventHandler(juego);
        
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(manejadoraDeEventosKey);
        
        ImageIcon imagenDeFondo1 = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/wood1_45.png"));
        lblImagenDeFondo1 = new JLabel();
        lblImagenDeFondo1.setSize(jpContenido.getWidth(), jpContenido.getHeight());
        lblImagenDeFondo1.setBounds(0, 0, jpContenido.getWidth(), jpContenido.getHeight());
        lblImagenDeFondo1.setIcon(new ImageIcon(imagenDeFondo1.getImage().getScaledInstance(lblImagenDeFondo1.getWidth(), lblImagenDeFondo1.getHeight(), Image.SCALE_SMOOTH)));
                      
        jpCuadricula = new CustomPaintedJPanel("/co/edu/univalle/miniproyecto2/images/FondoCuadricula.png");
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
        btnPausa.setBounds(getWidth()*5/6 - btnPausa.getWidth()/2,getHeight()*1/12 - btnPausa.getHeight()/2,btnPausa.getWidth(),btnPausa.getHeight());        
        btnPausa.setOpaque(false);
        btnPausa.setContentAreaFilled(false);
        btnPausa.setBorderPainted(false);
        btnPausa.addActionListener(manejadoraDeEventos);
        btnPausa.addMouseListener(manejadoraDeEventosMouse);
        btnPausa.addMouseMotionListener(manejadoraDeEventosMouse);
        
        ImageIcon btnIconReplay = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/ReplayButton.png"));
        btnPausaReplay = new JButton();
        btnPausaReplay.setSize(80,80);
        btnPausaReplay.setIcon(new ImageIcon(btnIconReplay.getImage().getScaledInstance(btnPausaReplay.getWidth(), btnPausaReplay.getHeight(), Image.SCALE_SMOOTH)));
        btnPausaReplay.setBounds(pausa.getWidth()/2 - btnPausaReplay.getWidth()/2,pausa.getHeight()*2/4 - btnPausaReplay.getHeight()/2,btnPausaReplay.getWidth(),btnPausaReplay.getHeight());
        btnPausaReplay.setOpaque(false);
        btnPausaReplay.setContentAreaFilled(false);
        btnPausaReplay.setBorderPainted(false);
        btnPausaReplay.addActionListener(manejadoraDeEventos);
        btnPausaReplay.addMouseListener(manejadoraDeEventosMouse);
        
        ImageIcon btnIconPausaContinuar = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/PlayButton.png"));
        btnPausaContinuar = new JButton();
        btnPausaContinuar.setSize(80,80);
        btnPausaContinuar.setIcon(new ImageIcon(btnIconPausaContinuar.getImage().getScaledInstance(btnPausaContinuar.getWidth(), btnPausaContinuar.getHeight(), Image.SCALE_SMOOTH)));
        btnPausaContinuar.setBounds(pausa.getWidth()/2- btnPausaContinuar.getWidth()/2,pausa.getHeight()*1/4 - btnPausaContinuar.getHeight()/2,btnPausaContinuar.getWidth(),btnPausaContinuar.getHeight());
        btnPausaContinuar.setOpaque(false);
        btnPausaContinuar.setContentAreaFilled(false);
        btnPausaContinuar.setBorderPainted(false);
        btnPausaContinuar.addActionListener(manejadoraDeEventos);
        btnPausaContinuar.addMouseListener(manejadoraDeEventosMouse);
        
        btnPausaAudio = new JButton();
        btnPausaAudio.setSize(80,80);
        ImageIcon btnIconAudio = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/AudioButton.png"));
        ImageIcon btnIconMute = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/MuteButton.png"));
        if(estadoMusica) {
            btnPausaAudio.setIcon(new ImageIcon(btnIconAudio.getImage().getScaledInstance(btnPausaAudio.getWidth(), btnPausaAudio.getHeight(), Image.SCALE_SMOOTH)));

        }
        else {
            btnPausaAudio.setIcon(new ImageIcon(btnIconMute.getImage().getScaledInstance(btnPausaAudio.getWidth(), btnPausaAudio.getHeight(), Image.SCALE_SMOOTH)));
        }
        btnPausaAudio.setBounds(pausa.getWidth()/2 - btnPausaAudio.getWidth()/2,pausa.getHeight()*3/4 - btnPausaAudio.getHeight()/2,btnPausaAudio.getWidth(),btnPausaAudio.getHeight());
        btnPausaAudio.setOpaque(false);
        btnPausaAudio.setContentAreaFilled(false);
        btnPausaAudio.setBorderPainted(false);
        btnPausaAudio.addActionListener(manejadoraDeEventos);
        btnPausaAudio.addMouseListener(manejadoraDeEventosMouse);
                
        btnPosicion = new JButton[3][3];
        
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                btnPosicion[i][j] = new JButton("");
                btnPosicion[i][j].setOpaque(false);
                btnPosicion[i][j].setContentAreaFilled(false);
                btnPosicion[i][j].setBorderPainted(false);
                
                btnPosicion[i][j].addActionListener(manejadoraDeEventos);
                
                jpCuadricula.add(btnPosicion[i][j]);
            }
        }
        
        jpPausa = new CustomPaintedJPanel("/co/edu/univalle/miniproyecto2/images/wood2_45.png");
        jpPausa.setLayout(null);
        jpPausa.setSize(pausa.getWidth(),pausa.getHeight());
        jpPausa.setBounds(0, 0, pausa.getWidth(), pausa.getHeight());


        jpPausa.add(btnPausaReplay);
        jpPausa.add(btnPausaContinuar);
        jpPausa.add(btnPausaAudio);
        
        pausa.add(jpPausa);
        
        add(pausa);
        
        jpContenido.add(btnContadorJ1);
        jpContenido.add(btnContadorJ2);
        jpContenido.add(btnPausa);
        jpContenido.add(jpCuadricula);
        jpContenido.add(lblImagenDeFondo1);
        
        add(jpContenido);
        
        pausa.dispose();
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
                                JOptionPane.showMessageDialog(null, "¡¡GANASTE!! Jugador: " + ganador + ".", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                            }
                            else if(juego.matrizLlena()) {
                                JOptionPane.showMessageDialog(null, "Nadie Ganó.", "¿Empate?", JOptionPane.INFORMATION_MESSAGE);
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
                            vistaEstadisticas = new VistaEstadisticas(juego.getContGanadorJ1(),juego.getContGanadorJ2(), numeroRondas, modoDeJuego, musica);
                        }  
                    }
                }
            }
            if(e.getSource() == btnPausa) {
                
                pausa.setBounds(getWidth()/2 - pausa.getWidth()/2, getHeight()/2 - pausa.getHeight()/2, pausa.getWidth(), pausa.getHeight());

                pausa.show();
                
                for(int i = 0; i < jpContenido.getComponents().length; i++) {
                    jpContenido.getComponents()[i].setEnabled(false);
                }
                jpContenido.setEnabled(false);
                for(int i = 0; i < jpCuadricula.getComponents().length; i++) {
                    jpCuadricula.getComponents()[i].setEnabled(false);
                }
                jpCuadricula.setEnabled(false);
            }
            else if(e.getSource() == btnPausaContinuar) {
                pausa.dispose();
                
                for(int i = 0; i < jpContenido.getComponents().length; i++) {
                    jpContenido.getComponents()[i].setEnabled(true);
                }
                jpContenido.setEnabled(true);
                for(int i = 0; i < jpCuadricula.getComponents().length; i++) {
                    jpCuadricula.getComponents()[i].setEnabled(true);
                }
                jpCuadricula.setEnabled(true);
            }
            if(e.getSource() == btnPausaReplay){
                dispose();
                try {
                    VistaJuego vistaJuego = new VistaJuego(numeroRondas, modoDeJuego, musica);
                } catch (AWTException ex) {
                    Logger.getLogger(VistaEstadisticas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        private void actualizarBotones(int[][] respPosicion) {
            for(int i=0;i<3;i++) {
                for(int j=0;j<3;j++) {
//                    btnPosicion[i][j].setText(""+respPosicion[i][j]);
                    if(respPosicion[i][j] == 1) {
                        ImageIcon btnImageCross = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/BlackCross.png"));
                        btnPosicion[i][j].setIcon(new ImageIcon(btnImageCross.getImage().getScaledInstance(btnPosicion[i][j].getWidth() - 20, btnPosicion[i][j].getHeight() -20, Image.SCALE_SMOOTH)));
                    }
                    else if(respPosicion[i][j] == 2) {
                        ImageIcon btnImageCircle = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/RedCircle.png"));
                        btnPosicion[i][j].setIcon(new ImageIcon(btnImageCircle.getImage().getScaledInstance(btnPosicion[i][j].getWidth() - 20, btnPosicion[i][j].getHeight() - 20, Image.SCALE_SMOOTH)));
                    }
                    else if(respPosicion[i][j] == 0) {
                        ImageIcon btnImageEmpty = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/EmptyImage.png"));
                        btnPosicion[i][j].setIcon(new ImageIcon(btnImageEmpty.getImage().getScaledInstance(btnPosicion[i][j].getWidth() - 20, btnPosicion[i][j].getHeight() - 20, Image.SCALE_SMOOTH)));
                    }
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

    public class MouseEventHandler implements MouseListener, MouseMotionListener {

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if(e.getSource() == btnPausa) {
                ImageIcon btnIconNoShadowPausa = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/PauseButtonNoShadow.png"));
                btnPausa.setSize(50,50);
                btnPausa.setIcon(new ImageIcon(btnIconNoShadowPausa.getImage().getScaledInstance(btnPausa.getWidth(), btnPausa.getHeight(), Image.SCALE_SMOOTH)));
                btnPausa.setBounds(getWidth()*5/6 - btnPausa.getWidth()/2,getHeight()*1/12 - btnPausa.getHeight()/2,btnPausa.getWidth(),btnPausa.getHeight());
                
            }
            else if(e.getSource() == btnPausaContinuar) {
                ImageIcon btnIconNoShadowPausa = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/PlayButtonNoShadow.png"));
                btnPausaContinuar.setSize(90,90);
                btnPausaContinuar.setIcon(new ImageIcon(btnIconNoShadowPausa.getImage().getScaledInstance(btnPausaContinuar.getWidth(), btnPausaContinuar.getHeight(), Image.SCALE_SMOOTH)));
                btnPausaContinuar.setBounds(pausa.getWidth()/2 - btnPausaContinuar.getWidth()/2, pausa.getHeight()*1/4 - btnPausaContinuar.getHeight()/2,btnPausaContinuar.getWidth(),btnPausaContinuar.getHeight());
            }
            else if(e.getSource() == btnPausaReplay) {
                ImageIcon btnIconLightPausa = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/ReplayButtonNoShadow.png"));
                btnPausaReplay.setSize(90,90);
                btnPausaReplay.setIcon(new ImageIcon(btnIconLightPausa.getImage().getScaledInstance(btnPausaReplay.getWidth(), btnPausaReplay.getHeight(), Image.SCALE_SMOOTH)));
                btnPausaReplay.setBounds(pausa.getWidth()/2 - btnPausaReplay.getWidth()/2,pausa.getHeight()*2/4 - btnPausaReplay.getHeight()/2,btnPausaReplay.getWidth(),btnPausaReplay.getHeight());
            }

            else if ((e.getSource() == btnPausaAudio) && (estadoMusica == true)){
                ImageIcon btnIconLightPausa = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/AudioButtonNoShadow.png"));
                btnPausaAudio.setSize(90,90);
                btnPausaAudio.setIcon(new ImageIcon(btnIconLightPausa.getImage().getScaledInstance(btnPausaAudio.getWidth(), btnPausaAudio.getHeight(), Image.SCALE_SMOOTH)));
                btnPausaAudio.setBounds(pausa.getWidth()/2 - btnPausaAudio.getWidth()/2,pausa.getHeight()*3/4 - btnPausaAudio.getHeight()/2,btnPausaAudio.getWidth(),btnPausaAudio.getHeight());
            } 
            else if ((e.getSource() == btnPausaAudio) && (estadoMusica == false)){
                ImageIcon btnIconLightPausa = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/MuteButtonNoShadow.png"));
                btnPausaAudio.setSize(90,90);
                btnPausaAudio.setIcon(new ImageIcon(btnIconLightPausa.getImage().getScaledInstance(btnPausaAudio.getWidth(), btnPausaAudio.getHeight(), Image.SCALE_SMOOTH)));
                btnPausaAudio.setBounds(pausa.getWidth()/2 - btnPausaAudio.getWidth()/2,pausa.getHeight()*3/4 - btnPausaAudio.getHeight()/2,btnPausaAudio.getWidth(),btnPausaAudio.getHeight());
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if(e.getSource() == btnPausa) {
                ImageIcon btnIconLightPausa = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/PauseButtonLight.png"));
                btnPausa.setSize(60,60);
                btnPausa.setIcon(new ImageIcon(btnIconLightPausa.getImage().getScaledInstance(btnPausa.getWidth(), btnPausa.getHeight(), Image.SCALE_SMOOTH)));
                btnPausa.setBounds(getWidth()*5/6 - btnPausa.getWidth()/2,getHeight()*1/12 - btnPausa.getHeight()/2,btnPausa.getWidth(),btnPausa.getHeight());
            }
            else if(e.getSource() == btnPausaContinuar) {
                ImageIcon btnIconNoShadowPausa = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/PlayButtonLight.png"));
                btnPausaContinuar.setSize(100,100);
                btnPausaContinuar.setIcon(new ImageIcon(btnIconNoShadowPausa.getImage().getScaledInstance(btnPausaContinuar.getWidth(), btnPausaContinuar.getHeight(), Image.SCALE_SMOOTH)));
                btnPausaContinuar.setBounds(pausa.getWidth()/2 - btnPausaContinuar.getWidth()/2,pausa.getHeight()*1/4 - btnPausaContinuar.getHeight()/2,btnPausaContinuar.getWidth(),btnPausaReplay.getHeight());
            }
            else if(e.getSource() == btnPausaReplay) {
                ImageIcon btnIconLightPausa = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/ReplayButtonLight.png"));
                btnPausaReplay.setSize(100,100);
                btnPausaReplay.setIcon(new ImageIcon(btnIconLightPausa.getImage().getScaledInstance(btnPausaReplay.getWidth(), btnPausaReplay.getHeight(), Image.SCALE_SMOOTH)));
                btnPausaReplay.setBounds(pausa.getWidth()/2 - btnPausaReplay.getWidth()/2,pausa.getHeight()*2/4 - btnPausaReplay.getHeight()/2,btnPausaReplay.getWidth(),btnPausaReplay.getHeight());
            }
            else if ((e.getSource() == btnPausaAudio) && (estadoMusica == true)){
                estadoMusica = !estadoMusica;
                musica.playStop(estadoMusica);
                ImageIcon btnIconLightPausa = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/MuteButtonLight.png"));
                btnPausaAudio.setSize(100,100);
                btnPausaAudio.setIcon(new ImageIcon(btnIconLightPausa.getImage().getScaledInstance(btnPausaAudio.getWidth(), btnPausaAudio.getHeight(), Image.SCALE_SMOOTH)));
                btnPausaAudio.setBounds(pausa.getWidth()/2 - btnPausaAudio.getWidth()/2,pausa.getHeight()*3/4 - btnPausaAudio.getHeight()/2,btnPausaAudio.getWidth(),btnPausaAudio.getHeight());
            } 
            else if ((e.getSource() == btnPausaAudio) && (estadoMusica == false)){
                estadoMusica = !estadoMusica;
                musica.playStop(estadoMusica);
                ImageIcon btnIconLightPausa = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/AudioButtonLight.png"));
                btnPausaAudio.setSize(100,100);
                btnPausaAudio.setIcon(new ImageIcon(btnIconLightPausa.getImage().getScaledInstance(btnPausaAudio.getWidth(), btnPausaAudio.getHeight(), Image.SCALE_SMOOTH)));
                btnPausaAudio.setBounds(pausa.getWidth()/2 - btnPausaAudio.getWidth()/2,pausa.getHeight()*3/4 - btnPausaAudio.getHeight()/2,btnPausaAudio.getWidth(),btnPausaAudio.getHeight());
            }
        }
        
        @Override
        public void mouseEntered(MouseEvent e) {
            if(e.getSource() == btnPausa) {
                ImageIcon btnIconLightPausa = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/PauseButtonLight.png"));
                btnPausa.setSize(60,60);
                btnPausa.setIcon(new ImageIcon(btnIconLightPausa.getImage().getScaledInstance(btnPausa.getWidth(), btnPausa.getHeight(), Image.SCALE_SMOOTH)));
                btnPausa.setBounds(getWidth()*5/6 - btnPausa.getWidth()/2,getHeight()*1/12 - btnPausa.getHeight()/2,btnPausa.getWidth(),btnPausa.getHeight());
            }
            else if(e.getSource() == btnPausaContinuar) {
                ImageIcon btnIconNoShadowPausa = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/PlayButtonLight.png"));
                btnPausaContinuar.setSize(100,100);
                btnPausaContinuar.setIcon(new ImageIcon(btnIconNoShadowPausa.getImage().getScaledInstance(btnPausaContinuar.getWidth(), btnPausaContinuar.getHeight(), Image.SCALE_SMOOTH)));
                btnPausaContinuar.setBounds(pausa.getWidth()/2 - btnPausaContinuar.getWidth()/2,pausa.getHeight()*1/4 - btnPausaContinuar.getHeight()/2,btnPausaContinuar.getWidth(),btnPausaReplay.getHeight());
            }
            else if(e.getSource() == btnPausaReplay) {
                ImageIcon btnIconLightPausa = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/ReplayButtonLight.png"));
                btnPausaReplay.setSize(100,100);
                btnPausaReplay.setIcon(new ImageIcon(btnIconLightPausa.getImage().getScaledInstance(btnPausaReplay.getWidth(), btnPausaReplay.getHeight(), Image.SCALE_SMOOTH)));
                btnPausaReplay.setBounds(pausa.getWidth()/2 - btnPausaReplay.getWidth()/2,pausa.getHeight()*2/4 - btnPausaReplay.getHeight()/2,btnPausaReplay.getWidth(),btnPausaReplay.getHeight());
            }

            else if ((e.getSource() == btnPausaAudio) && (estadoMusica == true)){
                ImageIcon btnIconLightPausa = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/AudioButtonLight.png"));
                btnPausaAudio.setSize(100,100);
                btnPausaAudio.setIcon(new ImageIcon(btnIconLightPausa.getImage().getScaledInstance(btnPausaAudio.getWidth(), btnPausaAudio.getHeight(), Image.SCALE_SMOOTH)));
                btnPausaAudio.setBounds(pausa.getWidth()/2 - btnPausaAudio.getWidth()/2,pausa.getHeight()*3/4 - btnPausaAudio.getHeight()/2,btnPausaAudio.getWidth(),btnPausaAudio.getHeight());
            } 
            else if ((e.getSource() == btnPausaAudio) && (estadoMusica == false)){
                ImageIcon btnIconLightPausa = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/MuteButtonLight.png"));
                btnPausaAudio.setSize(100,100);
                btnPausaAudio.setIcon(new ImageIcon(btnIconLightPausa.getImage().getScaledInstance(btnPausaAudio.getWidth(), btnPausaAudio.getHeight(), Image.SCALE_SMOOTH)));
                btnPausaAudio.setBounds(pausa.getWidth()/2 - btnPausaAudio.getWidth()/2,pausa.getHeight()*3/4 - btnPausaAudio.getHeight()/2,btnPausaAudio.getWidth(),btnPausaAudio.getHeight());
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(e.getSource() == btnPausa) {
                ImageIcon btnIconSalidoPausa = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/PauseButton.png"));
                btnPausa.setSize(40,40);
                btnPausa.setIcon(new ImageIcon(btnIconSalidoPausa.getImage().getScaledInstance(btnPausa.getWidth(), btnPausa.getHeight(), Image.SCALE_SMOOTH)));
                btnPausa.setBounds(getWidth()*5/6 - btnPausa.getWidth()/2,getHeight()*1/12 - btnPausa.getHeight()/2,btnPausa.getWidth(),btnPausa.getHeight());
            }
            else if(e.getSource() == btnPausaContinuar) {
                ImageIcon btnIconNoShadowPausa = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/PlayButton.png"));
                btnPausaContinuar.setSize(80,80);
                btnPausaContinuar.setIcon(new ImageIcon(btnIconNoShadowPausa.getImage().getScaledInstance(btnPausaContinuar.getWidth(), btnPausaContinuar.getHeight(), Image.SCALE_SMOOTH)));
                btnPausaContinuar.setBounds(pausa.getWidth()/2 - btnPausaContinuar.getWidth()/2,pausa.getHeight()*1/4 - btnPausaContinuar.getHeight()/2,btnPausaContinuar.getWidth(),btnPausaReplay.getHeight());
            }
            else if(e.getSource() == btnPausaReplay) {
                ImageIcon btnIconLightPausa = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/ReplayButton.png"));
                btnPausaReplay.setSize(80,80);
                btnPausaReplay.setIcon(new ImageIcon(btnIconLightPausa.getImage().getScaledInstance(btnPausaReplay.getWidth(), btnPausaReplay.getHeight(), Image.SCALE_SMOOTH)));
                btnPausaReplay.setBounds(pausa.getWidth()/2 - btnPausaReplay.getWidth()/2,pausa.getHeight()*2/4 - btnPausaReplay.getHeight()/2,btnPausaReplay.getWidth(),btnPausaReplay.getHeight());
            }
            else if ((e.getSource() == btnPausaAudio) && (estadoMusica == true)){
                ImageIcon btnIconLightPausa = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/AudioButton.png"));
                btnPausaAudio.setSize(80,80);
                btnPausaAudio.setIcon(new ImageIcon(btnIconLightPausa.getImage().getScaledInstance(btnPausaAudio.getWidth(), btnPausaAudio.getHeight(), Image.SCALE_SMOOTH)));
                btnPausaAudio.setBounds(pausa.getWidth()/2 - btnPausaAudio.getWidth()/2,pausa.getHeight()*3/4 - btnPausaAudio.getHeight()/2,btnPausaAudio.getWidth(),btnPausaAudio.getHeight());
            } 
            else if ((e.getSource() == btnPausaAudio) && (estadoMusica == false)){
                ImageIcon btnIconLightPausa = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/MuteButton.png"));
                btnPausaAudio.setSize(80,80);
                btnPausaAudio.setIcon(new ImageIcon(btnIconLightPausa.getImage().getScaledInstance(btnPausaAudio.getWidth(), btnPausaAudio.getHeight(), Image.SCALE_SMOOTH)));
                btnPausaAudio.setBounds(pausa.getWidth()/2 - btnPausaAudio.getWidth()/2,pausa.getHeight()*3/4 - btnPausaAudio.getHeight()/2,btnPausaAudio.getWidth(),btnPausaAudio.getHeight());
            }
        }

        @Override
        public void mouseDragged(MouseEvent e) {
//            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void mouseMoved(MouseEvent e) {
//            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
    }
    
    public class KeyEventHandler implements KeyEventDispatcher {
        
        private Juego juego;
        
        public KeyEventHandler(Juego juego) {
            this.juego = juego;
        }

        private void actualizarBotones(int[][] respPosicion) {
            for(int i=0;i<3;i++) {
                for(int j=0;j<3;j++) {
                    if(respPosicion[i][j] == 1) {
                        ImageIcon btnImageCross = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/BlackCross.png"));
                        btnPosicion[i][j].setIcon(new ImageIcon(btnImageCross.getImage().getScaledInstance(btnPosicion[i][j].getWidth() - 20, btnPosicion[i][j].getHeight() -20, Image.SCALE_SMOOTH)));
                    }
                    else if(respPosicion[i][j] == 2) {
                        ImageIcon btnImageCircle = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/RedCircle.png"));
                        btnPosicion[i][j].setIcon(new ImageIcon(btnImageCircle.getImage().getScaledInstance(btnPosicion[i][j].getWidth() - 20, btnPosicion[i][j].getHeight() - 20, Image.SCALE_SMOOTH)));
                    }
                    else if(respPosicion[i][j] == 0) {
                        ImageIcon btnImageEmpty = new ImageIcon(getClass().getResource("/co/edu/univalle/miniproyecto2/images/EmptyImage.png"));
                        btnPosicion[i][j].setIcon(new ImageIcon(btnImageEmpty.getImage().getScaledInstance(btnPosicion[i][j].getWidth() - 20, btnPosicion[i][j].getHeight() - 20, Image.SCALE_SMOOTH)));
                    }
                }
            }
        }

        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            actualizarBotones(juego.getPosicion());
            
            boolean seleccionado = false;
            
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    if(btnPosicion[i][j].isFocusOwner()) {
                        seleccionado = true;
                    }
                }
            }
            switch (e.getID()) {
                case KeyEvent.KEY_RELEASED -> {
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_UP -> {
                            if(!seleccionado) {
                                btnPosicion[0][0].requestFocus();
                                break;
                            }
                            for(int i = 0; i < 3; i++) {
                                for(int j = 0; j < 3; j++) {
                                    if(btnPosicion[i][j].isFocusOwner() && (i != 0)) {
                                        btnPosicion[i-1][j].requestFocus();
                                        break;
                                    }
                                }
                            }
                            return true;
                        }
                        case KeyEvent.VK_DOWN -> {
                            if(!seleccionado) {
                                btnPosicion[0][0].requestFocus();
                                break;
                            }
                            for(int i = 0; i < 3; i++) {
                                for(int j = 0; j < 3; j++) {
                                    if(btnPosicion[i][j].isFocusOwner() && (i != 2)) {
                                        btnPosicion[i+1][j].requestFocus();
                                        break;
                                    }
                                }
                            }
                            return true;
                        }
                        case KeyEvent.VK_RIGHT -> {
                            if(!seleccionado) {
                                btnPosicion[0][0].requestFocus();
                                break;
                            }
                            for(int i = 0; i < 3; i++) {
                                for(int j = 0; j < 3; j++) {
                                    if(btnPosicion[i][j].isFocusOwner() && (j != 2)) {
                                        btnPosicion[i][j+1].requestFocus();
                                        break;
                                    }
                                }
                            }
                            return true;
                        }
                        case KeyEvent.VK_LEFT -> {
                            if(!seleccionado) {
                                btnPosicion[0][0].requestFocus();
                                break;
                            }
                            for(int i = 0; i < 3; i++) {
                                for(int j = 0; j < 3; j++) {
                                    if(btnPosicion[i][j].isFocusOwner() && (j != 0)) {
                                        btnPosicion[i][j-1].requestFocus();
                                        break;
                                    }
                                }
                            }
                            return true;
                        }
                        case KeyEvent.VK_ENTER -> {
                            try {
                                Robot robot = new Robot();
                                // Simulate a key press
                                robot.keyPress(KeyEvent.VK_SPACE);
                                robot.keyRelease(KeyEvent.VK_SPACE);
                            } catch (AWTException ex) {
                                Logger.getLogger(VistaJuego.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            return true;
                        }
                        case KeyEvent.VK_ESCAPE -> {
                            try {
                                Robot robot = new Robot();
                                // Simulate a key press
                                btnPausaContinuar.requestFocus();
                                robot.keyPress(KeyEvent.VK_SPACE);
                                robot.keyRelease(KeyEvent.VK_SPACE);
                            } catch (AWTException ex) {
                                Logger.getLogger(VistaJuego.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        
    }
    
}
