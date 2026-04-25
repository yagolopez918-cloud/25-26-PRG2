package tres_raya;

import java.io.Console;

public class Tablero {
    private char[][] casillas;
    final private int DIMENSION = 3;
    final private char VACIO = '_';
    private Console console;

    public Tablero() {
        console = new Console();
        casillas = new char[DIMENSION][DIMENSION];

        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                casillas[i][j] = VACIO;
            }
        }
    }

    public void mostrar() {
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                console.write(" " + casillas[i][j]);
            }
            console.writer();
        }
    }

    public boolean estaOcupado(Coordenada coordenada) {
        return !this.estaVacio(coordenada);
    }

    public boolean estaVacio(Coordenada coordenada) {
        return casillas[coordenada.getFila()][coordenada.getColumna()] == VACIO;
    }

    public void ponerFicha(Coordenada coordenada, char color) {
        int fila = coordenada.getFila();
        int columna = coordenada.getColumna();
        casillas[fila][columna] = color;
    }

    public void sacarFicha(Coordenada coordenada) {
        int fila = coordenada.getFila();
        int columna = coordenada.getColumna();
        casillas[fila][columna] = VACIO;
    }

    public boolean verificarColorFicha (Coordenada coordenada, char color){
        
        int fila = coordenada.getFila();
        int columna = coordenada.getColumna();

        if(casillas[fila][columna] == color){
            return true; 
        }
        return false;

        private boolean hayTresEnRaya(char color){
            int[] filas = new int[DIMENSION];
            int[] columnas = new int[DIMENSION];
            int diagonal = 0;
            int secundaria = 0;

            for(int i = 0; i<DIMENSION; i++){
                for(int j = 0;j<DIMENSION; j++){
                    if(casillas[i][j]==color){
                        filas[i]++;
                        columnas[j]++;

                        if(i == j){
                            diagonal++;
                        }

                        if(i + j == 2){
                            secundaria++;
                        } 

                        if(filas[i]==3 || columnas[j]==3 || diagonal==3 || secundaria==3){
                            return true;
                        }
                    }
                }
            } return false;
        } 
        
        public boolean hayTresEnRaya(){
            return this.hayTresEnRaya('x') || this.hayTresEnRaya('o');
        }

        public boolean estaCompleto(Jugador jugador){
            int conteoFichas = 0;

            for(int i = 0;i<DIMENSION;i++){
                for(int j = 0;j<DIMENSION;j++){
                    if(casillas[i][j]==jugador.color()){
                        conteoFichas++;
                    }
                }
            }
            return conteoFichas == 3;
            } 
        }
    }

}
