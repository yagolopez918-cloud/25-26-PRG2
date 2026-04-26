package documentos.CCCF;

public class CentroComercial {
    private Cola cola;
    private Caja[] cajas;
    private Tiempo tiempo;
    private boolean llegaClienteEsteMinuto;
    final private double PROBABILIDAD_LLEGADA = 0.4;
    private Console console;

    public CentroComercial() {
        console = new Console();
        cola = new Cola();
        cajas = new Caja[4];
        tiempo = new Tiempo();

        for (int i = 0; i < cajas.length; i++) {
            cajas[i] = new Caja(i + 1);
        }
    }

    public void simular() {
        do {
            tiempo.avanzar();
            this.procesarLlegadaCliente();
            cola.registrarEstado();
            this.asignarClientesACajas();
            this.procesarAtencionCajas();
            this.mostrarEstado();
            this.pausar();
        } while (!tiempo.haFinalizado());
        this.mostrarResumen();
    }

    public void procesarLlegadaCliente() {
        llegaClienteEsteMinuto = Math.random() <= PROBABILIDAD_LLEGADA;
        if (llegaClienteEsteMinuto) {
            Cliente cliente = new Cliente();
            cola.añadirCliente(cliente);
        }
    }

    public void asignarClientesACajas() {
        for (int numeroCaja = 0; numeroCaja < cajas.length; numeroCaja++) {
            if (cajas[numeroCaja].estaLibre() && cola.hayClientes()) {
                Cliente cliente = cola.quitarCliente();
                cajas[numeroCaja].asignar(cliente);
            }
        }
    }

    private void procesarAtencionCajas() {
        for (int numeroCaja = 0; numeroCaja < cajas.length; numeroCaja++) {
            cajas[numeroCaja].avanzarAtencion();
        }
    }

    private void mostrarEstado() {
        console.cleanScreen();
        tiempo.mostrar(llegaClienteEsteMinuto);
        cola.mostrar();
        this.mostrarCajas();
    }

    private void mostrarCajas() {
        for (int numeroCaja = 0; numeroCaja < cajas.length; numeroCaja++) {
            cajas[numeroCaja].mostrar();
        }
    }

    private void pausar() {
        console.pause(1);
    }

    private void mostrarResumen() {
        int minutosSinClientes = cola.obtenerMinutosSinClientes();
        int personasEnCola = cola.obtenerCantidadPersonasEnCola();
        int personasAtendidas = this.obtenerPersonasAtendidas();
        int itemsVendidos = this.obtenerItemsVendidos();

        console.writeln("Personas atendidas: " + personasAtendidas);
        console.writeln("Personas en cola al cierre: " + personasEnCola);
        console.writeln("Items vendidos: " + itemsVendidos);
        console.writeln("Minutos sin clientes en cola: " + minutosSinClientes);
    }

    private int obtenerPersonasAtendidas() {
        int total = 0;
        for (int numeroCaja = 0; numeroCaja < cajas.length; numeroCaja++) {
            total = total + cajas[numeroCaja].obtenerPersonasAtendidas();
        }
        return total;
    }

    private int obtenerItemsVendidos() {
        int total = 0;
        for (int numeroCaja = 0; numeroCaja < cajas.length; numeroCaja++) {
            total = total + cajas[numeroCaja].obtenerItemsVendidos();
        }
        return total;
    }
}
