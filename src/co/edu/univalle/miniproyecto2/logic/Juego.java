/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.univalle.miniproyecto2.logic;

import java.util.Random;

/**
 *
 * @author julia
 */
public class Juego {
    
    private int contGanadorJ1;
    private int contGanadorJ2;
    
    private int numeroRondas;
    private int rondasJugadas;
    
    private String modoDeJuego;
    private int posicion[][];
    
    private boolean cambioRealizado;
    
    public Juego(int numeroRondas, String tipoDeJuego) {
        this.numeroRondas = numeroRondas;
        this.modoDeJuego = tipoDeJuego;
        posicion = new int[][] {{0,0,0}, {0,0,0}, {0,0,0}};
        contGanadorJ1 = 0;
        contGanadorJ2 = 0;
        cambioRealizado = false;
        rondasJugadas = 0;
    }
    
    public int[][] marcarSeleccion(int jugador, int fila, int columna) {
        if(posicion[fila][columna] == 0) {
            posicion[fila][columna] = jugador;
            cambioRealizado = true;
            return posicion;
        }
        cambioRealizado = false;
        return posicion;
    }
    
    public int[] posicionAleatoria() {
        Random randomFila = new Random();
        Random randomColumna = new Random();
        int[] posAleatoria = new int[] {randomFila.nextInt(3), randomColumna.nextInt(3)};
        return posAleatoria;
    }
    
