

public class Carrera {

    private Pista pista;
    private Caballo[] caballos;
    private Turno turno;
    private int numeroJugadores;

    public Carrera(int numeroJugadores) {
        this.numeroJugadores = numeroJugadores;
        pista = new Pista();
        caballos = new Caballo[numeroJugadores];
        for(int i = 0;i<numeroJugadores;i++){
            caballos[i] = new Caballo(i + 1);
        }
    }

    public void jugar() {

        do{
            pista.mostrar();
            int numeroJugadores;
            for(int i = 0;i<numeroJugadores;i++){
                caballos[i].moverse(pista);
            }
        }while(!pista.hayGanadores());
        pista.mostrarResultadoFinal();
    }
}
