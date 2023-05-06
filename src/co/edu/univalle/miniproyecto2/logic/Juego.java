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
    private String tipoDeJuego;
    private int posicion[][];
    
    public Juego(int numeroRondas, String tipoDeJuego) {
        this.numeroRondas = numeroRondas;
        this.tipoDeJuego = tipoDeJuego;
        posicion = new int[][] {{0,0,0}, {0,0,0}, {0,0,0}};
        contGanadorJ1 = 0;
        contGanadorJ2 = 0;
    }
    
    public int[][] marcarSeleccion(int jugador, int fila, int columna) {
        if(posicion[fila][columna] == 0) {
            posicion[fila][columna] = jugador;
            return posicion;
        }
        return posicion;
    }
    
    public int[] posicionAleatoria() {
        Random randomFila = new Random();
        Random randomColumna = new Random();
        int[] posAleatoria = new int[] {randomFila.nextInt(3), randomColumna.nextInt(3)};
        return posAleatoria;
    }
    
    public int[][] respuestaAleatoria(int jugador) {
        while(true) {
            int[] posAleatoria = posicionAleatoria();
            if(posicion[posAleatoria[0]][posAleatoria[1]] == 0) {
                posicion[posAleatoria[0]][posAleatoria[1]] = jugador;
                return posicion;
            }
        }
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
}