    public int[][] respuestaAleatoria(int jugador) {
        if((jugador == 2) && (!matrizLlena())) {
            if(posicion[0][0] == 1 && posicion[0][1] == 1 && posicion[0][2] == 0) {
                posicion[0][2] = jugador;
                cambioRealizado = true;
                return posicion;
            } 
            else if(posicion[1][0] == 1 && posicion[1][1] == 1 && posicion[1][2] == 0) {
                posicion[1][2] = jugador;
                cambioRealizado = true;
                return posicion;
            }
            else if(posicion[2][0] == 1 && posicion[2][1] == 1 && posicion[2][2] == 0) {
                posicion[2][2] = jugador;
                cambioRealizado = true;
                return posicion;
            }
            else if(posicion[0][0] == 1 && posicion[1][0] == 1 && posicion[2][0] == 0) {
                posicion[2][0] = jugador;
                cambioRealizado = true;
                return posicion;
            }
            else if(posicion[0][1] == 1 && posicion[1][1] == 1 && posicion[2][1] == 0) {
                posicion[2][1] = jugador;
                cambioRealizado = true;
                return posicion;
            }
            else if(posicion[0][2] == 1 && posicion[1][2] == 1 && posicion[2][2] == 0) {
                posicion[2][2] = jugador;
                cambioRealizado = true;
                return posicion;
            }
            else if(posicion[0][0] == 1 && posicion[1][1] == 1 && posicion[2][2] == 0) {
                posicion[2][2] = jugador;
                cambioRealizado = true;
                return posicion;
            }
            else if(posicion[2][0] == 1 && posicion[1][1] == 1 && posicion[0][2] == 0) {
                posicion[0][2] = jugador;
                cambioRealizado = true;
                return posicion;
            }
            else if(posicion[0][0] == 1 && posicion[0][1] == 0 && posicion[0][2] == 1) { //
                posicion[0][1] = jugador;
                cambioRealizado = true;
                return posicion;
            } 
            else if(posicion[1][0] == 1 && posicion[1][1] == 0 && posicion[1][2] == 1) {
                posicion[1][1] = jugador;
                cambioRealizado = true;
                return posicion;
            }
            else if(posicion[2][0] == 1 && posicion[2][1] == 0 && posicion[2][2] == 1) {
                posicion[2][1] = jugador;
                cambioRealizado = true;
                return posicion;
            }
            else if(posicion[0][0] == 1 && posicion[1][0] == 0 && posicion[2][0] == 1) {
                posicion[1][0] = jugador;
                cambioRealizado = true;
                return posicion;
            }
            else if(posicion[0][1] == 1 && posicion[1][1] == 0 && posicion[2][1] == 1) {
                posicion[1][1] = jugador;
                cambioRealizado = true;
                return posicion;
            }
            else if(posicion[0][2] == 1 && posicion[1][2] == 0 && posicion[2][2] == 1) {
                posicion[1][2] = jugador;
                cambioRealizado = true;
                return posicion;
            }
            else if(posicion[0][0] == 1 && posicion[1][1] == 0 && posicion[2][2] == 1) {
                posicion[1][1] = jugador;
                cambioRealizado = true;
                return posicion;
            }
            else if(posicion[2][0] == 1 && posicion[1][1] == 0 && posicion[0][2] == 1) {
                posicion[1][1] = jugador;
                cambioRealizado = true;
                return posicion;
            }
            else if(posicion[0][0] == 0 && posicion[0][1] == 1 && posicion[0][2] == 1) { //
                posicion[0][0] = jugador;
                cambioRealizado = true;
                return posicion;
            } 
            else if(posicion[1][0] == 0 && posicion[1][1] == 1 && posicion[1][2] == 1) {
                posicion[1][0] = jugador;
                cambioRealizado = true;
                return posicion;
            }
            else if(posicion[2][0] == 0 && posicion[2][1] == 1 && posicion[2][2] == 1) {
                posicion[2][0] = jugador;
                cambioRealizado = true;
                return posicion;
            }
            else if(posicion[0][0] == 0 && posicion[1][0] == 1 && posicion[2][0] == 1) {
                posicion[0][0] = jugador;
                cambioRealizado = true;
                return posicion;
            }
            else if(posicion[0][1] == 0 && posicion[1][1] == 1 && posicion[2][1] == 1) {
                posicion[0][1] = jugador;
                cambioRealizado = true;
                return posicion;
            }
            else if(posicion[0][2] == 0 && posicion[1][2] == 1 && posicion[2][2] == 1) {
                posicion[0][2] = jugador;
                cambioRealizado = true;
                return posicion;
            }
            else if(posicion[0][0] == 0 && posicion[1][1] == 1 && posicion[2][2] == 1) {
                posicion[0][0] = jugador;
                cambioRealizado = true;
                return posicion;
            }
            else if(posicion[2][0] == 0 && posicion[1][1] == 1 && posicion[0][2] == 1) {
                posicion[2][0] = jugador;
                cambioRealizado = true;
                return posicion;
            }
            else {
                while(true) {
                    int[] posAleatoria = posicionAleatoria();
                    if(posicion[posAleatoria[0]][posAleatoria[1]] == 0) {
                        posicion[posAleatoria[0]][posAleatoria[1]] = jugador;
                        cambioRealizado = true;
                        return posicion;
                    }
                }
            }
        }
        else if((jugador == 1) && (!matrizLlena())) {
            if(posicion[0][0] == 2 && posicion[0][1] == 2 && posicion[0][2] == 0) {
                posicion[0][2] = jugador;
                cambioRealizado = true;
                return posicion;
            } 
            else if(posicion[1][0] == 2 && posicion[1][1] == 2 && posicion[1][2] == 0) {
                posicion[1][2] = jugador;
                cambioRealizado = true;
                return posicion;
            }
            else if(posicion[2][0] == 2 && posicion[2][1] == 2 && posicion[2][2] == 0) {
                posicion[2][2] = jugador;
                cambioRealizado = true;
                return posicion;
            }
            else if(posicion[0][0] == 2 && posicion[1][0] == 2 && posicion[2][0] == 0) {
                posicion[2][0] = jugador;
                cambioRealizado = true;
                return posicion;
            }
            else if(posicion[0][1] == 2 && posicion[1][1] == 2 && posicion[2][1] == 0) {
                posicion[2][1] = jugador;
                cambioRealizado = true;
                return posicion;
            }
            else if(posicion[0][2] == 2 && posicion[1][2] == 2 && posicion[2][2] == 0) {
                posicion[2][2] = jugador;
                cambioRealizado = true;
                return posicion;
            }
            else if(posicion[0][0] == 2 && posicion[1][1] == 2 && posicion[2][2] == 0) {
                posicion[2][2] = jugador;
                cambioRealizado = true;
                return posicion;
            }
            else if(posicion[2][0] == 2 && posicion[1][1] == 2 && posicion[0][2] == 0) {
                posicion[0][2] = jugador;
                cambioRealizado = true;
                return posicion;
            }
            else if(posicion[0][0] == 2 && posicion[0][1] == 0 && posicion[0][2] == 2) { //
                posicion[0][1] = jugador;
                cambioRealizado = true;
                return posicion;
            } 
            else if(posicion[1][0] == 2 && posicion[1][1] == 0 && posicion[1][2] == 2) {
                posicion[1][1] = jugador;
                cambioRealizado = true;
                return posicion;
            }
            else if(posicion[2][0] == 2 && posicion[2][1] == 0 && posicion[2][2] == 2) {
                posicion[2][1] = jugador;
                cambioRealizado = true;
                return posicion;
            }
            else if(posicion[0][0] == 2 && posicion[1][0] == 0 && posicion[2][0] == 2) {
                posicion[1][0] = jugador;
                cambioRealizado = true;
                return posicion;
            }
            else if(posicion[0][1] == 2 && posicion[1][1] == 0 && posicion[2][1] == 2) {
                posicion[1][1] = jugador;
                cambioRealizado = true;
                return posicion;
            }
            else if(posicion[0][2] == 2 && posicion[1][2] == 0 && posicion[2][2] == 2) {
                posicion[1][2] = jugador;
                cambioRealizado = true;
                return posicion;
            }
            else if(posicion[0][0] == 2 && posicion[1][1] == 0 && posicion[2][2] == 2) {
                posicion[1][1] = jugador;
                cambioRealizado = true;
                return posicion;
            }
            else if(posicion[2][0] == 2 && posicion[1][1] == 0 && posicion[0][2] == 2) {
                posicion[1][1] = jugador;
                cambioRealizado = true;
                return posicion;
            }
            else if(posicion[0][0] == 0 && posicion[0][1] == 2 && posicion[0][2] == 2) { //
                posicion[0][0] = jugador;
                cambioRealizado = true;
                return posicion;
            } 
            else if(posicion[1][0] == 0 && posicion[1][1] == 2 && posicion[1][2] == 2) {
                posicion[1][0] = jugador;
                cambioRealizado = true;
                return posicion;
            }
            else if(posicion[2][0] == 0 && posicion[2][1] == 2 && posicion[2][2] == 2) {
                posicion[2][0] = jugador;
                cambioRealizado = true;
                return posicion;
            }
            else if(posicion[0][0] == 0 && posicion[1][0] == 2 && posicion[2][0] == 2) {
                posicion[0][0] = jugador;
                cambioRealizado = true;
                return posicion;
            }
            else if(posicion[0][1] == 0 && posicion[1][1] == 2 && posicion[2][1] == 2) {
                posicion[0][1] = jugador;
                cambioRealizado = true;
                return posicion;
            }
            else if(posicion[0][2] == 0 && posicion[1][2] == 2 && posicion[2][2] == 2) {
                posicion[0][2] = jugador;
                cambioRealizado = true;
                return posicion;
            }
            else if(posicion[0][0] == 0 && posicion[1][1] == 2 && posicion[2][2] == 2) {
                posicion[0][0] = jugador;
                cambioRealizado = true;
                return posicion;
            }
            else if(posicion[2][0] == 0 && posicion[1][1] == 2 && posicion[0][2] == 2) {
                posicion[2][0] = jugador;
                cambioRealizado = true;
                return posicion;
            }
            else {
                while(true) {
                    int[] posAleatoria = posicionAleatoria();
                    if(posicion[posAleatoria[0]][posAleatoria[1]] == 0) {
                        posicion[posAleatoria[0]][posAleatoria[1]] = jugador;
                        cambioRealizado = true;
                        return posicion;
                    }
                }
            }
        }    
        return posicion;
    }

