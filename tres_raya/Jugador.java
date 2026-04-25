package tres_raya;

public class Jugador {
    private char color;
    private Console console;

    public Jugador(char color) {
        this.color = color;
        console = new Console();
    }

    public void ponerFicha(Tablero tablero) {
        Coordenada coordenada = new Coordenada();
        do {
            this.presentate("Poner ficha");
            coordenada.pedir();
        } while (!coordenada.esValida() || tablero.estaOcupado(coordenada));
        tablero.ponerFicha(coordenada, this.color);
    }

    public void moverFicha(Tablero tablero) {
        Coordenada coordenada = new Coordenada();
        do {
            this.presentate("Mover ficha");
            coordenada.pedir();
        } while (!coordenada.esValida() || tablero.estaVacio(coordenada)
                || !tablero.verificarColorFicha(coordenada, this.color));
        tablero.sacarFicha(coordenada);
        this.ponerFicha(tablero);
    }

    public void celebrar() {
        console.writeln("Los " + color + " somos unos cracks!!!!");
    }

    public char color() {
        return this.color;
    }

    private void presentate(String accion) {
        console.writeln("Eres " + color + " y vas a " + accion);
    }
}
