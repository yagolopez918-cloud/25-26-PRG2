package entregas.lopezYago;

public class Carrera {

    private Pista pista;
    private Caballo[] caballos;
    private Turnos turnos;

    public Carrera() {
        pista = new Pista();
        caballos = new Caballo[2];
        caballos[0] = new Caballo(1);
        caballos[1] = new Caballo(2);
        turnos = new Turnos();
    }
}
