package tres_raya;

public class Coordenada {
    private int fila;
    private int columna;
    private Console console;
    
    public Coordenada() {
        console = new Console();
    }
    
    public void pedir() {
        do {
            fila = console.readInt("Dime la fila: ");
            columna = console.readInt("Dime la columna: ");
        } while(!this.esValida());
    }
    
    public boolean esValida() {
        return (fila >= 1 && fila <= 3 && columna >= 1 && columna <= 3);
    }
    
    public int getFila() {
        return fila - 1;
    }
    
    public int getColumna() {
        return columna - 1;
    }
}