    public boolean isCambioRealizado() {
        return cambioRealizado;
    }

    public int getContGanadorJ1() {
        return contGanadorJ1;
    }

    public int getContGanadorJ2() {
        return contGanadorJ2;
    }

    public int getRondasJugadas() {
        return rondasJugadas;
    }
    
    public int verificarGanador() {
        if(posicion[0][0] == 1 && posicion[0][1] == 1 && posicion[0][2] == 1) {
            contGanadorJ1++;
            return 1;
        } 
        else if(posicion[1][0] == 1 && posicion[1][1] == 1 && posicion[1][2] == 1) {
            contGanadorJ1++;
            return 1;
        }
        else if(posicion[2][0] == 1 && posicion[2][1] == 1 && posicion[2][2] == 1) {
            contGanadorJ1++;
            return 1;
        }
        else if(posicion[0][0] == 1 && posicion[1][0] == 1 && posicion[2][0] == 1) {
            contGanadorJ1++;
            return 1;
        }
        else if(posicion[0][1] == 1 && posicion[1][1] == 1 && posicion[2][1] == 1) {
            contGanadorJ1++;
            return 1;
        }
        else if(posicion[0][2] == 1 && posicion[1][2] == 1 && posicion[2][2] == 1) {
            contGanadorJ1++;
            return 1;
        }
        else if(posicion[0][0] == 1 && posicion[1][1] == 1 && posicion[2][2] == 1) {
            contGanadorJ1++;
            return 1;
        }
        else if(posicion[2][0] == 1 && posicion[1][1] == 1 && posicion[0][2] == 1) {
            contGanadorJ1++;
            return 1;
        }
        else if(posicion[0][0] == 2 && posicion[0][1] == 2 && posicion[0][2] == 2) {
            contGanadorJ2++;
            return 2;
        } 
        else if(posicion[1][0] == 2 && posicion[1][1] == 2 && posicion[1][2] == 2) {
            contGanadorJ2++;
            return 2;
        }
        else if(posicion[2][0] == 2 && posicion[2][1] == 2 && posicion[2][2] == 2) {
            contGanadorJ2++;
            return 2;
        }
        else if(posicion[0][0] == 2 && posicion[1][0] == 2 && posicion[2][0] == 2) {
            contGanadorJ2++;
            return 2;
        }
        else if(posicion[0][1] == 2 && posicion[1][1] == 2 && posicion[2][1] == 2) {
            contGanadorJ2++;
            return 2;
        }
        else if(posicion[0][2] == 2 && posicion[1][2] == 2 && posicion[2][2] == 2) {
            contGanadorJ2++;
            return 2;
        }
        else if(posicion[0][0] == 2 && posicion[1][1] == 2 && posicion[2][2] == 2) {
            contGanadorJ2++;
            return 2;
        }
        else if(posicion[2][0] == 2 && posicion[1][1] == 2 && posicion[0][2] == 2) {
            contGanadorJ2++;
            return 2;
        }
        return 0;
    }
    
    public int[][] verificarRonda(int Ganador) {
        if(Ganador != 0) {
            reiniciarMatriz();
            rondasJugadas++;
        }
        else if(matrizLlena()) {
            reiniciarMatriz();
            rondasJugadas++;
        }
        return posicion;
    }
    
    public boolean juegoTerminado() {
        if(numeroRondas == rondasJugadas) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean matrizLlena() {
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                if(posicion[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public void reiniciarMatriz() {
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                posicion[i][j] = 0;
            }
        }
    }
    
    public int[][] getPosicion() {
        return posicion;
    }
}
